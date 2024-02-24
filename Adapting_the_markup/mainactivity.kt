package com.example.dolg2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onChangePictureClick(v: View) {
        val iv = findViewById<ImageView>(R.id.picture)
        val pictures = resources.getStringArray(R.array.pictures)

        val currentTag = iv.tag?.toString()
        val currentIndex = pictures.indexOf(currentTag)

        val nextIndex = (currentIndex + 1) % pictures.size

        when (pictures[nextIndex]) {
            getString(R.string.car1) -> iv.setImageResource(R.drawable.car1)
            getString(R.string.car2) -> iv.setImageResource(R.drawable.car2)
            getString(R.string.car3) -> iv.setImageResource(R.drawable.car3)
            else -> iv.setImageResource(R.drawable.squarecat)
        }

        iv.tag = pictures[nextIndex]
    }
}
