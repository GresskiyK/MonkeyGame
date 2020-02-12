package com.example.monkeygamejava;

import android.content.Context;

import java.util.Random;

public class Asteroid extends SpaceBody {
    private int radius = 1; // радиус
    private float minSpeed = (float) 0.1; // минимальная скорость
    private float maxSpeed = (float) 0.5; // максимальная скорость
    int[] myImageList = new int[]{R.drawable.orange, R.drawable.apple,R.drawable.banan,R.drawable.fireball};

    public Asteroid(Context context) {
        Random random = new Random();
        switch (random.nextInt(myImageList.length)){
            case 0:
                bitmapId=R.drawable.apple;
                y=0;
                x = random.nextInt(GameView.maxX) - radius;
                size = radius*2;
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat();
                break;
            case 1:
                bitmapId=R.drawable.orange;
                y=0;
                x = random.nextInt(GameView.maxX) - radius;
                size = radius*2;
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat();
                break;
            case 2:
                bitmapId=R.drawable.banan;
                y=0;
                x = random.nextInt(GameView.maxX) - radius;
                size = radius*2;
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat();
                break;
            case 3:
                bitmapId=R.drawable.fireball;
                y=0;
                x = random.nextInt(GameView.maxX)-radius;
                size = 4;
                speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat();
                break;
        }


        init(context);
    }

    public static void disable(Asteroid asteroid){
        asteroid.size=0;
    }

    @Override
    void update() {
        y += speed;
    }

    public boolean isCollision(float shipX, float shipY, float shipSize) {
        return !(((x+size) < shipX)||(x > (shipX+shipSize))||((y+size) < shipY)||(y > (shipY+shipSize)));
    }
}
