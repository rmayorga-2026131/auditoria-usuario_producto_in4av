/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudymayorga.system.repository;

import com.rudymayorga.system.model.Users;
import java.sql.CallableStatement;
import com.rudymayorga.system.config.ConexionDB;
import java.sql.SQLException;

public class UserRepository implements UserInterface{
    private CallableStatement callSP;
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();
    
    @Override
    public void create(Users user){
        try {
            callSP = conexionDB.getConnection().prepareCall("{call_sp_create_users(?,?,?,?,?)}");
            
            callSP.setString(1, user.getName());
            callSP.setString(2, user.getLastname());
            callSP.setString(3, user.getEmail());
            callSP.setString(4, user.getUser());
            callSP.setString(5, user.getPassword());
            
            callSP.execute();
            callSP.close(); //libera el almacenamiento
            
        } catch (SQLException e) {
            System.out.println("Error al crear usuario repository");
            System.out.println(e.getMessage());
            e.printStackTrace();
            
            
        }
    }
    
    
}
