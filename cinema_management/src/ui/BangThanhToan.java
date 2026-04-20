package ui;

import entity.SuatChieu;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

/**
 * Giao diện Thanh Toán
 */
public class BangThanhToan extends JPanel {
    
    private String maSC;
    private List<String> gheMuon;
    private double tongGia;
    
    private JLabel lbTongTien;
    private JLabel lbKhuyenMai;
    private JLabel lbTongCong;
    private JComboBox<String> cbbHinhThucTT;
    private JTextArea taGhiChuDonHang;
    
    public BangThanhToan(String maSC, List<String> gheMuon, double tongGia) {
        this.maSC = maSC;
        this.gheMuon = gheMuon;
        this.tongGia = tongGia;
        
        setLayout(new BorderLayout());
        setBackground(new Color(31, 32, 44));
        
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createPaymentPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }
    
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(31, 32, 44));
        header.setBorder(new EmptyBorder(15, 20, 15, 20));
        header.setPreferredSize(new Dimension(0, 60));
        
        JLabel titleLabel = new JLabel("Xác Nhận Thanh Toán");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        header.add(titleLabel, BorderLayout.WEST);
        
        return header;
    }
    
    private JPanel createPaymentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        
        // Left panel - Order summary
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(31, 32, 44));
        
        JLabel summaryLabel = new JLabel("Tóm Tắt Đơn Hàng");
        summaryLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        summaryLabel.setForeground(Color.WHITE);
        leftPanel.add(summaryLabel, BorderLayout.NORTH);
        
        orderSummaryArea = new JTextArea();
        orderSummaryArea.setEditable(false);
        orderSummaryArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        orderSummaryArea.setBackground(new Color(50, 50, 60));
        orderSummaryArea.setForeground(Color.WHITE);
        orderSummaryArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        orderSummaryArea.setLineWrap(true);
        orderSummaryArea.setWrapStyleWord(true);
        
        updateOrderSummary();
        
        JScrollPane scrollPane = new JScrollPane(orderSummaryArea);
        scrollPane.setBorder(null);
        leftPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Right panel - Payment details
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(31, 32, 44));
        rightPanel.setBorder(new EmptyBorder(0, 30, 0, 0));
        
        // Tổng tiền
        JPanel tongTienPanel = createPriceRow("Tổng Tiền:", String.format("%.0f VND", tongGia));
        rightPanel.add(tongTienPanel);
        rightPanel.add(Box.createVerticalStrut(15));
        
        // Khuyến mãi
        JPanel khuyenMaiPanel = createPriceRow("Khuyến Mãi:", "0 VND");
        rightPanel.add(khuyenMaiPanel);
        rightPanel.add(Box.createVerticalStrut(15));
        
        // Hình thức thanh toán
        JLabel hinhThucLabel = new JLabel("Hình Thức Thanh Toán:");
        hinhThucLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        hinhThucLabel.setForeground(Color.WHITE);
        rightPanel.add(hinhThucLabel);
        
        cbbHinhThucTT = new JComboBox<>(new String[] {
            "Tiền Mặt", "Thẻ Tín Dụng", "Chuyển Khoản", "E-Wallet"
        });
        cbbHinhThucTT.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cbbHinhThucTT.setBackground(new Color(50, 50, 60));
        cbbHinhThucTT.setForeground(Color.WHITE);
        cbbHinhThucTT.setMaximumSize(new Dimension(300, 35));
        rightPanel.add(cbbHinhThucTT);
        rightPanel.add(Box.createVerticalStrut(25));
        
        // Tổng cộng
        JPanel tongCongPanel = new JPanel(new BorderLayout());
        tongCongPanel.setBackground(new Color(31, 32, 44));
        
        JLabel tongCongTitleLabel = new JLabel("Tổng Cộng:");
        tongCongTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tongCongTitleLabel.setForeground(Color.WHITE);
        
        lbTongCong = new JLabel(String.format("%.0f VND", tongGia));
        lbTongCong.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lbTongCong.setForeground(new Color(241, 121, 104));
        
        tongCongPanel.add(tongCongTitleLabel, BorderLayout.WEST);
        tongCongPanel.add(lbTongCong, BorderLayout.EAST);
        rightPanel.add(tongCongPanel);
        
        rightPanel.add(Box.createVerticalGlue());
        
        // Add panels
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(rightPanel, BorderLayout.EAST);
        
        return panel;
    }
    
    private JPanel createPriceRow(String label, String price) {
        JPanel row = new JPanel(new BorderLayout());
        row.setBackground(new Color(31, 32, 44));
        
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        labelComponent.setForeground(Color.WHITE);
        
        JLabel priceComponent = new JLabel(price);
        priceComponent.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        priceComponent.setForeground(Color.LIGHT_GRAY);
        
        row.add(labelComponent, BorderLayout.WEST);
        row.add(priceComponent, BorderLayout.EAST);
        
        if (label.contains("Khuyến Mãi")) {
            discountLabel = priceComponent;
        } else if (label.contains("Tổng Tiền")) {
            subtotalLabel = priceComponent;
        }
        
        return row;
    }
    
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(new Color(31, 32, 44));
        
        JButton thanhToanBtn = new JButton("Thanh Toán");
        thanhToanBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        thanhToanBtn.setBackground(new Color(241, 121, 104));
        thanhToanBtn.setForeground(Color.WHITE);
        thanhToanBtn.setFocusPainted(false);
        thanhToanBtn.setPreferredSize(new Dimension(150, 45));
        
        JButton huyBtn = new JButton("Hủy");
        huyBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        huyBtn.setBackground(new Color(100, 100, 120));
        huyBtn.setForeground(Color.WHITE);
        huyBtn.setFocusPainted(false);
        huyBtn.setPreferredSize(new Dimension(150, 45));
        
        buttonPanel.add(thanhToanBtn);
        buttonPanel.add(huyBtn);
        
        return buttonPanel;
    }
    
    private void capNhatTomTatDonHang() {
        StringBuilder tomTat = new StringBuilder();
        tomTat.append("═════════════════════════════════════\n");
        tomTat.append("Suất Chiếu ID: ").append(maSC).append("\n");
        tomTat.append("Số Ghế: ").append(gheMuon.size()).append("\n");
        tomTat.append("ID Ghế: ");
        for (int i = 0; i < gheMuon.size(); i++) {
            tomTat.append(gheMuon.get(i));
            if (i < gheMuon.size() - 1) tomTat.append(", ");
        }
        tomTat.append("\n");
        tomTat.append("═════════════════════════════════════\n");
        tomTat.append("\nGiá tiền chi tiết:\n");
        tomTat.append("• Giá vé: ").append(String.format("%.0f VND", tongGia / gheMuon.size())).append("/ghế\n");
        tomTat.append("• Số ghế: ").append(gheMuon.size()).append("\n");
        tomTat.append("• Tổng: ").append(String.format("%.0f VND", tongGia)).append("\n");
        
        taGhiChuDonHang.setText(tomTat.toString());
    }
}
