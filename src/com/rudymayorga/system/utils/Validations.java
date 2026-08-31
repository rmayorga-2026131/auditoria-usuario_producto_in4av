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
    
    public Validations(){ 
    }
    
    public Boolean validateTextEmpty(String text){
        boolean isEmpty = false;
        
        if( text.isEmpty() ==true  ||  text.isBlank() == true )
            isEmpty = true;
        return isEmpty;
    }
    
    public Boolean validateTextLength( String text, int textMax ){
        return text.length()<= textMax;
    }
    
    public Boolean equalsText(String textOriginal, String textCompare){
        return textOriginal.equals(textCompare);
    }
    
    public Boolean validateEmail(String email){
        int dotCount= 0 , arrobeCount=0;
        //Valida el punto
        for( int index = 0; index < email.length(); index++ ){
            if( email.charAt(index) == '.' )
                dotCount++;
            if( dotCount >1 )
                return false;
        }
        //REGEX
        //VALIDAR CANTIDAD ARROBAS
        for( int index = 0; index < email.length(); index++ ){
            if( email.charAt(index) == '@' )
                arrobeCount++;
        }
        if( arrobeCount != 1 )
            return false;
        
        return true;
    }    
    
    
    
    
    
}