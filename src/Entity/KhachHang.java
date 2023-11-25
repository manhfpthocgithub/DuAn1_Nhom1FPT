/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class KhachHang {
    private int maKhachHang;
    private String tenKhachHang;
    private String loaiKhachHang;
    private boolean gioiTinhKH;
    private Date ngaySinhKH;
    private String soDienThoaiKH;
    private String emailKH;
    private String diaChiKH;
    private boolean trangThaiKH;
    private String ghiChuKH;

    public KhachHang() {
    }

    public KhachHang(int maKhachHang, String tenKhachHang, String loaiKhachHang, boolean gioiTinhKH, Date ngaySinhKH, String soDienThoaiKH, String emailKH, String diaChiKH, boolean trangThaiKH, String ghiChuKH) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.loaiKhachHang = loaiKhachHang;
        this.gioiTinhKH = gioiTinhKH;
        this.ngaySinhKH = ngaySinhKH;
        this.soDienThoaiKH = soDienThoaiKH;
        this.emailKH = emailKH;
        this.diaChiKH = diaChiKH;
        this.trangThaiKH = trangThaiKH;
        this.ghiChuKH = ghiChuKH;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public boolean isGioiTinhKH() {
        return gioiTinhKH;
    }

    public void setGioiTinhKH(boolean gioiTinhKH) {
        this.gioiTinhKH = gioiTinhKH;
    }

    public Date getNgaySinhKH() {
        return ngaySinhKH;
    }

    public void setNgaySinhKH(Date ngaySinhKH) {
        this.ngaySinhKH = ngaySinhKH;
    }

    public String getSoDienThoaiKH() {
        return soDienThoaiKH;
    }

    public void setSoDienThoaiKH(String soDienThoaiKH) {
        this.soDienThoaiKH = soDienThoaiKH;
    }

    public String getEmailKH() {
        return emailKH;
    }

    public void setEmailKH(String emailKH) {
        this.emailKH = emailKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public boolean isTrangThaiKH() {
        return trangThaiKH;
    }

    public void setTrangThaiKH(boolean trangThaiKH) {
        this.trangThaiKH = trangThaiKH;
    }

    public String getGhiChuKH() {
        return ghiChuKH;
    }

    public void setGhiChuKH(String ghiChuKH) {
        this.ghiChuKH = ghiChuKH;
    }
 
   
    
     @Override
    public String toString() {
        return this.loaiKhachHang;
    }
    
}
