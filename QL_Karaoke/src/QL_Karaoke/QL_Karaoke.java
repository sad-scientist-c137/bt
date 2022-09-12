
package QL_Karaoke;

import View.Login;

public class QL_Karaoke {
    public static String ketnoi="jdbc:sqlserver://DESKTOP-KPDD9U9\\QUANG:1433;databaseName=QLYKARAOKE;username=sa;password=12345";
    public static String UN, PW, FN;
    
    public static void main(String[] args) {
        Login  frm = new Login();
        frm.setVisible(true);
    }    
}
