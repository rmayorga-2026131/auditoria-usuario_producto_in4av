package com.rudymayorga.system.repository;

import com.rudymayorga.system.config.ConexionDB;
import com.rudymayorga.system.model.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationRepository implements AuthenticationInterface {
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();
    
    @Override
    public Users login(String email, String password){
        Users userFound = null;
        try {
            PreparedStatement statement = conexionDB.getConnection().prepareStatement(
                "select id_user, name, lastname, email, user, password from Users where (user = ? or email = ?) and password = ?");
            
            statement.setString(1, email);
            statement.setString(2, email);
            statement.setString(3, password);
            
            ResultSet result = statement.executeQuery();
            
            if(result.next()){
                userFound = new Users();
                userFound.setId_user(result.getString("id_user"));
                userFound.setName(result.getString("name"));
                userFound.setLastname(result.getString("lastname"));
                userFound.setEmail(result.getString("email"));
                userFound.setUser(result.getString("user"));
                userFound.setPassword(result.getString("password"));
            }
            
            statement.close();
            
        } catch (SQLException e) {
            System.out.println("Error al hacer login repository");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return userFound;
    }
}
