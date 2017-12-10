package Entity;

import Main.Game;
import ResourceLoading.ImageBank;

public class Player1 extends PlayerEntity {

	public Player1() {
		super(Game.player1Controls, -1);
		current = running = ImageBank.getImages("Running");

	}

	@Override
	protected PlayerEntity getEnemy() {
		return Game.player2;
	}
	
	public String toString(){
		return "White";
	}
}
