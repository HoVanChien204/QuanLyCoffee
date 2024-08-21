/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.ui;

import com.coffeesys.dao.NhanVienDAO;
import com.coffeesys.dao.SanPhamDAO;
import com.coffeesys.entity.NhanVien;
import com.coffeesys.entity.SanPham;
import java.util.List;

/**
 *
 * @author VAN GIAU
 */
public class Test {
    public static void main(String[] args) {
//        NhanVienDAO dao = new NhanVienDAO();
//        List<NhanVien> list = dao.selectAll();
//        for (NhanVien nv : list) {
//            System.out.println("Ho va ten: "+nv.toString());
//        }
//        SanPhamDAO dao = new SanPhamDAO();
//        List<SanPham> list = dao.selectAll();
//        for (SanPham sp : list) {
//            System.out.println("Ten san pham: "+sp.toString());
//        }
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nv = dao.selectById("NV01");
        System.out.println("ID Cua nhan vien la: "+nv.getIdNhanVien());
    }
}
