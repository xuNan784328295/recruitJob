package com.hanvon.zhaopin.tpm.recruit;

import java.util.Date;

public class Positioninfo {
    private Long id;

    private String position;

    private Integer area;

    private String areainfo;

    private Integer category;

    private Integer minsalary;

    private Integer maxsalary;

    private Date timestamp;

    private String search;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAreainfo() {
        return areainfo;
    }

    public void setAreainfo(String areainfo) {
        this.areainfo = areainfo == null ? null : areainfo.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(Integer minsalary) {
        this.minsalary = minsalary;
    }

    public Integer getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(Integer maxsalary) {
        this.maxsalary = maxsalary;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search == null ? null : search.trim();
    }

    @Override
    public String toString() {
        return "Positioninfo{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", area=" + area +
                ", areainfo='" + areainfo + '\'' +
                ", category=" + category +
                ", minsalary=" + minsalary +
                ", maxsalary=" + maxsalary +
                ", timestamp=" + timestamp +
                ", search='" + search + '\'' +
                '}';
    }
}