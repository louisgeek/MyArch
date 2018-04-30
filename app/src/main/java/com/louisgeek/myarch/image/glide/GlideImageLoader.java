package com.louisgeek.myarch.image.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.louisgeek.myarch.image.IImageLoader;

import java.io.File;


public class GlideImageLoader implements IImageLoader {

    @Override
    public void load(ImageView imageView, int imageResId) {
        Glide.with(imageView.getContext()).load(imageResId)
                //.placeholder(R.mipmap.ic_image_no)
                //.error(R.drawable.ic_image_no)
                //.crossFade()
                .into(imageView);
    }

    @Override
    public void load(ImageView imageView, File imageFile) {
        Glide.with(imageView.getContext())
                .load(imageFile)
                .into(imageView);
    }

    @Override
    public void load(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                /*  .placeholder(R.drawable.ic_image_no)
                  .error(R.drawable.ic_image_no)
                  .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                  .crossFade()*/
                .into(imageView);

    }

}
