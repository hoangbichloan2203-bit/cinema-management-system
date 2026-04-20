package dao;

import java.util.List;

/**
 * Interface DAO generic cho các Entity
 */
public interface DAO<T> {
    
    /**
     * Thêm một đối tượng
     */
    boolean them(T obj);
    
    /**
     * Cập nhật một đối tượng
     */
    boolean capNhat(T obj);
    
    /**
     * Xóa một đối tượng theo ID
     */
    boolean xoa(String id);
    
    /**
     * Lấy một đối tượng theo ID
     */
    T layTheoId(String id);
    
    /**
     * Lấy tất cả đối tượng
     */
    List<T> layTat();
    
    /**
     * Kiểm tra tồn tại
     */
    boolean tonTai(String id);
}
