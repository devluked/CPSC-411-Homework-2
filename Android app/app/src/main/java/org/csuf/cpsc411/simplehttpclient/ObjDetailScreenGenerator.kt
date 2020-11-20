package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ObjDetailScreenGenerator(val ctx : Context) {
    // Create a linearlayout object
    lateinit var layoutObj : LinearLayout

    fun pxtodp(px : Int) : Int {
        var density = ctx.getResources().getDisplayMetrics().density
        var paddingDp = (px*density).toInt();

        return paddingDp
    }

    fun generate() : LinearLayout {


        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        // layoutObj.setBackgroundColor(Color.MAGENTA)


        // Add objdetail section
        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        // add next button
        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
       // nLayout.setBackgroundColor(Color.GRAY)
        //
        val nButton = Button(ctx)
        nButton.text = "Add"

        nButton.setId(R.id.add_btn)

       // nButton.setBackgroundColor(Color.CYAN)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.gravity = Gravity.BOTTOM
        nLayout.addView(nButton, nbParams)
        //
        layoutObj.addView(nLayout)


        layoutObj.setBackgroundColor(Color.WHITE)
        var status = TextView(ctx)
        status.text = "Status:           <Status Message>"
        status.setId(R.id.status)
        status.setPadding(pxtodp(11),0,0,0)
        status.gravity = Gravity.LEFT
        status.setTextColor(Color.BLACK)
        layoutObj.addView(status, lParams)

        return layoutObj
    }
}