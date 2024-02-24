package com.example.vladick_zdarova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.graphics.drawable.ColorDrawable
import android.widget.Toast
import kotlin.random.Random


data class Coord(val x: Int, val y: Int)

class MainActivity : AppCompatActivity() {

    private lateinit var tiles: Array<Array<View?>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tiles = arrayOf(
            arrayOf(findViewById(R.id.t00), findViewById(R.id.t01), findViewById(R.id.t02), findViewById(R.id.t03)),
            arrayOf(findViewById(R.id.t10), findViewById(R.id.t11), findViewById(R.id.t12), findViewById(R.id.t13)),
            arrayOf(findViewById(R.id.t20), findViewById(R.id.t21), findViewById(R.id.t22), findViewById(R.id.t23)),
            arrayOf(findViewById(R.id.t30), findViewById(R.id.t31), findViewById(R.id.t32), findViewById(R.id.t33))
        )

        initField()
    }


    private fun getCoordFromString(s: String): Coord {
        val x = s[0].digitToInt()
        val y = s[1].digitToInt()
        return Coord(x, y)
    }

    private fun changeColor(view: View) {
        val brightColor = resources.getColor(R.color.bright)
        val darkColor = resources.getColor(R.color.dark)
        val drawable = view.background as ColorDrawable
        if (drawable.color == brightColor) {
            view.setBackgroundColor(darkColor)
        } else {
            view.setBackgroundColor(brightColor)
        }
    }

    fun onClick(v: View) {
        val coord = getCoordFromString(v.tag.toString())
        changeColor(v)

        for (i in 0..3) {
            tiles[coord.x][i]?.let { changeColor(it) }
            tiles[i][coord.y]?.let { changeColor(it) }
        }

        checkVictory()
    }

    private fun checkVictory() {
        var countBright = 0
        var countDark = 0

        for (rows in tiles) {
            for (tile in rows) {
                val drawable = tile?.background as ColorDrawable
                val tileColor = drawable.color

                tileColor.let {
                    if (it == resources.getColor(R.color.bright)) {
                        countBright++
                    } else if (it == resources.getColor(R.color.dark)) {
                        countDark++
                    } else {

                    }
                }
            }
        }

        if (countBright == 0 || countDark == 0) {
            Toast.makeText(this, "Победа", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initField() {
        val darkColor = resources.getColor(R.color.dark)
        val brightColor = resources.getColor(R.color.bright)

        for (row in tiles) {
            for (tile in row) {
                val randomColor = if (Random.nextBoolean()) {
                    darkColor
                } else {
                    brightColor
                }
                tile?.setBackgroundColor(randomColor)
            }
        }
    }

}
