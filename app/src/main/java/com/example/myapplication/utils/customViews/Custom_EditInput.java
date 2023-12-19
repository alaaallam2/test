package com.example.myapplication.utils.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.google.android.material.textfield.TextInputEditText;

public class Custom_EditInput extends TextInputEditText {
    public Custom_EditInput(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Cairo-Medium.ttf"));
    }
}
