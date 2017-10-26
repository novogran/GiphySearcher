package com.example.vi199.gifsearcher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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