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
import com.google.android.material.snackbar.Snackbar
import android.app.DatePickerDialog
import android.widget.ArrayAdapter
import java.text.SimpleDateFormat
import java.util.*

class LoginView : AppCompatActivity() {
    lateinit var userNameField : TextView
    lateinit var passwordField : TextView
    lateinit var dobField : TextView
    lateinit var genderSelector : RadioGroup
    lateinit var userTypeSelector : AutoCompleteTextView
    private lateinit var signupButton : Button
    private val calendar: Calendar = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_view)

        userNameField = findViewById(R.id.usernameField)
        passwordField = findViewById(R.id.passwordField)

        dobField = findViewById(R.id.editTextDate)
        genderSelector = findViewById(R.id.radioGroup)
        userTypeSelector = findViewById(R.id.userTypeAutocompleteTextView)

        signupButton = findViewById(R.id.signupButton)

        dobField.setOnClickListener {
            showDatePickerDialog()
        }

        val userTypeAutocompleteTextView: AutoCompleteTextView = findViewById(R.id.userTypeAutocompleteTextView)

        // Define the array of choices
        val userTypeChoices = arrayOf("Business", "Consumer")

        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, userTypeChoices)

        // Set the ArrayAdapter to the AutoCompleteTextView
        userTypeAutocompleteTextView.setAdapter(adapter)

        signupButton.setOnClickListener{
            if (passwordField.text.length < 8){
                Snackbar.make(userNameField, "The password must be longer than 8 Characters", Snackbar.LENGTH_LONG).show()
            }
            Toast.makeText(this, "Any of the fields cannot be empty", Toast.LENGTH_LONG).show()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                // Update the EditText field with the selected date
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        // Set max date to today's date
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()

        // Show the DatePickerDialog
        datePickerDialog.show()
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy" // Format of date to display
        val sdf = SimpleDateFormat(myFormat, Locale.getDefault())

        // Set the formatted date to the EditText field
        dobField.setText(sdf.format(calendar.time))
    }
}