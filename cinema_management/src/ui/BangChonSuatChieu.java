package ui;

import entity.Phim;
import entity.SuatChieu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Giao diện Chọn Suất Chiếu
 */
public class BangChonSuatChieu extends JPanel {
    
    private JComboBox<String> filmCombo;
    private JTable showtimeTable;
    private DefaultTableModel tableModel;
    private SuatChieu selectedShowtime;
    
    public BangChonSuatChieu() {
        setLayout(new BorderLayout());
        setBackground(new Color(31, 32, 44));
        
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createSelectionPanel(), BorderLayout.CENTER);
    }
    
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(31, 32, 44));
        header.setBorder(new EmptyBorder(15, 20, 15, 20));
        header.setPreferredSize(new Dimension(0, 60));
        
        JLabel titleLabel = new JLabel("Chọn Suất Chiếu");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        header.add(titleLabel, BorderLayout.WEST);
        
        return header;
    }
    
    private JPanel createSelectionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(31, 32, 44));
        panel.setBorder(new EmptyBorder(15, 20, 15, 20));
        
        // Film selection
        JPanel filmPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        filmPanel.setBackground(new Color(31, 32, 44));
        
        JLabel filmLabel = new JLabel("Chọn Phim:");
        filmLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        filmLabel.setForeground(Color.WHITE);
        
        filmCombo = new JComboBox<>();
        filmCombo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        filmCombo.setBackground(new Color(50, 50, 60));
        filmCombo.setForeground(Color.WHITE);
        filmCombo.setPreferredSize(new Dimension(300, 35));
        
        filmPanel.add(filmLabel);
        filmPanel.add(filmCombo);
        
        panel.add(filmPanel, BorderLayout.NORTH);
        
        // Showtimes table
        tableModel = new DefaultTableModel(new Object[] {
            "ID", "Phòng", "Giờ Chiếu", "Thời Gian Kết Thúc", "Giá Vé", "Trạng Thái"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        showtimeTable = new JTable(tableModel);
        showtimeTable.setBackground(new Color(50, 50, 60));
        showtimeTable.setForeground(Color.WHITE);
        showtimeTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        showtimeTable.getTableHeader().setBackground(new Color(241, 121, 104));
        showtimeTable.getTableHeader().setForeground(Color.WHITE);
        showtimeTable.setRowHeight(25);
        showtimeTable.setSelectionBackground(new Color(241, 121, 104));
        
        showtimeTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = showtimeTable.getSelectedRow();
            if (selectedRow >= 0) {
                int showtimeId = (int) tableModel.getValueAt(selectedRow, 0);
                selectedShowtime = showtimeDAO.getShowtimeById(showtimeId);
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(showtimeTable);
        scrollPane.setBackground(new Color(31, 32, 44));
        scrollPane.getVerticalScrollBar().setBackground(new Color(50, 50, 60));
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(31, 32, 44));
        
        JButton selectBtn = new JButton("Chọn Suất Chiếu");
        selectBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        selectBtn.setBackground(new Color(241, 121, 104));
        selectBtn.setForeground(Color.WHITE);
        selectBtn.setFocusPainted(false);
        selectBtn.setPreferredSize(new Dimension(150, 40));
        
        buttonPanel.add(selectBtn);
        
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    public SuatChieu getSelectedShowtime() {
        return selectedShowtime;
    }
}
