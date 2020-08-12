package com.example.a30shineproject.Model;

public class AddressModel {
    String txtTenDuong,txtTenPhuongQuan;
    float txtsoKm;

    public AddressModel(String txtTenDuong, String txtTenPhuongQuan, float txtsoKm) {
        this.txtTenDuong = txtTenDuong;
        this.txtTenPhuongQuan = txtTenPhuongQuan;
        this.txtsoKm = txtsoKm;
    }

    public String getTxtTenDuong() {
        return txtTenDuong;
    }

    public void setTxtTenDuong(String txtTenDuong) {
        this.txtTenDuong = txtTenDuong;
    }

    public String getTxtTenPhuongQuan() {
        return txtTenPhuongQuan;
    }

    public void setTxtTenPhuongQuan(String txtTenPhuongQuan) {
        this.txtTenPhuongQuan = txtTenPhuongQuan;
    }

    public float getTxtsoKm() {
        return txtsoKm;
    }

    public void setTxtsoKm(float txtsoKm) {
        this.txtsoKm = txtsoKm;
    }
}
