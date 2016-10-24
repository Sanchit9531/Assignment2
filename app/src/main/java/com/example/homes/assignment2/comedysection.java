package com.example.homes.assignment2;

/**
 * Created by homes on 10/22/2016.
 */

public class comedysection {
    private String name;
    private int iconID;
    private String url;
    private String Description;

    public comedysection(String name, int iconID, String url,String Description) {
        this.name = name;
        this.iconID = iconID;
        this.url = url;
        this.Description=Description;
    }
    public String getDescription()
    {
        return Description;
    }
    public String getName() {
        return name;
    }

    public int getIconID() {
        return iconID;
    }

    public String getUrl() {
        return url;
    }
}
