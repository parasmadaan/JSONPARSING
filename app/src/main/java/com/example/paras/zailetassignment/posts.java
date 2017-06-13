package com.example.paras.zailetassignment;

/**
 * Created by paras on 08-06-2017.
 */

public class posts {
    String id;
    String title;
    String time;
    String cover;
    String thumbnail;
    String description;
    String id2;
    String name;
    String username;
    String dp;


    public posts(String title, String id, String time, String thumbnail, String description, String cover, String id2, String name, String username, String dp) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.cover = cover;
        this.thumbnail = thumbnail;
        this.description = description;
        this.id2 = id2;
        this.name = name;
        this.username = username;
        this.dp = dp;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getCover() {
        return cover;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public String getId2() {
        return id2;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getDp() {
        return dp;
    }
}