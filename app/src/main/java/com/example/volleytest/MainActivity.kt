package com.example.volleytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://demo.onmyfinger.com/home/getbyid?id=W001"

        // Request a string response from the provided URL.
        val request = JsonObjectRequest(
            Request.Method.GET, // method
            url, // url
            null, // json request
            Response.Listener<JSONObject> { response ->
                val obj: JSONObject = response

                textView.text = obj.getString("name")
            },
                Response.ErrorListener{
                error -> // error listener
                textView.text = error.message
            })

        // Add the request to the RequestQueue.
        queue.add(request)
    }
}