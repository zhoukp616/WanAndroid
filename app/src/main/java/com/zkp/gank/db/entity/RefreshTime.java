package com.zkp.gank.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.weather
 * @time: 2019/5/10 10:01
 * @description:
 */
@Entity
public class RefreshTime {

    @Id
    private Long id = 1L;
    /**
     * 标题
     */
    private String title;

    /**
     * 当前时间
     */
    private long currentTime;

    /**
     * 上次刷新时间
     */
    private long lastRefreshTime;

    public RefreshTime(String title, long currentTime, long lastRefreshTime) {
        this.title = title;
        this.currentTime = currentTime;
        this.lastRefreshTime = lastRefreshTime;
    }

    @Generated(hash = 1900030996)
    public RefreshTime(Long id, String title, long currentTime,
            long lastRefreshTime) {
        this.id = id;
        this.title = title;
        this.currentTime = currentTime;
        this.lastRefreshTime = lastRefreshTime;
    }

    @Generated(hash = 608382539)
    public RefreshTime() {
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public long getLastRefreshTime() {
        return lastRefreshTime;
    }

    public void setLastRefreshTime(long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }

    @Override
    public String toString() {
        return "RefreshTime{" +
                "title='" + title + '\'' +
                ", currentTime=" + currentTime +
                ", lastRefreshTime=" + lastRefreshTime +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
