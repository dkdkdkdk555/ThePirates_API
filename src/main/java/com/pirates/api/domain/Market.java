package com.pirates.api.domain;

import java.util.List;

public class Market {
    private long id; //자동증가id값
    private String name; //점포명
    private String owner; //대표자명
    private String description; //점포 설명
    private int level; //노출 우선순위
    private String address; //점포 주소
    private String phone; //전화번호
    private List<Businesstimes> businessTimes; //영업시간

    public Market() {

    }

    public Market(long id, String name, String owner, String description, int level, String address, String phone, List<Businesstimes> businessTimes) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.level = level;
        this.address = address;
        this.phone = phone;
        this.businessTimes = businessTimes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Businesstimes> getBusinessTimes() {
        return businessTimes;
    }

    public void setBusinessTimes(List<Businesstimes> businessTimes) {
        this.businessTimes = businessTimes;
    }
}
