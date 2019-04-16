package com.zkp.gank.greendao.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.greendao
 * @time: 2019/4/11 15:20
 * @description: 收藏的文章
 */
@Entity
public class CollectionArticles {

    @Id
    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private String imageUrl;
    @Generated(hash = 313992129)
    public CollectionArticles(String _id, String createdAt, String desc,
            String publishedAt, String source, String type, String url,
            boolean used, String who, String imageUrl) {
        this._id = _id;
        this.createdAt = createdAt;
        this.desc = desc;
        this.publishedAt = publishedAt;
        this.source = source;
        this.type = type;
        this.url = url;
        this.used = used;
        this.who = who;
        this.imageUrl = imageUrl;
    }
    @Generated(hash = 777700346)
    public CollectionArticles() {
    }
    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getPublishedAt() {
        return this.publishedAt;
    }
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
    public String getSource() {
        return this.source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean getUsed() {
        return this.used;
    }
    public void setUsed(boolean used) {
        this.used = used;
    }
    public String getWho() {
        return this.who;
    }
    public void setWho(String who) {
        this.who = who;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
