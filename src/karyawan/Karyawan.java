/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karyawan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class Karyawan {
    public String Nama;
    public int Umur;
    public int Gaji;
    private Karyawan[] k;
    public Karyawan(String Nama, int Umur, int Gaji){
        this.Nama = Nama;
        this. Umur = Umur;
        this. Gaji = Gaji;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Tampilan().show();
        // TODO code application logic here
    }
    
}
