package com.example.vi199.gifsearcher;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class GifData {

    @SerializedName("data")
    @Expose
    private List<Data> data;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}