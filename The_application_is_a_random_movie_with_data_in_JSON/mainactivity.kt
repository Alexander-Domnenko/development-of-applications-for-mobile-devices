package com.example.random_movies

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.google.gson.Gson
import java.io.InputStreamReader
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var movies: Array<Movie>
    private lateinit var isDeleted: BooleanArray
    private var count_click: Int = 0
    private lateinit var tvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTitle = findViewById(R.id.title)

        val moviesStream = resources.openRawResource(R.raw.movies)
        val gson = Gson()
        val moviesData = gson.fromJson(InputStreamReader(moviesStream), Movies::class.java)
        movies = moviesData.movies

        isDeleted = BooleanArray(movies.size) { false }
    }

    fun onClick(view: View) {
        if (count_click < movies.size) {
            val r = Random()

            var index: Int
            do {
                index = r.nextInt(movies.size)
            } while (isDeleted[index])

            val movieInfo = "<b>Название:</b> ${movies[index].name}<br>" +
                    "<b>Год:</b> ${movies[index].year}<br>" +
                    "<b>Рейтинг:</b> ${movies[index].rating}<br>" +
                    "<b>Жанры:</b> ${movies[index].genres.joinToString(", ")}<br>" +
                    "<b>Режиссер:</b> ${movies[index].director}"

            tvTitle.text = HtmlCompat.fromHtml(movieInfo, HtmlCompat.FROM_HTML_MODE_LEGACY)

            isDeleted[index] = true
            count_click++
        } else {
            tvTitle.text = "Фильмы закончились"
        }
    }

    fun reset(view: View) {
        tvTitle.text = "Нажмите на 'Посмотреть'"
        count_click = 0
        isDeleted.fill(false)
    }
}
