package ui;

import services.AuthService;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Giao diện Đăng Nhập
 */
public class BangDangNhap extends JPanel {
    
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel errorLabel;
    private AuthService authService;
    
    public BangDangNhap() {
        this.authService = new AuthService();
        setLayout(new BorderLayout());
        setBackground(new Color(31, 32, 44));
        
        add(createLoginForm(), BorderLayout.CENTER);
    }
    
    private JPanel createLoginForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(31, 32, 44));
        formPanel.setBorder(new EmptyBorder(60, 100, 60, 100));
        
        // Title
        JLabel titleLabel = new JLabel("Đăng Nhập Hệ Thống");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        formPanel.add(titleLabel);
        formPanel.add(Box.createVerticalStrut(30));
        
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
        formPanel.add(Box.createVerticalStrut(15));
        
        // Password
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.WHITE);
        formPanel.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setMaximumSize(new Dimension(400, 40));
        passwordField.setBackground(new Color(50, 50, 60));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        formPanel.add(passwordField);
        formPanel.add(Box.createVerticalStrut(20));
        
        // Error Label
        errorLabel = new JLabel("");
        errorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        errorLabel.setForeground(new Color(241, 121, 104));
        errorLabel.setAlignmentX(LEFT_ALIGNMENT);
        formPanel.add(errorLabel);
        formPanel.add(Box.createVerticalStrut(10));
        
        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(new Color(31, 32, 44));
        
        loginButton = new JButton("Đăng Nhập");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setBackground(new Color(241, 121, 104));
        loginButton.setForeground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(150, 45));
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(this::handleLogin);
        
        registerButton = new JButton("Đăng Ký");
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        registerButton.setBackground(new Color(100, 100, 120));
        registerButton.setForeground(Color.WHITE);
        registerButton.setPreferredSize(new Dimension(150, 45));
        registerButton.setFocusPainted(false);
        
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        formPanel.add(buttonPanel);
        
        formPanel.add(Box.createVerticalGlue());
        return formPanel;
    }
    
    private void handleLogin(ActionEvent e) {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        
        if (email.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Vui lòng nhập đầy đủ email và mật khẩu");
            return;
        }
        
        // Thử đăng nhập nhân viên trước
        if (authService.dangNhapNhanVien(email, password)) {
            errorLabel.setText("");
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công! Vai trò: Nhân Viên", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
            emailField.setText("");
            passwordField.setText("");
            // TODO: Chuyển tới admin dashboard
            return;
        }
        
        // Thử đăng nhập khách hàng
        if (authService.dangNhapKhachHang(email, password)) {
            errorLabel.setText("");
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công! Vai trò: Khách Hàng", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
            emailField.setText("");
            passwordField.setText("");
            // TODO: Chuyển tới customer dashboard
            return;
        }
        
        errorLabel.setText("Email hoặc mật khẩu không đúng");
    }
}
