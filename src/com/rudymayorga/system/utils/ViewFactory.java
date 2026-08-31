package com.rudymayorga.system.utils;

import com.rudymayorga.system.ClasePrincipal;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
 
public class ViewFactory {
    private final String PATH_VIEWS="/com/rudymayorga/system/view/";
    
    public Scene loadFileFXML(String nameFile, int width, int height){
        String pathOfFile = PATH_VIEWS + nameFile;
        try {
            //Llamar al FXMLLoader
            FXMLLoader loadFXML = new FXMLLoader();
            //Obtener la URL del archivo, viene de la clase main
            URL urlFile = ClasePrincipal.class.getResource(pathOfFile);
            loadFXML.setBuilderFactory(new JavaFXBuilderFactory() );
            loadFXML.setLocation(urlFile);
            
            return new Scene( loadFXML.load(), width, height  );
            
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
            
    public void loadScene(String nameFile){
        Scene scene = null;
        try {
            switch (nameFile) {
                case "login" -> scene = loadFileFXML("LoginView.fxml",400,500);
                case "register" -> {
                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal().setTitle("REGISTRO DE USUARIO");
                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal().setResizable(false);
                    scene = loadFileFXML("RegistroView.fxml",350,400);
                }
                case "dashboard" -> {
                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal().setTitle("DASHBOARD");
                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal().setResizable(true);
                    scene = loadFileFXML("DashboardView.fxml",700,500);
                }
                default      -> scene = loadFileFXML("LoginView.fxml",0,0); 
            }
            SceneManager.getInstanciaSceneManager().changeScene(scene);
        } catch (NullPointerException e) {
            System.out.println("Error load scene");
            //Alert
        }
    }
    public void viewRegister(){
        loadScene("register");
    }
    
    public void viewLogin(){
        loadScene("login");
    }
    
    public void viewDashboard(){
        loadScene("dashboard");
    }
    
}