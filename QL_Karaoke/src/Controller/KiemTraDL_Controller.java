
package Controller;

import static Controller.TaiKhoan_Controller.conn;
import static Controller.TaiKhoan_Controller.rs;
import static Controller.TaiKhoan_Controller.sql;
import static Controller.TaiKhoan_Controller.state;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static QL_Karaoke.QL_Karaoke.ketnoi;


public class KiemTraDL_Controller {
    public static boolean KiemTraTrungMa(String TenTruong, String TenBang, String manhap, boolean ktThem, String macu){
        boolean kq=false;
        conn=null;
        state=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            if (ktThem==true)
                sql="Select " + TenTruong + " From " + TenBang + " Where " + TenTruong + " = '" + manhap + "'";
            else
                sql="Select " + TenTruong + " From " + TenBang + " Where " + 
                        TenTruong + " = '" + manhap + "' and " + TenTruong + " <> '" + macu + "'";
            state=conn.createStatement();
            rs=state.executeQuery(sql);
            if (rs.next())
                kq=true;
            state.close();conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public static boolean KiemTraTrung2Ma(String TenTruong1, String TenTruong2, String TenBang, 
            String GiaTri1, String GiaTri2, boolean ktThem, String macu1, String macu2){
        boolean kq=false;
        conn=null;
        state=null;
        
        try {
            conn=DriverManager.getConnection(ketnoi);
            if (ktThem==true)
                sql="Select " + TenTruong1 + " From " + TenBang + 
                        " Where " + TenTruong1 + " = '" + GiaTri1 + "' And " + TenTruong2 + " = '" + GiaTri2 + "'";
            else
                sql="Select " + TenTruong1 + " From " + TenBang + 
                        " Where " + TenTruong1 + " = '" + GiaTri1 + "' And " + 
                        TenTruong2 + " = '" + GiaTri2 + "' And " + 
                        TenTruong1 + "<>'" + macu1 + "' And " + TenTruong2 + "<>'" + macu2 + "'";
            
            state=conn.createStatement();
            rs=state.executeQuery(sql);
            if (rs.next())
                kq=true;
            state.close();conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
}
