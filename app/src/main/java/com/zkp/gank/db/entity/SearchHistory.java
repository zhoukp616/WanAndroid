package com.zkp.gank.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.db
 * @time: 2019/5/7 17:12
 * @description: 搜索纪录实体类
 */
@Entity
public class SearchHistory {

    @Id(autoincrement = true)
    private Long id;

    private long date;

    private String data;

    @Generated(hash = 1462840955)
    public SearchHistory(Long id, long date, String data) {
        this.id = id;
        this.date = date;
        this.data = data;
    }

    @Generated(hash = 1905904755)
    public SearchHistory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getData() {
        return data == null ? "" : data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
