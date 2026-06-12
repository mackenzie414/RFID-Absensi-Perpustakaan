/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.service;

import com.mycompany.rfidabsensiperpus.Objects.PetugasPerpus;
import com.mycompany.rfidabsensiperpus.Objects.GenericDAO;
import com.mycompany.rfidabsensiperpus.Gui.Dashboard; // Halaman tujuan
import com.mycompany.rfidabsensiperpus.Gui.Login;
import com.mycompany.rfidabsensiperpus.Utils.SecurityUtils;
import com.mongodb.client.model.Filters;
import java.awt.Frame;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;

/**
 *
 * @author acer
 */
public class AuthService {
    private final GenericDAO<PetugasPerpus>  userDAO = new GenericDAO<>("users", PetugasPerpus.class);
    
    public void login(String username, String plainPassword, Login login) {
        String hashedInput = SecurityUtils.getHash(plainPassword, SecurityUtils.SHA_256);
        
            // TAMBAH INI SEMENTARA UNTUK DEBUG
        System.out.println("Username input: " + username);
        System.out.println("Hash input: " + hashedInput);
        
        PetugasPerpus user = userDAO.findOne(Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", hashedInput)
        ));
        
        // TAMBAH INI JUGA
        System.out.println("User ditemukan: " + (user != null));
        
        if (user != null) {
            // Update waktu login terakhir
            user.setLastLogin(LocalDateTime.now());
            userDAO.update(Filters.eq("username", username), user);

            // Berhasil: Masuk ke Halaman Admin
            JOptionPane.showMessageDialog(null, "Selamat Datang, " + user.getNamaPetugas());
            Dashboard admPage = new Dashboard();
            admPage.setLocationRelativeTo(null); 
            admPage.setVisible(true);
            admPage.setExtendedState(Frame.MAXIMIZED_BOTH); 
            login.setVisible(false); 
        } else {
            // Gagal: Notifikasi Error
            JOptionPane.showMessageDialog(null,
                    "Username atau Password Salah!",
                    "Login Gagal",
                    JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void registerUser(String namaPetugas, String username, String plainPassword) {
        // 1. Proses Hashing: Mengamankan password mentah menggunakan SHA-256 [1]
        String hashedPassword = SecurityUtils.getHash(plainPassword, SecurityUtils.SHA_256);

        // 2. Instansiasi Objek: Membuat objek User baru dengan password yang sudah di-hash
        // lastLogin disetel null karena user baru belum pernah masuk sistem
        PetugasPerpus newUser = new PetugasPerpus(username, hashedPassword, namaPetugas, null);

        // 3. Operasi Create: Menyimpan dokumen user ke koleksi MongoDB melalui GenericDAO [3], [4]
        try {
            userDAO.save(newUser); // Memanggil insertOne melalui GenericDAO [5]
        } catch (Exception e) {
            // Standar Debugging: Mengidentifikasi error log secara mandiri [6]
            JOptionPane.showMessageDialog(null, "Gagal mendaftarkan user: " + e.getMessage());
        }
    }
}
