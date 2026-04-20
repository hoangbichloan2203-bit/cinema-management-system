package dao;

import entity.KhuyenMai;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

/**
 * DAO cho Entity KhuyenMai
 */
public class KhuyenMaiDAO implements DAO<KhuyenMai> {
    
    private static Map<String, KhuyenMai> danhSach = new HashMap<>();
    
    static {
        // Dữ liệu mẫu
        KhuyenMai km1 = new KhuyenMai();
        km1.setMaKM("KM001");
        km1.setTenKM("Giảm 10% cho vé buổi chiều");
        km1.setMoTa("Áp dụng cho tất cả vé buổi chiều từ 14:00 - 17:00");
        km1.setGiaTri(10);
        km1.setMaGiamGia("SALE10");
        km1.setNgayBatDau(LocalDate.now());
        km1.setNgayKetThuc(LocalDate.now().plusDays(30));
        danhSach.put(km1.getMaKM(), km1);
        
        KhuyenMai km2 = new KhuyenMai();
        km2.setMaKM("KM002");
        km2.setTenKM("Giảm 20% cho thẻ VIP");
        km2.setMoTa("Dành riêng cho khách hàng VIP");
        km2.setGiaTri(20);
        km2.setMaGiamGia("VIP20");
        km2.setNgayBatDau(LocalDate.now());
        km2.setNgayKetThuc(LocalDate.now().plusDays(60));
        danhSach.put(km2.getMaKM(), km2);
    }
    
    @Override
    public boolean them(KhuyenMai khuyenMai) {
        if (khuyenMai == null || danhSach.containsKey(khuyenMai.getMaKM())) {
            return false;
        }
        danhSach.put(khuyenMai.getMaKM(), khuyenMai);
        return true;
    }
    
    @Override
    public boolean capNhat(KhuyenMai khuyenMai) {
        if (khuyenMai == null || !danhSach.containsKey(khuyenMai.getMaKM())) {
            return false;
        }
        danhSach.put(khuyenMai.getMaKM(), khuyenMai);
        return true;
    }
    
    @Override
    public boolean xoa(String maKM) {
        if (maKM == null || !danhSach.containsKey(maKM)) {
            return false;
        }
        danhSach.remove(maKM);
        return true;
    }
    
    @Override
    public KhuyenMai layTheoId(String maKM) {
        return danhSach.get(maKM);
    }
    
    @Override
    public List<KhuyenMai> layTat() {
        return new ArrayList<>(danhSach.values());
    }
    
    @Override
    public boolean tonTai(String maKM) {
        return danhSach.containsKey(maKM);
    }
    
    /**
     * Tìm khuyến mãi theo mã giảm giá
     */
    public KhuyenMai timTheoMaGiamGia(String maGiamGia) {
        for (KhuyenMai km : danhSach.values()) {
            if (km.getMaGiamGia().equalsIgnoreCase(maGiamGia)) {
                return km;
            }
        }
        return null;
    }
    
    /**
     * Lấy khuyến mãi đang hoạt động
     */
    public List<KhuyenMai> layKhuyenMaiHoatDong() {
        LocalDate hienTai = LocalDate.now();
        List<KhuyenMai> ketQua = new ArrayList<>();
        for (KhuyenMai km : danhSach.values()) {
            if (hienTai.isAfter(km.getNgayBatDau()) && hienTai.isBefore(km.getNgayKetThuc())) {
                ketQua.add(km);
            }
        }
        return ketQua;
    }
    
    /**
     * Lấy khuyến mãi sắp kết thúc
     */
    public List<KhuyenMai> layKhuyenMaiSapKetThuc(int soNgay) {
        LocalDate hienTai = LocalDate.now();
        List<KhuyenMai> ketQua = new ArrayList<>();
        for (KhuyenMai km : danhSach.values()) {
            if (km.getNgayKetThuc().isAfter(hienTai) && 
                km.getNgayKetThuc().isBefore(hienTai.plusDays(soNgay))) {
                ketQua.add(km);
            }
        }
        return ketQua;
    }
}
