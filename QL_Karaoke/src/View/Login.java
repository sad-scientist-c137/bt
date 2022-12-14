
package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static QL_Karaoke.QL_Karaoke.*;


public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenDN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        cmdDangNhap = new javax.swing.JButton();
        cmdKetThuc = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nen.jpg"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nen.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng Nhập Chương Trình");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("ĐĂNG NHẬP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 156, 32));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, -1, 43));
        getContentPane().add(txtTenDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 298, 32));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pass.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 105, -1, -1));
        getContentPane().add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 105, 298, 33));

        cmdDangNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdDangNhap.setForeground(new java.awt.Color(0, 204, 0));
        cmdDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/enter.png"))); // NOI18N
        cmdDangNhap.setText("Đăng nhập");
        cmdDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(cmdDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 156, -1, 48));

        cmdKetThuc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdKetThuc.setForeground(new java.awt.Color(255, 51, 51));
        cmdKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        cmdKetThuc.setText("Kết thúc");
        cmdKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKetThucActionPerformed(evt);
            }
        });
        getContentPane().add(cmdKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 156, 135, 48));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 34, 10));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nen.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 230));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKetThucActionPerformed
        dispose();
    }//GEN-LAST:event_cmdKetThucActionPerformed

    private void cmdDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDangNhapActionPerformed
        if (txtTenDN.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tài khoản.","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenDN.requestFocus();
            return;
        }
        if (txtMatKhau.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu.","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtMatKhau.requestFocus();
            return;
        }
        Connection conn=null;
        Statement state=null;

        try {
            conn=DriverManager.getConnection(ketnoi);
            String us, pw, sql;
            us=txtTenDN.getText();
            pw=txtMatKhau.getText();
            sql="Select taikhoan, ten_tk, matkhau From tb_login Where taikhoan = '" + us + "' and matkhau = '" + pw + "'";
            state=conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()){
                UN=rs.getString("taikhoan");
                PW=rs.getString("matkhau");
                FN=rs.getString("ten_tk");
                dispose();
                FormMain frm = new FormMain();
               
                frm.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Bạn nhập sai tài khoản.","Thông Báo",JOptionPane.ERROR_MESSAGE);
                txtMatKhau.requestFocus();
            }
            state.close();conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (state!=null)
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdDangNhapActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDangNhap;
    private javax.swing.JButton cmdKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDN;
    // End of variables declaration//GEN-END:variables
}
