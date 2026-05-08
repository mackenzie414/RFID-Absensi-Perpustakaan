/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.Objects;

import java.time.LocalDateTime;

/**
 *
 * @author acer
 */
public class LogAbsensi {
    private String idLog;
    private String uidRfid;
    private LocalDateTime waktuTap;
    private String status;
    
    public LogAbsensi(){   
    }
    
    public LogAbsensi(String idLog, String uiRfid, LocalDateTime waktuTap, String status){
        this.idLog = idLog;
        this.uidRfid = uidRfid;
        this.waktuTap = waktuTap;
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getIdLog() {
        return idLog;
    }
    
    public void setIdLog(String idLog) {
        this.idLog = idLog;
    }
    
     public String getUidRfid() {
        return uidRfid;
    }

    public void setUidRfid(String uidRfid) {
        this.uidRfid = uidRfid;
    }

    public LocalDateTime getWaktuTap() {
        return waktuTap;
    }

    public void setWaktuTap(LocalDateTime waktuTap) {
        this.waktuTap = waktuTap;
    }
}
