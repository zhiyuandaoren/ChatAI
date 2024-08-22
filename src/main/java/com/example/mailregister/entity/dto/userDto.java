package com.example.mailregister.entity.dto;

import jakarta.persistence.Column;

public class userDto {
    private String vipid;
    private String viptype;
    private String price;
    private String email;
    private String start;
    private String end;

    public String getVipid() {
        return vipid;
    }

    public void setVipid(String vipid) {
        this.vipid = vipid;
    }

    public String getViptype() {
        return viptype;
    }

    public void setViptype(String viptype) {
        this.viptype = viptype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "userDto{" +
                "vipid='" + vipid + '\'' +
                ", viptype='" + viptype + '\'' +
                ", price='" + price + '\'' +
                ", email='" + email + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}

