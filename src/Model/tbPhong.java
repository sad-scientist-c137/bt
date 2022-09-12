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
public class tbPhong {
    String maph, tenph, loaiph, giaph, tinhtrang;
    public tbPhong() {
    }

    public tbPhong(String maph, String tenph, String loaiph, String giaph, String tinhtrang){
        this.maph = maph;
        this.tenph = tenph;
        this.loaiph = loaiph;
        this.giaph = giaph;
        this.tinhtrang=tinhtrang;
       

    }
    public String getMaph(){
        return maph;
    }
    public void setMaph(String maph){
        this.maph = maph;
    }

    public String getTenph() {
        return tenph;
    }

    public void setTenph(String tenph) {
        this.tenph = tenph;
    }

    public String getLoaiph() {
        return loaiph;
    }

    public void setLoaiph(String loaiph) {
        this.loaiph = loaiph;
    }

    public String getGiaph() {
        return giaph;
    }

    public void setGiaph(String giaph) {
        this.giaph = giaph;
    }
     public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
   
}
                                     
       