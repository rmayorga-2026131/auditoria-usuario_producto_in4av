package com.rudymayorga.system.repository;

import com.rudymayorga.system.model.Users;

public interface AuthenticationInterface {
    Users login(String email, String password);
}
