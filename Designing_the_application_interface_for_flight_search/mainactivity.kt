package com.example.air_ticket

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

private lateinit var textDate: EditText
private lateinit var buttonDate: Button
private lateinit var textDate2: EditText
private lateinit var buttonDate2: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textDate = findViewById(R.id.textDate)
        buttonDate = findViewById(R.id.buttonDate)
        textDate2 = findViewById(R.id.textDate2)
        buttonDate2 = findViewById(R.id.buttonDate2)

        buttonDate.setOnClickListener {
            pickDateAndSetEditText(textDate)
        }

        buttonDate2.setOnClickListener {
            pickDateAndSetEditText(textDate2)
        }
    }

    private fun pickDateAndSetEditText(editText: EditText) {
        val calendar = Calendar.getInstance()
        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            updateText(calendar, editText)
        }

        DatePickerDialog(
            this, dateListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun updateText(calendar: Calendar, editText: EditText) {
        val dateFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(dateFormat, Locale.UK)
        editText.setText(sdf.format(calendar.time))
    }
}
