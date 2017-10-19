package com.example.vi199.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Pagination {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("offset")
    @Expose
    private int offset;

    int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}