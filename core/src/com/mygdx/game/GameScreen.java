package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter {
    private float WIDTH = 640;
    private float HEIGHT = 640;
    private float step;
    private Viewport viewport;
    private Texture chessBoard, b_rook,b_knight,b_bishop,b_queen,b_king,b_pawn;
    private Texture w_rook,w_knight,w_bishop,w_queen,w_king,w_pawn;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Piece black_rook;
    @Override
    public void show(){
        viewport = new FitViewport(WIDTH,HEIGHT, camera);
        step = viewport.getWorldWidth() / 8;
        batch = new SpriteBatch();
        camera = new OrthographicCamera(WIDTH,HEIGHT);
        camera.position.set(WIDTH/2,HEIGHT/2,0);
        camera.update();

        chessBoard = new Texture(Gdx.files.internal("ChessBoard.png"));

        black_rook = new Rook(b_rook,step,w_rook);

        b_rook = new Texture(Gdx.files.internal("black_rook.png"));
        b_knight = new Texture(Gdx.files.internal("black_knight.png"));
        b_bishop = new Texture(Gdx.files.internal("black_bishop.png"));
        b_queen = new Texture(Gdx.files.internal("black_queen.png"));
        b_king = new Texture(Gdx.files.internal("black_king.png"));
        b_pawn = new Texture(Gdx.files.internal("black_pawn.png"));

        w_rook = new Texture(Gdx.files.internal("white_rook.png"));
        w_knight = new Texture(Gdx.files.internal("white_knight.png"));
        w_bishop = new Texture(Gdx.files.internal("white_bishop.png"));
        w_queen = new Texture(Gdx.files.internal("white_queen.png"));
        w_king = new Texture(Gdx.files.internal("white_king.png"));
        w_pawn = new Texture(Gdx.files.internal("white_pawn.png"));
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);
        batch.begin();
        batch.draw(chessBoard,0,0,viewport.getWorldWidth(),viewport.getWorldHeight());
        drawPieces(batch);
        batch.end();
    }

    public void drawPieces(SpriteBatch batch){
        float x = 0;
        float y = 0;
        float width = step * 0.8f;
        float height = step * 0.8f;

        // rooks

        black_rook.draw(batch);

        batch.draw(b_rook,x+5,y,width,height);
        batch.draw(b_rook,(step*7) + 5,y,width,height);
        // knights
        batch.draw(b_knight,(step) + 5, 0,width,height);
        batch.draw(b_knight,(step*6) + 5, 0,width,height);
        // bishops
        batch.draw(b_bishop,(step * 2) + 5,0,width,height);
        batch.draw(b_bishop,(step * 5) + 5,0,width,height);
        //queen
        batch.draw(b_queen,(step * 3) + 5,0,width,height);
        //king
        batch.draw(b_king,(step * 4) + 5,0,width,height);

        // rooks
        batch.draw(w_rook,x+5,(step*7),width,height);
        batch.draw(w_rook,(step*7) + 5,(step*7),width,height);
        // knights
        batch.draw(w_knight,(step) + 5, (step*7),width,height);
        batch.draw(w_knight,(step*6) + 5, (step*7),width,height);
        // bishops
        batch.draw(w_bishop,(step * 2) + 5,(step*7),width,height);
        batch.draw(w_bishop,(step * 5) + 5,(step*7),width,height);
        //queen
        batch.draw(w_queen,(step * 3) + 5,(step*7),width,height);
        //king
        batch.draw(w_king,(step * 4) + 5,(step*7),width,height);

        //pawns
        for(int i = 0; i < 8; i++){
            batch.draw(b_pawn,step * i,step,width,height);
            batch.draw(w_pawn,step * i,step*6,width,height);
        }
    }

    public void update(){
        // checks where mouse is clicked
        float mouseX = Gdx.input.getX();

    }
}
