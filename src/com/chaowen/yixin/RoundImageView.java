package com.chaowen.yixin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2015/9/29.
 */
public class RoundImageView extends ImageView {
    public RoundImageView(Context context) {
        super(context);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        int width = getWidth();
        int height = getHeight();
        Bitmap rBitmap = getRoundBitmap(bitmap, width);
        canvas.drawBitmap(rBitmap, 0, 0, null);
    }

    private Bitmap getRoundBitmap(Bitmap bitmap, int diameter) {
        Bitmap squareBimap = Bitmap.createScaledBitmap(bitmap, diameter, diameter, false);
        Bitmap output = Bitmap.createBitmap(diameter, diameter, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);//图层1
        paint.setColor(Color.WHITE);
        canvas.drawCircle(diameter / 2.0f, diameter / 2.0f, diameter / 2.0f, paint);//图层2
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//图层交集取上层
        canvas.drawBitmap(squareBimap, 0, 0, paint);
        return output;
    }
}
