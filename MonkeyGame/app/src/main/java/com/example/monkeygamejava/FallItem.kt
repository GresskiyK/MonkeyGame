package com.example.monkeygamejava

import android.content.Context
import android.graphics.drawable.Drawable
import java.util.*

class FallItem(context: Context?) : GameBody() {
    private val radius = 1
    private val minSpeed = 0.1.toFloat()
    private val maxSpeed = 0.5.toFloat()
    var myImageList = intArrayOf(R.drawable.orange, R.drawable.apple, R.drawable.banan, R.drawable.fireball,R.drawable.cold_fireball,R.drawable.squash)
    var list = arrayOf(R.drawable.orange, R.drawable.apple, R.drawable.banan, R.drawable.fireball,R.drawable.cold_fireball,R.drawable.squash)

    public override fun update() {
        y += speed
    }

    fun isCollision(shipX: Float, shipY: Float, shipSize: Float): Boolean {
        return !(x + size < shipX || x > shipX + shipSize || y + size < shipY || y > shipY + shipSize)
    }
    fun randomInt():Int{
        val r = Random()
        val n=r.nextInt(list.size)
        return n
    }



    init {
                val random = Random()
                bitmapId = list[randomInt()]
                y = 0f
                x = random.nextInt(GameView.maxX) - radius.toFloat()
                size = radius * 2.toFloat()
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat()


        context?.let { init(it) }
    }

}