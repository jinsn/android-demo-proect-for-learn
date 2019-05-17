package com.glucowell.learnapp;

import android.app.Activity;
import android.widget.ImageView;

import com.lzy.imagepicker.loader.ImageLoader;

class GlideImageLoader implements ImageLoader {
    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        GlideShowImageUtils.displayNativeImage(activity,path,imageView,R.mipmap.checkbox_checked);
    }

    @Override
    public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
        GlideShowImageUtils.displayNativeImage(activity,path,imageView,R.mipmap.checkbox_checked);
    }

    @Override
    public void clearMemoryCache() {

    }
}
