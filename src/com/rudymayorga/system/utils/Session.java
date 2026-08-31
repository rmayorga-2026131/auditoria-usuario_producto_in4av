package com.rudymayorga.system.utils;

import com.rudymayorga.system.model.Users;

public class Session {
    private static Users userLogged;
    
    public static Users getUserLogged(){
        return userLogged;
    }
    
    public static void setUserLogged(Users user){
        userLogged = user;
    }
}
