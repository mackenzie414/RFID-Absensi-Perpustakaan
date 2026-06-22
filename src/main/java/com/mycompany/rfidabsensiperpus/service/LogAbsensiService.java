/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.service;

import com.mycompany.rfidabsensiperpus.Objects.GenericDAO;
import com.mycompany.rfidabsensiperpus.Objects.LogAbsensi;
import java.time.LocalDateTime;
import java.util.UUID;
/**
 *
 * @author acer
 */
public class LogAbsensiService {
//    inisialisasi dao untuk kolesksi log absensi
    private final GenericDAO<LogAbsensi> logDAO = new GenericDAO<>("log_absensi", LogAbsensi.class);
    
    public void simpanLog(String hashedUid, String status) {
//        membuat object LogAbsensi
        LogAbsensi log = new LogAbsensi(
            UUID.randomUUID().toString(),
            hashedUid, 
            LocalDateTime.now(), 
            status
        );
        logDAO.save(log); 
    }
}
