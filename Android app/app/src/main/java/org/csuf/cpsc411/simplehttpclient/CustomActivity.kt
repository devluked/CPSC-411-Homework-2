package org.csuf.cpsc411.simplehttpclient

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.loopj.android.http.AsyncHttpClient

class CustomActivity : AppCompatActivity() {
    lateinit var cList : MutableList<Claim>
    lateinit var string: String
    lateinit var cService : ClaimService
    fun refreshScreen() {
        //
        Log.d("Claim Service", "Refreshing the Screen. ")

        val titleView : EditText = findViewById(R.id.claim_title)
        val dateView : EditText = findViewById(R.id.date)


        titleView.setText("")
        dateView.setText("")

    }


    fun refreshStatus(stat : String) {
        val statusView : TextView = findViewById(R.id.status)
        val response = stat

        statusView.setText("Status:        <${response}>")
    }

    fun returnTitle() : String {
        var titleText : EditText? = findViewById(R.id.claim_title)
        if (titleText != null) {
            string = titleText.text.toString()
        }
        return string
    }

    fun returnDate() : String {
        var dateText : EditText? = findViewById(R.id.date)
        if (dateText != null) {
            string = dateText.text.toString()
        }
        return string
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        cService = ClaimService(this)
        super.onCreate(savedInstanceState)
        //val fldRowGenerator = FieldValueViewGenerator(this, "SSN")
        //val colGenerator = LableColumnGenerator(this)
        //val colView = colGenerator.generate()

        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)
        //
        val bView : Button = findViewById(R.id.add_btn)
        bView.setOnClickListener{
            val jsonstr = cService.add()
            cService.addClaim(jsonstr)
            refreshScreen()
        }
        //

        //setContentView(R.layout.activity_main)
    }
}