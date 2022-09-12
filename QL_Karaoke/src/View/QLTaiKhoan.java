
package View;

import Controller.KiemTraDL_Controller;
import Controller.TaiKhoan_Controller;
import Model.tbTaiKhoan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static QL_Karaoke.QL_Karaoke.*;


public class QLTaiKhoan extends javax.swing.JInternalFrame {
    DefaultTableModel tblDanhSach;
    List<tbTaiKhoan> arr = new ArrayList<>();
    String tendn, hoten, matkhau;
    boolean ktThem;
    String macu; //dung de luu gia tri truong khoa (TenDN)
    
    public QLTaiKhoan() {
        initComponents();
        setTitle("Quản Lý Tài Khoản");
        tblDanhSach = (DefaultTableModel) dgDanhSach.getModel();
        DesignTable();
        KhoaMo(true);
        LayNguon();  
        LayTKDangNhap();
    }
    public void LayTKDangNhap(){
        txtTenDN.setText(UN);
        txtHoTen.setText(FN);
        txtMatKhau.setText(PW);
    }
    
    public void KhoaMo(boolean b){
        cmdThem.setEnabled(b);
        cmdSua.setEnabled(b);
        cmdXoa.setEnabled(b);
        cmdKetThuc.setEnabled(b);
        
        cmdGhi.setEnabled(!b);
        cmdKhong.setEnabled(!b);
        
        txtHoTen.setEditable(!b);
        txtTenDN.setEditable(!b);
        txtMatKhau.setEditable(!b);
        
        dgDanhSach.setEnabled(b);
    }
    public void XoaTrang(){
        txtTenDN.setText("");
        txtHoTen.setText("");
        txtMatKhau.setText("");
    }
    public void DesignTable(){
        dgDanhSach.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        dgDanhSach.getColumnModel().getColumn(0).setPreferredWidth(110);
        dgDanhSach.getColumnModel().getColumn(1).setPreferredWidth(220);
        dgDanhSach.getColumnModel().getColumn(2).setPreferredWidth(110);
    }
       public void LayNguon(){
        arr = TaiKhoan_Controller.LayNguon();
        
        tblDanhSach.setRowCount(0);//xoa trang danh sach
        arr.forEach(p->{
            tblDanhSach.addRow(new Object[] {
                p.getTendn(), p.getHoten(), p.getMatkhau()
            });
        });    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenDN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        cmdThem = new javax.swing.JButton();
        cmdSua = new javax.swing.JButton();
        cmdXoa = new javax.swing.JButton();
        cmdGhi = new javax.swing.JButton();
        cmdKhong = new javax.swing.JButton();
        cmdKetThuc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgDanhSach = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        jLabel1.setText("Tên đăng nhập :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 27, -1, -1));

        txtTenDN.setToolTipText("");
        jPanel1.add(txtTenDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 27, 337, 28));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user4.png"))); // NOI18N
        jLabel2.setText("Họ và Tên : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 66, 149, -1));
        jPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 70, 337, 29));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pass.png"))); // NOI18N
        jLabel3.setText("Mật khẩu : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 105, -1, 47));
        jPanel1.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 114, 337, 32));

        cmdThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N
        cmdThem.setText("Thêm");
        cmdThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdThemActionPerformed(evt);
            }
        });
        jPanel1.add(cmdThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 163, 99, 37));

        cmdSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil.png"))); // NOI18N
        cmdSua.setText("Sửa");
        cmdSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSuaActionPerformed(evt);
            }
        });
        jPanel1.add(cmdSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 90, 37));

        cmdXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        cmdXoa.setText("Xóa");
        cmdXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdXoaActionPerformed(evt);
            }
        });
        jPanel1.add(cmdXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 163, 97, 37));

        cmdGhi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N
        cmdGhi.setText("Ghi");
        cmdGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGhiActionPerformed(evt);
            }
        });
        jPanel1.add(cmdGhi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 92, 37));

        cmdKhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/undo2.png"))); // NOI18N
        cmdKhong.setText("Không");
        cmdKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKhongActionPerformed(evt);
            }
        });
        jPanel1.add(cmdKhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 163, 108, 37));

        cmdKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        cmdKetThuc.setText("Kết thúc");
        cmdKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKetThucActionPerformed(evt);
            }
        });
        jPanel1.add(cmdKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 108, 37));

        dgDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên ĐN", "Họ Tên", "Mật Khẩu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgDanhSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dgDanhSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdThemActionPerformed
        XoaTrang();
        ktThem=true;
        KhoaMo(false);
        txtTenDN.requestFocus();
    }//GEN-LAST:event_cmdThemActionPerformed

    private void cmdKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKhongActionPerformed
        XoaTrang();
        KhoaMo(true);
    }//GEN-LAST:event_cmdKhongActionPerformed

    private void dgDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgDanhSachMouseClicked
        int index = dgDanhSach.getSelectedRow();
        TableModel model = dgDanhSach.getModel();
        tendn=model.getValueAt(index, 0).toString();
        hoten=model.getValueAt(index, 1).toString();
        matkhau=model.getValueAt(index, 2).toString();
        
        txtTenDN.setText(tendn);
        txtHoTen.setText(hoten);
        txtMatKhau.setText(matkhau);
    }//GEN-LAST:event_dgDanhSachMouseClicked

    private void cmdSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSuaActionPerformed
        if (txtTenDN.getText().length()<=0)
            return;
        macu=txtTenDN.getText();
        ktThem=false;
        KhoaMo(false);
        txtTenDN.requestFocus();
    }//GEN-LAST:event_cmdSuaActionPerformed

    private void cmdXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdXoaActionPerformed
        if (txtTenDN.getText().length()<=0)
            return;
        int kq=JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tài khoản [ " + txtTenDN.getText() + " ] không?","Thông Báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq==JOptionPane.YES_OPTION){
            macu=txtTenDN.getText();
            TaiKhoan_Controller.XoaBo(macu);
            XoaTrang();
            LayNguon();
        }
    }//GEN-LAST:event_cmdXoaActionPerformed

    private void cmdGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGhiActionPerformed
        //kiem tra du lieu rong
        if (txtTenDN.getText().length()<=0 ){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên đăng nhập","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenDN.requestFocus();
            return;
        }
        if (txtHoTen.getText().length()<=0 ){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập họ tên","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtHoTen.requestFocus();
            return;
        }
        if (txtMatKhau.getText().length()<=0 ){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtMatKhau.requestFocus();
            return;
        }
        //kiem tra tinh hop le cua du lieu
        //kiem tra trung ma (trung khoa chinh - xay dung ham kiemtra trong controller)
        if (KiemTraDL_Controller.KiemTraTrungMa("taikhoan","ten_tk",txtTenDN.getText(), ktThem, macu)==true){
            JOptionPane.showMessageDialog(this, "Bạn nhập trùng tên đăng nhập đã có","Thông Báo",JOptionPane.ERROR_MESSAGE);
            txtTenDN.requestFocus();
            return;
        }
        //thuc hien ghi
        tendn=txtTenDN.getText();
        hoten=txtHoTen.getText();
        matkhau=txtMatKhau.getText();
        tbTaiKhoan tk = new tbTaiKhoan(tendn, matkhau, hoten);
        if (ktThem==true)
            TaiKhoan_Controller.ThemMoi(tk);
        else
            TaiKhoan_Controller.CapNhat(tk, macu);        
        //lay nguon du lieu moi
        LayNguon();
        KhoaMo(true);
    }//GEN-LAST:event_cmdGhiActionPerformed

    private void cmdKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKetThucActionPerformed
        dispose();
    }//GEN-LAST:event_cmdKetThucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdGhi;
    private javax.swing.JButton cmdKetThuc;
    private javax.swing.JButton cmdKhong;
    private javax.swing.JButton cmdSua;
    private javax.swing.JButton cmdThem;
    private javax.swing.JButton cmdXoa;
    private javax.swing.JTable dgDanhSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDN;
    // End of variables declaration//GEN-END:variables
}
