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
public class Dichvu_Controller {
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
  public void XoaId(String table,String id1,String id2)
	{
	  try 
	     {  
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    Connection connection = DriverManager.getConnection(chuoikn);
			PreparedStatement st = connection.prepareStatement("delete from "+table+" where "+id1+"=N'"+id2+"'");
			st.executeUpdate();			
				JOptionPane.showMessageDialog(null, "Ðã xóa","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Không có gì để xóa");
	    } 
	}

 public DefaultTableModel loadDichVu()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from tb_dichvu order by ma_dv asc");
			String[] tieudecot = {"ID","Tên Dv","Giá Dv"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ma_dv");
				dong[1] = rs.getString("ten_dv");
				dong[2] = rs.getString("gia_dv");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}	
	}
 public DefaultTableModel loadHdDv()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_hddv,tb_dichvu.ten_dv,gio_hddv,ngay_hddv from tb_hoadondv, tb_dichvu where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tinhtrang=0 order by ma_hddv asc");
			String[] tieudecot = {"ID","Tên Dv","Tgian đặt","Ngày đặt"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[4];
				dong[0] = rs.getString("ma_hddv");
				dong[1] = rs.getString("ten_dv");
				dong[2] = rs.getString("gio_hddv");
				dong[3] = rs.getString("ngay_hddv");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][4];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}
        
	}
 public void XoaHddv()
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_hoadondv where tinhtrang='0'");
				st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã xóa","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa!" + e.toString());
		    } 
	}
 public void ThemDichVu(String ten_dv,String gia_dv)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_dichvu  values(N'"+Id("tb_dichvu","ma_dv")+"',N'" +ten_dv+"',N'" +gia_dv+"')");
				if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm dịch vụ");
			}catch(Exception ex)
			{
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Nhập sai tiền, phải nhập số /1000đ");
			}
	}
 public DefaultComboBoxModel loadNhanvienCmb()
	{ 
		cmbModel=new DefaultComboBoxModel();
		cmbModel.addElement("Chọn Nv:");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select ten_nv from tb_nhanvien");
			while(rs.next()){
				cmbModel.addElement(rs.getString("ten_nv"));
			}
			return cmbModel;
	}
		catch(Exception e)
		{
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
    public DefaultTableModel loadTtDv()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select tb_dichvu.ten_dv,gio_hddv,tb_dichvu.gia_dv from tb_hoadondv, tb_dichvu where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tinhtrang=0 order by ma_hddv asc");
			String[] tieudecot = {"Dịch vụ","Đơn Giá","Thời gian đặt"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ten_dv");
				dong[1] = rs.getString("gia_dv");
				dong[2] = rs.getString("gio_hddv");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}
	}
    public void ThemHoaDonDv(String ma_dv,String giodv,String ngaydv)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
			    st.executeUpdate("insert into tb_hoadondv  values(N'"+Id("tb_hoadondv","ma_hddv")+"',N'"+ma_dv+"',N'" +giodv+"',N'" +ngaydv+"',N'0')");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Chưa chọn dịch vụ !");
			}
	}
}

