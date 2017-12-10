package Map;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Map {
	public static final int WIDTH = 7, HEIGHT = 3000;
	public static Tile[][] array;

	public Map() {
		array = new Tile[WIDTH][HEIGHT];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = new Tile(new Point2D.Double(i, j));
			}
		}
	}

	public void draw(Graphics2D g) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j].isVisible())
					array[i][j].draw(g);
			}
		}
	}

	public void logic() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j].logic();
			}
		}

	}

}
