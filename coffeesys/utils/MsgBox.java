/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author VAN GIAU
 */
public class MsgBox {
    public static void alert(Component parent,String message) {
        JOptionPane.showMessageDialog(parent, message, 
                "Hệ thống quản lý coffee", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void error(Component parent,String message) {
        JOptionPane.showMessageDialog(parent, message, 
                "Hệ thống quản lý coffee", JOptionPane.ERROR_MESSAGE);
    }
    public static void warning(Component parent,String message) {
        JOptionPane.showMessageDialog(parent, message, 
                "Hệ thống quản lý coffee", JOptionPane.WARNING_MESSAGE);
    }
    public static boolean comfirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message,
                "Hệ thống quản lý coffee", JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }
    public static String prompt(Component parent,String message) {
        return JOptionPane.showInputDialog(parent, message, 
                "Hệ thống quản lý coffee", JOptionPane.INFORMATION_MESSAGE);
    }
}
