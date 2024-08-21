/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.dao;

import com.coffeesys.entity.NhanVien;
import com.coffeesys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VAN GIAU
 */
public class NhanVienDAO extends CoffeeSysDAO<NhanVien, String> {

    final String INSERT_SQL = "INSERT INTO NHANVIEN(MANV,MATKHAU,HOTEN,VAITRO) VALUES (?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NhanVien SET MatKhau = ?, HoTen = ?, VaiTro = ? where MaNV = ?";
    final String DELETE_SQL = "DELETE from NhanVien where MaNV = ?";
    final String SELECT_ALL_SQL = "SELECT * from nhanvien";
    final String SELECT_BY_ID_SQL = "SELECT * from nhanvien where IDNhanVien LIKE ?";
    final String UPDATE_MK_SQL = "UPDATE NhanVien SET MatKhau = ? where MaNV = ?";

    @Override
    public void insert(NhanVien entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(NhanVien entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setIdNhanVien(rs.getString("IDNhanVien"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setTen(rs.getString("Ten"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setSoDienThoai(rs.getInt("SDT"));
                nv.setNgayLam(rs.getDate("NgayLam"));
                nv.setCaLam(rs.getString("CaLam"));
                nv.setLuong(rs.getFloat("Luong"));
                nv.setNgayNghi(rs.getInt("NgayNghi"));
                nv.setHinh(rs.getString("Hinh"));
                nv.setChucVu(rs.getBoolean("ChucVu"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
