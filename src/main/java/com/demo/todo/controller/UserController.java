package com.demo.todo.controller;

import javax.servlet.http.HttpServletRequest;

import com.demo.todo.dto.LoginDto;
import com.demo.todo.dto.RegisterDto;
import com.demo.todo.dto.http.response.RestResponse;
import com.demo.todo.dto.http.response.StatusResponse;
import com.demo.todo.model.users.Token;
import com.demo.todo.repository.TokenRepository;
import com.demo.todo.service.UserService;
import com.demo.todo.util.AlreadyExistException;
import com.demo.todo.util.HandleUserException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;
    
    @Autowired
    TokenRepository tokenRespository;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "/register", produces = "application/json")
    public RestResponse userRegister(@RequestBody RegisterDto registerDto) {

        try {
            return userService.register(registerDto);
        } catch (AlreadyExistException e) {
            logger.error(e.getMessage());
            return new StatusResponse(409, e.getMessage(), null);
        } catch (Exception e) {
            return new StatusResponse(500, e.getMessage(), null);
        }

    }

    //login code
    @PostMapping(value = "/login", produces = "application/json")
    public RestResponse userLogin(@RequestBody LoginDto loginDto) {
        try {
            return userService.userLogin(loginDto);
        } catch (HandleUserException e) {
            return new StatusResponse(404, e.getMessage(), null);
        } catch (Exception e) {
            return new StatusResponse(500, e.getMessage(), null);
        }
    }

    //logout code
    @PostMapping(value = "/logout", produces = "application/json")
	public RestResponse logout(HttpServletRequest req) {
        Token tokenObj =  tokenRespository.findByUserToken(req.getHeader("Authorization"));
             tokenRespository.delete(tokenObj);  
           return new StatusResponse(200,"Logout Successful",null);
	}

}
