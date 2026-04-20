package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Lớp đại diện cho Suất Chiếu
 */
public class SuatChieu implements Serializable {
    private String maSC;
    private String maPhong;
    private String maPhim;
    private LocalDate ngayChieu;
    private LocalDateTime gioChieu;

    public SuatChieu() {}

    public SuatChieu(String maSC, String maPhong, String maPhim, LocalDate ngayChieu, LocalDateTime gioChieu) {
        this.maSC = maSC;
        this.maPhong = maPhong;
        this.maPhim = maPhim;
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
    }

    // Getters and Setters
    public String getMaSC() { return maSC; }
    public void setMaSC(String maSC) { this.maSC = maSC; }

    public String getMaPhong() { return maPhong; }
    public void setMaPhong(String maPhong) { this.maPhong = maPhong; }

    public String getMaPhim() { return maPhim; }
    public void setMaPhim(String maPhim) { this.maPhim = maPhim; }

    public LocalDate getNgayChieu() { return ngayChieu; }
    public void setNgayChieu(LocalDate ngayChieu) { this.ngayChieu = ngayChieu; }

    public LocalDateTime getGioChieu() { return gioChieu; }
    public void setGioChieu(LocalDateTime gioChieu) { this.gioChieu = gioChieu; }

    @Override
    public String toString() {
        return "SuatChieu{" +
                "maSC='" + maSC + '\'' +
                ", maPhim='" + maPhim + '\'' +
                ", ngayChieu=" + ngayChieu +
                '}';
    }
}
