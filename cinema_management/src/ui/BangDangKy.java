package ui;

import services.AuthService;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Giao diện Đăng Ký
 */
public class BangDangKy extends JPanel {
    
    private JTextField hoTenField;
    private JTextField emailField;
    private JTextField sdtField;
    private JPasswordField matKhauField;
    private JPasswordField xacNhanMatKhauField;
    private JButton dangKyButton;
    private JButton quayLaiButton;
    private JLabel lbiBaoLoi;
    private AuthService authService;
    private CuaSoChinhMoi parentFrame;
    
    public BangDangKy(CuaSoChinhMoi parentFrame) {
        this.parentFrame = parentFrame;
        this.authService = new AuthService();
        setLayout(new BorderLayout());
        setBackground(new Color(31, 32, 44));
        
        add(createRegisterForm(), BorderLayout.CENTER);
    }
    
    private JPanel createRegisterForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(31, 32, 44));
        formPanel.setBorder(new EmptyBorder(40, 100, 40, 100));
        
        // Title
        JLabel titleLabel = new JLabel("Đăng Ký Tài Khoản");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        formPanel.add(titleLabel);
        formPanel.add(Box.createVerticalStrut(25));
        
        // Họ và tên
        JLabel hoTenLabel = new JLabel("Họ và tên:");
        hoTenLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        hoTenLabel.setForeground(Color.WHITE);
        formPanel.add(hoTenLabel);
        
        hoTenField = new JTextField();
        hoTenField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        hoTenField.setMaximumSize(new Dimension(400, 40));
        hoTenField.setBackground(new Color(50, 50, 60));
        hoTenField.setForeground(Color.WHITE);
        hoTenField.setCaretColor(Color.WHITE);
        formPanel.add(hoTenField);
        formPanel.add(Box.createVerticalStrut(12));
        
        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailLabel.setForeground(Color.WHITE);
        formPanel.add(emailLabel);
        
        emailField = new JTextField();
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setMaximumSize(new Dimension(400, 40));
        emailField.setBackground(new Color(50, 50, 60));
        emailField.setForeground(Color.WHITE);
        emailField.setCaretColor(Color.WHITE);
        formPanel.add(emailField);
        formPanel.add(Box.createVerticalStrut(12));
        
        // Số điện thoại
        JLabel sdtLabel = new JLabel("Số điện thoại:");
        sdtLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        sdtLabel.setForeground(Color.WHITE);
        formPanel.add(sdtLabel);
        
        sdtField = new JTextField();
        sdtField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        sdtField.setMaximumSize(new Dimension(400, 40));
        sdtField.setBackground(new Color(50, 50, 60));
        sdtField.setForeground(Color.WHITE);
        sdtField.setCaretColor(Color.WHITE);
        formPanel.add(sdtField);
        formPanel.add(Box.createVerticalStrut(12));
        
        // Mật khẩu
        JLabel matKhauLabel = new JLabel("Mật khẩu:");
        matKhauLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        matKhauLabel.setForeground(Color.WHITE);
        formPanel.add(matKhauLabel);
        
        matKhauField = new JPasswordField();
        matKhauField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        matKhauField.setMaximumSize(new Dimension(400, 40));
        matKhauField.setBackground(new Color(50, 50, 60));
        matKhauField.setForeground(Color.WHITE);
        matKhauField.setCaretColor(Color.WHITE);
        formPanel.add(matKhauField);
        formPanel.add(Box.createVerticalStrut(12));
        
        // Xác nhận mật khẩu
        JLabel xacNhanLabel = new JLabel("Xác nhận mật khẩu:");
        xacNhanLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        xacNhanLabel.setForeground(Color.WHITE);
        formPanel.add(xacNhanLabel);
        
        xacNhanMatKhauField = new JPasswordField();
        xacNhanMatKhauField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        xacNhanMatKhauField.setMaximumSize(new Dimension(400, 40));
        xacNhanMatKhauField.setBackground(new Color(50, 50, 60));
        xacNhanMatKhauField.setForeground(Color.WHITE);
        xacNhanMatKhauField.setCaretColor(Color.WHITE);
        formPanel.add(xacNhanMatKhauField);
        formPanel.add(Box.createVerticalStrut(15));
        
        // Thông báo lỗi
        lbiBaoLoi = new JLabel("");
        lbiBaoLoi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lbiBaoLoi.setForeground(new Color(241, 121, 104));
        formPanel.add(lbiBaoLoi);
        formPanel.add(Box.createVerticalStrut(10));
        
        // Panel nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(new Color(31, 32, 44));
        
        dangKyButton = new JButton("Đăng Ký");
        dangKyButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        dangKyButton.setBackground(new Color(241, 121, 104));
        dangKyButton.setForeground(Color.WHITE);
        dangKyButton.setPreferredSize(new Dimension(150, 45));
        dangKyButton.setFocusPainted(false);
        dangKyButton.addActionListener(this::handleRegister);
        
        quayLaiButton = new JButton("Quay Lại");
        quayLaiButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        quayLaiButton.setBackground(new Color(100, 100, 120));
        quayLaiButton.setForeground(Color.WHITE);
        quayLaiButton.setPreferredSize(new Dimension(150, 45));
        quayLaiButton.setFocusPainted(false);
        quayLaiButton.addActionListener(e -> parentFrame.hienThiBangDangNhap());
        
        buttonPanel.add(dangKyButton);
        buttonPanel.add(quayLaiButton);
        formPanel.add(buttonPanel);
        
        formPanel.add(Box.createVerticalGlue());
        return formPanel;
    }
    
    private void xoaNoiDung() {
        hoTenField.setText("");
        emailField.setText("");
        sdtField.setText("");
        matKhauField.setText("");
        xacNhanMatKhauField.setText("");
    }
    
    private void handleRegister(ActionEvent e) {
        String hoTen = hoTenField.getText().trim();
        String email = emailField.getText().trim();
        String sdt = sdtField.getText().trim();
        String matKhau = new String(matKhauField.getPassword());
        String xacNhan = new String(xacNhanMatKhauField.getPassword());
        
        // Kiểm tra nhập liệu
        if (hoTen.isEmpty() || email.isEmpty() || sdt.isEmpty() || matKhau.isEmpty()) {
            lbiBaoLoi.setText("Vui lòng nhập đầy đủ thông tin");
            return;
        }
        
        if (!matKhau.equals(xacNhan)) {
            lbiBaoLoi.setText("Mật khẩu xác nhận không khớp");
            return;
        }
        
        if (matKhau.length() < 6) {
            lbiBaoLoi.setText("Mật khẩu phải có ít nhất 6 ký tự");
            return;
        }
        
        // Đăng ký tài khoản
        if (authService.dangKyKhachHang(hoTen, email, sdt, matKhau)) {
            lbiBaoLoi.setText("");
            JOptionPane.showMessageDialog(this, "Đăng ký thành công! Bạn có thể đăng nhập ngay", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
            xoaNoiDung();
            parentFrame.hienThiBangDangNhap();
        } else {
            lbiBaoLoi.setText("Email đã tồn tại hoặc lỗi khi đăng ký");
        }
    }
}
