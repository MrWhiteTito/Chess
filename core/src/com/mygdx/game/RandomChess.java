package com.mygdx.game;

import com.badlogic.gdx.Game;

public class RandomChess extends Game {

	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}
