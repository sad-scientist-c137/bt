/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;
import Controller.KiemTraDL_Controller;
import Controller.Phong_Controller;
import Model.tbPhong;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static QL_Karaoke.QL_Karaoke.*;
/**
 *
 * @author Quang
 */
public class Phong extends javax.swing.JInternalFrame {
DefaultTableModel tblDanhSach;
    List<tbPhong> arr = new ArrayList<>();
    String maph, tenph, loaiph, giaph, tinhtrang ;
    boolean ktThem;
    String macu;
    /**
     * Creates new form Phong1
     */
    public Phong() {
        initComponents();
        setTitle("Quản Lý Phòng hát");
        tblDanhSach = (DefaultTableModel) tblPhong.getModel();
        DesignTable();
        KhoaMo(true);
        LayNguon(); 
    }
    public void KhoaMo(boolean b){
        btnThem.setEnabled(b);
        btnSua.setEnabled(b);
        btnXoa.setEnabled(b);
        btnKetthuc.setEnabled(b);
        
        btnGhi.setEnabled(!b);
       
        
        txtTenph.setEditable(!b);
        txtMaph.setEditable(!b);
        txtGiaph.setEditable(!b);
     
        
        tblPhong.setEnabled(b);
     }
    public void XoaTrang(){
        txtMaph.setText("");
        txtTenph.setText("");
        txtGiaph.setText("");
       
    }
    public void DesignTable(){
        tblPhong.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblPhong.getColumnModel().getColumn(0).setPreferredWidth(110);
        tblPhong.getColumnModel().getColumn(1).setPreferredWidth(220);
        tblPhong.getColumnModel().getColumn(2).setPreferredWidth(110);
    }
    public void LayNguon(){
        arr = Phong_Controller.LayNguon();
        
        tblDanhSach.setRowCount(0);//xoa trang danh sach
        arr.forEach(p->{
            tblDanhSach.addRow(new Object[] {
                p.getMaph(),p.getTenph(), p.getLoaiph(), p.getGiaph(), p.getTinhtrang()
                    
            });
        });
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMaph = new javax.swing.JTextField();
        txtGiaph = new javax.swing.JTextField();
        cmbLoaiphong = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnGhi = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtTenph = new javax.swing.JTextField();
        btnKetthuc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTinhtrang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cmbLoaiphong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Chon-", "Phòng Thường", "Phòng VIP" }));
        cmbLoaiphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLoaiphongActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên phòng:");

        jLabel4.setText("Loại phòng:");

        btnThem.setBackground(new java.awt.Color(255, 153, 51));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel5.setText("Giá phòng/1h:");

        btnSua.setBackground(new java.awt.Color(255, 153, 51));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 153, 51));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã phòng:");

        btnGhi.setBackground(new java.awt.Color(255, 153, 0));
        btnGhi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnGhi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N
        btnGhi.setText("Ghi");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 153, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        jButton6.setText("Làm trắng");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnKetthuc.setBackground(new java.awt.Color(255, 153, 0));
        btnKetthuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/enter.png"))); // NOI18N
        btnKetthuc.setText("Kết thúc");
        btnKetthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetthucActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Tên phòng", "Loại phòng", "Giá phòng", "Tình Trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhong);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jLabel2.setText("Tình trạng");

        txtTinhtrang.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMaph, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenph, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(95, 95, 95)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbLoaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtGiaph, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6))
                                    .addGap(80, 80, 80)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnKetthuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtTinhtrang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(437, 437, 437))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbLoaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGhi)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKetthuc))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("QUẢN LÝ PHÒNG HÁT:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbLoaiphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLoaiphongActionPerformed
 
    }//GEN-LAST:event_cmbLoaiphongActionPerformed

    private void btnKetthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetthucActionPerformed
        dispose();
    }//GEN-LAST:event_btnKetthucActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (txtTenph.getText().length()<=0)
            return;
        int kq=JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Phòng [ " + txtTenph.getText() + " ] không?","Thông Báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq==JOptionPane.YES_OPTION){
            macu=txtTenph.getText();
           Phong_Controller.XoaBo(macu);
            XoaTrang();
            LayNguon();
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongMouseClicked
   int index = tblPhong.getSelectedRow();
        TableModel model = tblPhong.getModel();
        maph=model.getValueAt(index, 0).toString();
        tenph=model.getValueAt(index, 1).toString();
        loaiph=model.getValueAt(index, 2).toString();
        giaph=model.getValueAt(index, 3).toString();
        tinhtrang=model.getValueAt(index,4).toString();
      
        
        txtMaph.setText(maph);
        txtTenph.setText(tenph);
        //cmbGioitinh.setSelectedIndex(gioitinh.equals("Nam") ? 0 : 1);
        cmbLoaiphong.setSelectedItem(loaiph);
        txtGiaph.setText(giaph);
        txtTinhtrang.setText(tinhtrang);
   
                                        
    }//GEN-LAST:event_tblPhongMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
     XoaTrang();
        ktThem=true;
        KhoaMo(false);
        txtTenph.requestFocus();       
      
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
    if (txtTenph.getText().length()<=0)
            return;
        macu=txtTenph.getText();
        ktThem=false;
        KhoaMo(false);
        txtTenph.requestFocus();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      XoaTrang();
        KhoaMo(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
      if (txtTenph.getText().length()<=0 ){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên phòng","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenph.requestFocus();
            return;
        }
    if (txtGiaph.getText().length()<=0 ){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá phòng","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtGiaph.requestFocus();
            return;
        }
  
        //thuc hien ghi
        maph=txtMaph.getText();
        tenph=txtTenph.getText();
        //gioitinh = cmbGioitinh.getSelectedItem().toString();
        int index1 = cmbLoaiphong.getSelectedIndex();
        loaiph = cmbLoaiphong.getItemAt(index1);
        
        giaph=txtGiaph.getText();
        tinhtrang=txtTinhtrang.getText();
        tbPhong ph = new tbPhong(maph, tenph, loaiph, giaph,tinhtrang);
        if (ktThem==true)
            Phong_Controller.ThemMoi(ph);
        else
            Phong_Controller.CapNhat(ph, macu);        
        //lay nguon du lieu moi
        LayNguon();
        KhoaMo(true);
    }//GEN-LAST:event_btnGhiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnKetthuc;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbLoaiphong;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTextField txtGiaph;
    private javax.swing.JTextField txtMaph;
    private javax.swing.JTextField txtTenph;
    private javax.swing.JTextField txtTinhtrang;
    // End of variables declaration//GEN-END:variables
}
