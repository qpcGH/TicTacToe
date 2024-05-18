package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
     private lateinit var tv1: TextView
    private lateinit var p1Name: EditText
    private lateinit var p2Name: EditText
    private lateinit var btn: Button
    var firstValue : String=""
    var secondValue : String=""



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        p1Name = findViewById(R.id.p1Name)
        p2Name = findViewById(R.id.p2Name)
        btn = findViewById((R.id.playbtn))
        tv1= findViewById(R.id.p2NameTag)




        btn.setOnClickListener {
            if (p1Name.text.toString().isNotEmpty() && p2Name.text.toString().isNotEmpty())
            {
                firstValue = p1Name.text.toString()
                secondValue = p2Name.text.toString()
                var intent = Intent(this,PlayArea::class.java)

                 intent.putExtra("n1",firstValue)
                  intent.putExtra("n2",secondValue)
                startActivity(intent)
            }
            else if(p1Name.text.toString().isEmpty())
            {

                Toast.makeText(this, "Please Enter a Name", Toast.LENGTH_SHORT).show()

                p1Name.requestFocus()
            }
            else if(p2Name.text.toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter a Name", Toast.LENGTH_SHORT).show()

                p2Name.requestFocus()
            }
            else
            {
                Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show()
            }
        }





    }






}