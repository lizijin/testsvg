package com.peter.testsvg

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.dmall.framework.drawable.CodeStateListDrawable
import com.dmall.framework.drawable.SelectorDrawableItem
import com.dmall.framework.drawable.StateChecked
import com.dmall.framework.drawable.StateSelected

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("checkbox is ${findViewById<CheckBox>(R.id.code_checkbox).javaClass}")


        val selectDrawable =
            VectorDrawableCompat.create(resources, R.drawable.app_brand_btn_checklist_sel, theme)

        val unselectDrawable =
            ContextCompat.getDrawable(this, R.drawable.common_ic_btn_checklist_nor)


        val checkedBuilder =
            SelectorDrawableItem.Builder().drawable(selectDrawable!!).addState(StateChecked);
        val uncheckedBuilder =
            SelectorDrawableItem.Builder().drawable(unselectDrawable!!).minusState(StateChecked);

        val checkedStateListDrawable =
            CodeStateListDrawable.Builder().addSelectorDrawableItem(checkedBuilder)
                .addSelectorDrawableItem(uncheckedBuilder).build()

        val selectedBuilder =
            SelectorDrawableItem.Builder().drawable(selectDrawable!!).addState(StateSelected);
        val unSelectedBuilder =
            SelectorDrawableItem.Builder().drawable(unselectDrawable!!).minusState(StateSelected);


        val selectedStateListDrawable =
            CodeStateListDrawable.Builder().addSelectorDrawableItem(selectedBuilder)
                .addSelectorDrawableItem(unSelectedBuilder).build()

        val selectedStateListDrawable2 =
            CodeStateListDrawable.Builder().addSelectorDrawableItem(selectedBuilder)
                .addSelectorDrawableItem(unSelectedBuilder).build()
        findViewById<ImageView>(R.id.code_image_view).setImageDrawable(selectedStateListDrawable)
        val textView = findViewById<TextView>(R.id.code_textview)
        selectedStateListDrawable2.setBounds(0,0,selectDrawable.intrinsicWidth,selectDrawable.intrinsicHeight)
        textView.setCompoundDrawables(selectedStateListDrawable2, null, null, null)

        findViewById<CheckBox>(R.id.code_checkbox).buttonDrawable = checkedStateListDrawable

    }

    fun checkImageView(view: View) {
        view.isSelected = !view.isSelected
    }
}