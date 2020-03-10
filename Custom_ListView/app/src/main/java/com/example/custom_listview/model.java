package com.example.custom_listview;

public class model {
    int image;
    String title;
    String artist;
    String time;

    public int getImage()
    {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        time = time;
    }

    public model(int image, String title, String artist, String time) {
        this.image = image;
        this.title = title;
        this.artist = artist;
        this.time = time;
    }
}

