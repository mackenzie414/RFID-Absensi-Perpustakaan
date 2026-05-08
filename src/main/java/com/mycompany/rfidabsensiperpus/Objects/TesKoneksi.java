/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.Objects;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
/**
 *
 * @author acer
 */
public class TesKoneksi {
    public static void main(String[] args){
        try {
            System.out.println("Sedang mencoba menghubungkan ke database...");
            MongoDatabase database = MongoManager.getDatabase();
            
            Document ping = new Document("ping", 1);
            database.runCommand(ping);
            
            System.out.println("================");
            System.out.println("Status: Koneksi Berhasil!");
            System.out.println("Terhubung ke Database: " + database.getName());
            System.out.println("================");
            System.out.println("Daftar Koleksi di " + database.getName() + ":");
            for (String name : database.listCollectionNames()){
                System.out.println("- " + name);
            }
        }catch (Exception e){
            System.err.println("================");
            System.err.println("Status: Koneksi Gagal!");
            System.err.println("Pesan Error: " + e.getMessage());
            System.err.println("================");
        }
    }
    
}
