package com.zkp.gank.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.db.entity
 * @time: 2019/5/14 17:37
 * @description:
 */
@Entity
public class Address {

    @Id(autoincrement = true)
    private Long id;

    private String address;

    /**
     * 纬度
     */
    private double latitude;
    /**
     * 经度
     */
    private double longitude;

    /**
     * 上次刷新时间
     */
    private long lastRefreshTime;

    @Generated(hash = 647581306)
    public Address(Long id, String address, double latitude, double longitude,
                   long lastRefreshTime) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lastRefreshTime = lastRefreshTime;
    }

    public Address(Long id, String address, double latitude, double longitude) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Address(String address, double latitude, double longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Address(String address) {
        this.address = address;
    }

    @Generated(hash = 388317431)
    public Address() {
    }

    public Address(String address, double latitude, double longitude, long lastRefreshTime) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lastRefreshTime = lastRefreshTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getLastRefreshTime() {
        return this.lastRefreshTime;
    }

    public void setLastRefreshTime(long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", lastRefreshTime=" + lastRefreshTime +
                '}';
    }
}
