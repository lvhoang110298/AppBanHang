package com.example.asus.appbanhang.modal;

public class Loaisp {
    public int Maloaisp;
    public String Tenloaisp;
    public String Hinhanhloaisp;

    public int getMaloaisp() {
        return Maloaisp;
    }

    public void setMaloaisp(int maloaisp) {
        Maloaisp = maloaisp;
    }

    public String getTenloaisp() {
        return Tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {
        Tenloaisp = tenloaisp;
    }

    public String getHinhanhloaisp() {
        return Hinhanhloaisp;
    }

    public void setHinhanhloaisp(String hinhanhloaisp) {
        Hinhanhloaisp = hinhanhloaisp;
    }

    public Loaisp(int maloaisp, String tenloaisp, String hinhanhloaisp) {
        Maloaisp = maloaisp;
        Tenloaisp = tenloaisp;
        Hinhanhloaisp = hinhanhloaisp;
    }
}
