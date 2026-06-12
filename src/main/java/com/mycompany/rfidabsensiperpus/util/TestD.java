/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.util;

/**
 *
 * @author ASUS
 */
public class TestD {   
    public static void main(String[] args) {
        String pwd = EncryptionUtils
                .encrypt("admin123");
        System.out.println(pwd);
    }
}