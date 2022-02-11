package com.peter.testsvg;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

public class MyGradientDrawable extends GradientDrawable {
    public MyGradientDrawable(Builder builder) {
        super();
        setShape(builder.shape);
        setColors(new int[]{builder.startColor, builder.endColor});
        setCornerRadius(builder.radius);

    }

    public static class Builder {
        public float radius = 20;
        int shape = RECTANGLE;

        int startColor = Color.parseColor("#ff0000");
        int endColor = Color.parseColor("#00ff00");

    }
}
