package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Rook extends Piece{
    Texture b_rook,w_rook;
    public Rook(Texture chessPiece, float step,Texture w_rook) {
        super(chessPiece, step);
        b_rook = chessPiece;
        this.w_rook = w_rook;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(b_rook,super.getX(),0);
    }

    public void update(){
        float x=  getX()+ 1;
        setXAndY(x,getY());
    }

}
