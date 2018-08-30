package com.example.shraboni.technicaltestmcc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {


    @SerializedName("contentfilelist")
    @Expose
    private List<Contentfilelist> contentfilelist = null;

    public List<Contentfilelist> getContentfilelist() {
        return contentfilelist;
    }

    public void setContentfilelist(List<Contentfilelist> contentfilelist) {
        this.contentfilelist = contentfilelist;
    }
}
