package ui;

import entity.Phim;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Giao diện Danh Sách Phim
 */
public class BangDanhSachPhim extends JPanel {
    
    private JTable phimTable;
    private DefaultTableModel tableModel;
    
    public BangDanhSachPhim() {
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
        
        JLabel titleLabel = new JLabel("Danh Sách Phim");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        header.add(titleLabel, BorderLayout.WEST);
        
        return header;
    }
    
    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(new Color(31, 32, 44));
        tablePanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        
        // Tạo table model với các cột
        tableModel = new DefaultTableModel(new Object[] {
            "Mã Phim", "Tên Phim", "Đạo Diễn", "Thể Loại", "Thời Lượng"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        phimTable = new JTable(tableModel);
        phimTable.setBackground(new Color(50, 50, 60));
        phimTable.setForeground(Color.WHITE);
        phimTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        phimTable.getTableHeader().setBackground(new Color(241, 121, 104));
        phimTable.getTableHeader().setForeground(Color.WHITE);
        phimTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        phimTable.setRowHeight(25);
        phimTable.setSelectionBackground(new Color(241, 121, 104));
        
        JScrollPane scrollPane = new JScrollPane(phimTable);
        scrollPane.setBackground(new Color(31, 32, 44));
        scrollPane.getVerticalScrollBar().setBackground(new Color(50, 50, 60));
        scrollPane.getHorizontalScrollBar().setBackground(new Color(50, 50, 60));
        
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        // Panel nút
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(new Color(31, 32, 44));
        
        JButton lamMoiBtn = createButton("Làm Mới");
        JButton chiTietBtn = createButton("Chi Tiết");
        
        buttonPanel.add(lamMoiBtn);
        buttonPanel.add(chiTietBtn);
        
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
