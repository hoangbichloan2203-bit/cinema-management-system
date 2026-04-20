package ui;

import entity.Phim;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.Vector;

/**
 * Giao diện Quản Lý Phim
 */
public class BangQuanLyPhim extends JPanel {
    
    private JTable movieTable;
    private DefaultTableModel tableModel;
    private JTextField maPhimField, tenPhimField, daoDienField, theLoaiField, thoiLuongField;
    private JTextArea moTaArea;
    
    public BangQuanLyPhim() {
        setLayout(new BorderLayout());
        setBackground(new Color(31, 32, 44));
        
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createFormPanel(), BorderLayout.WEST);
        add(createTablePanel(), BorderLayout.CENTER);
    }
    
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(31, 32, 44));
        header.setBorder(new EmptyBorder(15, 20, 15, 20));
        header.setPreferredSize(new Dimension(0, 60));
        
        JLabel titleLabel = new JLabel("Quản Lý Phim");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        header.add(titleLabel, BorderLayout.WEST);
        
        return header;
    }
    
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(31, 32, 44));
        formPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        formPanel.setPreferredSize(new Dimension(350, 0));
        
        // Mã Phim
        formPanel.add(createLabel("Mã Phim:"));
        maPhimField = createTextField();
        formPanel.add(maPhimField);
        formPanel.add(Box.createVerticalStrut(10));
        
        // Tên Phim
        formPanel.add(createLabel("Tên Phim:"));
        tenPhimField = createTextField();
        formPanel.add(tenPhimField);
        formPanel.add(Box.createVerticalStrut(10));
        
        // Đạo Diễn
        formPanel.add(createLabel("Đạo Diễn:"));
        daoDienField = createTextField();
        formPanel.add(daoDienField);
        formPanel.add(Box.createVerticalStrut(10));
        
        // Thể Loại
        formPanel.add(createLabel("Thể Loại:"));
        theLoaiField = createTextField();
        formPanel.add(theLoaiField);
        formPanel.add(Box.createVerticalStrut(10));
        
        // Thời Lượng (phút)
        formPanel.add(createLabel("Thời Lượng (phút):"));
        thoiLuongField = createTextField();
        formPanel.add(thoiLuongField);
        formPanel.add(Box.createVerticalStrut(10));
        
        // Mô Tả
        formPanel.add(createLabel("Mô Tả:"));
        moTaArea = new JTextArea(4, 20);
        moTaArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        moTaArea.setBackground(new Color(50, 50, 60));
        moTaArea.setForeground(Color.WHITE);
        moTaArea.setCaretColor(Color.WHITE);
        moTaArea.setLineWrap(true);
        moTaArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(moTaArea);
        formPanel.add(scrollPane);
        formPanel.add(Box.createVerticalStrut(15));
        
        // Buttons
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        btnPanel.setBackground(new Color(31, 32, 44));
        
        JButton addBtn = createButton("Thêm");
        JButton updateBtn = createButton("Sửa");
        JButton deleteBtn = createButton("Xóa");
        
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        
        formPanel.add(btnPanel);
        formPanel.add(Box.createVerticalGlue());
        
        JScrollPane formScroll = new JScrollPane(formPanel);
        formScroll.setBorder(null);
        return formScroll;
    }
    
    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(new Color(31, 32, 44));
        tablePanel.setBorder(new EmptyBorder(10, 10, 10, 20));
        
        tableModel = new DefaultTableModel(new Object[] {
            "Mã Phim", "Tên Phim", "Đạo Diễn", "Thể Loại", "Thời Lượng"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        movieTable = new JTable(tableModel);
        movieTable.setBackground(new Color(50, 50, 60));
        movieTable.setForeground(Color.WHITE);
        movieTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        movieTable.getTableHeader().setBackground(new Color(241, 121, 104));
        movieTable.getTableHeader().setForeground(Color.WHITE);
        movieTable.setRowHeight(25);
        movieTable.setSelectionBackground(new Color(241, 121, 104));
        
        JScrollPane scrollPane = new JScrollPane(movieTable);
        scrollPane.setBackground(new Color(31, 32, 44));
        scrollPane.getVerticalScrollBar().setBackground(new Color(50, 50, 60));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        return tablePanel;
    }
    
    private void clearForm() {
        maPhimField.setText("");
        tenPhimField.setText("");
        daoDienField.setText("");
        theLoaiField.setText("");
        thoiLuongField.setText("");
        moTaArea.setText("");
        movieTable.clearSelection();
    }
    
    private JLabel createLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lbl.setForeground(Color.WHITE);
        return lbl;
    }
    
    private JTextField createTextField() {
        JTextField tf = new JTextField();
        tf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tf.setBackground(new Color(50, 50, 60));
        tf.setForeground(Color.WHITE);
        tf.setCaretColor(Color.WHITE);
        tf.setMaximumSize(new Dimension(300, 30));
        return tf;
    }
    
    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBackground(new Color(241, 121, 104));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(80, 30));
        return btn;
    }
}
