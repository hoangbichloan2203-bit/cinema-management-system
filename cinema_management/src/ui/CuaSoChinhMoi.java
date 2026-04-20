package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Cửa sổ chính mới
 */
public class CuaSoChinhMoi extends JFrame {
    
    private JPanel mainContentPanel;
    private JPanel menuPanel;
    private JPanel headerPanel;
    private final List<JPanel> tatCaItemMenu = new ArrayList<>();
    private final List<JPanel> danhSachSubMenu = new ArrayList<>();
    
    private BangDangNhap bangDangNhap;
    private BangDangKy bangDangKy;
    private BangDieuKhienKhachHang bangDieuKhienKhachHang;
    private BangDieuKhienQuanLy bangDieuKhienQuanLy;
    
    private static final Color MAU_NEN_MENU = new Color(31, 32, 44);
    private static final Color MAU_MENU_CHON = new Color(241, 121, 104);
    private static final Color MAU_CHU_TRANG = Color.WHITE;
    
    public CuaSoChinhMoi() {
        setTitle("Hệ thống Quản lý Rạp Chiếu Phim T3L");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Bắt đầu từ BangDangNhap
        hienThiBangDangNhap();
    }
    
    /**
     * Hiển thị BangDangNhap
     */
    public void hienThiBangDangNhap() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        bangDangNhap = new BangDangNhap(this);
        add(bangDangNhap, BorderLayout.CENTER);
        
        revalidate();
        repaint();
    }
    
    /**
     * Hiển thị BangDangKy
     */
    public void hienThiBangDangKy() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        bangDangKy = new BangDangKy(this);
        add(bangDangKy, BorderLayout.CENTER);
        
        revalidate();
        repaint();
    }
    
    /**
     * Hiển thị BangDieuKhienKhachHang
     */
    public void hienThiBangDieuKhienKhachHang() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        headerPanel = taoHeaderPanel("Khách Hàng");
        add(headerPanel, BorderLayout.NORTH);
        
        bangDieuKhienKhachHang = new BangDieuKhienKhachHang();
        add(bangDieuKhienKhachHang, BorderLayout.CENTER);
        
        revalidate();
        repaint();
    }
    
    /**
     * Hiển thị BangDieuKhienQuanLy
     */
    public void hienThiBangDieuKhienQuanLy() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        headerPanel = taoHeaderPanel("Quản Lý");
        add(headerPanel, BorderLayout.NORTH);
        
        bangDieuKhienQuanLy = new BangDieuKhienQuanLy();
        add(bangDieuKhienQuanLy, BorderLayout.CENTER);
        
        revalidate();
        repaint();
    }
    
    /**
     * Tạo Header Panel với thông tin người dùng
     */
    private JPanel taoHeaderPanel(String vaiTro) {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(31, 32, 44));
        header.setBorder(new EmptyBorder(10, 20, 10, 20));
        header.setPreferredSize(new Dimension(0, 60));
        
        // Logo/Title
        JLabel titleLabel = new JLabel("Rạp Chiếu Phim T3L");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(MAU_CHU_TRANG);
        
        // User Info
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 0));
        userPanel.setBackground(new Color(31, 32, 44));
        
        JLabel userLabel = new JLabel("Vai Trò: " + vaiTro);
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        userLabel.setForeground(Color.LIGHT_GRAY);
        
        JButton dangXuatButton = new JButton("Đăng Xuất");
        dangXuatButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        dangXuatButton.setBackground(new Color(241, 121, 104));
        dangXuatButton.setForeground(Color.WHITE);
        dangXuatButton.setFocusPainted(false);
        dangXuatButton.addActionListener(e -> hienThiBangDangNhap());
        
        userPanel.add(userLabel);
        userPanel.add(dangXuatButton);
        
        header.add(titleLabel, BorderLayout.WEST);
        header.add(userPanel, BorderLayout.EAST);
        
        return header;
    }
}
