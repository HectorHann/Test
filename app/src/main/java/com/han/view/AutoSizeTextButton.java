package com.han.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;

/**
 * Created by Han on 2016/8/2.
 */
public class AutoSizeTextButton extends Button {
    private static final String TAG = AutoSizeTextButton.class.getSimpleName();
    private static final float AUTO_SIZE_BASE = 0.9f;
    private static final float PADDING = 0;

    public AutoSizeTextButton(Context context) {
        super(context);
    }

    public AutoSizeTextButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoSizeTextButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG + " onMeasure", getWidth() + "|" + getHeight());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG + " onSizeChanged", getWidth() + "|" + getHeight());
        autoResizeTextSize();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        Log.d(TAG + " setText", text.toString());
        autoResizeTextSize();
    }

    private void autoResizeTextSize() {
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        CharSequence str = this.getText();
        Log.d(TAG, "autoResizeTextSize Str = " + str);
        if (null != getTransformationMethod()) {
            str = getTransformationMethod().getTransformation(str, this);
        }
        Log.d(TAG, "autoResizeTextSize Trans Str = " + str);

        float strWidth = 0f;
        float strHeight = 0f;

        int availableWidth = 0;
        int availableHeight = 0;

        float textSize = getTextSize();
        TextPaint textPaint = new TextPaint();
        availableWidth = (int) (getWidth() - getPaddingLeft() - getPaddingRight() - 2 * PADDING);
        availableHeight = (int) (getHeight() - getPaddingTop() - getPaddingBottom() - 2 * PADDING);

        textPaint.setTextSize(textSize);
        strWidth = textPaint.measureText(String.valueOf(str));

        Paint paint = new Paint();
        paint.setTextSize(textSize);
        strHeight = (float) Math.ceil(paint.getFontMetrics().bottom - paint.getFontMetrics().top);
        if (strWidth >= availableWidth || strHeight >= availableHeight) {
            while (strWidth >= availableWidth || strHeight >= availableHeight) {
                textSize *= AUTO_SIZE_BASE;
                textPaint.setTextSize(textSize);
                strWidth = textPaint.measureText(String.valueOf(str));

                paint.setTextSize(textSize);
                strHeight = (float) Math.ceil(paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
            }
        } else {
            while (strWidth < availableWidth && strHeight < availableHeight) {
                textSize /= AUTO_SIZE_BASE;
                textPaint.setTextSize(textSize);
                strWidth = textPaint.measureText(String.valueOf(str));

                paint.setTextSize(textSize);
                strHeight = (float) Math.ceil(paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
            }

            textSize *= AUTO_SIZE_BASE;
        }

        setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);


    }

    @Override
    public float getTextSize() {
        Log.d(TAG + " getTextSize", super.getTextSize() + "");
        return super.getTextSize();
    }
}
