package Entity;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import Controls.KeyControl;
import EntityTypes.Barrel;
import Main.Camera;
import Main.Game;
import Main.GameClock;
import Main.Window;
import Map.Map;
import Map.Tile;

public abstract class PlayerEntity extends Entity {
	protected BufferedImage[] running, current;
	public static double jumpSpeed = 8;
	private int tick;
	private int imageIndex;
	protected boolean movingRight, movingLeft, movingUp, movingDown;
	protected KeyControl key;
	protected double yDest;
	protected PlayerEntity enemy;
	protected boolean gameOver;

	public PlayerEntity(KeyControl key, int i) {
		super(Map.array[Map.WIDTH / 2 + i][Map.HEIGHT - 1]);
		this.key = key;
		xPos = (int) tile.getMapPos().x * Tile.SIZE + (int) Camera.position.x;
		yPos = (int) tile.getMapPos().y * Tile.SIZE + (int) Camera.position.y;
	}

	public void logic() {
		enemy = getEnemy();
		if(!gameOver){
		if (getCenterPoint().y - tile.getCenterPoint().y < -32) {
			move(Map.array[(int) (tile.mapPos.x)][(int) (tile.mapPos.y) - 1]);
		}
		if (!movingRight && !movingLeft && !movingDown && !movingUp) {

			if (key.right && tile.mapPos.x < Map.WIDTH - 2 && enemyCheck(1, 0) && !(Map.array[(int) (tile.mapPos.x + 1)][(int) (tile.mapPos.y)].getEntity() instanceof Barrel)) {
				move(Map.array[(int) (tile.mapPos.x + 1)][(int) (tile.mapPos.y)]);
				movingRight = true;
				
			}
			if (!movingRight && key.left && tile.mapPos.x > 1 && enemyCheck(-1, 0) && !(Map.array[(int) (tile.mapPos.x - 1)][(int) (tile.mapPos.y)].getEntity() instanceof Barrel)) {
				move(Map.array[(int) (tile.mapPos.x - 1)][(int) (tile.mapPos.y)]);
				movingLeft = true;
			}
			if (!movingRight && !movingLeft && key.up && yPos > Tile.SIZE * 3 && enemyCheck(0, -1)) {
				movingUp = true;
				yDest = yPos - 64;
			}
			if (!movingRight && !movingLeft && !movingUp && key.down && yPos < Window.HEIGHT - Tile.SIZE * 2 && enemyCheck(0, 1)) {
				movingDown = true;
				yDest = yPos + 64;
			}

		} else {
			key.down = false;
			key.up = false;
			key.right = false;
			key.left = false;
		}
		if (movingRight) {
			if (xPos < tile.xPos) {
				xPos += jumpSpeed;
			} else {
				movingRight = false;
			}
		}
		if (movingLeft) {
			if (xPos > tile.xPos) {
				xPos -= jumpSpeed;
			} else {
				movingLeft = false;
			}
		}
		if (movingUp) {
			if (yPos > yDest) {
				yPos -= jumpSpeed;
			} else {
				movingUp = false;
			}
		}
		if (movingDown) {
			if (yPos < yDest) {
				yPos += jumpSpeed;
			} else {
				movingDown = false;
			}
		}
		if (tick != (int) GameClock.tick) {
			imageIndex = (imageIndex + 1) % current.length;
			tick = (int) (GameClock.tick);
		}
		}
	}

	protected abstract PlayerEntity getEnemy();

	private boolean enemyCheck(int x, int y) {
		Point DesiredPoint = new Point((int) (getCenterPoint().x + (x * Tile.SIZE)),
				(int) (getCenterPoint().y + (y * Tile.SIZE)));
		Point EnemyPoint = new Point((int) enemy.getCenterPoint().x, (int) enemy.getCenterPoint().y);
		double distance = Math.sqrt((EnemyPoint.x - DesiredPoint.x) * (EnemyPoint.x - DesiredPoint.x)
				+ (EnemyPoint.y - DesiredPoint.y) * (EnemyPoint.y - DesiredPoint.y));
		if (distance >= 64) {
			return true;
		}
		return false;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(current[imageIndex], xPos, yPos, null);
		if (tile.getEntity() instanceof Barrel) {
			gameOver = true;
			Game.gameOver(enemy.toString(), g);
		}

	}

}
