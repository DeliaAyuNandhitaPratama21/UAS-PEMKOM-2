/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Koneksi {
    private static Connection conn;

    public static Connection conn() {
        if (conn == null) {
            try {
                MysqlDataSource m = new MysqlDataSource();
                m.setServerName("localhost");
                m.setPortNumber(3306);
                m.setDatabaseName("manajemen_tagihan"); // Ganti sesuai nama database kamu
                m.setUser("root");
                m.setPassword(""); // Jika ada password MySQL kamu, isi di sini
                m.setServerTimezone("Asia/Jakarta");

                conn = m.getConnection();
                System.out.println("Koneksi database berhasil.");
            } catch (SQLException e) {
                System.err.println("Gagal koneksi ke database: " + e.getMessage());
            }
        }
        return conn;
    }
}
