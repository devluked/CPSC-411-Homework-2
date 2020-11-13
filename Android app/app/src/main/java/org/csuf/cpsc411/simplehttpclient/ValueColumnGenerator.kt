package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class ValueColumnGenerator(val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)


        val tParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        //tParams.weight = 1.0F
     //   tParams.bottomMargin = 200
        var tlbl = TextView(ctx)
        tlbl.setTypeface(null, Typeface.BOLD)
        tlbl.text = "Please Enter Claim Information"
        tlbl.setTextSize(18F)
        tlbl.gravity = Gravity.CENTER
        tlbl.setTextColor(Color.BLACK)
        // lbl.setBackgroundColor(Color.YELLOW)
        layoutObj.addView(tlbl, tParams)


        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
       // layoutObj.setBackgroundColor(Color.GREEN) // line color between button borders
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
       // vParams.topMargin = 5
        vParams.topMargin = 50
        var value = EditText(ctx)
        value.id = R.id.claim_title
        value.setHint("Enter Claim Title")
      //  value.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(value, vParams)
        value = EditText(ctx)
        value.id = R.id.date
        value.setHint("Enter Claim Date")
       // value.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(value, vParams)
        value = EditText(ctx)


        return layoutObj
    }
}