package com.unida.sirajuddin.otherwordpress.Model;

import android.widget.ImageView;

import java.util.Date;

public class Model {

    public static final int IMAGE_TYPE = 1 ;
    public String title;
    public String subtitle;
    public String Image;
    public String Author;
    public Date date;
    public int type;


    public Model(int mtype, String title, String subtitle, String image) {
        this.title = title;
        this.subtitle = subtitle;
        this.type = mtype;
        this.Image = image;
        this.Author = Author;
        this.date = date;

    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
