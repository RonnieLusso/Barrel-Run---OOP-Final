package Entity;

import Main.Game;
import ResourceLoading.ImageBank;

public class Player2 extends PlayerEntity {

	public Player2() {
		super(Game.player2Controls, 1);
		current = running = ImageBank.getImages("Running2");
	}

	@Override
	protected PlayerEntity getEnemy() {
		return Game.player1;
	}

	public String toString() {
		return "Red";
	}

}
