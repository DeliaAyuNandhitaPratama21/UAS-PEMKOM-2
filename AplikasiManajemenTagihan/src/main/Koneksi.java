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
    public static Connection getConnection() {
        try {
            MysqlDataSource m = new MysqlDataSource();
            m.setServerName("localhost");
            m.setPortNumber(3306);
            m.setDatabaseName("manajemen_tagihan"); // ganti sesuai nama database
            m.setUser("root");
            m.setPassword(""); // sesuaikan jika ada password
            m.setServerTimezone("Asia/Jakarta");

            Connection conn = m.getConnection();
            System.out.println("Koneksi database berhasil.");
            return conn;
        } catch (SQLException e) {
            System.err.println("Gagal koneksi ke database: " + e.getMessage());
            return null;
        }
    }
}



