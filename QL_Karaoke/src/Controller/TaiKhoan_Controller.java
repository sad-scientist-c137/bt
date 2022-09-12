
package Controller;

import Model.tbTaiKhoan;
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

public class TaiKhoan_Controller {
    public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;
    public static ResultSet rs;
    //1. lay nguon : dung de lay du lieu tu CSDL va dua vao mang ArrayList<TaiKhoan>
    public static List<tbTaiKhoan> LayNguon(){
        List<tbTaiKhoan> arr = new ArrayList<>();
        conn=null;
        state=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Select * From tb_login Order By taikhoan";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()){
                tbTaiKhoan temp = new tbTaiKhoan();
                temp.setTendn(rs.getString("taikhoan"));
                temp.setHoten(rs.getString("ten_tk"));
                temp.setMatkhau(rs.getString("matkhau"));
                arr.add(temp);
            }
            state.close();conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (state!=null)
                try {
                    state.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }
    //2. insert : them tai khoan
    public static void ThemMoi(tbTaiKhoan tk){
        conn=null;
        pstate = null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Insert Into tb_login(taikhoan, ten_tk, matkhau) Values(?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getTendn());
            pstate.setString(2, tk.getHoten());
            pstate.setString(3, tk.getMatkhau());
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //3. update : cap nhat tai khoan
    public static void CapNhat(tbTaiKhoan tk, String macu){
        conn=null;
        pstate=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Update tb_login Set taikhoan=?, ten_tk=?, matkhau=? Where taikhoan=?";
            pstate=conn.prepareStatement(sql);
            pstate.setString(1, tk.getTendn());
            pstate.setString(2, tk.getHoten());
            pstate.setString(3, tk.getMatkhau());
            pstate.setString(4, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //4. delete : xoa tai khoan
    public static void XoaBo(String macu){
        conn=null;
        pstate=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            sql="Delete From tb_login Where taikhoan=?";
            pstate=conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
