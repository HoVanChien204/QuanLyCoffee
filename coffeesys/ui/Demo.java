/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.ui;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author VAN GIAU
 */
public class Demo extends JFrame{
    private DefaultListModel<String> tableListModel;
    private JList<String> tableList;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;

    public Demo() {
        // Khởi tạo cửa sổ chính
        setTitle("Quản lý Bàn Coffee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Tạo panel chứa danh sách bàn
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());

        // Danh sách bàn
        tableListModel = new DefaultListModel<String>();
        tableList = new JList<String>(tableListModel);
        JScrollPane tableScrollPane = new JScrollPane(tableList);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Tạo panel chứa nút thêm, cập nhật và xóa bàn
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Thêm Bàn");
        updateButton = new JButton("Cập nhật trạng thái");
        deleteButton = new JButton("Xóa Bàn");
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Thêm các panel vào cửa sổ chính
        add(tablePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Xử lý sự kiện nút thêm bàn
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableName = JOptionPane.showInputDialog("Tên bàn:");
                tableListModel.addElement(tableName);
            }
        });

        // Xử lý sự kiện nút cập nhật trạng thái
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tableList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String status = JOptionPane.showInputDialog("Cập nhật trạng thái bàn:");
                    tableListModel.setElementAt(tableList.getSelectedValue() + " - " + status, selectedIndex);
                }
            }
        });

        // Xử lý sự kiện nút xóa bàn
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tableList.getSelectedIndex();
                if (selectedIndex != -1) {
                    tableListModel.remove(selectedIndex);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().setVisible(true);
            }
        });
    }
}
