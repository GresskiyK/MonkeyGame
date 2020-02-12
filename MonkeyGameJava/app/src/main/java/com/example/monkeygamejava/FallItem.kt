package com.example.monkeygamejava

import android.content.Context
import java.util.*

class FallItem(context: Context?) : GameBody() {
    private val radius = 1
    private val minSpeed = 0.1.toFloat()
    private val maxSpeed = 0.5.toFloat()
    var myImageList = intArrayOf(R.drawable.orange, R.drawable.apple, R.drawable.banan, R.drawable.fireball,R.drawable.cold_fireball,R.drawable.squash)
    public override fun update() {
        y += speed
    }

    fun isCollision(shipX: Float, shipY: Float, shipSize: Float): Boolean {
        return !(x + size < shipX || x > shipX + shipSize || y + size < shipY || y > shipY + shipSize)
    }

    companion object {
        fun disable(fallItem: FallItem) {
            fallItem.size = 0f
        }
    }

    init {
        val random = Random()
        when (random.nextInt(myImageList.size)) {
            0 -> {
                bitmapId = R.drawable.apple
                y = 0f
                x = random.nextInt(GameView.maxX) - radius.toFloat()
                size = radius * 2.toFloat()
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat()
            }
            1 -> {
                bitmapId = R.drawable.orange
                y = 0f
                x = random.nextInt(GameView.maxX) - radius.toFloat()
                size = radius * 2.toFloat()
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat()
            }
            2 -> {
                bitmapId = R.drawable.banan
                y = 0f
                x = random.nextInt(GameView.maxX) - radius.toFloat()
                size = radius * 2.toFloat()
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat()
            }
            3 -> {
                bitmapId = R.drawable.fireball
                y = 0f
                x = random.nextInt(GameView.maxX) - radius.toFloat()
                size = 4f
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat()
            }
            4 -> {
                bitmapId = R.drawable.cold_fireball
                y = 0f
                x = random.nextInt(GameView.maxX) - radius.toFloat()
                size = 4f
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat()
            }
            5 -> {
                bitmapId = R.drawable.squash
                y = 0f
                x = random.nextInt(GameView.maxX) - radius.toFloat()
                size = radius * 2.toFloat()
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat()
            }
        }
        context?.let { init(it) }
    }
}