/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.KiemTraDL_Controller;
import Controller.Khachhang_Controller;
import Model.tbKhachHang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static QL_Karaoke.QL_Karaoke.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
/**
 *
 * @author Quang
 */
public class khachhang extends javax.swing.JInternalFrame {
    
    DefaultTableModel tblDanhSach;
    List<tbKhachHang> arr = new ArrayList<>();
    String makh, tenkh, sdt, songuoi , tiencoc, ngaycoc, ghichu ;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static Date datetime;
    boolean ktThem;
    String macu;

    public khachhang() {
        initComponents();
        setTitle("Quản Lý Khách Hàng");
        tblDanhSach = (DefaultTableModel) tblKh.getModel();
        DesignTable();
        KhoaMo(true);
        LayNguon(); 
    }
    public void KhoaMo(boolean b){
        btnThemkh.setEnabled(b);
        btnSuakh.setEnabled(b);
        btnXoakh.setEnabled(b);
        btnKetthuc.setEnabled(b);
        
        btnGhikh.setEnabled(!b);
       
        
        txtTenkh.setEditable(!b);
        txtMakh.setEditable(!b);
        txtSdt.setEditable(!b);
        txtSonguoi.setEditable(!b);
        txtTiencoc.setEditable(!b);
        txtGhichu.setEditable(!b);
        date.setEnabled(!b);
        
        tblKh.setEnabled(b);
     }
      public void XoaTrang(){
        txtMakh.setText("");
        txtTenkh.setText("");
        txtSdt.setText("");
        txtSonguoi.setText("");
        txtTiencoc.setText("");
        txtGhichu.setText("");
    }
    public void DesignTable(){
        tblKh.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblKh.getColumnModel().getColumn(0).setPreferredWidth(110);
        tblKh.getColumnModel().getColumn(1).setPreferredWidth(220);
        tblKh.getColumnModel().getColumn(2).setPreferredWidth(110);
    }
    public void LayNguon(){
        arr = Khachhang_Controller.LayNguon();
        
        tblDanhSach.setRowCount(0);//xoa trang danh sach
        arr.forEach(p->{
            tblDanhSach.addRow(new Object[] {
                p.getMakh(),p.getTenkh(), p.getSdt(), p.getSonguoi(),p.getTiencoc(),p.getNgaycoc(),p.getGhichu()
                    
            });
        });
        }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMakh = new javax.swing.JTextField();
        txtTenkh = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtSonguoi = new javax.swing.JTextField();
        txtTiencoc = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();
        txtGhichu = new javax.swing.JTextField();
        btnThemkh = new javax.swing.JButton();
        btnSuakh = new javax.swing.JButton();
        btnXoakh = new javax.swing.JButton();
        btnGhikh = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnKetthuc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKh = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("QUẢN LÝ Khách Hàng");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setText("Mã KH");

        jLabel3.setText("Tên KH");

        jLabel4.setText("Số đt");

        jLabel5.setText("Số Người");

        jLabel6.setText("Tiền Cọc");

        jLabel7.setText("Ngày Cọc");

        jLabel8.setText("Ghi Chú");

