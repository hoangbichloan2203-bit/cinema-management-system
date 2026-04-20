package ui;

import services.AuthService;
import dao.SuatChieuDAO;
import dao.PhimDAO;
import entity.KhachHang;
import entity.SuatChieu;
import entity.Phim;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Giao diện Customer Dashboard
 */
public class CustomerDashboard extends JPanel {
    
    private JTabbedPane tabbedPane;
    private JLabel welcomeLabel;
    private SuatChieuDAO suatChieuDAO;
    private PhimDAO phimDAO;
    private JTable suatChieuTable;
    private DefaultTableModel tableModel;
    
    public CustomerDashboard() {
        this.suatChieuDAO = new SuatChieuDAO();
        this.phimDAO = new PhimDAO();
        
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
        
        JLabel titleLabel = new JLabel("Đặt Vé Xem Phim");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel, BorderLayout.WEST);
        
        KhachHang khachHang = AuthService.getKhachHangHienTai();
        welcomeLabel = new JLabel("Xin chào: " + (khachHang != null ? khachHang.getTenKhachHang() : "Khách Hàng"));
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
        
        // Tab Xem Lịch Chiếu
        tabbedPane.addTab("Lịch Chiếu", createLichChieuPanel());
        
        // Tab Mua Vé
        tabbedPane.addTab("Mua Vé", createMuaVePanel());
        
        // Tab Vé Của Tôi
        tabbedPane.addTab("Vé Của Tôi", createVeCuaTôiPanel());
        
