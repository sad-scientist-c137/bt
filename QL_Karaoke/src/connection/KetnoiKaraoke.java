/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.TruyvanKaraoke;

/**
 *
 * @author nguyenchienjf
 */

public class KetnoiKaraoke {
String ketnoi = "jdbc:sqlserver://DESKTOP-KPDD9U9\\QUANG:1433;databaseName=QLYKARAOKE;username=sa;password=12345";
private Connection con;
DateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");
DateFormat gio= new SimpleDateFormat("HH:mm");
Calendar cal = Calendar.getInstance();
public String ngayHt=ngay.format(cal.getTime());
public String gioHt=gio.format(cal.getTime());
TruyvanKaraoke adapter=new TruyvanKaraoke();
public String demPhongTrong="where tinhtrang='0'";
public String demPhongDat="where tinhtrang='1'";
public String demPhongThuong="where loai_phong='1'";
public String demPhongVip="where loai_phong='2'";
public String demHddv="where tb_hoadondv.tinhtrang=N'0'";
public String demtien1="select gia_dv from tb_hoadondv, tb_dichvu where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tb_hoadondv.tinhtrang=N'0' order by ma_hddv asc";



public String demGio(String ngayden,String gioden,String ngaydi,String giodi)
{
	String dateStart=ngayden+" "+gioden;
	String dateStop=ngaydi+" "+giodi;
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");

	Date d1 = null;
	Date d2 = null;

	try {
	d1 = format.parse(dateStart);
	d2 = format.parse(dateStop);

	long diff = d2.getTime() - d1.getTime();
	long diffMinutes = diff / (60 * 1000) % 60;
	long diffHours = diff / (60 * 60 * 1000) % 24;
	long diffDays = diff / (24 * 60 * 60 * 1000);

	return diffHours+"";

	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"l???i ?????m gi???: "+e.toString());
	return null;
	}
}
public void luuid(String idHd,String idTk)
{
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	con = DriverManager.getConnection(ketnoi);
	Statement st = con.createStatement();
   st.executeUpdate("insert into id  values(N'"+adapter.Id("id","ma_id")+"',N'"+idHd+"',N'"+idTk+"')");
}catch(Exception ex)
	{
	JOptionPane.showMessageDialog(null,"l???i l??u id");
	}
}
public String Id(String idlay,String idloai)
{
	String ma="0";
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(ketnoi);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from id where "+idloai+"=N'*' order by ma_id asc");
		while(rs.next()) 
			{
			ma=new String();
			ma = rs.getString(idlay);;
			}
		return ma;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "l???i id: " + ex.toString());
			return null;
		}
}
public String demtien2(String id)
{
String demtien2="select tb_dichvu.gia_dv from tb_hoadondv,tb_dichvu,tb_bienlai,tb_hdtp,tb_phong where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+id+"'";
return demtien2;
}
public String demTaikhoan(String taikhoan,String matkhau)
{
	String where="where taikhoan=N'"+taikhoan+"' and matkhau=N'"+matkhau+"'";
	return where;
}
public String demKhach(String giatri)
{
	String where="where tb_khachnhanphong.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+giatri+"'";
	return where;
}

public String demDichvu(String giatri)
{
 String where="where tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_hdtp.ma_phong='"+giatri+"'";
return where;
}
public String itemGiaP(String giatri)
{
String select="select DISTINCT * from tb_phong where tb_phong.ma_phong=N'"+giatri+"'";
return select;
}
public String itemNgayDp(String giatri)
{
String select="select tb_hdtp.ngay_dp from tb_hdtp,tb_phong where tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+giatri+"'";
return select;
}
public String itemNgayDv(String giatri)
{
String select="select DISTINCT tb_hoadondv.ngay_hddv from tb_hoadondv,tb_bienlai,tb_hdtp,tb_phong where tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+giatri+"'";
return select;
}
public String itemNv(String giatri)
{
String select="select tb_nhanvien.ten_nv from tb_nhanvien,tb_hdtp,tb_phong where tb_nhanvien.ma_nv=tb_hdtp.ma_nv and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+giatri+"'";
return select;
}

