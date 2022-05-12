package com.demo.todo.service;

import com.demo.todo.dto.LoginDto;
import com.demo.todo.dto.RegisterDto;
import com.demo.todo.dto.http.response.RestResponse;
import com.demo.todo.util.AlreadyExistException;
import com.demo.todo.util.HandleUserException;

public interface UserService {
    public RestResponse register(RegisterDto registerDto) throws AlreadyExistException;

    public RestResponse userLogin(LoginDto loginDto) throws HandleUserException;

}
