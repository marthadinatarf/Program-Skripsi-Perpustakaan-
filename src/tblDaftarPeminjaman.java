
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rizki_
 */
public class tblDaftarPeminjaman extends javax.swing.JFrame {

    /**
     * Creates new form tblDaftarPeminjaman
     */
    public tblDaftarPeminjaman() {
        initComponents(); //<<-- JANGAN DIHAPUS
        tampildata();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeminjaman = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "no peminjaman", "Nis", "Nama", "Kelas", "No.Telp", "Kode Buku", "Judul Buku", "Jenis Buku", "Penerbit"
            }
        ));
        tblPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeminjaman);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 700, 252));

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeminjamanMouseClicked
        // TODO add your handling code here:
        int bar = tblPeminjaman.rowAtPoint(evt.getPoint());
        tx.NOPINJAM = tblPeminjaman.getValueAt(bar, 0).toString();
        tx.NIS = tblPeminjaman.getValueAt(bar, 1).toString();
        tx.NAMA = tblPeminjaman.getValueAt(bar, 2).toString();
        tx.KELAS = tblPeminjaman.getValueAt(bar, 3).toString();
        tx.TELP = tblPeminjaman.getValueAt(bar, 4).toString();
        tx.KODE = tblPeminjaman.getValueAt(bar, 5).toString();
        tx.BUKU = tblPeminjaman.getValueAt(bar, 6).toString();
        tx.JENIS = tblPeminjaman.getValueAt(bar, 7).toString();
        tx.PENERBIT = tblPeminjaman.getValueAt(bar, 8).toString();
        
        tx.itemPengembalianBuku();
        this.dispose();
    }//GEN-LAST:event_tblPeminjamanMouseClicked

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
            java.util.logging.Logger.getLogger(tblDaftarPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tblDaftarPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tblDaftarPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tblDaftarPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tblDaftarPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPeminjaman;
    // End of variables declaration//GEN-END:variables
public Connection conn;
public Statement stat;
public kembalian tx = null;
public void koneksi() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newperpustakaan", "root", "");

    } catch (ClassNotFoundException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        System.out.println(e.getMessage());

    }
}

public final void tampildata() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("No Peminjaman");
    model.addColumn("Nis");
    model.addColumn("Nama");
    model.addColumn("Kelas");
    model.addColumn("No. Telp");
    model.addColumn("Kode Buku");
    model.addColumn("Judul Buku");
    model.addColumn("Jenis Buku");
    model.addColumn("Penerbit");
    try {
        koneksi();
        String sql = "SELECT noPeminjaman,nis,nama,kelas,telepon,kode,buku,jenisBuku,penerbit FROM peminjaman";
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9)
            });
        }
        tblPeminjaman.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ada kesalahan" + e);
    }
}
}
