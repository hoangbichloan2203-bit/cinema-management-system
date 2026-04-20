package ui;

import entity.Ve;
import entity.SuatChieu;
import entity.Phim;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Giao diện Lịch Sử Vé
 */
public class BangLichSuVe extends JPanel {
    
    private JTable veTable;
    private DefaultTableModel tableModel;
    
    public BangLichSuVe() {
        setLayout(new BorderLayout());
        setBackground(new Color(31, 32, 44));
        
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createTablePanel(), BorderLayout.CENTER);
    }
    
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(31, 32, 44));
        header.setBorder(new EmptyBorder(15, 20, 15, 20));
        header.setPreferredSize(new Dimension(0, 60));
        
        JLabel titleLabel = new JLabel("Lịch Sử Vé Của Tôi");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        header.add(titleLabel, BorderLayout.WEST);
        
        return header;
    }
    
    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(new Color(31, 32, 44));
        tablePanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        
        tableModel = new DefaultTableModel(new Object[] {
            "Mã Vé", "Phim", "Phòng", "Ghế", "Giờ Chiếu", "Giá", "Trạng Thái"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        veTable = new JTable(tableModel);
        veTable.setBackground(new Color(50, 50, 60));
        veTable.setForeground(Color.WHITE);
        veTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        veTable.getTableHeader().setBackground(new Color(241, 121, 104));
        veTable.getTableHeader().setForeground(Color.WHITE);
        veTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        veTable.setRowHeight(25);
        veTable.setSelectionBackground(new Color(241, 121, 104));
        
        JScrollPane scrollPane = new JScrollPane(veTable);
        scrollPane.setBackground(new Color(31, 32, 44));
        scrollPane.getVerticalScrollBar().setBackground(new Color(50, 50, 60));
        scrollPane.getHorizontalScrollBar().setBackground(new Color(50, 50, 60));
        
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        // Panel nút
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(31, 32, 44));
        
        JButton lamMoiBtn = createButton("Làm Mới");
        JButton xemChiTietBtn = createButton("Xem Chi Tiết");
        JButton inVeBtn = createButton("In Vé");
        
        buttonPanel.add(lamMoiBtn);
        buttonPanel.add(xemChiTietBtn);
        buttonPanel.add(inVeBtn);
        
        tablePanel.add(buttonPanel, BorderLayout.SOUTH);
        
        return tablePanel;
    }
    
    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBackground(new Color(241, 121, 104));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(120, 35));
        return btn;
    }
}
