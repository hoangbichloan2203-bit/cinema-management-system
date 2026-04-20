package dao;

import entity.Phong;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * DAO cho Entity Phong
 */
public class PhongDAO implements DAO<Phong> {
    
    private static Map<String, Phong> danhSach = new HashMap<>();
    
    static {
        // Dữ liệu mẫu
        Phong phong1 = new Phong();
        phong1.setMaPhong("P001");
        phong1.setTenPhong("Phòng Standard 1");
        phong1.setLoaiPhong("Standard");
        phong1.setSucChua(80);
        phong1.setTrangThai("Hoạt động");
        danhSach.put(phong1.getMaPhong(), phong1);
        
        Phong phong2 = new Phong();
        phong2.setMaPhong("P002");
        phong2.setTenPhong("Phòng Deluxe 1");
        phong2.setLoaiPhong("Deluxe");
        phong2.setSucChua(100);
        phong2.setTrangThai("Hoạt động");
        danhSach.put(phong2.getMaPhong(), phong2);
    }
    
    @Override
    public boolean them(Phong phong) {
        if (phong == null || danhSach.containsKey(phong.getMaPhong())) {
            return false;
        }
        danhSach.put(phong.getMaPhong(), phong);
        return true;
    }
    
    @Override
    public boolean capNhat(Phong phong) {
        if (phong == null || !danhSach.containsKey(phong.getMaPhong())) {
            return false;
        }
        danhSach.put(phong.getMaPhong(), phong);
        return true;
    }
    
    @Override
    public boolean xoa(String maPhong) {
        if (maPhong == null || !danhSach.containsKey(maPhong)) {
            return false;
        }
        danhSach.remove(maPhong);
        return true;
    }
    
    @Override
    public Phong layTheoId(String maPhong) {
        return danhSach.get(maPhong);
    }
    
    @Override
    public List<Phong> layTat() {
        return new ArrayList<>(danhSach.values());
    }
    
    @Override
    public boolean tonTai(String maPhong) {
        return danhSach.containsKey(maPhong);
    }
    
    /**
     * Tìm phòng theo loại
     */
    public List<Phong> timTheoLoai(String loaiPhong) {
        List<Phong> ketQua = new ArrayList<>();
        for (Phong phong : danhSach.values()) {
            if (phong.getLoaiPhong().equalsIgnoreCase(loaiPhong)) {
                ketQua.add(phong);
            }
        }
        return ketQua;
    }
    
    /**
     * Lấy phòng theo sức chứa
     */
    public List<Phong> timTheoSucChua(int sucChua) {
        List<Phong> ketQua = new ArrayList<>();
        for (Phong phong : danhSach.values()) {
            if (phong.getSucChua() >= sucChua) {
                ketQua.add(phong);
            }
        }
        return ketQua;
    }
}
