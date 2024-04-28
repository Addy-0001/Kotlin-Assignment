package com.example.assignment

import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.DatePicker
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class LoginView : AppCompatActivity() {
    lateinit var userNameField : TextView
    lateinit var passwordField : TextView
    lateinit var dobField : DatePicker
    lateinit var genderSelector : RadioGroup
    lateinit var userTypeSelector : AutoCompleteTextView
    lateinit var submitButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        submitButton = findViewById(R.id.signupButton)
        userNameField = findViewById(R.id.usernameField)
        passwordField = findViewById(R.id.passwordField)

        dobField = findViewById(R.id.editTextDate)
        genderSelector = findViewById(R.id.radioGroup)
        userTypeSelector = findViewById(R.id.userTypeAutocompleteTextView)

        submitButton.setOnClickListener{
            if(userNameField.text != null || passwordField.text != null || dobField.get != null || genderSelector.text != null || userTypeSelector != null){
            } else {
                Toast.makeText(this, "Any of the fields cannot be empty", Toast.LENGTH_LONG).show()
            }
        }


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}