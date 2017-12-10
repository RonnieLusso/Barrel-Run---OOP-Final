package Entity;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import Main.Camera;
import Main.Window;
import Map.Tile;

public abstract class Entity {
	protected Tile tile;
	protected int xPos, yPos;

	public Entity(Tile tile) {
		this.tile = tile;
		tile.setEntity(this);
	}

	public void move(Tile tile) {
	 // change the entity of the tile
		this.tile = tile; // change the title of the entity
	}

	public void logic() {
		xPos = (int) tile.getMapPos().x * Tile.SIZE + (int) Camera.position.x;
		yPos = (int) tile.getMapPos().y * Tile.SIZE + (int) Camera.position.y;
	}

	public Point2D.Double getCenterPoint() {
		double x = xPos + (.5 * Tile.SIZE);
		double y = yPos + (.5 * Tile.SIZE);
		return new Point2D.Double(x, y);
	}

	public abstract void draw(Graphics2D g);

	public boolean isVisible() {
		return (xPos >= -Tile.SIZE && xPos < Window.WIDTH && yPos >= -Tile.SIZE && yPos < Window.HEIGHT);
	}
}
