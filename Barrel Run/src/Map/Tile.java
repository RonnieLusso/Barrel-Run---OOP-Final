package Map;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import Entity.Entity;
import EntityTypes.EmptySpace;
import Main.Camera;
import Main.Window;
import ResourceLoading.ImageBank;

public class Tile {
	public static final int SIZE = 64;
	private BufferedImage image = ImageBank.getImages("Tile.png")[0];
	public int xPos, yPos;
	public Point2D.Double mapPos;
	private Entity entity;

	public Tile(Point2D.Double mapPos) {
		this.mapPos = mapPos;

	}

	public void logic() {
		xPos = (int) mapPos.x * SIZE + (int) Camera.position.x;
		yPos = (int) mapPos.y * SIZE + (int) Camera.position.y;
	}

	public void draw(Graphics2D g) {
		g.drawImage(image, xPos, yPos, null);
		
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		if (entity == null) {
			entity = new EmptySpace(this);
		}

		return entity;

	}

	public Point2D.Double getCenterPoint() {
		double x = xPos + (.5 * SIZE);
		double y = yPos + (.5 * SIZE);
		return new Point2D.Double(x, y);
	}

	public Point2D.Double getMapPos() {
		return mapPos;
	}

	public boolean isVisible() {
		return (xPos >= -SIZE && xPos < Window.WIDTH && yPos >= -SIZE && yPos < Window.HEIGHT);
	}

}
