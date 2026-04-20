package dao;

import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * DAO cho Entity NhanVien
 */
public class NhanVienDAO implements DAO<NhanVien> {
    
    private static Map<String, NhanVien> danhSach = new HashMap<>();
    
    static {
        // Dữ liệu mẫu
        NhanVien nv1 = new NhanVien();
        nv1.setMaNV("NV001");
        nv1.setTenNV("Nguyễn Văn A");
        nv1.setEmail("a@cinema.com");
        nv1.setSDT("0912345678");
        nv1.setChucVu("Quản Lý");
        nv1.setLuong(10000000);
        nv1.setTrangThai("Hoạt động");
        danhSach.put(nv1.getMaNV(), nv1);
        
        NhanVien nv2 = new NhanVien();
        nv2.setMaNV("NV002");
        nv2.setTenNV("Trần Thị B");
        nv2.setEmail("b@cinema.com");
        nv2.setSDT("0912345679");
        nv2.setChucVu("Nhân viên Bán Vé");
        nv2.setLuong(5000000);
        nv2.setTrangThai("Hoạt động");
        danhSach.put(nv2.getMaNV(), nv2);
    }
    
    @Override
    public boolean them(NhanVien nhanVien) {
        if (nhanVien == null || danhSach.containsKey(nhanVien.getMaNV())) {
            return false;
        }
        danhSach.put(nhanVien.getMaNV(), nhanVien);
        return true;
    }
    
    @Override
    public boolean capNhat(NhanVien nhanVien) {
        if (nhanVien == null || !danhSach.containsKey(nhanVien.getMaNV())) {
            return false;
        }
        danhSach.put(nhanVien.getMaNV(), nhanVien);
        return true;
    }
    
    @Override
    public boolean xoa(String maNV) {
        if (maNV == null || !danhSach.containsKey(maNV)) {
            return false;
        }
        danhSach.remove(maNV);
        return true;
    }
    
    @Override
    public NhanVien layTheoId(String maNV) {
        return danhSach.get(maNV);
    }
    
    @Override
    public List<NhanVien> layTat() {
        return new ArrayList<>(danhSach.values());
    }
    
    @Override
    public boolean tonTai(String maNV) {
        return danhSach.containsKey(maNV);
    }
    
    /**
     * Tìm nhân viên theo email
     */
    public NhanVien timTheoEmail(String email) {
        for (NhanVien nv : danhSach.values()) {
            if (nv.getEmail().equalsIgnoreCase(email)) {
                return nv;
            }
        }
        return null;
    }
    
    /**
     * Tìm nhân viên theo tên
     */
    public List<NhanVien> timTheoTen(String tenNV) {
        List<NhanVien> ketQua = new ArrayList<>();
        for (NhanVien nv : danhSach.values()) {
            if (nv.getTenNV().toLowerCase().contains(tenNV.toLowerCase())) {
                ketQua.add(nv);
            }
        }
        return ketQua;
    }
    
    /**
     * Tìm nhân viên theo chức vụ
     */
    public List<NhanVien> timTheoChucVu(String chucVu) {
        List<NhanVien> ketQua = new ArrayList<>();
        for (NhanVien nv : danhSach.values()) {
            if (nv.getChucVu().equalsIgnoreCase(chucVu)) {
                ketQua.add(nv);
            }
        }
        return ketQua;
    }
}
