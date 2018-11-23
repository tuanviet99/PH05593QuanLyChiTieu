package com.example.admin.ph05593quanlychitieu.Model;

import java.util.Date;

public class ChiTieu {
    private String tenChiphi;
    private int soLuong;
    private int giaTien;
    private String ngayChi;

    public ChiTieu(String tenChiphi, int soLuong, int giaTien, String ngayChi) {
        this.tenChiphi = tenChiphi;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.ngayChi = ngayChi;
    }

    public ChiTieu() {

    }

    public String getTenChiphi() {
        return tenChiphi;
    }

    public void setTenChiphi(String tenChiphi) {
        this.tenChiphi = tenChiphi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(String ngayChi) {
        this.ngayChi = ngayChi;
    }

    @Override
    public String toString() {
        return "ChiTieu{" +
                "tenChiphi='" + tenChiphi + '\'' +
                ", soLuong=" + soLuong +
                ", giaTien=" + giaTien +
                ", ngayChi=" + ngayChi +
                '}';
    }
}
