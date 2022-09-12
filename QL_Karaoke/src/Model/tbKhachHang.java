/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Quang
 */
public class tbKhachHang {
    String makh, tenkh, sdt, songuoi , tiencoc, ngaycoc, ghichu ;
    public tbKhachHang() {
    }
 public tbKhachHang(String makh, String tenkh, String sdt, String songuoi,String tiencoc, String ngaycoc, String ghichu) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.songuoi = songuoi;
        this.tiencoc = tiencoc;
        this.ngaycoc = ngaycoc;
         this.ghichu = ghichu;
    }
    public String getMakh(){
        return makh;
    }
    public void setMakh(String makh){
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getSonguoi() {
        return songuoi;
    }

    public void setSonguoi(String songuoi) {
        this.songuoi = songuoi;
    }
    public String getTiencoc() {
        return tiencoc;
    }

    public void setTiencoc(String tiencoc) {
        this.tiencoc = tiencoc;
    }
    public String getNgaycoc() {
        return ngaycoc;
    }

    public void setNgaycoc(String ngaycoc) {
        this.ngaycoc = ngaycoc;
    }
    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}



