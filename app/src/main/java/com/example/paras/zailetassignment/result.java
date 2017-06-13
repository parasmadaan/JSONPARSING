package com.example.paras.zailetassignment;

/**
 * Created by paras on 06-06-2017.
 */

public class result {
    private int id;
    private String interest;
    private String cover;
    private String time;

    public result(int id, String interest, String cover, String time) {
        this.id = id;
        this.interest = interest;
        this.cover = cover;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getInterest() {
        return interest;
    }

    public String getCover() {
        return cover;
    }

    public String getTime() {
        return time;
    }
}
