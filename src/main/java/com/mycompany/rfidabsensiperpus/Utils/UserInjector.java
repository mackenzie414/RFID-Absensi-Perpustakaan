/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.Utils;

import com.mycompany.rfidabsensiperpus.service.AuthService;

/**
 *
 * @author acer
 */
public class UserInjector {
    public static void main(String[] args) {
        AuthService userService = new AuthService();
        userService.registerUser("Fauzy", "admin3", "admin123"); 
        userService.registerUser("Fatim", "admin2", "admin123");
        userService.registerUser("Tanwirul", "admin1", "admin123"); 


    }
    
}
