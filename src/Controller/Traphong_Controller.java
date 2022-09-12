/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
/**
 *
 * @author Quang
 */
public class Traphong_Controller {
     String chuoikn = "jdbc:sqlserver://DESKTOP-KPDD9U9\\QUANG:1433;databaseName=QLYKARAOKE;username=sa;password=12345";
	DefaultTableModel tbModel=new DefaultTableModel();
	DefaultComboBoxModel cmbModel=new DefaultComboBoxModel();
	private Connection con;
	DateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");
	DateFormat gio= new SimpleDateFormat("HH:mm");
	Calendar cal = Calendar.getInstance();
	public String Id(String tb,String ma)
	{
	    int id1=0,id2=0;
		String id = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+tb+"");
				while(rs.next())
				{
					id = new String();
					id = rs.getString(ma);
					id1=Integer.parseInt(id);
					if(id1>=id2)
					{
						id2=id1;
					}
				}
				id=String.valueOf(id2+1);
				return id;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "lỗi id: " + ex.toString());
				return null;
			}
	}
         public DefaultTableModel loadPhong(String tt)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_phong,ten_phong,loai_phong from tb_phong where tinhtrang=N'"+tt+"' order by ma_phong asc");
		String[] tieudecot = {"Mã Phòng","Tên Phòng","Loại Phòng"};
		ArrayList<String[]> dulieubang = new ArrayList<String[]>();
		while(rs.next())
		{
		String[] dong = new String[3];
		dong[0] = rs.getString("ma_phong");
		dong[1] = rs.getString("ten_phong");
		dong[2] = rs.getString("loai_phong");
		dulieubang.add(dong);
		}
		String[][] data = new String[dulieubang.size()][3];
		for(int i=0; i<dulieubang.size(); i++)
		{
		data[i]=dulieubang.get(i);
		}
		tbModel.setDataVector(data,tieudecot);
		return tbModel;
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Báo lỗi: " + ex.toString());
		return null;
	}
	}
    public void updatePhong(String tt,String chonPhong)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
			        PreparedStatement st = connection.prepareStatement("update tb_phong set tinhtrang='"+tt+"' where ma_phong="+chonPhong+"");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update phòng!" + e.toString());
			} 
	}
    public void XoaHddvTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_hoadondv where ma_hddv in (select tb_bienlai.ma_hddv from tb_bienlai,tb_hdtp,tb_phong where tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaHddvTp!" + e.toString());
		    } 
	} 
	//trả phòng 2 xóa biên lai
    public void XoaBlTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_bienlai where ma_hddv in (select tb_bienlai.ma_hddv from tb_bienlai,tb_hdtp,tb_phong where tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "không có thông tin để xóa");
		    } 
	} 
	//trả phòng 5 xóa hdtp
    public void XoaKhTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_khachhang where ma_kh in (select tb_khachhang.ma_kh from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_khachnhanphong.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaKhTp!" + e.toString());
		    } 
	} 
	//trả phòng 4 xóa khachnhanphong
    public void XoaKnpTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_khachnhanphong where ma_kh in (select tb_khachnhanphong.ma_kh from tb_khachnhanphong,tb_phong where tb_khachnhanphong.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaKnpTp!" + e.toString());
		    } 
	} 
    public void XoaHdTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_hdtp where ma_phong in (select tb_hdtp.ma_phong from tb_hdtp, tb_phong where tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaBlTp!" + e.toString());
		    } 
	}
}
