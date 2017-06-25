/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.javamail;

/**
 *
 * @author SENA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MailJava mail =  new MailJava("sigmeyc@gmail.com","sigmeyc123","sigmeyc@gmail.com");
        String mjs = "Este es un mensaje de Sigmeyc";
        mjs += "Enviando mails desde java" ;
        
        mail.enviarBasic("Prueba de envio", mjs);
    }
    
}
