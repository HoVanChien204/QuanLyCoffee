/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.dao;

import com.coffeesys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author VAN GIAU
 */
public class ThongKeDAO {
    public List<Object[]> getDoanhThu(Date tuNgay,Date denNgay) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{CALL sp_ThongKeDoanhThu(?,?)}";
                rs = JdbcHelper.query(sql, tuNgay,denNgay);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("TenSanPham"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("Doanhthu"),
                        rs.getDouble("Caonhat"),
                        rs.getDouble("Thapnhat"),
                        rs.getDouble("Trungbinh")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<Object[]> getNuocBanRa(Date tuNgay,Date denNgay) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{CALL sp_ThongKeNuoc(?,?)}";
                rs = JdbcHelper.query(sql, tuNgay,denNgay);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("TenSanPham"),
                        rs.getInt("SoLuongBanRa"),
                        rs.getInt("NhieuNhat"),
                        rs.getInt("ItNhat"),
                        rs.getInt("Trungbinh"),                
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
