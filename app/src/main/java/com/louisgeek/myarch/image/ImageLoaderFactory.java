package com.louisgeek.myarch.image;

import com.louisgeek.myarch.image.glide.GlideImageLoader;


public class ImageLoaderFactory {
    public static IImageLoader getInstance() {
        return Inner.sInstance;
    }

    private static class Inner {
        private static IImageLoader sInstance = new GlideImageLoader();
//        private static IImageLoader sInstance = new PicassoImageLoader();
    }
}
