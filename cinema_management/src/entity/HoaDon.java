package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Lớp đại diện cho Hóa Đơn
 */
public class HoaDon implements Serializable {
    private String maHoaDon;
    private String maNV;
    private String maKH;
    private String maKM;
    private String maThue;
    private LocalDate ngayLap;
    private BigDecimal tongTien;

    public HoaDon() {}

    public HoaDon(String maHoaDon, String maNV, String maKH, String maKM, 
                  String maThue, LocalDate ngayLap, BigDecimal tongTien) {
        this.maHoaDon = maHoaDon;
        this.maNV = maNV;
        this.maKH = maKH;
        this.maKM = maKM;
        this.maThue = maThue;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    // Getters and Setters
    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }

    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public String getMaKH() { return maKH; }
    public void setMaKH(String maKH) { this.maKH = maKH; }

    public String getMaKM() { return maKM; }
    public void setMaKM(String maKM) { this.maKM = maKM; }

    public String getMaThue() { return maThue; }
    public void setMaThue(String maThue) { this.maThue = maThue; }

    public LocalDate getNgayLap() { return ngayLap; }
    public void setNgayLap(LocalDate ngayLap) { this.ngayLap = ngayLap; }

    public BigDecimal getTongTien() { return tongTien; }
    public void setTongTien(BigDecimal tongTien) { this.tongTien = tongTien; }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", tongTien=" + tongTien +
                ", ngayLap=" + ngayLap +
                '}';
    }
}
