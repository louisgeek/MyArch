package com.louisgeek.myarch.image.picasso;

import android.widget.ImageView;

import com.louisgeek.myarch.image.IImageLoader;
import com.squareup.picasso.Picasso;

import java.io.File;

public class PicassoImageLoader implements IImageLoader {
    @Override
    public void load(ImageView imageView, int imageResId) {
        Picasso.get().load(imageResId).into(imageView);
    }

    @Override
    public void load(ImageView imageView, File imageFile) {
        Picasso.get().load(imageFile).into(imageView);
    }

    @Override
    public void load(ImageView imageView, String url) {
        Picasso.get().load(url).into(imageView);
    }
}
