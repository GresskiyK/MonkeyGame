package com.example.monkeygamejava

import android.content.Context

class Monkey(context: Context?) : GameBody() {
    override fun update() {
        if (GameActivity.isLeftPressed && x >= 0) {
            x -= speed
        }
        if (GameActivity.isRightPressed && x <= GameView.maxX - 5) {
            x += speed
        }
    }

    init {
        bitmapId = R.drawable.monkey_model
        size = 6F
        x = 8F
        y = GameView.maxY - size - 0
        speed = 0.4.toFloat()
        init(context!!)
    }
}