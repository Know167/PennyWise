package com.example.pennywise

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner=findViewById<Spinner>(R.id.spinner)
        val amt=findViewById<EditText>(R.id.amount)

        val btn=findViewById<Button>(R.id.add_button)
        val foodEx=findViewById<TextView>(R.id.food_expense)
        val rentEx=findViewById<TextView>(R.id.rent_expense)

        val miscEx=findViewById<TextView>(R.id.misc_expense)
    }
}