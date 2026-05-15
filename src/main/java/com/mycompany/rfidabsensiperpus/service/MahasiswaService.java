/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.service;
import com.mycompany.rfidabsensiperpus.Gui.DataMahasiswa;
import com.mycompany.rfidabsensiperpus.Objects.GenericDAO;
import com.mycompany.rfidabsensiperpus.Objects.Mahasiswa;
import com.mongodb.client.model.Filters;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.bson.conversions.Bson;

/**
 *
 * @author acer
 */
public class MahasiswaService {
    // inisialisai generic dao untuk entitas mahasiswa
    private final GenericDAO<Mahasiswa> DAO;
    
    public MahasiswaService(){
        this.DAO = new GenericDAO<>("mahasiswa", Mahasiswa.class);
    }
    
    //fungsi untuk menyimpan data mahasiswa baru ke mongodb
    public void tambahMahasiswa(Mahasiswa mahasiswaBaru) {
        DAO.save(mahasiswaBaru); 
    }
    
    public void tambahMahasiswa(String uidRfid, String idMahasiswa, String namaLengkap, String prodi){
        Mahasiswa mahasiswaBaru = new Mahasiswa(uidRfid, idMahasiswa, namaLengkap, prodi);
        DAO.save(mahasiswaBaru); // manggil insertone melalui generic dao
    }
    
    //fungsi untuk ambil data mahasiswa
    public void tampilkanDaftarMahasiswa() {
        List<Mahasiswa> daftar = DAO.findAll();
        System.out.println("----- Daftar Mahasiswa -----");
        for (Mahasiswa m : daftar) {
            System.out.println(m.toString()); 
        }
    }

    public void tampilMahasiswa(JPanel panelData, String key) {
        List<Mahasiswa> daftarMahasiswa;
        if (key.isEmpty()) {
            daftarMahasiswa = DAO.findAll();
        } else {
            daftarMahasiswa = cariMahasiswa(key);
        }
        panelData.removeAll();
        
        panelData.setBorder(null);
        
        panelData.setLayout(new BorderLayout());
        
        panelData.setBackground(Color.WHITE);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        JPanel gridPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        gridPanel.setOpaque(false); 
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       
        
        try {
            for (Mahasiswa m : daftarMahasiswa){
                JPanel cardPanel = new JPanel(new GridLayout(4, 1, 0, 0));
                cardPanel.setBackground(new Color(139, 0, 0));
                
                cardPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE, 1, true),
                        BorderFactory.createEmptyBorder(15, 15, 15, 15)
                ));
                
                JLabel lblNama = new JLabel("Nama: " + m.getNamaLengkap());
                lblNama.setForeground(Color.WHITE);
                
                JLabel lblIDM = new JLabel("ID Karyawan: " + m.getIdMahasiswa());
                lblIDM.setForeground(Color.WHITE);
                
                JLabel lblProdi = new JLabel("Prodi: " + m.getProdi());
                lblProdi.setForeground(Color.WHITE);
                
                JPanel controlPanel = new JPanel(new GridLayout(1, 2, 20, 15));
                controlPanel.setBackground(new Color(139, 0, 0));
                
                JButton tombolEdit = new JButton("Edit");
                tombolEdit.setBackground(Color.RED);
                tombolEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
                tombolEdit.addActionListener((ActionEvent e) -> {
                    DataMahasiswa.txtUID.setText(m.getUidRfid());
                    DataMahasiswa.txtMHSID.setText(m.getIdMahasiswa());
                    DataMahasiswa.txtMHSID.setEnabled(false); 
                    DataMahasiswa.txtMHSName.setText(m.getNamaLengkap());
                    DataMahasiswa.txtMHSProdi.setSelectedItem(m.getProdi());
                    DataMahasiswa.btnEdit.setEnabled(true);
                    DataMahasiswa.btnSave.setEnabled(false); 
                    
                });
                JButton tombolDelete = new JButton("Delete");
                tombolDelete.setBackground(Color.GRAY);
                tombolDelete.setForeground(Color.WHITE);
                tombolDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
                tombolDelete.addActionListener((ActionEvent e) -> {
                    Object[] options = {"Ya, Hapus", "Batal"};
                    int choice = JOptionPane.showOptionDialog(
                            null, 
                            "Apakah Anda ingin menyimpan data "+m.getNamaLengkap()+"?", 
                            "Konfirmasi Pengelolaan", 
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.QUESTION_MESSAGE, 
                            null, 
                            options, 
                            options[0] 
                    );
                    
                     switch (choice) {
                        case JOptionPane.YES_OPTION -> hapusMahasiswa(m.getIdMahasiswa());
                        case JOptionPane.NO_OPTION -> System.out.println("User memilih: Batal");
                        default -> {
                        }
                    }
                });
                controlPanel.add(tombolEdit);
                controlPanel.add(tombolDelete);
                
                cardPanel.add(lblNama);
                cardPanel.add(lblIDM);
                cardPanel.add(lblProdi);
                cardPanel.add(controlPanel);
                
                gridPanel.add(cardPanel);
            }
             panelData.add(gridPanel, BorderLayout.NORTH);

            panelData.revalidate();
            panelData.repaint();
        } catch (Exception e) {
            
        }
    }
    
    public List<Mahasiswa> cariMahasiswa(String key) {
        List<Bson> filters = new ArrayList<>();
        // Get all fields from the Karyawan class
        for (Field field : Mahasiswa.class.getDeclaredFields()) {
            // Skip the uidRfid field and non-string fields if necessary
            if (field.getName().equals("uidRfid")) {
                continue;
            }
            filters.add(Filters.regex(field.getName(), key, "i"));
        }
        // Search and return Karyawan objects directly
        List<Mahasiswa> results = DAO.findMany(Filters.or(filters));
        return results;
    }
    
    public void updateMahasiswa(Mahasiswa newM) {
        Bson filter = Filters.eq("idMahasiswa", newM.getIdMahasiswa());
        Mahasiswa m = DAO.findOne(filter);
        if (m != null) {
            DAO.update(filter, newM);
            DataMahasiswa.showData("");
            JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!");
        }
    }
    
    public void hapusMahasiswa(String idM) {
        Bson filter = Filters.eq("idMahasiswa", idM);
        DAO.delete(filter); // Menggunakan deleteOne [6]
        DataMahasiswa.showData("");
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
    }

   
        
}
