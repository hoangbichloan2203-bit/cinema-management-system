package entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Lớp đại diện cho Vé
 */
public class Ve implements Serializable {
    private String maVe;
    private String maSC;
    private String maGhe;
    private BigDecimal giaVe;
    private String trangThai; // Đã bán, Chờ thanh toán

    public Ve() {}

    public Ve(String maVe, String maSC, String maGhe, BigDecimal giaVe, String trangThai) {
        this.maVe = maVe;
        this.maSC = maSC;
        this.maGhe = maGhe;
        this.giaVe = giaVe;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public String getMaVe() { return maVe; }
    public void setMaVe(String maVe) { this.maVe = maVe; }

    public String getMaSC() { return maSC; }
    public void setMaSC(String maSC) { this.maSC = maSC; }

    public String getMaGhe() { return maGhe; }
    public void setMaGhe(String maGhe) { this.maGhe = maGhe; }

    public BigDecimal getGiaVe() { return giaVe; }
    public void setGiaVe(BigDecimal giaVe) { this.giaVe = giaVe; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    @Override
    public String toString() {
        return "Ve{" +
                "maVe='" + maVe + '\'' +
                ", maSC='" + maSC + '\'' +
                ", giaVe=" + giaVe +
                '}';
    }
}
