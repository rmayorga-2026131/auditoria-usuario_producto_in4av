package com.rudymayorga.system.controller;

import com.rudymayorga.system.model.Users;
import com.rudymayorga.system.service.AuthenticationService;
import com.rudymayorga.system.service.AuthenticationStatus;
import com.rudymayorga.system.utils.AlertInformation;
import com.rudymayorga.system.utils.Session;
import com.rudymayorga.system.utils.Validations;
import com.rudymayorga.system.utils.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class LoginController implements Initializable{
    
    @FXML private TextField txtUserOrEmail;
    @FXML private PasswordField pwdPassword;
    private AuthenticationService authService = new AuthenticationService();
    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }
    
    @FXML
    public void onRegister(MouseEvent event){
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewRegister();
    }
    
    @FXML
    public void onLogin(MouseEvent event){
        String userOrEmail = txtUserOrEmail.getText().trim();
        String password = pwdPassword.getText().trim();
        
        if(validate.validateTextEmpty(userOrEmail) == true ||
           validate.validateTextEmpty(password) == true){
            
           alertInfo.viewAlert("ERROR","ERROR DE CAMPO", "ERROR CAMPOS VACIOS",
                            "NO LLENASTE LOS CAMPOS");
           return;
        }
        
        AuthenticationStatus status = authService.login(userOrEmail, password);
        
        switch (status) {
            case NOT_EXIST_USER -> alertInfo.viewAlert("ERROR","ERROR DE CUENTA", "CUENTA NO EXISTE",
                            "NO EXISTE UNA CUENTA CON ESE USUARIO O CORREO, DEBES REGISTRARTE");
            case INCORRECT_PASSWORD -> alertInfo.viewAlert("ERROR","ERROR DE CONTRASEÑA", "CONTRASEÑA INCORRECTA",
                            "LA CONTRASEÑA INGRESADA ES INCORRECTA");
            case LOGIN_SUCCESS -> {
                Users userLogged = authService.getUserLogged();
                Session.setUserLogged(userLogged);
                ViewFactory viewFacto = new ViewFactory();
                viewFacto.viewDashboard();
            }
        }
    }
        
}
