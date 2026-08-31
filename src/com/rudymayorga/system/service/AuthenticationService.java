package com.rudymayorga.system.service;

import com.rudymayorga.system.model.Users;
import com.rudymayorga.system.repository.AuthenticationRepository;

public class AuthenticationService {
    private AuthenticationRepository authRepo = new AuthenticationRepository();
    private UserService userService = new UserService();
    private Users userLogged;
    
    public AuthenticationStatus login(String userOrEmail, String password){
        Users userFound = userService.findUser(userOrEmail);
        
        if(userFound == null)
            return AuthenticationStatus.NOT_EXIST_USER;
        
        Users userAuth = authRepo.login(userOrEmail, password);
        
        if(userAuth == null)
            return AuthenticationStatus.INCORRECT_PASSWORD;
        
        userLogged = userAuth;
        return AuthenticationStatus.LOGIN_SUCCESS;
    }
    
    public Users getUserLogged(){
        return userLogged;
    }
}
