package com.example.myapplication.utils.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.example.myapplication.R;
import com.google.android.material.button.MaterialButton;

public class Custom_ButtonBold extends MaterialButton {
    public Custom_ButtonBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackground(getResources().getDrawable(R.drawable.enable_selector, getContext().getTheme()));
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Cairo-SemiBold.ttf"));
    }
}
