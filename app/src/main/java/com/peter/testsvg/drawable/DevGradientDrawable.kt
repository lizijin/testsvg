package com.peter.testsvg.drawable

import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.GradientDrawable.*
import androidx.annotation.IntDef


class DevGradientDrawable  private constructor() : GradientDrawable() {

    internal  class Builder {
        var mShape: Shape? = null
        var mSolidColor: ColorStateList? = null
        var mGradient: Gradient? = null
        var mCorner :Float = 0.0f

        fun shape(shape: Shape): Builder = apply {
            mShape = shape
        }

        fun solidColor(solidColor: ColorStateList): Builder = apply {
            mSolidColor = solidColor
        }

        fun gradient(gradient: Gradient): Builder = apply {
            mGradient = gradient
        }

        fun corner(corner:Float) = apply {
            mCorner = corner
        }

        fun build(): DevGradientDrawable {
            val devGradientDrawable = DevGradientDrawable()
            checkNotNull(mShape) { "mShape == null" }
            return devGradientDrawable.apply {
                shape = mShape!!.mShape
                mSolidColor?.let {
                    color = it
                }

                setDither(mShape!!.mDither)

                mGradient?.let {
                    orientation = it.orientation
                    colors = it.colors
                }

                cornerRadius = mCorner
            }
        }
    }

    class Shape(
        val mShape: Int = GradientDrawable.RECTANGLE,
        val mDither: Boolean = false,
        val mInnerRadius: Int = -1,
        val mThickness: Int = -1,
        val mThicknessRatio: Float = 0.0F,
        val mUseLevelForShape: Boolean = true,
        val mTintMode: Int = -1,
        val mTint: ColorStateList? = null
    )

    class Gradient(
        val centerX: Float = 0.5f,
        val centerY: Float = 0.5f,
        val useLevel: Boolean = false,
        @GradientType val gradient: Int = LINEAR_GRADIENT,
        val orientation: Orientation = Orientation.LEFT_RIGHT,
        val colors: IntArray
    )


}

@IntDef(LINEAR_GRADIENT, RADIAL_GRADIENT, SWEEP_GRADIENT)
@Retention(AnnotationRetention.SOURCE)
annotation class GradientType