        btnThemkh.setBackground(new java.awt.Color(255, 153, 51));
        btnThemkh.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnThemkh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N
        btnThemkh.setText("Thêm");
        btnThemkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemkhActionPerformed(evt);
            }
        });

        btnSuakh.setBackground(new java.awt.Color(255, 153, 51));
        btnSuakh.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSuakh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil.png"))); // NOI18N
        btnSuakh.setText("Sửa");
        btnSuakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuakhActionPerformed(evt);
            }
        });

        btnXoakh.setBackground(new java.awt.Color(255, 153, 51));
        btnXoakh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoakh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnXoakh.setText("Xóa");
        btnXoakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoakhActionPerformed(evt);
            }
        });

        btnGhikh.setBackground(new java.awt.Color(255, 153, 51));
        btnGhikh.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnGhikh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N
        btnGhikh.setText("Ghi");
        btnGhikh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhikhActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 153, 51));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        jButton8.setText("Làm trắng");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnKetthuc.setBackground(new java.awt.Color(255, 153, 51));
        btnKetthuc.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnKetthuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        btnKetthuc.setText("Kết thúc");
        btnKetthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetthucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemkh, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(btnGhikh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSuakh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(117, 117, 117)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoakh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKetthuc, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMakh, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSdt)
                            .addComponent(txtTenkh))))
                .addGap(123, 123, 123)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSonguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGhichu, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSonguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtGhichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemkh)
                    .addComponent(btnSuakh)
                    .addComponent(btnXoakh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKetthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGhikh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblKh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên KH", "Liênlạc", "Số người", "Tiền đặt cọc", "Ngày cọc", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKh);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhMouseClicked
    
        int index = tblKh.getSelectedRow();
        TableModel model = tblKh.getModel();
        makh=model.getValueAt(index, 0).toString();
        tenkh=model.getValueAt(index, 1).toString();
        sdt=model.getValueAt(index, 2).toString();
        songuoi=model.getValueAt(index, 3).toString();
        tiencoc=model.getValueAt(index, 4).toString();
        ngaycoc=model.getValueAt(index,5).toString();
        ghichu=model.getValueAt(index, 6).toString();
        
        txtMakh.setText(makh);
        txtTenkh.setText(tenkh);
        txtSdt.setText(sdt);
        txtSonguoi.setText(songuoi);
        txtTiencoc.setText(tiencoc);
        try {
            datetime = sdf.parse(ngaycoc);//Chuyển đổi kiểu chuỗi -> ngày
            date.setDate(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
        txtGhichu.setText(ghichu);
      
    }//GEN-LAST:event_tblKhMouseClicked

    private void btnThemkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemkhActionPerformed
        XoaTrang();
        ktThem=true;
        KhoaMo(false);
        txtMakh.requestFocus(); 
        
    }//GEN-LAST:event_btnThemkhActionPerformed

    private void btnSuakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuakhActionPerformed
         if (txtTenkh.getText().length()<=0)
            return;
        macu=txtTenkh.getText();
        ktThem=false;
        KhoaMo(false);
        txtTenkh.requestFocus();
    }//GEN-LAST:event_btnSuakhActionPerformed

    private void btnXoakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoakhActionPerformed
      if (txtTenkh.getText().length()<=0)
            return;
        int kq=JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khách hàng [ " + txtTenkh.getText() + " ] không?","Thông Báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq==JOptionPane.YES_OPTION){
            macu=txtTenkh.getText();
           Khachhang_Controller.XoaBo(macu);
            XoaTrang();
            LayNguon();
        } 
    }//GEN-LAST:event_btnXoakhActionPerformed

    private void btnGhikhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhikhActionPerformed
     if (txtTenkh.getText().length()<=0 ){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên khách hàng","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenkh.requestFocus();
            return;
        }
    if (txtSdt.getText().length()<=0 ){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông tin liên lạc","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtSdt.requestFocus();
            return;
        }
    if (txtTiencoc.getText().length()<=0 ){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tiền cọc","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTiencoc.requestFocus();
            return;
        }
  
        //thuc hien ghi
        makh=txtMakh.getText();
        tenkh=txtTenkh.getText();
        sdt=txtSdt.getText();
        songuoi=txtSonguoi.getText();
        tiencoc=txtTiencoc.getText();
        ngaycoc = sdf.format(date.getDate());
        
        
        ghichu=txtGhichu.getText();
        tbKhachHang nv = new tbKhachHang(makh, tenkh, sdt, songuoi , tiencoc, ngaycoc, ghichu );
        if (ktThem==true)
            Khachhang_Controller.ThemMoi(nv);
        else
            Khachhang_Controller.CapNhat(nv, macu);        
        //lay nguon du lieu moi
        LayNguon();
        KhoaMo(true);
    }//GEN-LAST:event_btnGhikhActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         XoaTrang();
        KhoaMo(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnKetthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetthucActionPerformed
        dispose();
    }//GEN-LAST:event_btnKetthucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhikh;
    private javax.swing.JButton btnKetthuc;
    private javax.swing.JButton btnSuakh;
    private javax.swing.JButton btnThemkh;
    private javax.swing.JButton btnXoakh;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKh;
    private javax.swing.JTextField txtGhichu;
    private javax.swing.JTextField txtMakh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSonguoi;
    private javax.swing.JTextField txtTenkh;
    private javax.swing.JTextField txtTiencoc;
    // End of variables declaration//GEN-END:variables
}
