/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudymayorga.system.service;

import com.rudymayorga.system.model.Users;
import com.rudymayorga.system.repository.UserRepository;


public class UserService {
    private UserRepository userRepo = new UserRepository();
    
    
    public UserStatus createUser(String user, String name, String lastName,
            String email, String password){
        try {
            Users newUser = new Users(name, lastName, email, user, password);
            userRepo.create(newUser);
            return UserStatus.USER_CREATED;
            
        } catch (Exception e) {
            return UserStatus.ERROR_USER_CREATE;
        }
        
    }
    
    public Users findUser(String userOrEmail){
        return userRepo.search(userOrEmail);
    }
}
