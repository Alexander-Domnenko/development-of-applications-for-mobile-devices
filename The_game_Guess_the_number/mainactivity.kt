package com.example.random_number

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        val editTextStart = findViewById<EditText>(R.id.begin)
        val editTextEnd = findViewById<EditText>(R.id.end)

        val startStr = editTextStart.text.toString()
        val endStr = editTextEnd.text.toString()

        if (startStr.isEmpty() || endStr.isEmpty()) {
            Toast.makeText(this, "Введите начало и конец диапазона", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val start = startStr.toInt()
            val end = endStr.toInt()

            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("start", start)
            i.putExtra("end", end)
            startActivity(i)
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Введите корректные числовые значения", Toast.LENGTH_SHORT).show()
        }
    }
}
