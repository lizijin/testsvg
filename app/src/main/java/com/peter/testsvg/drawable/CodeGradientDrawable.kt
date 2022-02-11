package com.peter.testsvg.drawable

import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable

class CodeGradientDrawable private constructor(builder: Builder) : GradientDrawable() {
    init {
        shape = builder.shape

        builder.color?.let {
            color = builder.color
        }

    }

    class Builder {

        var color: ColorStateList? = null
        var shape: Int = RECTANGLE

        var width: Int = -1
        var height: Int = -1

        var gradient: Gradient.Builder? = null

        fun shape(shape: Int) = apply {
            this.shape = shape
        }

        fun color(color: ColorStateList) = apply {
            this.color = color
        }

        fun size(width: Int, height: Int) = apply {
            this.width = width
            this.height = height
        }


    }
}

class Gradient private constructor(
    val centerX: Float,
    val centerY: Float,
    val useLevel: Boolean,
    val gradientType: Int,
    val gradientRadius: Float,
    val orientation: GradientDrawable.Orientation,
    val gradientColors: IntArray
) {
    class Builder {
        var centerX: Float = 0.5f
        var centerY: Float = 0.5f
        var useLevel: Boolean = false
        var gradientType: Int = GradientDrawable.LINEAR_GRADIENT
        var gradientRadius: Float = 0.5f
        var orientation: GradientDrawable.Orientation = GradientDrawable.Orientation.LEFT_RIGHT
        var gradientColors: IntArray? = null

//        fun gradientCenter()
    }

}