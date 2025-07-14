package com.cybersoft.demospringboot09.entity;

import java.util.List;

public class Product {
    String hinhAnh;
    String tieuDe;
    Long giaTien;
    List<String> info;

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public Long getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Long giaTien) {
        this.giaTien = giaTien;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public Product(String hinhAnh, String tieuDe, Long giaTien, List<String> info) {
        this.hinhAnh = hinhAnh;
        this.tieuDe = tieuDe;
        this.giaTien = giaTien;
        this.info = info;
    }
}
