package com.example.monkeygamejava

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity(), OnTouchListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val gameView = GameView(this, object : OnDieListener {
            override fun onDie() {
                this@GameActivity.runOnUiThread {
                    this@GameActivity.finish()
                    Toast.makeText(baseContext,"Your result :$result", Toast.LENGTH_SHORT).show()
                    result=0
                }


            }
        })
        gameLayout = findViewById<View>(R.id.gameLayout) as LinearLayout
        gameLayout!!.addView(gameView)
        val leftButton = findViewById<View>(R.id.leftButton) as Button
        val rightButton = findViewById<View>(R.id.rightButton) as Button
        textViewScore = findViewById(R.id.textViewScore)

        leftButton.setOnTouchListener(this)
        rightButton.setOnTouchListener(this)
    }


    override fun onTouch(button: View, motion: MotionEvent): Boolean {
        when (button.id) {
            R.id.leftButton -> when (motion.action) {
                MotionEvent.ACTION_DOWN -> isLeftPressed = true
                MotionEvent.ACTION_UP -> isLeftPressed = false
            }
            R.id.rightButton -> when (motion.action) {
                MotionEvent.ACTION_DOWN -> isRightPressed = true
                MotionEvent.ACTION_UP -> isRightPressed = false
            }
        }
        return true
    }

    companion object {
        var isLeftPressed = false
        var isRightPressed = false
        var textViewScore: TextView? = null
        var gameLayout: LinearLayout? = null
        var result = 0
        fun setScore(score: Int) {
            result += score
            textViewScore!!.text = "Your score: $result"
        }
    }
}