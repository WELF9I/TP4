package com.example.tp4_ex2;


public class Movie {
    private String title;
    private int imgURL;

    public Movie(String title, int imgURL) {
        this.title = title;
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public int getImgURL() {
        return imgURL;
    }
}