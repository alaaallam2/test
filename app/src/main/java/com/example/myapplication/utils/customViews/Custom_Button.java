package com.example.myapplication.utils.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.google.android.material.button.MaterialButton;

public class Custom_Button extends MaterialButton {
    public Custom_Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Cairo-Medium.ttf"));
    }
}
