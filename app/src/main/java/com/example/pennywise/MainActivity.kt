package com.example.pennywise

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val sp=findViewById<Spinner>(R.id.spinner)
        val amt=findViewById<EditText>(R.id.amount)

        val btn=findViewById<Button>(R.id.add_button)
        val foodEx=findViewById<TextView>(R.id.food_expense)
        val rentEx=findViewById<TextView>(R.id.rent_expense)

        val miscEx=findViewById<TextView>(R.id.misc_expense)
        val opt= arrayOf("Food","Rent","Misc")
        var flag="Food"
        sp.adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,opt)
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = opt.get(p2) //p2 is the index of selected item
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        btn.setOnClickListener{view ->
            var prevText=0
            val enteredVal=amt.text.toString().toInt()
            when(flag){

                "Food"->{
                    prevText=foodEx.text.toString().toInt()
                    foodEx.text=(prevText+enteredVal).toString()
                }
                "Rent"->{
                    prevText=rentEx.text.toString().toInt()
                    rentEx.text=(prevText+enteredVal).toString()
                }
                "Misc"->{
                    prevText=miscEx.text.toString().toInt()
                    miscEx.text=(prevText+enteredVal).toString()

                }
            }
            amt.text.clear()
        }
    }
}