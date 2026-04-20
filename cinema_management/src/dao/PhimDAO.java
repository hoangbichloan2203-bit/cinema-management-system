package dao;

import entity.Phim;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * DAO cho Entity Phim
 */
public class PhimDAO implements DAO<Phim> {
    
    private static Map<String, Phim> danhSach = new HashMap<>();
    
    static {
        // Dữ liệu mẫu
        Phim phim1 = new Phim();
        phim1.setMaPhim("P001");
        phim1.setTenPhim("Avengers: Endgame");
        phim1.setTacGia("Russo Brothers");
        phim1.setNamSX(2019);
        phim1.setTheTLoai("Action");
        phim1.setThoiLuong(181);
        phim1.setDaoDien("Anthony Russo");
        phim1.setDienVien("Robert Downey Jr., Chris Evans");
        danhSach.put(phim1.getMaPhim(), phim1);
        
        Phim phim2 = new Phim();
        phim2.setMaPhim("P002");
        phim2.setTenPhim("The Shawshank Redemption");
        phim2.setTacGia("Frank Darabont");
        phim2.setNamSX(1994);
        phim2.setTheTLoai("Drama");
        phim2.setThoiLuong(142);
        phim2.setDaoDien("Frank Darabont");
        phim2.setDienVien("Tim Robbins, Morgan Freeman");
        danhSach.put(phim2.getMaPhim(), phim2);
    }
    
    @Override
    public boolean them(Phim phim) {
        if (phim == null || danhSach.containsKey(phim.getMaPhim())) {
            return false;
        }
        danhSach.put(phim.getMaPhim(), phim);
        return true;
    }
    
    @Override
    public boolean capNhat(Phim phim) {
        if (phim == null || !danhSach.containsKey(phim.getMaPhim())) {
            return false;
        }
        danhSach.put(phim.getMaPhim(), phim);
        return true;
    }
    
    @Override
    public boolean xoa(String maPhim) {
        if (maPhim == null || !danhSach.containsKey(maPhim)) {
            return false;
        }
        danhSach.remove(maPhim);
        return true;
    }
    
    @Override
    public Phim layTheoId(String maPhim) {
        return danhSach.get(maPhim);
    }
    
    @Override
    public List<Phim> layTat() {
        return new ArrayList<>(danhSach.values());
    }
    
    @Override
    public boolean tonTai(String maPhim) {
        return danhSach.containsKey(maPhim);
    }
    
    /**
     * Tìm phim theo tên
     */
    public List<Phim> timTheoTen(String tenPhim) {
        List<Phim> ketQua = new ArrayList<>();
        for (Phim phim : danhSach.values()) {
            if (phim.getTenPhim().toLowerCase().contains(tenPhim.toLowerCase())) {
                ketQua.add(phim);
            }
        }
        return ketQua;
    }
    
    /**
     * Tìm phim theo thể loại
     */
    public List<Phim> timTheoTheLoai(String theLoai) {
        List<Phim> ketQua = new ArrayList<>();
        for (Phim phim : danhSach.values()) {
            if (phim.getTheTLoai().equalsIgnoreCase(theLoai)) {
                ketQua.add(phim);
            }
        }
        return ketQua;
    }
}
