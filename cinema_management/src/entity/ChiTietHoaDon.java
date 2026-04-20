package entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Lớp đại diện cho Chi Tiết Hóa Đơn
 */
public class ChiTietHoaDon implements Serializable {
    private String maCTHD;
    private String maHoaDon;
    private String maVe;
    private int soLuong;
    private BigDecimal thanhTien;

    public ChiTietHoaDon() {}

    public ChiTietHoaDon(String maCTHD, String maHoaDon, String maVe, int soLuong, BigDecimal thanhTien) {
        this.maCTHD = maCTHD;
        this.maHoaDon = maHoaDon;
        this.maVe = maVe;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    // Getters and Setters
    public String getMaCTHD() { return maCTHD; }
    public void setMaCTHD(String maCTHD) { this.maCTHD = maCTHD; }

    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }

    public String getMaVe() { return maVe; }
    public void setMaVe(String maVe) { this.maVe = maVe; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public BigDecimal getThanhTien() { return thanhTien; }
    public void setThanhTien(BigDecimal thanhTien) { this.thanhTien = thanhTien; }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "maCTHD='" + maCTHD + '\'' +
                ", thanhTien=" + thanhTien +
                '}';
    }
}
