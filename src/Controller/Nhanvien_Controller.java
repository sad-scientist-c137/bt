/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.tbNhanVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static QL_Karaoke.QL_Karaoke.ketnoi;
/**
 *
 * @author Quang
 */
public class Nhanvien_Controller {
     public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;
    public static ResultSet rs;
    //1. lay nguon : dung de lay du lieu tu CSDL va dua vao mang ArrayList<TaiKhoan>
    public static List<tbNhanVien> LayNguon(){
        List<tbNhanVien> arr = new ArrayList<>();
        conn=null;
        state=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="select * from tb_nhanvien order by ma_nv asc";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()){
                tbNhanVien temp = new tbNhanVien();
                temp.setManv(rs.getString("ma_nv"));
                temp.setTennv(rs.getString("ten_nv"));
                temp.setChucvu(rs.getString("chucvu_nv"));
                temp.setLuong(rs.getString("luong_nv"));
                temp.setNamsinh(rs.getString("namsinh_nv"));
                temp.setGioitinh(rs.getString("gioitinh_nv"));
                temp.setChuthich(rs.getString("chuthich_nv"));
                arr.add(temp);
            }
            state.close();conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (state!=null)
                try {
                    state.close();
            } catch (SQLException ex) {
                Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }
    public static void ThemMoi(tbNhanVien nv){
        conn=null;
        pstate = null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Insert Into tb_nhanvien( ma_nv, ten_nv, chucvu_nv, luong_nv, namsinh_nv, gioitinh_nv, chuthich_nv) Values(?,?,?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, nv.getManv());
            pstate.setString(2, nv.getTennv());
            pstate.setString(3, nv.getChucvu());
            pstate.setString(4, nv.getLuong());
            pstate.setString(5, nv.getNamsinh());
            pstate.setString(6, nv.getGioitinh());
            pstate.setString(7, nv.getChuthich());
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //3. update : cap nhat tai khoan
    public static void CapNhat(tbNhanVien nv, String macu){
        conn=null;
        pstate=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Update tb_nhanvien Set ma_nv=?, ten_nv=?, chucvu_nv=?, luong_nv=?, namsinh_nv=?, gioitinh_nv=?, chuthich_nv=?  Where ten_nv=?";
            pstate=conn.prepareStatement(sql);
            pstate.setString(1,nv.getManv());
            pstate.setString(2, nv.getTennv());
            pstate.setString(3, nv.getChucvu());
            pstate.setString(4, nv.getLuong());
            pstate.setString(5, nv.getNamsinh());
            pstate.setString(6, nv.getGioitinh());
            pstate.setString(7, nv.getChuthich());
            pstate.setString(8, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //4. delete : xoa tai khoan
    public static void XoaBo(String macu){
        conn=null;
        pstate=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Delete From tb_nhanvien Where ten_nv=?";
            pstate=conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Nhanvien_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}



