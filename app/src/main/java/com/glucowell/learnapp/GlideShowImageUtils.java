package com.glucowell.learnapp;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;



public class GlideShowImageUtils {

    /**
     * 通过文件路径加载本地图片
     *
     * @param imagePath
     * @param mImageView
     */
    public static void displayNativeImage(Context context, String imagePath, ImageView mImageView, int defaultImg) {
        Glide.with(context)
                .load(new File(imagePath))
                .apply(new RequestOptions()
                        .placeholder(defaultImg))
                .into(mImageView);
    }

    /**
     * 通过文件路径加载本地图片
     *
     * @param imagePath
     * @param mImageView
     */
    public static void displayNativeRadiusImage(Context context, String imagePath, ImageView mImageView, int radius, int defaultImg) {
        Glide.with(context)
                .load(new File(imagePath))
                .apply(new RequestOptions()
                        .placeholder(defaultImg)
                        .transform(new GlideRoundTransform(context, radius))
                        .dontAnimate())
                .into(mImageView);
    }


    /**
     * 通过文件路径加载本地图片
     *
     * @param imagePath
     * @param mImageView
     */
    public static void displayNativeImageWithoutDefault(Context context, String imagePath, ImageView mImageView) {
        Glide.with(context)
                .load(new File(imagePath))
                .apply(new RequestOptions()
                        .dontAnimate())
                .into(mImageView);
    }

    /**
     * 显示手机本地圆形图片
     *
     * @param context
     * @param imagePath
     * @param mImageView
     * @param defaultImg
     */
    public static void displayCircleNativeImage(Context context, String imagePath, ImageView mImageView, int defaultImg) {
        Glide.with(context)
                .load(new File(imagePath))
                .apply(RequestOptions
                        .circleCropTransform()
                        .placeholder(defaultImg))
                .transition(withCrossFade())
                .into(mImageView);
    }

    /**
     * 显示网络图片
     *
     * @param imageUrl
     * @param mImageView
     * @param defaultImg
     */
    public static void displayNetImage(Context context, String imageUrl, ImageView mImageView, int defaultImg) {
        Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .apply(new RequestOptions()
                        .placeholder(defaultImg)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                //.transition(withCrossFade())
                .into(mImageView);
    }

    /**
     * 显示网络圆形图片
     *
     * @param context
     * @param imageUrl
     * @param mImageView
     * @param defaultImg
     */
    public static void displayCircleNetImage(Context context, String imageUrl, ImageView mImageView, int defaultImg) {

        Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform()
                        .placeholder(defaultImg)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                //.transition(withCrossFade())
                .into(mImageView);
    }

    /**
     * 显示网络圆形带边框图片
     *
     * @param context
     * @param imageUrl
     * @param mImageView
     * @param border
     * @param borderColor
     * @param defaultImg
     */
    public static void displayCircleBorderNetImage(Context context, String imageUrl, ImageView mImageView, int border, int borderColor, int defaultImg) {
        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions()
                        .placeholder(defaultImg)
                        .transform(new GlideCircleTransform(context, border, borderColor))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate())
                .into(mImageView);
    }


    /*本地原型带边框图片*/

    public static void displayCircleNativeBorderImage(Context context, String imagePath, ImageView mImageView, int defaultImg, int border, int borderColor) {
        Glide.with(context)
                .load(new File(imagePath))
                .apply(RequestOptions
                        .circleCropTransform()
                        .placeholder(defaultImg)
                        .placeholder(defaultImg)
                        .transform(new GlideCircleTransform(context, border, borderColor))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                )
                .into(mImageView);
    }


    /**
     * 显示网络图片 圆角
     *
     * @param imageUrl
     * @param mImageView
     * @param defaultImg 默认图片
     * @param Displayer  圆角大小
     */
    public static void displayNetImage(Context context, String imageUrl, ImageView mImageView, int defaultImg,
                                       int Displayer) {
        Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .apply(new RequestOptions()
                        .placeholder(defaultImg)
                        .transform(new GlideRoundTransform(context, Displayer))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate())
                //.transition(withCrossFade())
                .into(mImageView);
    }

    /**
     * @param resourceId
     * @param mImageView
     */
    public static void displayResourceRadiusImage(Context context, int resourceId, ImageView mImageView, int radius, int defaultImg) {
        Glide.with(context)
                .load(resourceId)
                .apply(new RequestOptions()
                        .placeholder(defaultImg)
                        .transform(new GlideRoundTransform(context, radius))
                        .dontAnimate())
                .into(mImageView);
    }


    public static void displayResourceImage(Context context, int resourceId, ImageView mImageView,  int defaultImg) {
        Glide.with(context)
                .load(resourceId)
                .apply(new RequestOptions()
                        .placeholder(defaultImg)
                        //.transform(new GlideRoundTransform(context, radius))
                        .dontAnimate())
                .into(mImageView);
    }
}
