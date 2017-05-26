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
public class Data extends javax.swing.JFrame {
    private Connection con;
    private Statement stat;
    private ResultSet res;
    private String t;
    private Karyawan[] k;
    public String Nama;
    public int Umur;
    public int Gaji;
    public int BanyakData;
    public String Kondisi;
    public Data() {
        initComponents();
        koneksi();
        Data();
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
     
     public void CekData(){
        BanyakData=0;
        try{
            res=stat.executeQuery("select * from karyawan");
            while(res.next()){
                res.getString(1);
                BanyakData++;
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
     
     public void SetBatas(int jumlahMahasiswa){
        k = new Karyawan[jumlahMahasiswa];
    }
     
     public void SetKaryawan(int indekske, Karyawan karyawan){
        k[indekske] = karyawan;
    }
     
     public Karyawan AmbilKaryawan(int indekske){
        return k[indekske];
    }
     
     public void BubbleSort(){
         for(int b = 0; b<BanyakData;b++){  
             for(int a = 0; a<BanyakData-1-b; a++){
              if(AmbilKaryawan(a).Gaji < AmbilKaryawan(a+1).Gaji){
                        int g = AmbilKaryawan(a+1).Gaji;
                        int h = AmbilKaryawan(a+1).Umur;
                        String i = AmbilKaryawan(a+1).Nama;
                        AmbilKaryawan(a+1).Gaji = AmbilKaryawan(a).Gaji;
                        AmbilKaryawan(a+1).Umur = AmbilKaryawan(a).Umur;
                        AmbilKaryawan(a+1).Nama = AmbilKaryawan(a).Nama;
                        AmbilKaryawan(a).Gaji = g;
                        AmbilKaryawan(a).Umur = h;
                        AmbilKaryawan(a).Nama = i;
                    }
                }
            }
        }
     
     private void Data(){
         CekData();
         SetBatas(BanyakData);
        DefaultTableModel t= new DefaultTableModel();
            t.addColumn("Nama");
            t.addColumn("Umur");
            t.addColumn("Gaji");
        tabel.setModel(t);
        try{
            int a=0;
            res=stat.executeQuery("select * from karyawan");
            while(res.next()){
                Nama = res.getString("nama");
                Umur = res.getInt("umur");
                Gaji = res.getInt("gaji");
                SetKaryawan(a, new Karyawan(Nama, Umur, Gaji));
                a++;
            }
            if(Kondisi == "Urut"){
                BubbleSort();
            }
            for(a = 0; a<BanyakData; a++){
                t.addRow(new Object[]{
                    AmbilKaryawan(a).Nama,
                    AmbilKaryawan(a).Umur,
                    AmbilKaryawan(a).Gaji,
                });
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        urut = new javax.swing.JButton();
        normal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jLabel1.setText("Data Karyawan");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(250, 20, 140, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 70);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(null);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(60, 30, 452, 100);

        urut.setText("Urutkan");
        urut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urutActionPerformed(evt);
            }
        });
        jPanel2.add(urut);
        urut.setBounds(60, 180, 90, 30);

        normal.setText("Normal");
        normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalActionPerformed(evt);
            }
        });
        jPanel2.add(normal);
        normal.setBounds(425, 180, 80, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 70, 590, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void urutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urutActionPerformed
    Kondisi = "Urut";
    Data();
// TODO add your handling code here:
    }//GEN-LAST:event_urutActionPerformed

    private void normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalActionPerformed
    Kondisi = "Normal";
    Data();
// TODO add your handling code here:
    }//GEN-LAST:event_normalActionPerformed

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
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton normal;
    private javax.swing.JTable tabel;
    private javax.swing.JButton urut;
    // End of variables declaration//GEN-END:variables

    

} 

