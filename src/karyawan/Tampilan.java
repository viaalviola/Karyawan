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
public class Tampilan extends javax.swing.JFrame {
    private Connection con;
    private Statement stat;
    private ResultSet res;
    private String t;
    public Tampilan() {
        initComponents();
        koneksi();
    }
    private void koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/belajar","root","");
            stat=con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void kosongkan(){
        nama.setText("");
        umur.setText("");
        gaji.setText("");
        nama.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        umur = new javax.swing.JTextField();
        gaji = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        simpan = new javax.swing.JButton();
        data = new javax.swing.JButton();
        keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));
        jPanel1.setLayout(null);

        jLabel1.setText("Pendataan Karyawan");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 140, 30);

        jLabel2.setText("Nama :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 80, 40, 20);

        jLabel3.setText("Umur :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 150, 40, 20);

        jLabel4.setText("Gaji :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 220, 40, 20);
        jPanel1.add(nama);
        nama.setBounds(90, 80, 100, 30);
        jPanel1.add(umur);
        umur.setBounds(90, 150, 100, 30);
        jPanel1.add(gaji);
        gaji.setBounds(90, 220, 100, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(120, 0, 280, 300);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        jPanel2.add(simpan);
        simpan.setBounds(20, 80, 80, 23);

        data.setText("Data");
        data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataActionPerformed(evt);
            }
        });
        jPanel2.add(data);
        data.setBounds(20, 150, 55, 23);

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        jPanel2.add(keluar);
        keluar.setBounds(20, 220, 80, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 120, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
     try {
         stat.executeUpdate("insert into karyawan values("
         + "'" + nama.getText()+"',"
         + "'" + umur.getText()+"',"
         + "'" + gaji.getText()+"')"
         );
        kosongkan();
        JOptionPane.showMessageDialog(null, "Data Tersimpan");    
     } catch (Exception e){
         JOptionPane.showMessageDialog(null, "Perintah Salah : "+e);
         
     }
    }//GEN-LAST:event_simpanActionPerformed

    private void dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataActionPerformed
        new Data().show();
        // TODO add your handling code here:
    }//GEN-LAST:event_dataActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_keluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tampilan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton data;
    private javax.swing.JTextField gaji;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField nama;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField umur;
    // End of variables declaration//GEN-END:variables
}
