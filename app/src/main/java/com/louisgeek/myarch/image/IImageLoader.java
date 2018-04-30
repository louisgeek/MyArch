package com.louisgeek.myarch.image;

import android.widget.ImageView;

import java.io.File;


public interface IImageLoader {
    void load(ImageView imageView, int imageResId);

    void load(ImageView imageView, File imageFile);

    void load(ImageView imageView, String url);
}