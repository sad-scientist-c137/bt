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

 */

public class TruyvanKaraoke {
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

	public void ThemKhachHang(String ten_kh,String ghichu_kh,String sdt_kh,String tt)
	{		
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
	int i = st.executeUpdate("insert into tb_khachhang  values(N'"+Id("tb_khachhang","ma_kh")+"',N'"+ten_kh+"',N'" +ghichu_kh+"',N'" +sdt_kh+"',N'"+tt+"')");	 
	if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm khách hàng");
	}catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng!" + ex.toString());
	}
	}
	public void ThemPhong(String ten_phong,String loai_phong,String gia_phong)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_phong values(N'"+Id("tb_phong", "ma_phong")+"',N'"+ten_phong+"',N'"+loai_phong+"',N'"+gia_phong+"', N'',N'0' )");
			//	if(i>0&&tinhtrang==1) JOptionPane.showMessageDialog(null, "Phòng đã được đặt");
				if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm phòng");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng!" + ex.toString());
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
	
	public void ThemHopDong(String ma_phong,String ma_nv)
	{
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		int i = st.executeUpdate("insert into tb_hdtp  values(N'"+Id("tb_hdtp","ma_hd")+"',N'"+ma_phong+"',N'"+ma_nv+"',N'"+ngay.format(cal.getTime())+"',N'"+gio.format(cal.getTime())+"')");
		if(i>0) JOptionPane.showMessageDialog(null, "Phòng đã được đặt");
		  }catch(Exception ex)
			{
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm hợp đồng " + ex.toString());
			}
	}
	
	public void ThemKhachNhanPhong(String ma_phong,String tt)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				st.executeUpdate("insert into tb_khachnhanphong select ma_kh,ma_phong from tb_phong,tb_khachhang where tb_khachhang.tinhtrang=N'"+tt+"' and tb_phong.ma_phong='"+ma_phong+"'");
			}catch(Exception ex)
			{

				JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng nhận phòng " + ex.toString());
			}
	}
	public void Them(String ma_phong,String tt)
	{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			st.executeUpdate("insert into tb_khachnhanphong select ma_kh,ma_phong from tb_phong,tb_khachhang where tb_khachhang.tinhtrang=N'"+tt+"' and tb_phong.ma_phong='"+ma_phong+"'");
		}catch(Exception ex)
		{

			JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng nhận phòng " + ex.toString());
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
	public void ThemBienLai(String ma_hopdong,String ma_hddv)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_bienlai  values(N'"+Id("tb_bienlai","ma_bl")+"',N'"+ma_hopdong+"',N'"+ma_hddv+"')");
				if(i>0) JOptionPane.showMessageDialog(null, "Biên lai đã được thêm");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm biên lai!" + ex.toString());
			}
	}
	
  
    public void updateMaKhto0(String makh)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
			        PreparedStatement st = connection.prepareStatement("update tb_khachhang set tinhtrang='0' where tinhtrang='1' and ma_kh=N'"+makh+"'");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update khách hàng!" + e.toString());
			} 
	}
	
	
	public void updateKhachHang()
	{
	     try 
	     {  
	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  Connection connection = DriverManager.getConnection(chuoikn);
	  PreparedStatement st = connection.prepareStatement("update tb_khachhang set tinhtrang='1' where tinhtrang='0'");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update khách hàng!" + e.toString());
			} 
	}
	public void updateAllKh(String ma_kh,String ten,String ghichu,String sdt)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
PreparedStatement st = connection.prepareStatement("update tb_khachhang set ten_kh=N'"+ten+"', ghichu_kh=N'"+ghichu+"', sdt_kh=N'"+sdt+"' where ma_kh='"+ma_kh+"'");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update khách hàng!" + e.toString());
			} 
	}
        public void updateAllNv(String ten_nv,String chucvu_nv,String luong_nv,String namsinh_nv,String gioitinh_nv,String chuthich_nv)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