public String itemLogin(String giatri)
{
String select="select * from tb_login where ma_tk='"+giatri+"'";
return select;
}
public String itemTgden(String giatri)
{
String select="select * from tb_hdtp,tb_phong where tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+giatri+"'";
return select;
}
public String demDong(String table,String where)
{
	String soDong="";
	int countRow=0;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(ketnoi);
		Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select DISTINCT * from "+table+" "+where+"");
			while(rs.next())
			{
				countRow++;
			}
			soDong=""+countRow;
			return soDong;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "L???i ?????m"+ex.toString());
			return null;
		}
}
public String demTien(String select)
{
    String tien="";
    int congtien=0;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(ketnoi);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(""+select+"");
			while(rs.next())
			{
				congtien+=Integer.parseInt(rs.getString("gia_dv"));
			}
			tien=String.valueOf(congtien);
			return tien;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"C???ng ti???n b??? l???i");
			return null;
		}
}
//h??m l???y ra item c???a table
public String cellTb(String col,String select)
{
	String cell="";
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(ketnoi);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(""+select+"");
			while(rs.next())
			{
				cell = rs.getString(col);;
			}
			return cell;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"L???i: " + ex.toString());
			return null;
		}
}
//t??m ki???m ph??ng
//n???u i=1 th?? load danh s??ch ph??ng ?????t else load danh s??ch ph??ng tr???ng else load t???t c???
	public DefaultTableModel timKiemPhong(int j)
	{
	DefaultTableModel tbModel=new DefaultTableModel();
	String where="";
	if(j==0) where="where tinhtrang=N'0'";
	else if(j==1) where="where tinhtrang=N'1'";
	else if(j==2) where="where loai_phong=N'1'";
	else if(j==3) where="where loai_phong=N'2'";
	else where="";
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(ketnoi);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_phong,ten_phong, case loai_phong when 1 then N'Ph??ng th?????ng' else N'Ph??ng Vip' end as loai_phong,gia_phong, chuthich, case when tinhtrang=1 then N'Ph??ng ???? ?????t' else N'Ph??ng tr???ng' end as tinhtrang from tb_phong "+where+" order by ma_phong asc");//load du lieu len JTable

			String[] tieudecot = {"M?? Ph??ng","T??n Ph??ng","Lo???i Ph??ng","Gi?? Ph??ng","T??nh tr???ng","Ch?? Th??ch"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[6];
				dong[0] = rs.getString("ma_phong");
				dong[1] = rs.getString("ten_phong");
				dong[2] = rs.getString("loai_phong");
				dong[3]=rs.getString("gia_phong");
				dong[4]=rs.getString("tinhtrang");
				dong[5]=rs.getString("chuthich");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][6];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "B??o l???i: " + ex.toString());
			return null;
		}
	}
	
//tr??? v??? ma_hd c???a tb_hdtp khi ch???n 1 ph??ng d???a v??o maphong
public String iDhopdong(String maphong)
{
	String id="b??o l???i";
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(ketnoi);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select DISTINCT tb_hdtp.ma_hd from tb_hdtp where ma_phong=N'"+maphong+"'");
			while(rs.next())
			{
				id = rs.getString("ma_hd");;
			}
			return id;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "B??o l???i: " + ex.toString());
			return null;
		}
}
//l???y ma_hd c???a tb_hdtp insert nh???ng d??ng c?? tinhtrang=2 + ma_hd (t????ng ???ng t??n ph??ng ???????c ch???n) 
public void themvaoBl(String ma_hd)
{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ketnoi);
			Statement st = con.createStatement();
			st.executeUpdate("insert into tb_bienlai select tb_hdtp.ma_hd, ma_hddv from tb_hoadondv,tb_hdtp where tb_hoadondv.tinhtrang=N'2' and tb_hdtp.ma_hd='"+ma_hd+"'");
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "L???i th??m HDdv,Hd vao bien lai!" + ex.toString());
		}
}
public void dvThanhToanSau(String maphong)
{
   //update cot tinh trang c???a tb_hoadondv t??? 0 th??nh 2
	adapter.updateHDDV("2","0");
	//l???y nh???ng c???t tinhtrang=2 + ma_hd( t????ng ???ng ph??ng ???????c ch???n) ch??n v??o tb_bienlai
	themvaoBl(iDhopdong(maphong));
	//sau update cot tinhtrang c???a tb_hoadondv t??? 2 th??nh 1, nh???ng c???t c?? c?? tinhtrang=1 ???????c l??u l???i!
	adapter.updateHDDV("1","2");
   }
}


