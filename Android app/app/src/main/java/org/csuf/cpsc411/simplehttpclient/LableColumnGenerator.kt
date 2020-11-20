package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class LableColumnGenerator(val ctx : Context) {

    fun pxtodp(px : Int) : Int {
        var density = ctx.getResources().getDisplayMetrics().density
        var paddingDp = (px*density).toInt();

        return paddingDp
    }

    fun generate() : LinearLayout {

        val layoutObj = LinearLayout(ctx)

        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
      //  layoutObj.setBackgroundColor(Color.GREEN)

        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F
        var lbl = TextView(ctx)
        lbl.text = "Claim Title"
        lbl.gravity = Gravity.LEFT
        lbl.setTextColor(Color.BLACK)


        lbl.setPadding(pxtodp(10),pxtodp(55),0,0)
       // lbl.setBackgroundColor(Color.YELLOW)
        layoutObj.addView(lbl, lbParams)
        lbl = TextView(ctx)
        lbl.text = "Date"
        lbl.gravity = Gravity.LEFT
        lbl.setTextColor(Color.BLACK)
        lbl.setPadding(pxtodp(12),pxtodp(32),0,0)

        // lbl.setBackgroundColor(Color.YELLOW)
        layoutObj.addView(lbl, lbParams)



        return layoutObj
    }
}