PreparedStatement st = connection.prepareStatement("update tb_nhanvien  values(N'"+Id("tb_nhanvien","ma_nv")+"',N'"+ten_nv+"',N'"+chucvu_nv+"',N'"+luong_nv+"',N'"+namsinh_nv+"',N'"+gioitinh_nv+"',N'"+chuthich_nv+"')");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update nhân viên!" + e.toString());
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
	public void updateHDDV(String mot,String ko)
	{
	     try 
	     {  
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 Connection connection = DriverManager.getConnection(chuoikn);
	     PreparedStatement st = connection.prepareStatement("update tb_hoadondv set tinhtrang=N'"+mot+"' where tinhtrang=N'"+ko+"'");
	     st.executeUpdate();						    				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update HDDV!" + e.toString());
			} 
	}
	public void updateHopDongInHDon(String ma_hd)
	{
	     try 
	     {  
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 Connection connection = DriverManager.getConnection(chuoikn);
	     PreparedStatement st = connection.prepareStatement("update tb_hoadondv set ma_hd=N'"+ma_hd+"' where tinhtrang=N'1'");
	     st.executeUpdate();						    				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update dịch vụ!" + e.toString());
			} 
	}
        
	//trả phòng 3 xóa khách hàng
	
	/// lOAD tất cả kh
	public DefaultTableModel loadAllKh()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select DISTINCT tb_khachhang.ma_kh,ten_kh,ghichu_kh,sdt_kh,tb_phong.ten_phong from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_phong.ma_phong=tb_khachnhanphong.ma_phong order by ma_kh asc");
			String[] tieudecot = {"ID","Tên KH","ghi chú","Liên lạc","Phòng"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[8];
				dong[0] = rs.getString("ma_kh");
				dong[1] = rs.getString("ten_kh");
				dong[2] = rs.getString("ghichu_kh");
				dong[3] = rs.getString("sdt_kh");
				//dong[6] = rs.getString("tinhtrang");
				dong[4] = rs.getString("ten_phong");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][8];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load Kh " + ex.toString());
			return null;
		}
		}
	//tìm kiếm phòng
	public DefaultTableModel loadTimPhong(String phong)
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select DISTINCT tb_khachhang.ma_kh,ten_kh,ghichu_kh,quoctich_kh,tuoi_kh,sdt_kh,tb_phong.ten_phong from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_phong.ma_phong=tb_khachnhanphong.ma_phong and ten_phong=N'"+phong+"' order by ma_kh asc");
				String[] tieudecot = {"ID","Tên KH","ghi chú","Quốc tịch","Giới tính","Tuổi","Liên lạc","Phòng"};
				ArrayList<String[]> dulieubang = new ArrayList<String[]>();
				while(rs.next())
				{
					String[] dong = new String[8];
					dong[0] = rs.getString("ma_kh");
					dong[1] = rs.getString("ten_kh");
					dong[2] = rs.getString("ghichu_kh");
					dong[3] = rs.getString("sdt_kh");
					//dong[6] = rs.getString("tinhtrang");
					dong[4] = rs.getString("ten_phong");
					dulieubang.add(dong);
				}
				//
				String[][] data = new String[dulieubang.size()][8];
				for(int i=0; i<dulieubang.size(); i++)
				{
					data[i]=dulieubang.get(i);
				}
				tbModel.setDataVector(data,tieudecot);
				return tbModel;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Báo l?i: " + ex.toString());
				return null;
			}
		}
	/**
	 * @wbp.parser.entryPoint
	 */
	public DefaultTableModel loadKhachhang()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_kh,ten_kh,sdt_kh from tb_khachhang order by ma_kh asc");//load du lieu len JTable
			String[] tieudecot = {"Mã KH","Tên KH","số ĐT"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ma_kh");
				dong[1] = rs.getString("ten_kh");
                                dong[2] = rs.getString("sdt_kh");
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
	//LOAD PHÒNG tt=0:phòng trống, tt=1 phòng đã đặt
	
	public DefaultTableModel loadAllNv()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_nv,ten_nv,chucvu_nv,luong_nv,namsinh_nv,case when gioitinh_nv=1 then N'Nam' else N'Nữ' end as gioitinh_nv,chuthich_nv from tb_nhanvien order by ma_nv asc");
			String[] tieudecot = {"Mã NV","Tên NV","Chức vụ","Lương","Năm sinh","Giới tính","Chú thích"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[7];
				dong[0] = rs.getString("ma_nv");
				dong[1] = rs.getString("ten_nv");
				dong[2] = rs.getString("chucvu_nv");
				dong[3] = rs.getString("luong_nv");
				dong[4] = rs.getString("namsinh_nv");
				dong[5] = rs.getString("gioitinh_nv");
				dong[6] = rs.getString("chuthich_nv");
				dulieubang.add(dong);
			}
			String[][] data = new String[dulieubang.size()][7];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Lỗi khi load Nv"+ex.toString());
		return null;
	}
	}
	// LOAD NHÂN VIEN
	public DefaultTableModel loadNhanVien()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from tb_nhanvien order by ma_nv asc");
			String[] tieudecot = {"Mã NV","Tên NV","Chức vụ"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ma_nv");
				dong[1] = rs.getString("ten_nv");
				dong[2] = rs.getString("chucvu_nv");
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
	public DefaultTableModel loadDSDatPhong()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ten_phong,loai_phong,gia_phong,tb_hdtp.ngay_dp,tb_hdtp.gio_dp from tb_phong,tb_hdtp where tb_phong.tinhtrang='1' and tb_phong.ma_phong=tb_hdtp.ma_phong order by ma_nv asc");//load du lieu len JTable
	
			String[] tieudecot = {"Tên Phòng","Loại Phòng","Giá Phòng","Ngày Đặt Phòng","Giờ Đặt Phòng"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[5];
				dong[0] = rs.getString("ten_phong");
				dong[1] = rs.getString("loai_phong");
				dong[2] = rs.getString("gia_phong");
				dong[3] = rs.getString("ngay_dp");
				dong[4] = rs.getString ("gio_dp");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][5];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load phòng! " + ex.toString());
			return null;
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

	public DefaultTableModel loadDvPhong(String maphong)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select tb_dichvu.ma_dv,tb_dichvu.ten_dv,tb_dichvu.gia_dv,tb_hoadondv.gio_hddv,tb_hoadondv.ngay_hddv,tb_phong.ten_phong from tb_dichvu,tb_hoadondv,tb_hdtp,tb_bienlai,tb_phong where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_phong.ma_phong=tb_hdtp.ma_phong and tb_phong.ma_phong=N'"+maphong+"' order by ma_dv asc");
			String[] tieudecot = {"Tên Dv","Giá Dv","Thời gian đặt","Ngày đặt","Tên phòng"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[5];
				dong[0] = rs.getString("ten_dv");
				dong[1] = rs.getString("gia_dv");
				dong[2] = rs.getString("gio_hddv");
				dong[3] = rs.getString("ngay_hddv");
				dong[4] = rs.getString("ten_phong");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][5];
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
	
	public DefaultComboBoxModel loadPhongList()
	{ 
		cmbModel=new DefaultComboBoxModel();
		cmbModel.addElement("chọn phòng:");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select ten_phong from tb_phong, tb_hdtp where tb_hdtp.ma_phong=tb_phong.ma_phong");
			while(rs.next()){
				cmbModel.addElement(rs.getString("ten_phong"));
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
	

	
   
}

