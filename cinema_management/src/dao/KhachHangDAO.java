package dao;

import entity.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * DAO cho Entity KhachHang
 */
public class KhachHangDAO implements DAO<KhachHang> {
    
    private static Map<String, KhachHang> danhSach = new HashMap<>();
    
    static {
        // Dữ liệu mẫu
        KhachHang kh1 = new KhachHang();
        kh1.setMaKH("KH001");
        kh1.setTenKhachHang("Đỗ Quang Huy");
        kh1.setEmail("huy@example.com");
        kh1.setSDT("0987654321");
        kh1.setDiemTichLuy(500);
        danhSach.put(kh1.getMaKH(), kh1);
        
        KhachHang kh2 = new KhachHang();
        kh2.setMaKH("KH002");
        kh2.setTenKhachHang("Lê Thị Hương");
        kh2.setEmail("huong@example.com");
        kh2.setSDT("0987654322");
        kh2.setDiemTichLuy(1000);
        danhSach.put(kh2.getMaKH(), kh2);
    }
    
    @Override
    public boolean them(KhachHang khachHang) {
        if (khachHang == null || danhSach.containsKey(khachHang.getMaKH())) {
            return false;
        }
        danhSach.put(khachHang.getMaKH(), khachHang);
        return true;
    }
    
    @Override
    public boolean capNhat(KhachHang khachHang) {
        if (khachHang == null || !danhSach.containsKey(khachHang.getMaKH())) {
            return false;
        }
        danhSach.put(khachHang.getMaKH(), khachHang);
        return true;
    }
    
    @Override
    public boolean xoa(String maKH) {
        if (maKH == null || !danhSach.containsKey(maKH)) {
            return false;
        }
        danhSach.remove(maKH);
        return true;
    }
    
    @Override
    public KhachHang layTheoId(String maKH) {
        return danhSach.get(maKH);
    }
    
    @Override
    public List<KhachHang> layTat() {
        return new ArrayList<>(danhSach.values());
    }
    
    @Override
    public boolean tonTai(String maKH) {
        return danhSach.containsKey(maKH);
    }
    
    /**
     * Tìm khách hàng theo email
     */
    public KhachHang timTheoEmail(String email) {
        for (KhachHang kh : danhSach.values()) {
            if (kh.getEmail().equalsIgnoreCase(email)) {
                return kh;
            }
        }
        return null;
    }
    
    /**
     * Tìm khách hàng theo tên
     */
    public List<KhachHang> timTheoTen(String tenKH) {
        List<KhachHang> ketQua = new ArrayList<>();
        for (KhachHang kh : danhSach.values()) {
            if (kh.getTenKhachHang().toLowerCase().contains(tenKH.toLowerCase())) {
                ketQua.add(kh);
            }
        }
        return ketQua;
    }
    
    /**
     * Tìm khách hàng theo số điện thoại
     */
    public KhachHang timTheoSDT(String sdt) {
        for (KhachHang kh : danhSach.values()) {
            if (kh.getSDT().equals(sdt)) {
                return kh;
            }
        }
        return null;
    }
    
    /**
     * Lấy khách hàng VIP (có điểm tích lũy > 1000)
     */
    public List<KhachHang> layKhachHangVIP() {
        List<KhachHang> ketQua = new ArrayList<>();
        for (KhachHang kh : danhSach.values()) {
            if (kh.getDiemTichLuy() >= 1000) {
                ketQua.add(kh);
            }
        }
        return ketQua;
    }
}
