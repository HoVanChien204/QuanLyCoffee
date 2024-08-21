/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.entity;

/**
 *
 * @author VAN GIAU
 */
public class SanPham {

    private int idSanPham;
    private int idDanhMuc;
    private String tenDanhMuc;
    private String tenSanPham;
    private float gia;

    public SanPham() {
    }
    @Override
    public String toString(){
        return this.tenSanPham;
    }
    public SanPham(int idSanPham, int idDanhMuc, String tenSanPham, float gia) {
        this.idSanPham = idSanPham;
        this.idDanhMuc = idDanhMuc;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
    }

    public SanPham(int idSanPham, int idDanhMuc, String tenDanhMuc, String tenSanPham, float gia) {
        this.idSanPham = idSanPham;
        this.idDanhMuc = idDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
    }
    
    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    
    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    
    
}
