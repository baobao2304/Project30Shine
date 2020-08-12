package com.example.a30shineproject.Model;

public class StylistModel {
    private int id;
    private String tenStylist;
    private int checked;

    public StylistModel(int id, String tenStylist, int checked) {
        this.id = id;
        this.tenStylist = tenStylist;
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenStylist() {
        return tenStylist;
    }

    public void setTenStylist(String tenStylist) {
        this.tenStylist = tenStylist;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }
}
