package org.csuf.cpsc411.simplehttpclient

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import java.lang.reflect.Type

class ClaimService (val ctx : CustomActivity){

    lateinit var claimList : MutableList<Claim>

    fun add() : String {
        val jsonStr = "{'title':'${ctx.returnTitle()}', 'date':'${ctx.returnDate()}'}"
        return jsonStr
    }


    inner class GetAllServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            // JSON string
            if (responseBody != null) {
                Log.d("Claim Service", "The response JSON string is ${String(responseBody)}")
                val gson = Gson()
                val claimListType: Type = object : TypeToken<List<Claim>>() {}.type
                claimList = gson.fromJson(String(responseBody), claimListType)

                Log.d("Claim Service", "The Claim List: ${claimList}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {

        }
    }

    inner class addServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        )   {
            if (responseBody != null) {
                val respStr = String(responseBody)
                ctx.refreshStatus("Claim added successfully")
                Log.d("Claim Service", "The add Service response : ${respStr}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            ctx.refreshStatus("Claim failed to be added")
        }
    }

    fun addClaim(jsonstr : String) {
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.50.19:8080/ClaimService/add"
        val entity = StringEntity(jsonstr)

        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity,"application/json", addServiceRespHandler())
    }

  /*  fun getAll()  {
        //var pList : List<Person> = mutableListOf()
        // Call Http
        //clientObj = clObj
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.50.19:8080/ClaimService/getAll"
        //
        Log.d("Claim Service", "About Sending the HTTP Request. ")
        //
        client.get(requestUrl, GetAllServiceRespHandler())
    }*/
}