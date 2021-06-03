package com.pirates.api.domain;

public class Businesstimes {
    private String day;
    private String open;
    private String close;

    public Businesstimes(String day, String open, String close) {
        this.day = day;
        this.open = open;
        this.close = close;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }
}
