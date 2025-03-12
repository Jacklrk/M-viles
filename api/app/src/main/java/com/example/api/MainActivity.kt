package com.example.api

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)

        RetrofitClient.instance.getHelloMessage().enqueue(object : Callback<HelloResponse> {
            override fun onResponse(call: Call<HelloResponse>, response: Response<HelloResponse>) {
                if (response.isSuccessful) {
                    textView.text = response.body()?.message
                } else {
                    textView.text = "Error en la respuesta"
                }
            }

            override fun onFailure(call: Call<HelloResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error de conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
