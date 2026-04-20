package ui;

import services.AuthService;
import entity.NhanVien;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Giao diện Admin Dashboard
 */
public class AdminDashboard extends JPanel {
    
    private JTabbedPane tabbedPane;
    private JLabel welcomeLabel;
    
    public AdminDashboard() {
        setLayout(new BorderLayout());
        setBackground(new Color(31, 32, 44));
        
        add(createHeader(), BorderLayout.NORTH);
        add(createMainContent(), BorderLayout.CENTER);
        add(createFooter(), BorderLayout.SOUTH);
    }
    
    private JPanel createHeader() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(25, 25, 35));
        headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        
        JLabel titleLabel = new JLabel("Bảng Điều Khiển Admin");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel, BorderLayout.WEST);
        
        NhanVien nhanVien = AuthService.getNhanVienHienTai();
        welcomeLabel = new JLabel("Xin chào: " + (nhanVien != null ? nhanVien.getTenNV() : "Admin"));
        welcomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        welcomeLabel.setForeground(new Color(200, 200, 200));
        
        JButton logoutButton = new JButton("Đăng Xuất");
        logoutButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        logoutButton.setBackground(new Color(241, 121, 104));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setPreferredSize(new Dimension(100, 35));
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(this::handleLogout);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        rightPanel.setBackground(new Color(25, 25, 35));
        rightPanel.add(welcomeLabel);
        rightPanel.add(logoutButton);
        
        headerPanel.add(rightPanel, BorderLayout.EAST);
        
        return headerPanel;
    }
    
    private JPanel createMainContent() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(31, 32, 44));
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(31, 32, 44));
        tabbedPane.setForeground(Color.WHITE);
        
        // Tab Quản Lý Phim
        tabbedPane.addTab("Quản Lý Phim", createPhimPanel());
        
        // Tab Quản Lý Phòng Chiếu
        tabbedPane.addTab("Quản Lý Phòng", createPhongPanel());
        
        // Tab Quản Lý Suất Chiếu
        tabbedPane.addTab("Quản Lý Suất Chiếu", createSuatChieuPanel());
        
        // Tab Quản Lý Nhân Viên
        tabbedPane.addTab("Quản Lý Nhân Viên", createNhanVienPanel());
        
        // Tab Quản Lý Khách Hàng
        tabbedPane.addTab("Quản Lý Khách Hàng", createKhachHangPanel());
        
        // Tab Quản Lý Khuyến Mãi
        tabbedPane.addTab("Quản Lý Khuyến Mãi", createKhuyenMaiPanel());
        
        // Tab Thống Kê
        tabbedPane.addTab("Thống Kê", createThongKePanel());
        
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        
        return mainPanel;
    }
    
    private JPanel createPhimPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel label = new JLabel("Quản Lý Danh Sách Phim");
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(50, 50, 60));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JTextArea textArea = new JTextArea("Chức năng quản lý phim:\n\n" +
                "• Thêm phim mới\n" +
                "• Sửa thông tin phim\n" +
                "• Xóa phim\n" +
                "• Xem danh sách phim\n" +
                "• Quản lý đánh giá phim");
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textArea.setBackground(new Color(50, 50, 60));
        textArea.setForeground(Color.WHITE);
        
        contentPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(contentPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createPhongPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel label = new JLabel("Quản Lý Phòng Chiếu");
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(50, 50, 60));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JTextArea textArea = new JTextArea("Chức năng quản lý phòng chiếu:\n\n" +
                "• Thêm phòng chiếu mới\n" +
                "• Sửa thông tin phòng\n" +
                "• Xóa phòng\n" +
                "• Xem danh sách phòng\n" +
                "• Quản lý sức chứa và loại phòng");
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textArea.setBackground(new Color(50, 50, 60));
        textArea.setForeground(Color.WHITE);
        
        contentPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(contentPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createSuatChieuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel label = new JLabel("Quản Lý Suất Chiếu");
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(50, 50, 60));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JTextArea textArea = new JTextArea("Chức năng quản lý suất chiếu:\n\n" +
                "• Tạo lịch chiếu\n" +
                "• Sửa giờ chiếu\n" +
                "• Xóa suất chiếu\n" +
                "• Xem danh sách suất chiếu\n" +
                "• Quản lý giá vé");
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textArea.setBackground(new Color(50, 50, 60));
        textArea.setForeground(Color.WHITE);
        
        contentPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(contentPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createNhanVienPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel label = new JLabel("Quản Lý Nhân Viên");
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(50, 50, 60));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JTextArea textArea = new JTextArea("Chức năng quản lý nhân viên:\n\n" +
                "• Thêm nhân viên mới\n" +
                "• Sửa thông tin nhân viên\n" +
                "• Xóa nhân viên\n" +
                "• Xem danh sách nhân viên\n" +
                "• Quản lý chức vụ và lương");
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textArea.setBackground(new Color(50, 50, 60));
        textArea.setForeground(Color.WHITE);
        
        contentPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(contentPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createKhachHangPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel label = new JLabel("Quản Lý Khách Hàng");
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(50, 50, 60));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JTextArea textArea = new JTextArea("Chức năng quản lý khách hàng:\n\n" +
                "• Xem danh sách khách hàng\n" +
                "• Xem lịch sử mua vé\n" +
                "• Quản lý điểm tích lũy\n" +
                "• Xem thông tin cá nhân\n" +
                "• Quản lý liên hệ khách hàng");
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textArea.setBackground(new Color(50, 50, 60));
        textArea.setForeground(Color.WHITE);
        
        contentPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(contentPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createKhuyenMaiPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel label = new JLabel("Quản Lý Khuyến Mãi");
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(50, 50, 60));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JTextArea textArea = new JTextArea("Chức năng quản lý khuyến mãi:\n\n" +
                "• Tạo chương trình khuyến mãi\n" +
                "• Sửa thông tin khuyến mãi\n" +
                "• Xóa khuyến mãi\n" +
                "• Xem danh sách khuyến mãi\n" +
                "• Quản lý mã giảm giá");
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textArea.setBackground(new Color(50, 50, 60));
        textArea.setForeground(Color.WHITE);
        
        contentPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(contentPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createThongKePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel label = new JLabel("Thống Kê & Báo Cáo");
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(50, 50, 60));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JTextArea textArea = new JTextArea("Chức năng thống kê:\n\n" +
                "• Thống kê doanh thu\n" +
                "• Thống kê số vé bán\n" +
                "• Phim yêu thích nhất\n" +
                "• Phòng chiếu được sử dụng nhiều nhất\n" +
                "• Báo cáo tài chính");
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textArea.setBackground(new Color(50, 50, 60));
        textArea.setForeground(Color.WHITE);
        
        contentPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(contentPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createFooter() {
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(25, 25, 35));
        footerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        
        JLabel copyrightLabel = new JLabel("© 2024 Hệ Thống Quản Lý Rạp Chiếu Phim");
        copyrightLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        copyrightLabel.setForeground(new Color(150, 150, 150));
        
        footerPanel.add(copyrightLabel);
        
        return footerPanel;
    }
    
    private void handleLogout(ActionEvent e) {
        AuthService.dangXuat();
        JOptionPane.showMessageDialog(this, "Đã đăng xuất thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        // TODO: Chuyển về trang đăng nhập
    }
}
