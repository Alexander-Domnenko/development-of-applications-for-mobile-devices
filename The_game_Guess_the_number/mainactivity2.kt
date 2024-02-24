package com.example.random_number

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    lateinit var questionText: TextView
    var start = 0
    var end = 100
    var interval = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        questionText = findViewById(R.id.question)

        val i = intent
        start = i.getIntExtra("start", 0)
        end = i.getIntExtra("end", 100)

        if (start > end) {
            val temp = start
            start = end
            end = temp
        }
        interval = (start + end) / 2
        updateQuestionText()
    }

    fun updateQuestionText() {
        if (start == end) {
            questionText.text = "Я думаю это $start"
        } else {
            val myMessage = "Ваше число > $interval?"
            questionText.text = myMessage
        }
    }
    fun onYesNoClick(view: View) {
        if (start == end) {
            return
        }
        when (view.id) {
            R.id.yes -> {
                start = interval + 1
            }
            R.id.no -> {
                end = interval
            }
        }
        interval = (start + end) / 2
        updateQuestionText()
    }
}

