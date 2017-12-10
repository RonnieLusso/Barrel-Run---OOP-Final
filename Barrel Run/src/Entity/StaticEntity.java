package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Map.Tile;
import ResourceLoading.ImageBank;

public abstract class StaticEntity extends Entity {
	private BufferedImage image;

	public StaticEntity(Tile tile, String imageName) {
		super(tile);
		BufferedImage[] images = ImageBank.getImages(imageName);
		image = images[(int) (Math.random() * images.length)];
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, xPos, yPos, null);

	}


}
