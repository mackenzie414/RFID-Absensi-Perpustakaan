/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.Objects;

import java.time.LocalDateTime;

/**
 *
 * @author ADVAN
 */
public class PetugasPerpus {
    private String username;
    private String password;
    private String namaPetugas;
     private LocalDateTime lastLogin;
    
    public PetugasPerpus() {}
    
    public PetugasPerpus(String username, String password, String namaPetugas, LocalDateTime lastLogin) {
        this.username = username;
        this.password = password;
        this.namaPetugas = namaPetugas;
        this.lastLogin = lastLogin;
    }
    
    //getter dan setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNamaPetugas() { return namaPetugas; }
    public void setNamaPetugas(String namaPetugas) { this.namaPetugas = namaPetugas; }
    public LocalDateTime getLastLogin() {return lastLogin; }
    public void setLastLogin(LocalDateTime lastLogin) {this.lastLogin = lastLogin; }
}
