/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Tagihan implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nama;
    private double jumlah;
    private Date jatuhTempo;
    private String kategori;
    private String status;

    public Tagihan(String nama, double jumlah, Date jatuhTempo, String kategori, String status) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.jatuhTempo = jatuhTempo;
        this.kategori = kategori;
        this.status = status;
    }

    // Getter
    public String getNama() { return nama; }
    public double getJumlah() { return jumlah; }
    public Date getJatuhTempo() { return jatuhTempo; }
    public String getKategori() { return kategori; }
    public String getStatus() { return status; }
}


