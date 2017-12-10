package ResourceLoading;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageBank {
	private static Map<String, ArrayList<BufferedImage>> images = new HashMap<String, ArrayList<BufferedImage>>();

	public ImageBank() {
		getResourcesStatic();
		getResourcesGrass();
		getResourcesRunning();
		getResourcesRunning2();

	}

	private void getResourcesRunning2() {
		String[] imageNames = new String[] { "1.png", "2.png", "3.png", "4.png" };
		ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();
		for (int i = 0; i < imageNames.length; i++) {

			try {
				imgs.add(ImageIO.read(getClass().getResourceAsStream("/ResourcesRunning2/" + imageNames[i])));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		images.put("Running2", imgs);
		
	}

	private void getResourcesRunning() {
		String[] imageNames = new String[] { "1.png", "2.png", "3.png", "4.png" };
		ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();
		for (int i = 0; i < imageNames.length; i++) {

			try {
				imgs.add(ImageIO.read(getClass().getResourceAsStream("/ResourcesRunning/" + imageNames[i])));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		images.put("Running", imgs);

	}

	private void getResourcesGrass() {
		String[] imageNames = new String[] { "grass1.png", "grass2.png", "grass3.png" };
		ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();
		for (int i = 0; i < imageNames.length; i++) {

			try {
				imgs.add(ImageIO.read(getClass().getResourceAsStream("/ResourcesGrass/" + imageNames[i])));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		images.put("Grass", imgs);
	}

	private void getResourcesStatic() {
		String[] imageNames = new String[] { "Barrel.png", "gameOver.png", "RightFence.png", "LeftFence.png", "defaultImage.png",
				"Tile.png" };
		for (int i = 0; i < imageNames.length; i++) {
			ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();
			try {
				imgs.add(ImageIO.read(getClass().getResourceAsStream("/ResourcesStatic/" + imageNames[i])));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			images.put(imageNames[i], imgs);
		}

	}

	public static BufferedImage[] getImages(String key) {
		try {
			ArrayList<BufferedImage> imageArray = images.get(key);
			return imageArray.toArray(new BufferedImage[imageArray.size()]);
		} catch (NullPointerException e) {
			System.out.println(key + " does not exsist in the imagebank");
			ArrayList<BufferedImage> imageArray = images.get("defaultImage.png");
			return imageArray.toArray(new BufferedImage[imageArray.size()]);
		}
	}

	public static BufferedImage toBufferedImage(Image img) {
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		return bimage;
	}

}
