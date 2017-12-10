package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import Main.GameClock;
import Map.Tile;
import ResourceLoading.ImageBank;

public abstract class DynamicEntity extends Entity {
	private static int tick;
	private BufferedImage[] images;
	private int imageIndex;

	public DynamicEntity(Tile tile, String folderName) {
		super(tile);
		this.images = ImageBank.getImages(folderName);
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(images[imageIndex], xPos, yPos, null);
		if (tick != (int)GameClock.tick) {
			imageIndex = (imageIndex + 1) % images.length;
			tick = (int) (GameClock.tick);
		}
	}

}
