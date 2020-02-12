package com.example.monkeygamejava

import android.content.Context
import android.graphics.*
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.util.*

class GameView(context: Context?, private val callback: OnDieListener) : SurfaceView(context), Runnable {
    companion object{
        var maxX = 20
        var maxY = 28
        var unitW = 0f
        var unitH = 0f
    }

    private var firstTime = true
    private var gameRunning = true
    private var monkey: Monkey? = null
    private var gameThread: Thread? = null
    private val paint: Paint = Paint()
    private var canvas: Canvas? = null
    private val surfaceHolder: SurfaceHolder = holder
    private val items = ArrayList<FallItem>()
    private val ASTEROID_INTERVAL = 50
    private var currentTime = 0
    private fun checkCollision() {
        for (item in items) {
            if (item.isCollision(monkey!!.x, monkey!!.y, monkey!!.size)&&item.bitmapId == R.drawable.banan&& item.bitmapId != R.drawable.fireball && item.bitmapId != R.drawable.cold_fireball) {
                GameActivity.setScore(5)
                items.remove(item)
                break
            } else if (item.isCollision(monkey!!.x, monkey!!.y, monkey!!.size)&&item.bitmapId != R.drawable.banan && item.bitmapId != R.drawable.fireball && item.bitmapId != R.drawable.cold_fireball) {
                GameActivity.setScore(2)
                items.remove(item)
                break
            }else if (item.isCollision(monkey!!.x, monkey!!.y, monkey!!.size) && item.bitmapId == R.drawable.fireball) {
                callback.onDie()
                gameRunning = false
            }else if (item.isCollision(monkey!!.x, monkey!!.y, monkey!!.size) && item.bitmapId == R.drawable.cold_fireball) {
                callback.onDie()
                gameRunning = false
            }
        }
    }

    private fun checkIfNewAsteroid() {
        if (currentTime >= ASTEROID_INTERVAL) {
            val asteroid = FallItem(context)
            items.add(asteroid)
            currentTime = 0
        } else {
            currentTime++
        }
    }

    override fun run() {
        while (gameRunning) {
            update()
            draw()
            checkCollision()
            checkIfNewAsteroid()
            control()
        }
    }

    private fun update() {
        if (!firstTime) {
            monkey!!.update()
            for (asteroid in items) {
                asteroid.update()
            }
        }
    }

    private fun draw() {
        if (surfaceHolder.surface.isValid) {
            if (firstTime) {
                firstTime = false
                unitW = surfaceHolder.surfaceFrame.width() / maxX.toFloat()
                unitH = surfaceHolder.surfaceFrame.height() / maxY.toFloat()
                monkey = Monkey(context)
            }
            canvas = surfaceHolder.lockCanvas()
            canvas!!.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
            monkey!!.drow(paint, canvas!!)
            for (asteroid in items) {
                asteroid.drow(paint, canvas!!)
            }
            surfaceHolder.unlockCanvasAndPost(canvas)
        }
    }

    private fun control() {
        try {
            Thread.sleep(15)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    init {

        val sfvTrack: SurfaceView = this
        sfvTrack.setZOrderOnTop(true)
        val sfhTrackHolder = sfvTrack.holder
        sfhTrackHolder.setFormat(PixelFormat.TRANSPARENT)
        gameThread = Thread(this)
        gameThread!!.start()
    }
}

interface OnDieListener {
    fun onDie()
}