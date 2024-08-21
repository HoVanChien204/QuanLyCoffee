/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.coffeesys.ui;

import com.coffeesys.dao.NhanVienDAO;
import com.coffeesys.entity.NhanVien;
import com.coffeesys.utils.Auth;
import com.coffeesys.utils.MsgBox;
import com.coffeesys.utils.XImage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author VAN GIAU
 */
public class DangNhapJDialog extends javax.swing.JDialog {

    NhanVienDAO dao = new NhanVienDAO();

    private void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        txtTaiKhoan.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtMatKhau.setBackground(new java.awt.Color(0, 0, 0, 1));
        setTitle("Hệ thống Đăng nhập");
    }

    private void nutEnter() {
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnDangNhap.doClick();
                }
            }
        };
        txtTaiKhoan.addKeyListener(keyAdapter);
        txtMatKhau.addKeyListener(keyAdapter);
    }

    public DangNhapJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        nutEnter();
    }

    private boolean checkValidateForm() {
        String user = txtTaiKhoan.getText();
        String pass = new String(txtMatKhau.getPassword());
        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Tài khoản!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
            txtTaiKhoan.requestFocus();
            return false;
        }
        if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mật khẩu!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
            txtMatKhau.requestFocus();
            return false;
        }
        if (user.length() > 4) {
            JOptionPane.showMessageDialog(this, "Nhập tài khoản đúng 4 ký tự!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
            txtTaiKhoan.requestFocus();
            return false;
        }
        return true;
    }

    private void login() {
        String strIDNhanVien = txtTaiKhoan.getText();
        String strMatKhau = new String(txtMatKhau.getPassword());
        NhanVien nv = dao.selectById(strIDNhanVien);
        if (strIDNhanVien.equals(nv.getIdNhanVien())) {
            if (nv.getMatKhau().equals(strMatKhau)) {
                Auth.user = nv;
                MsgBox.alert(this, "Đăng nhập thành công");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Sai mật khẩu!", "ERROR", JOptionPane.ERROR_MESSAGE);
                txtMatKhau.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập!", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTaiKhoan.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        lblDisable = new javax.swing.JLabel();
        lblShow = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        lblThoat = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(139, 69, 19));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng nhập");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 49, 450, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tài khoản");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 110, 76, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("___________________________________________________________________");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 30));

        txtTaiKhoan.setFont(txtTaiKhoan.getFont().deriveFont(txtTaiKhoan.getFont().getSize()+2f));
        txtTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        txtTaiKhoan.setText("NV01");
        txtTaiKhoan.setBorder(null);
        jPanel2.add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 350, 50));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeesys/icon/user (1).png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 153, 41, 32));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mật khẩu");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 208, 75, -1));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("___________________________________________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 257, 470, 28));

        txtMatKhau.setFont(txtMatKhau.getFont().deriveFont(txtMatKhau.getFont().getSize()+2f));
        txtMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        txtMatKhau.setText("123");
        txtMatKhau.setBorder(null);
        jPanel2.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 350, 50));

        lblDisable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeesys/icon/hidden.png"))); // NOI18N
        lblDisable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDisable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDisableMouseClicked(evt);
            }
        });
        jPanel2.add(lblDisable, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 257, 41, 28));

        lblShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeesys/icon/eye.png"))); // NOI18N
        lblShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowMouseClicked(evt);
            }
        });
        jPanel2.add(lblShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 257, 41, 28));

        btnDangNhap.setBackground(new java.awt.Color(240, 240, 240));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(139, 69, 19));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel2.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 319, 350, 40));

        lblThoat.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(255, 255, 255));
        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThoat.setText("X");
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });
        jPanel2.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 40, 40));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 460, 410));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeesys/icon/chao-coffee.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -4, 450, 410));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDisableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDisableMouseClicked
        txtMatKhau.setEchoChar((char) 0);
        lblDisable.setVisible(false);
        lblDisable.setEnabled(false);
        lblShow.setEnabled(true);
        lblShow.setEnabled(true);
    }//GEN-LAST:event_lblDisableMouseClicked

    private void lblShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowMouseClicked
        txtMatKhau.setEchoChar((char) 8226);
        lblDisable.setVisible(true);
        lblDisable.setEnabled(true);
        lblShow.setEnabled(false);
        lblShow.setEnabled(false);
    }//GEN-LAST:event_lblShowMouseClicked

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        if (checkValidateForm()) {
            login();
        }

    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblThoatMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhapJDialog dialog = new DangNhapJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDisable;
    private javax.swing.JLabel lblShow;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
