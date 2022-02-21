package com.example.cs421hw1v3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.view.View
import android.view.inputmethod.InputMethodManager

class GradeActivity : AppCompatActivity() {
    private val grade: EditText
        get() = findViewById(R.id.grade_input)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)

        val actionBar = supportActionBar
        actionBar!!.title = "Back"
        actionBar.setDisplayHomeAsUpEnabled(true)

        }

    fun ButtonClick(view:View)
    {
        val gradeIn = findViewById<EditText>(R.id.grade_input).text.toString()
        val gradeInInt = gradeIn.toInt()
        val getGrade = findViewById<TextView>(R.id.final_grade_text)
        

        if(gradeInInt >=94) {
            getGrade.setText("You got an A!").toString()
        }
        else if(gradeInInt >=90 && gradeInInt < 94)
        {
            getGrade.setText("You got an A-!").toString()
        }
        else if(gradeInInt >=87 && gradeInInt <= 90)
        {
            getGrade.setText("You got an B+!").toString()
        }
        else if(gradeInInt >= 83 && gradeInInt <= 87)
        {
            getGrade.setText("You got an B!").toString()
        }
        else if(gradeInInt >=80 && gradeInInt <= 83)
        {
            getGrade.setText("You got an B-!").toString()
        }
        else if(gradeInInt >=77 && gradeInInt <= 80)
        {
            getGrade.setText("You got an C+!").toString()
        }
        else if(gradeInInt >=73 && gradeInInt <= 77)
        {
            getGrade.setText("You got an C!").toString()
        }
        else if(gradeInInt >=70 && gradeInInt <= 73)
        {
            getGrade.setText("You got an C-!").toString()
        }
        else if(gradeInInt < 70)
        {
            getGrade.setText("You got an F!").toString()
        }
        else{
            getGrade.setText("Please enter a valid number greater than 0")
        }
        hideKeyboard()
        clearInputFields()
    }

    private fun clearInputFields() {
        grade.text.clear()
    }

    private fun hideKeyboard() {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}