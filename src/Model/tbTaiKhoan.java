
package Model;

public class tbTaiKhoan {
    String tendn, matkhau,hoten;

    public tbTaiKhoan() {
    }

    public tbTaiKhoan(String tendn, String matkhau, String hoten) {
        this.tendn = tendn;
        this.matkhau = matkhau;
        this.hoten = hoten;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    
}
