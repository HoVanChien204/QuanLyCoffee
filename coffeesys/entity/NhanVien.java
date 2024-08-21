/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.entity;

import java.util.Date;

/**
 *
 * @author VAN GIAU
 */
public class NhanVien {
    private String idNhanVien;
    private String matKhau;
    private String ten;
    private Date ngaySinh ;
    private boolean gioiTinh;
    private int soDienThoai;
    private Date ngayLam;
    private String caLam;
    private float luong;
    private int ngayNghi;
    private boolean chucVu;
    private String hinh;

    @Override
    public String toString(){
        return this.ten;
    }
    public NhanVien() {
    }
    
    public NhanVien(String idNhanVien, String matKhau, String ten, Date ngaySinh, boolean gioiTinh, int soDienThoai, Date ngayLam, String caLam, float luong, int ngayNghi, boolean chucVu, String hinh) {
        this.idNhanVien = idNhanVien;
        this.matKhau = matKhau;
        this.ten = ten;

        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.ngayLam = ngayLam;
        this.caLam = caLam;
        this.luong = luong;
        this.ngayNghi = ngayNghi;
        this.chucVu = chucVu;
        this.hinh = hinh;
    }

    
    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(Date ngayLam) {
        this.ngayLam = ngayLam;
    }

    public String getCaLam() {
        return caLam;
    }

    public void setCaLam(String caLam) {
        this.caLam = caLam;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public int getNgayNghi() {
        return ngayNghi;
    }

    public void setNgayNghi(int ngayNghi) {
        this.ngayNghi = ngayNghi;
    }

    public boolean isChucVu() {
        return chucVu;
    }

    public void setChucVu(boolean chucVu) {
        this.chucVu = chucVu;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    
    
}
