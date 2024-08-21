/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.dao;

import com.coffeesys.entity.DanhMuc;
import com.coffeesys.entity.SanPham;
import com.coffeesys.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author VAN GIAU
 */
public class SanPhamDAO extends CoffeeSysDAO<SanPham, Integer> {

    final String INSERT_SQL = "INSERT INTO SanPham(IDDanhMuc,Ten,Gia) VALUES (?,?,?)";
    final String UPDATE_SQL = "UPDATE SanPham SET IDDanhMuc = ?, Ten = ?, Gia = ? where IDSanPham = ?";
    final String DELETE_SQL = "DELETE from SanPham where IDSanPham = ?";
    final String SELECT_ALL_SQL = "select sp.IDSanPham,dm.IDDanhMuc,dm.TenDanhMuc,sp.Ten,sp.Gia from SanPham sp join DanhMucSanPham dm on sp.IDDanhMuc = dm.IDDanhMuc";
    final String SELECT_BY_ID_SQL = "SELECT sp.IDSanPham,sp.IDDanhMuc,dm.TenDanhMuc,sp.Ten,sp.Gia from SanPham sp join DanhMucSanPham dm on sp.IDDanhMuc = dm.IDDanhMuc where IDSanPham = ?";
    final String SELECT_BY_TENDANHMUC = "select sp.IDSanPham,sp.Ten,dm.IDDanhMuc,dm.TenDanhMuc,sp.Gia from SanPham sp join DanhMucSanPham dm on sp.IDDanhMuc = dm.IDDanhMuc where TenDanhMuc like ?";

    @Override
    public void insert(SanPham entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getIdDanhMuc(),
                entity.getTenSanPham(),
                entity.getGia());
    }

    @Override
    public void update(SanPham entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getIdDanhMuc(),
                entity.getTenSanPham(),
                entity.getGia(),
                entity.getIdSanPham());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<SanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SanPham selectById(Integer id) {
        List<SanPham> list = selectBySql(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getInt("IDSanPham"));
                sp.setIdDanhMuc(rs.getInt("IDDanhMuc"));
                sp.setTenDanhMuc(rs.getString("TenDanhMuc"));
                sp.setTenSanPham(rs.getString("Ten"));
                sp.setGia(rs.getFloat("Gia"));
                list.add(sp);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<SanPham> selectByKeyword(String tenSanPham) {
        String sql = "select sp.IDSanPham,dm.IDDanhMuc,dm.TenDanhMuc,sp.Ten,sp.Gia from sanpham sp join DanhMucSanPham dm on sp.IDDanhMuc = dm.IDDanhMuc where ten like ?";
        return selectBySql(sql, "%" + tenSanPham + "%");
    }

    public List<SanPham> selectByTenDanhMuc(String tenDanhMuc) {
        return selectBySql(SELECT_BY_TENDANHMUC, tenDanhMuc);
    }

}
