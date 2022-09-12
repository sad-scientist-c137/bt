/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Quang
 */

import Model.tbKhachHang;
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
public class Khachhang_Controller {
     public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;
    public static ResultSet rs;
    //1. lay nguon : dung de lay du lieu tu CSDL va dua vao mang ArrayList<TaiKhoan>
    public static List<tbKhachHang> LayNguon(){
        List<tbKhachHang> arr = new ArrayList<>();
        conn=null;
        state=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="select * from tb_khachhang order by ma_kh asc";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()){
                tbKhachHang temp = new tbKhachHang();
                temp.setMakh(rs.getString("ma_kh"));
                temp.setTenkh(rs.getString("ten_kh"));
                temp.setSdt(rs.getString("sdt_kh"));
                temp.setSonguoi(rs.getString("songuoi"));
                temp.setTiencoc(rs.getString("tiencoc"));
                temp.setNgaycoc(rs.getString("ngaycoc"));
                temp.setGhichu(rs.getString("ghichu_kh"));
                arr.add(temp);
            }
            state.close();conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (state!=null)
                try {
                    state.close();
            } catch (SQLException ex) {
                Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }
    public static void ThemMoi(tbKhachHang kh){
        conn=null;
        pstate = null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Insert Into tb_khachhang( ma_kh, ten_kh, sdt_kh, songuoi, tiencoc, ngaycoc, ghichu_kh) Values(?,?,?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, kh.getMakh());
            pstate.setString(2, kh.getTenkh());
            pstate.setString(3, kh.getSdt());
            pstate.setString(4, kh.getSonguoi());
            pstate.setString(5, kh.getTiencoc());
            pstate.setString(6, kh.getNgaycoc());
            pstate.setString(7, kh.getGhichu());
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //3. update : cap nhat tai khoan
    public static void CapNhat(tbKhachHang kh, String macu){
        conn=null;
        pstate=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Update tb_khachhang Set ma_kh=?, ten_kh=?, sdt_kh=?, songuoi=?, tiencoc=?, ngaycoc=?, ghichu_kh=?  Where ten_kh=?";
            pstate=conn.prepareStatement(sql);
            pstate.setString(1, kh.getMakh());
            pstate.setString(2, kh.getTenkh());
            pstate.setString(3, kh.getSdt());
            pstate.setString(4, kh.getSonguoi());
            pstate.setString(5, kh.getTiencoc());
            pstate.setString(6, kh.getNgaycoc());
            pstate.setString(7, kh.getGhichu());
            pstate.setString(8, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //4. delete : xoa tai khoan
    public static void XoaBo(String macu){
        conn=null;
        pstate=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Delete From tb_khachhang Where ten_kh=?";
            pstate=conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Khachhang_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}



