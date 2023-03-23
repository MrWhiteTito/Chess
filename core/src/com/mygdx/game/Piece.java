package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Piece {
    private float x,y;
    private Texture piece;
    private float size;

    public Piece(Texture chessPiece,float step){
        x = 0;
        y = 0;
        piece = chessPiece;
        size = step;
    }

    public void setXAndY(float myX, float myY){
        x = myX;
        y = myY;
    }

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public float getSize(){
        return size;
    }
    public abstract void draw(SpriteBatch batch);
}
