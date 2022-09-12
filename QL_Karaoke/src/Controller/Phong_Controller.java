/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.tbPhong;
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
public class Phong_Controller {
     public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;
    public static ResultSet rs;
    //1. lay nguon : dung de lay du lieu tu CSDL va dua vao mang ArrayList<TaiKhoan>
    public static List<tbPhong> LayNguon(){
        List<tbPhong> arr = new ArrayList<>();
        conn=null;
        state=null;
    
        //"select ma_phong,ten_phong,loai_phong,gia_phong,case when tinhtrang=0 then N'phòng trống' else N'phòng đặt' end as tinhtrang from tb_phong order by ma_phong asc";
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="select ma_phong,ten_phong,loai_phong,gia_phong,tinhtrang from tb_phong order by ma_phong asc";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()){
                tbPhong temp = new tbPhong();
                temp.setMaph(rs.getString("ma_phong"));
                temp.setTenph(rs.getString("ten_phong"));
                temp.setLoaiph(rs.getString("loai_phong"));
                temp.setGiaph(rs.getString("gia_phong"));
                temp.setTinhtrang(rs.getString("tinhtrang"));
               
                arr.add(temp);
            }
            state.close();conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (state!=null)
                try {
                    state.close();
            } catch (SQLException ex) {
                Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }
    public static void ThemMoi(tbPhong ph){
        conn=null;
        pstate = null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Insert Into tb_Phong( ma_phong, ten_phong, loai_phong, gia_phong, tinhtrang) Values(?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, ph.getMaph());
            pstate.setString(2, ph.getTenph());
            pstate.setString(3, ph.getLoaiph());
            pstate.setString(4, ph.getGiaph());
             pstate.setString(5, ph.getTinhtrang());
          
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //3. update : cap nhat tai khoan
    public static void CapNhat(tbPhong ph, String macu){
        conn=null;
        pstate=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Update tb_phong Set ma_phong=?, ten_phong=?, loai_phong=?, gia_phong=?,tinhtrang=?";
            pstate=conn.prepareStatement(sql);
            pstate.setString(1, ph.getMaph());
            pstate.setString(2, ph.getTenph());
            pstate.setString(3, ph.getLoaiph());
            pstate.setString(4, ph.getGiaph());
            pstate.setString(5, ph.getTinhtrang());
            
            pstate.setString(6, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //4. delete : xoa tai khoan
    public static void XoaBo(String macu){
        conn=null;
        pstate=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Delete From tb_phong Where ten_phong=?";
            pstate=conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Phong_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}



