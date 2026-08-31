package com.rudymayorga.system.controller;

import com.rudymayorga.system.model.Users;
import com.rudymayorga.system.utils.Session;
import com.rudymayorga.system.utils.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class DashboardController implements Initializable{
    
    @FXML private Label lblWelcome;
    @FXML private Label lblEmail;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        Users userLogged = Session.getUserLogged();
        
        if(userLogged != null){
            lblWelcome.setText("BIENVENIDO " + userLogged.getName().toUpperCase());
            lblEmail.setText(userLogged.getEmail());
        }
    }
    
    @FXML
    public void onLogout(MouseEvent event){
        Session.setUserLogged(null);
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }
}
