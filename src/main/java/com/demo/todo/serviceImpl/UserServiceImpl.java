package com.demo.todo.serviceImpl;

import java.sql.Date;

import com.demo.todo.dto.LoginDto;
import com.demo.todo.dto.LoginResponseDto;
import com.demo.todo.dto.RegisterDto;
import com.demo.todo.dto.http.response.RestResponse;
import com.demo.todo.dto.http.response.StatusResponse;
import com.demo.todo.model.users.Token;
import com.demo.todo.model.users.Users;
import com.demo.todo.repository.TokenRepository;
import com.demo.todo.repository.UserRepository;
import com.demo.todo.service.UserService;
import com.demo.todo.util.AlreadyExistException;
import com.demo.todo.util.HandleUserException;
import com.demo.todo.validator.Validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    /** The b crypt password encoder. */
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    TokenRepository tokenRespository;

    public String saveToken(Users u) {
        Token token = null;
        if (token == null) {
            token = new Token();
            token.setUserId(u.getId());
            token.setUserToken(this.generateToken(u.getId()));
            tokenRespository.save(token);
            return token.getUserToken();
        }
        return null;
    }

    private String generateToken(long id) {

        String userId = id + "";

        String token = Jwts.builder()
                .setSubject(userId)
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS512, "SecretKeyToGenJWTs")
                .compact();

        return token;
    }

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    public RestResponse register(RegisterDto registerDto) throws AlreadyExistException {
        RestResponse rs = null;
        // list of required parameter in this registration and can be change
        String[] requestedArray = { "userName", "firstName", "lastName", "contactNo", "emailId",
                "organisation", "dob" };
        Validations validations = new Validations();
        // validate user with required fields
        rs = validations.validate(registerDto, requestedArray);

        if (rs != null) {
            StatusResponse ds = (StatusResponse) rs;
            logger.error("Signup validation Error " + ds.getMessage());
            return new StatusResponse(400, ds.getMessage(), null);
        }
        // validate email , must be unique
        Users u2 = this.findByEmail(registerDto.getEmailId());
        if (u2 != null) {
            throw new AlreadyExistException("User " + registerDto.getEmailId() + " already Exist");
        }

        // validate userName , must be unique
        u2 = this.findByUserName(registerDto.getUserName());
        if (u2 != null) {
            throw new AlreadyExistException("User " + registerDto.getUserName() + " already Exist");
        }
        Users u = new Users();
        u.setFirstName(registerDto.getFirstName());
        u.setLastName(registerDto.getLastName());
        u.setUserName(registerDto.getUserName());
        u.setContactNo(registerDto.getContactNo());
        u.setEmailId(registerDto.getEmailId());
        u.setOrganisation(registerDto.getOrganisation());
        String passwordEnc = bCryptPasswordEncoder.encode(registerDto.getUserPassword());
        u.setPassword(passwordEnc);
        userRepository.save(u);
        return new StatusResponse(200, "User Created Successfully !", null);
    }

    public Users findByEmail(String emailId) {
        try {

            Users users = userRepository.findByEmailIdIgnoreCase(emailId);

            return users;

        } catch (Exception e) {
            return null;
        }
    }

    public Users findByUserName(String username) {
        try {

            Users users = userRepository.findByEmailIdIgnoreCase(username);

            return users;

        } catch (Exception e) {
            return null;
        }
    }

    public RestResponse userLogin(LoginDto loginDto) throws HandleUserException {
        Users u = null;
        RestResponse rs = null;
        // list of required parameter in this registration and can be change
        String[] requestedArray = { "userName",
                "password" };
        Validations validations = new Validations();
        // validate user with required fields
        rs = validations.validate(loginDto, requestedArray);
        if (rs != null) {
            StatusResponse ds = (StatusResponse) rs;
            logger.error("Login validation Error " + ds.getMessage());
            return new StatusResponse(400, ds.getMessage(), null);
        }
        if (loginDto.getUserName() == null) {
            throw new HandleUserException("Please Enter Details !");
        } else {
            u = userRepository.findByEmailIdIgnoreCase(loginDto.getUserName());
            if (u == null) {
                u = userRepository.findByUserName(loginDto.getUserName());
                if (u == null) {
                    throw new HandleUserException("Invalid Creadentials");
                }
            }

            if (u != null && bCryptPasswordEncoder.matches(loginDto.getUserPassword(), u.getPassword())) {
                String t = saveToken(u);
                LoginResponseDto loginResp = new LoginResponseDto();
                loginResp.setUserName(u.getUserName());
                loginResp.setOrganisation(u.getOrganisation());
                loginResp.setToken(t);

                return new StatusResponse(200, "User Login Successfully !", loginResp);
            } else {
                return new StatusResponse(401, "Invalid Credentials !", null);
            }
        }
    }
}
