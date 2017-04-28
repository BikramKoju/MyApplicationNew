package com.example.bikramkoju.myapplicationnew;

import android.graphics.Bitmap;

/**
 * Created by Bikramkoju on 4/27/2017.
 */

public class ImageItem2 {
    private Bitmap image;
    private String title;

    public ImageItem2(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
