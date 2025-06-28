/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.*;

/**
 *
 * @author ASUS
 */
public class FileManager {

    // Simpan objek ke file
    public static void saveObject(Object obj, String path) {
        try {
            File file = new File(path);
            file.getParentFile().mkdirs(); // Buat folder jika belum ada

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(obj);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load objek dari file
    public static Object loadObject(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) return null;

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            Object obj = in.readObject();
            in.close();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

