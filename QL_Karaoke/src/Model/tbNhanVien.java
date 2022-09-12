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
public class tbNhanVien {
    String manv, tennv, chucvu, luong, namsinh, gioitinh, chuthich ;
    public tbNhanVien() {
    }

    public tbNhanVien(String manv, String tennv, String chucvu, String luong,String namsinh, String gioitinh, String chuthich) {
        this.manv = manv;
        this.tennv = tennv;
        this.chucvu = chucvu;
        this.luong = luong;
        this.namsinh = namsinh;
        this.gioitinh = gioitinh;
         this.chuthich = chuthich;
    }
    public String getManv(){
        return manv;
    }
    public void setManv(String manv){
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }
    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }
    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    public String getChuthich() {
        return chuthich;
    }

    public void setChuthich(String chuthich) {
        this.chuthich = chuthich;
    }
}


