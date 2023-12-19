package com.example.myapplication.utils.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;

public class Custom_CheckBox extends AppCompatCheckBox {
    public Custom_CheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Cairo-Medium.ttf"));
    }
}