        // Tab Khuyến Mãi
        tabbedPane.addTab("Khuyến Mãi", createKhuyenMaiPanel());
        
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        
        return mainPanel;
    }
    
    private JPanel createLichChieuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel titleLabel = new JLabel("Lịch Chiếu Phim");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        // Tạo table hiển thị suất chiếu
        String[] columnNames = {"Mã Suất", "Phim", "Ngày", "Giờ", "Phòng", "Giá Vé", "Vé Còn"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        suatChieuTable = new JTable(tableModel);
        suatChieuTable.setBackground(new Color(50, 50, 60));
        suatChieuTable.setForeground(Color.WHITE);
        suatChieuTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        suatChieuTable.getTableHeader().setBackground(new Color(40, 40, 50));
        suatChieuTable.getTableHeader().setForeground(Color.WHITE);
        suatChieuTable.setRowHeight(25);
        
        // Thêm dữ liệu suất chiếu
        loadSuatChieuData();
        
        JScrollPane scrollPane = new JScrollPane(suatChieuTable);
        scrollPane.setBackground(new Color(31, 32, 44));
        scrollPane.getViewport().setBackground(new Color(31, 32, 44));
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void loadSuatChieuData() {
        tableModel.setRowCount(0);
        List<SuatChieu> danhSach = suatChieuDAO.layTat();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        
        for (SuatChieu suatChieu : danhSach) {
            Phim phim = phimDAO.layTheoId(suatChieu.getMaPhim());
            String tenPhim = phim != null ? phim.getTenPhim() : "N/A";
            
            Object[] row = {
                suatChieu.getMaSuatChieu(),
                tenPhim,
                suatChieu.getThoiGianChieu().format(dateFormatter),
                suatChieu.getThoiGianChieu().format(timeFormatter),
                suatChieu.getMaPhong(),
                suatChieu.getGiaVe() + " đ",
                suatChieu.getSoVeConLai()
            };
            tableModel.addRow(row);
        }
    }
    
    private JPanel createMuaVePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel titleLabel = new JLabel("Mua Vé");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(50, 50, 60));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Chọn suất chiếu
        JLabel suatChieuLabel = new JLabel("Chọn Suất Chiếu:");
        suatChieuLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        suatChieuLabel.setForeground(Color.WHITE);
        contentPanel.add(suatChieuLabel);
        
        JComboBox<String> suatChieuCombo = new JComboBox<>();
        suatChieuCombo.setBackground(new Color(60, 60, 70));
        suatChieuCombo.setForeground(Color.WHITE);
        suatChieuCombo.setMaximumSize(new Dimension(400, 35));
        
        List<SuatChieu> danhSach = suatChieuDAO.layTat();
        for (SuatChieu sc : danhSach) {
            Phim phim = phimDAO.layTheoId(sc.getMaPhim());
            String tenPhim = phim != null ? phim.getTenPhim() : "N/A";
            suatChieuCombo.addItem(sc.getMaSuatChieu() + " - " + tenPhim);
        }
        contentPanel.add(suatChieuCombo);
        contentPanel.add(Box.createVerticalStrut(15));
        
        // Chọn số lượng vé
        JLabel soVeLabel = new JLabel("Số Vé:");
        soVeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        soVeLabel.setForeground(Color.WHITE);
        contentPanel.add(soVeLabel);
        
        JSpinner soVeSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        soVeSpinner.setMaximumSize(new Dimension(100, 35));
        contentPanel.add(soVeSpinner);
        contentPanel.add(Box.createVerticalStrut(20));
        
        JButton muaButton = new JButton("Mua Vé");
        muaButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        muaButton.setBackground(new Color(241, 121, 104));
        muaButton.setForeground(Color.WHITE);
        muaButton.setPreferredSize(new Dimension(150, 45));
        muaButton.setFocusPainted(false);
        muaButton.addActionListener(e -> handleMuaVe(suatChieuCombo, soVeSpinner));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(new Color(50, 50, 60));
        buttonPanel.add(muaButton);
        
        contentPanel.add(buttonPanel);
        contentPanel.add(Box.createVerticalGlue());
        
        panel.add(new JScrollPane(contentPanel), BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createVeCuaTôiPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel titleLabel = new JLabel("Vé Của Tôi");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(50, 50, 60));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JTextArea textArea = new JTextArea("Chức năng xem vé:\n\n" +
                "• Xem danh sách vé đã mua\n" +
                "• Xem chi tiết vé\n" +
                "• Hủy vé (nếu còn thời gian)\n" +
                "• In vé\n" +
                "• Xem lịch sử mua vé");
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
        
        JLabel titleLabel = new JLabel("Khuyến Mãi");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(50, 50, 60));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JTextArea textArea = new JTextArea("Các chương trình khuyến mãi:\n\n" +
                "• Giảm 10% cho vé buổi chiều\n" +
                "• Mua 5 vé được tặng 1 vé\n" +
                "• Khách hàng VIP được giảm 20%\n" +
                "• Ưu đãi sinh nhật\n" +
                "• Chương trình điểm thưởng");
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
    
    private void handleMuaVe(JComboBox<String> suatChieuCombo, JSpinner soVeSpinner) {
        String selected = (String) suatChieuCombo.getSelectedItem();
        int soVe = (int) soVeSpinner.getValue();
        
        if (selected != null) {
            String maSuatChieu = selected.split(" - ")[0];
            SuatChieu suatChieu = suatChieuDAO.layTheoId(maSuatChieu);
            
            if (suatChieu != null && suatChieu.getSoVeConLai() >= soVe) {
                int totalPrice = (int) (suatChieu.getGiaVe() * soVe);
                JOptionPane.showMessageDialog(this, 
                    "Mua thành công!\nTổng tiền: " + totalPrice + " đ\nSố vé: " + soVe, 
                    "Thành Công", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                // Giảm số vé còn lại
                suatChieu.setSoVeConLai(suatChieu.getSoVeConLai() - soVe);
                suatChieuDAO.capNhat(suatChieu);
                loadSuatChieuData();
            } else {
                JOptionPane.showMessageDialog(this, "Vé không đủ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void handleLogout(ActionEvent e) {
        AuthService.dangXuat();
        JOptionPane.showMessageDialog(this, "Đã đăng xuất thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        // TODO: Chuyển về trang đăng nhập
    }
}
