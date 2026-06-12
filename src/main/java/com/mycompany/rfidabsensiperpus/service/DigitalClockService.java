/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author acer
 */
public class DigitalClockService {
        private final JLabel label;
    private final String format;
    private final Thread thread;

    public DigitalClockService(JLabel label, String format) {
        this.label = label;
        this.format = format;

        this.thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String waktu = LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern(format));
                    SwingUtilities.invokeLater(() -> label.setText(waktu));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }   
    
    public Thread getThread() {
        return thread;
    }
}
