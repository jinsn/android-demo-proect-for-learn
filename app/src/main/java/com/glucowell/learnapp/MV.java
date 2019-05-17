package com.glucowell.learnapp;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import retrofit2.http.POST;

import static android.graphics.Paint.Style.FILL_AND_STROKE;
import static android.graphics.Paint.Style.STROKE;


public class MV extends View {
    public MV(Context context) {
        super(context);
        init();
    }

    public MV(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MV(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;
    }

    Paint paint;
    Path path;
    int waveWidth=100;
    int height,width;

    int waveHeight =100;

    private void init() {
        paint=new Paint();
        path = new Path();
        paint.setStyle(FILL_AND_STROKE);
    }

    float lastX,lastY;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w=MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(w+1000,MeasureSpec.getSize(heightMeasureSpec));
    }
    ValueAnimator valueAnimator;

    public void start(){
        valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(2000);
        valueAnimator.setFloatValues(0,waveWidth);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animatedValue = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();

    }

    float animatedValue=0;


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        path.reset();
        path.moveTo(-waveWidth+animatedValue,height/2);
        for(int i=-waveWidth;i<width+waveWidth;i+=waveWidth){
            path.rQuadTo(waveWidth/4,-100,waveWidth/2,0);
            path.rQuadTo(waveWidth/4,100,waveWidth/2,0);
        }
        path.lineTo(width,height);
        path.lineTo(0,height);
        path.close();
        canvas.drawPath(path,paint);
//        path.reset();
//        path.moveTo(-waveWidth , height / 2);
//        for (float i = -waveWidth; i < width + waveWidth; i += waveWidth) {
//            path.rQuadTo(waveWidth / 4, -waveHeight, waveWidth / 2, 0);
//            path.rQuadTo(waveWidth / 4, waveHeight, waveWidth / 2, 0);
//        }
//        path.lineTo(width, height);
//        path.lineTo(0, height);
//        path.close();
//        canvas.drawPath(path, paint);

    }
}
