package com.ivan.uts_10119003.model;

import com.ivan.uts_10119003.view.About.AboutAdapter;

public class AboutModel {
    public int imageID;
    public String heading, description;

    public AboutModel(int imageID, String heading, String description) {
        this.imageID = imageID;
        this.heading = heading;
        this.description = description;
    }
}
