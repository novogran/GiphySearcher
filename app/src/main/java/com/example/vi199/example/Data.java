package com.example.vi199.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

class Data {

    @SerializedName("images")
    @Expose
    private Images images;

    Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

}