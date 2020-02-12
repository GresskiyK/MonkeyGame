package com.example.monkeygamejava;

import android.content.Context;

import java.security.AccessControlContext;

public class Ship extends SpaceBody {
    public Ship(Context context) {
        bitmapId = R.drawable.monkey_model; // определяем начальные параметры
        size = 5;
        x=8;
        y=GameView.maxY - size - 1;
        speed = (float) 0.4;

        init(context); // инициализируем корабль
    }

    @Override
    void update() {
        if(GameActivity.isLeftPressed && x >= 0){
            x -= speed;
        }
        if(GameActivity.isRightPressed && x <= GameView.maxX - 5){
            x += speed;
        }
    }
}
