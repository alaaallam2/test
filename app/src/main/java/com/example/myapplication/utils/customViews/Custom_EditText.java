package com.example.myapplication.utils.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.google.android.material.textfield.TextInputLayout;

public class Custom_EditText extends TextInputLayout {
    public Custom_EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Cairo-Medium.ttf"));
    }
}
