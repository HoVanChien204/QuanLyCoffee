/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.dao;

import com.coffeesys.entity.HoaDon;
import com.coffeesys.entity.SanPham;
import com.coffeesys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VAN GIAU
 */
public class HoaDonDAO extends CoffeeSysDAO<HoaDon, Integer> {

    final String INSERT_SQL = "INSERT INTO SanPham(IDDanhMuc,Ten,Gia) VALUES (?,?,?)";
    final String UPDATE_SQL = "UPDATE SanPham SET IDDanhMuc = ?, Ten = ?, Gia = ? where IDSanPham = ?";
    final String DELETE_SQL = "DELETE from SanPham where IDSanPham = ?";
    final String SELECT_ALL_SQL = "select hd.IDHoaDon,b.Ten as N'Ban',nv.Ten as 'NguoiTao',hd.TrangThai,hd.NgayTao from HoaDon hd join Ban b on hd.IDBan = b.IDBan join NhanVien nv on hd.IDNhanVien = nv.IDnhanVien";
    final String SELECT_BY_ID_SQL = "SELECT sp.IDSanPham,sp.IDDanhMuc,dm.TenDanhMuc,sp.Ten,sp.Gia from SanPham sp join DanhMucSanPham dm on sp.IDDanhMuc = dm.IDDanhMuc where IDSanPham = ?";
    final String SELECT_BY_TRANGTHAI = "select hd.IDHoaDon,b.Ten as N'Ban',nv.Ten as 'NguoiTao',hd.TrangThai,hd.NgayTao from HoaDon hd join Ban b on hd.IDBan = b.IDBan join NhanVien nv on hd.IDNhanVien = nv.IDnhanVien where hd.TrangThai like ?";

    @Override
    public void insert(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }
    public List<HoaDon> selectTrangThai(String trangThai) {
        return selectBySql(SELECT_BY_TRANGTHAI,trangThai);
    }
    @Override
    public HoaDon selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getInt("IDHoaDon"));
                hd.setBan(rs.getString("Ban"));
                hd.setTenNhanVien(rs.getString("NguoiTao"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                list.add(hd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
