package com.example.vi199.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class FixedHeightDownsampled extends Images {

    @SerializedName("webp")
    @Expose
    private String webp;

    public String getWebp() {
        return webp;
    }

    public void setWebp(String webp) {
        this.webp = webp;
    }
}