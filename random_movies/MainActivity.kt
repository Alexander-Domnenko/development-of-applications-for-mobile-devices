package com.example.para

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var movies: Array<String>
    private lateinit var isDeleted: BooleanArray
    private var count_click: Int = 0
    private lateinit var tvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTitle = findViewById(R.id.title)
        movies = resources.getStringArray(R.array.movies_array)
        isDeleted = BooleanArray(movies.size) { false }
    }

    fun onClick(view: View) {
        if (count_click < movies.size) {
            val r = Random()

            var index: Int
            do {
                index = r.nextInt(movies.size)
            } while (isDeleted[index])

            tvTitle.text = movies[index]
            isDeleted[index] = true
            count_click++
        } else {
            tvTitle.text = "Фильмы закончились"
        }
    }

    fun reset(view: View) {
        tvTitle.text = "Нажмите на 'Посмотреть'"
        count_click = 0
        isDeleted.fill(false) // Сбросить флаги удаления
    }
}
