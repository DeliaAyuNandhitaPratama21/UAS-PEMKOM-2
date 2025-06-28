/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import main.Koneksi;

/**
 *
 * @author ASUS
 */
public class Notifikasi extends Thread {

    @Override
    public void run() {
        // Jalankan cek langsung
        cekDanTampilkanNotifikasi();

        while (true) {
            try {
                TimeUnit.MINUTES.sleep(1); // cek tiap 10 detik
                cekDanTampilkanNotifikasi();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void cekDanTampilkanNotifikasi() {
        try (Connection conn = Koneksi.getConnection()) {
            String sql = "SELECT nama_tagihan, jatuh_tempo FROM tagihan WHERE status = 'Belum Lunas'";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                LocalDate hariIni = LocalDate.now();
                while (rs.next()) {
                    String nama = rs.getString("nama_tagihan");
                    LocalDate jatuhTempo = rs.getDate("jatuh_tempo").toLocalDate();

                    if (!jatuhTempo.isBefore(hariIni)) {
                        long selisih = java.time.temporal.ChronoUnit.DAYS.between(hariIni, jatuhTempo);
                        if (selisih <= 3) {
                            JOptionPane.showMessageDialog(null, "Tagihan \"" + nama + "\" akan jatuh tempo dalam " + selisih + " hari!");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


