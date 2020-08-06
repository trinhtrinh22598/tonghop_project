package com.example.dienthoai;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.InsetDrawable;
import android.service.voice.VoiceInteractionSession;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

public class PhoneView extends View {

    Paint mBigRect;
    Paint mBigCircle;
    Paint mSmallCircle;
    Paint mSmallRect;
    private Path path = new Path();


    public PhoneView(Context context) {
        super(context);
        init();
    }

    public PhoneView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PhoneView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mBigRect = new Paint();
        mBigRect.setColor(Color.BLACK);
        mBigRect.setStrokeWidth(10);
        mBigRect.setStrokeCap(Paint.Cap.SQUARE);
        mBigRect.setStyle(Paint.Style.FILL);


        mSmallRect = new Paint();
        mSmallRect.setColor(Color.BLACK);
        mSmallRect.setStrokeWidth(10);
        mSmallRect.setStyle(Paint.Style.STROKE);

        mBigRect.setStyle(Paint.Style.STROKE);
        mBigCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBigCircle.setStyle(Paint.Style.STROKE);
        mBigCircle.setStrokeWidth(15);
        mBigCircle.setColor(Color.RED);

        mBigRect.setStyle(Paint.Style.STROKE);
        mSmallCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSmallCircle.setStyle(Paint.Style.FILL);
        mSmallCircle.setStrokeWidth(5);
        mSmallCircle.setColor(Color.RED);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        //Draw circle big:
        canvas.drawCircle(400, 920, 50, mBigCircle);
        //Draw circle small:
        canvas.drawCircle(300, 100, 20, mSmallCircle);
        RectF rect1 = new RectF(350, 80, 550, 120);
        canvas.drawRoundRect(rect1, 30, 30, mSmallCircle);

        //Draw Rectangcle big
        RectF rect = new RectF(100, 60, 700, 1000);
        canvas.drawRoundRect(rect, 100, 100, mBigRect);
        //Draw rectangcle small
        canvas.drawRect(150, 150, 650, 850, mSmallRect);
        canvas.drawPath(path, mBigRect);

    }

    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                path.addCircle(eventX, eventY, 10, Path.Direction.CCW);
                break;
            case MotionEvent.ACTION_CANCEL:
                path.addCircle(eventX, eventY, 10, Path.Direction.CW);
                break;
            default:
                return false;
        }
        invalidate();
        return true;

    }
}

