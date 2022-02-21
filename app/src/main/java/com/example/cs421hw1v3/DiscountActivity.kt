package com.example.cs421hw1v3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.view.View

class DiscountActivity : AppCompatActivity() {
    private val discountButton: Button
        get() = findViewById(R.id.discount_button)

    private val firstName: EditText
        get() = findViewById(R.id.first_name_input)

    private val lastName: EditText
        get() = findViewById(R.id.last_name_input)

    private val email: EditText
        get() = findViewById(R.id.email_input)

    private val discountCodeConfirmation: TextView
        get() = findViewById(R.id.discount_code_confirmation)

    private val discountCode: TextView
        get() = findViewById(R.id.discount_code)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discount)

        val actionBar = supportActionBar
        actionBar!!.title = "Back"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    fun DiscountButtonClick(view: View) {
        val firstNameIn = findViewById<EditText>(R.id.first_name_input).text.toString()
        val lastNameIn = findViewById<EditText>(R.id.last_name_input).text.toString()
        //val getName = findViewById<TextView>(R.id.final_name_text)
        val emailIn = findViewById<EditText>(R.id.email_input).text.toString()
        //val getEmail = findViewById<TextView>(R.id.final_email_text)

        if (firstNameIn.isEmpty() || lastNameIn.isEmpty() || emailIn.isEmpty()) {
            Toast.makeText(this, getString(R.string.add_text_validation), Toast.LENGTH_LONG).show()
        }
        else {
            val fullName = firstNameIn.plus(" ").plus(lastNameIn)
            discountCodeConfirmation.text = getString(R.string.discount_code_confirmation, fullName)

            // Generates discount code
            discountCode.text = UUID.randomUUID().toString().take(8).toUpperCase()
            hideKeyboard()
            clearInputFields()
        }
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        //Get the discount code or an empty string if it hasn't been set
        discountCode.text = savedInstanceState.getString(DISCOUNT_CODE,"")
        //Get the discount confirmation message or an empty string if it hasn't been set
        discountCodeConfirmation.text =
            savedInstanceState.getString(
                DISCOUNT_CONFIRMATION_MESSAGE,"")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(DISCOUNT_CODE,
            discountCode.text.toString())
        outState.putString(DISCOUNT_CONFIRMATION_MESSAGE,
            discountCodeConfirmation.text.toString())
    }


    private fun clearInputFields() {
        firstName.text.clear()
        lastName.text.clear()
        email.text.clear()
    }

    private fun hideKeyboard() {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    companion object {
        private const val TAG = "DiscountActivity"
        private const val DISCOUNT_CONFIRMATION_MESSAGE = "DISCOUNT_CONFIRMATION_MESSAGE"
        private const val DISCOUNT_CODE = "DISCOUNT_CODE"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}