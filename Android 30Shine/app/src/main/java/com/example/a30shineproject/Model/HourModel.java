package com.example.a30shineproject.Model;

public class HourModel {
    String hourStylist;
    int checkWork;

    public HourModel(String hourStylist, int checkWork) {
        this.hourStylist = hourStylist;
        this.checkWork = checkWork;
    }

    public String getHourStylist() {
        return hourStylist;
    }

    public void setHourStylist(String hourStylist) {
        this.hourStylist = hourStylist;
    }

    public int getCheckWork() {
        return checkWork;
    }

    public void setCheckWork(int checkWork) {
        this.checkWork = checkWork;
    }
}
