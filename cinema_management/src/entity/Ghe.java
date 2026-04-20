package entity;

import java.io.Serializable;

/**
 * Lớp đại diện cho Ghế
 */
public class Ghe implements Serializable {
    private String maGhe;
    private String maPhong;
    private String hang;
    private int soGhe;

    public Ghe() {}

    public Ghe(String maGhe, String maPhong, String hang, int soGhe) {
        this.maGhe = maGhe;
        this.maPhong = maPhong;
        this.hang = hang;
        this.soGhe = soGhe;
    }

    // Getters and Setters
    public String getMaGhe() { return maGhe; }
    public void setMaGhe(String maGhe) { this.maGhe = maGhe; }

    public String getMaPhong() { return maPhong; }
    public void setMaPhong(String maPhong) { this.maPhong = maPhong; }

    public String getHang() { return hang; }
    public void setHang(String hang) { this.hang = hang; }

    public int getSoGhe() { return soGhe; }
    public void setSoGhe(int soGhe) { this.soGhe = soGhe; }

    @Override
    public String toString() {
        return hang + soGhe;
    }
}
