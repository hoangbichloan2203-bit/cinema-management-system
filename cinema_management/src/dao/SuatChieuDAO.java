package dao;

import entity.SuatChieu;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 * DAO cho Entity SuatChieu
 */
public class SuatChieuDAO implements DAO<SuatChieu> {
    
    private static Map<String, SuatChieu> danhSach = new HashMap<>();
    
    static {
        // Dữ liệu mẫu
        SuatChieu suatChieu1 = new SuatChieu();
        suatChieu1.setMaSuatChieu("SC001");
        suatChieu1.setMaPhim("P001");
        suatChieu1.setMaPhong("P001");
        suatChieu1.setThoiGianChieu(LocalDateTime.now().plusDays(1).withHour(14).withMinute(0));
        suatChieu1.setGiaVe(120000);
        suatChieu1.setSoVeConLai(80);
        danhSach.put(suatChieu1.getMaSuatChieu(), suatChieu1);
    }
    
    @Override
    public boolean them(SuatChieu suatChieu) {
        if (suatChieu == null || danhSach.containsKey(suatChieu.getMaSuatChieu())) {
            return false;
        }
        danhSach.put(suatChieu.getMaSuatChieu(), suatChieu);
        return true;
    }
    
    @Override
    public boolean capNhat(SuatChieu suatChieu) {
        if (suatChieu == null || !danhSach.containsKey(suatChieu.getMaSuatChieu())) {
            return false;
        }
        danhSach.put(suatChieu.getMaSuatChieu(), suatChieu);
        return true;
    }
    
    @Override
    public boolean xoa(String maSuatChieu) {
        if (maSuatChieu == null || !danhSach.containsKey(maSuatChieu)) {
            return false;
        }
        danhSach.remove(maSuatChieu);
        return true;
    }
    
    @Override
    public SuatChieu layTheoId(String maSuatChieu) {
        return danhSach.get(maSuatChieu);
    }
    
    @Override
    public List<SuatChieu> layTat() {
        return new ArrayList<>(danhSach.values());
    }
    
    @Override
    public boolean tonTai(String maSuatChieu) {
        return danhSach.containsKey(maSuatChieu);
    }
    
    /**
     * Tìm suất chiếu theo phim
     */
    public List<SuatChieu> timTheoPhim(String maPhim) {
        List<SuatChieu> ketQua = new ArrayList<>();
        for (SuatChieu suatChieu : danhSach.values()) {
            if (suatChieu.getMaPhim().equals(maPhim)) {
                ketQua.add(suatChieu);
            }
        }
        return ketQua;
    }
    
    /**
     * Tìm suất chiếu theo phòng
     */
    public List<SuatChieu> timTheoPhong(String maPhong) {
        List<SuatChieu> ketQua = new ArrayList<>();
        for (SuatChieu suatChieu : danhSach.values()) {
            if (suatChieu.getMaPhong().equals(maPhong)) {
                ketQua.add(suatChieu);
            }
        }
        return ketQua;
    }
    
    /**
     * Tìm suất chiếu theo ngày
     */
    public List<SuatChieu> timTheoNgay(LocalDate ngay) {
        List<SuatChieu> ketQua = new ArrayList<>();
        for (SuatChieu suatChieu : danhSach.values()) {
            if (suatChieu.getThoiGianChieu().toLocalDate().equals(ngay)) {
                ketQua.add(suatChieu);
            }
        }
        return ketQua;
    }
    
    /**
     * Tìm suất chiếu sắp tới
     */
    public List<SuatChieu> timSapToi(int soNgay) {
        LocalDate hienTai = LocalDate.now();
        List<SuatChieu> ketQua = new ArrayList<>();
        for (SuatChieu suatChieu : danhSach.values()) {
            LocalDate ngayChieu = suatChieu.getThoiGianChieu().toLocalDate();
            if (ngayChieu.isAfter(hienTai) && ngayChieu.isBefore(hienTai.plusDays(soNgay))) {
                ketQua.add(suatChieu);
            }
        }
        return ketQua;
    }
}
