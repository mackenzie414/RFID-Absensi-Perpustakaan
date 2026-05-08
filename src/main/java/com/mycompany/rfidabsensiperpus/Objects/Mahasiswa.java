/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.Objects;

/**
 *
 * @author acer
 */
public class Mahasiswa {
    private String uidRfid;
    private String idMahasiswa;
    private String namaLengkap;
    private String prodi;
    
    public Mahasiswa() {
    }
    
    public Mahasiswa(String uiRfid, String idMahasiswa, String namaLengkap, String prodi) {
        this.uidRfid = uiRfid;
        this.idMahasiswa = idMahasiswa;
        this.namaLengkap = namaLengkap;
        this.prodi = prodi;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                ", uidRfid = " + uidRfid +
                ", namaLengkap = " + namaLengkap +
                ", prodi = " + prodi + '}';
    }
    
    public String getUidRfid() {
        return uidRfid;
    }
    
    public void setUirfid(String uiRfid) {
        this.uidRfid = uiRfid;
    }
    
    public String getIdMahasiswa() {
        return idMahasiswa;
    }
    
    public void setIdMahasiswa(String idMahasiswa){
        this.idMahasiswa = idMahasiswa;
    }
    
    public String getNamaLengkap() {
        return namaLengkap;
    }
    
    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }
    
    public String getProdi() {
        return prodi;
    }
    
    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
    
}
