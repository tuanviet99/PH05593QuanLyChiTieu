package com.example.admin.ph05593quanlychitieu.Model;

import java.util.Date;

public class ChiTieu {
    private String chitieuName;
    private int soluong;
    private int giatien;
    private Date ngaychi;

    public ChiTieu(String chitieuName, int soluong, int giatien, Date ngaychi) {
        this.chitieuName = chitieuName;
        this.soluong = soluong;
        this.giatien = giatien;
        this.ngaychi = ngaychi;
    }

    public ChiTieu() {

    }
    public String getChitieuName() {
        return chitieuName;
    }

    public void setChitieuName(String chitieuName) {
        this.chitieuName = chitieuName;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public Date getNgaychi() {
        return ngaychi;
    }

    public void setNgaychi(Date ngaychi) {
        this.ngaychi = ngaychi;
    }

    @Override
    public String toString() {
        return "ChiTieu{" +
                "chitieuName='" + chitieuName + '\'' +
                ", soluong=" + soluong +
                ", giatien=" + giatien +
                ", ngaychi=" + ngaychi +
                '}';
    }
}
