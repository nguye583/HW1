package com.example.cs421hw1v3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

//const val PICK_GRADE_INTENT = 1 // The request code
// Key to return grade in intent
//const val GRADE = "GRADE"
//const val DEFAULT_GRADE = "90"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClickListener = View.OnClickListener { view ->

            when (view.id) {
                R.id.grade_button -> startActivity(Intent(this, GradeActivity::class.java))
                R.id.discount_button -> startActivity(Intent(this, DiscountActivity::class.java))
                else -> {
                    Toast.makeText(
                        this,
                        getString(R.string.unexpected_button_pressed),
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }
        }
        findViewById<View>(R.id.grade_button).setOnClickListener(buttonClickListener)
        findViewById<View>(R.id.discount_button).setOnClickListener(buttonClickListener)

        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
        }

        startActivity(intent)

        val startActButton = findViewById<Button>(R.id.grade_button)
        startActButton.setOnClickListener{
            startActivity(Intent(this@MainActivity, GradeActivity::class.java))
        }
    }
}