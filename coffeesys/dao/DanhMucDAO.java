/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.dao;

import com.coffeesys.entity.DanhMuc;
import com.coffeesys.entity.SanPham;
import com.coffeesys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VAN GIAU
 */
public class DanhMucDAO extends CoffeeSysDAO<DanhMuc, Integer> {

    final String SELECT_ALL_SQL = "select * from DanhMucSanPham";
    final String SELECT_BY_ID_SQL = "SELECT * from danhmucsanpham where IDDanhMuc = ?";
    final String SELECT_BY_TEN_SQL = "SELECT * FROM DanhMucSanPham WHERE TenDanhMuc LIKE ?";
    final String SELECT_BY_TENDANHMUC = "select sp.Ten,dm.TenDanhMuc,sp.Gia from SanPham sp join DanhMucSanPham dm on sp.IDDanhMuc = dm.IDDanhMuc where TenDanhMuc like ?";

    @Override
    public void insert(DanhMuc entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(DanhMuc entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DanhMuc> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DanhMuc selectById(Integer id) {
        List<DanhMuc> list = selectBySql(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public DanhMuc selectByTen(String id) {
        List<DanhMuc> list = selectBySql(SELECT_BY_TEN_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DanhMuc> selectBySql(String sql, Object... args) {
        List<DanhMuc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setIdDanhMuc(rs.getInt("IDDanhMuc"));
                dm.setTenDanhMuc(rs.getString("TenDanhMuc"));
                list.add(dm);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
   
}
