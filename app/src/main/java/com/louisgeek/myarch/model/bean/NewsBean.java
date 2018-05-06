package com.louisgeek.myarch.model.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class NewsBean {
    @PrimaryKey
    public long newsID;
    public String title;
    public String content;

    @Override
    public String toString() {
        return "NewsBean{" +
                "newsID=" + newsID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
