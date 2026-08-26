/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rudymayorga.system.utils;

/**
 *
 * @author informatica
 */
public class Validations {
    
    
    
    
    public Validations(){}
    
    public Boolean validateTextEmpty(String text){
        boolean isEmpty = false;
        
        if(text.isEmpty() ==true || text.isBlank() == true)
            isEmpty = true;
        return isEmpty;
    }
    
    
    public Boolean validateTextLength(String text, int textMax){        
        return text.length()<= textMax;
        
    }
    
    public Boolean equalsText(String textoOriginal, String textCompare){
        return textoOriginal.equals(textCompare);
    }
    public Boolean validateEmail(String email){
        int dotCount = 0; // contar el punto
        int arrobaCount = 0;
        //validar punto
        for(int index = 0; index< email.length(); index++){
            if(email.charAt(index)== '.')  
                dotCount++;
            if(dotCount>1)
                return false;
        }
        // validar @
        for(int index = 0; index< email.length(); index++){
            if(email.charAt(index)== '@')  
                arrobaCount++;   
        }
        if(arrobaCount != 1)
                return false;
        
        return true;
    }
  
    
}
