package com.example.monkeygamejava

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

open class GameBody {
    var x
            = 0f
    var y = 0f
    var size
            = 0f
    protected var speed
            = 0f
    var bitmapId
            = 0
    private var bitmap
            : Bitmap? = null

    fun init(context: Context) {
        val cBitmap = BitmapFactory.decodeResource(context.resources, bitmapId)
        bitmap = Bitmap.createScaledBitmap(
                cBitmap, (size * GameView.unitW).toInt(), (size * GameView.unitH).toInt(), false)
        cBitmap.recycle()
    }

    open fun update() {
    }

    fun drow(paint: Paint?, canvas: Canvas) {
        bitmap?.let { canvas.drawBitmap(it, x * GameView.unitW, y * GameView.unitH, paint) }
    }
}