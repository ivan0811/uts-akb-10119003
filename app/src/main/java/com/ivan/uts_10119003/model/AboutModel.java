package com.ivan.uts_10119003.model;

import com.ivan.uts_10119003.view.About.AboutAdapter;

//nim : 10119003
//nama : ivan faathirza
//kelas : IF1

public class AboutModel {
    public int imageID;
    public String heading, description;

    public AboutModel(int imageID, String heading, String description) {
        this.imageID = imageID;
        this.heading = heading;
        this.description = description;
    }
}
