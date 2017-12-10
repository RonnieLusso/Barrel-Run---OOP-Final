package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import Controls.KeyControl;
import Controls.Mouse;
import Controls.Player1Controls;
import Controls.Player2Controls;
import Entity.Entity;
import Entity.Player1;
import Entity.Player2;
import Entity.PlayerEntity;
import EntityTypes.Barrel;
import EntityTypes.Grass;
import EntityTypes.LeftFence;
import EntityTypes.RightFence;
import Map.Map;
import Map.Tile;
import ResourceLoading.ImageBank;

public class Game extends Canvas {
	public static PlayerEntity player1;
	public static PlayerEntity player2;
	public static ImageBank b = new ImageBank();
	private static final long serialVersionUID = 1L;
	private static Map map = new Map();
	private static BufferStrategy strategy;
	private static Thread thread = new GameClock();
	private static Window window = new Window();
	public static KeyControl player1Controls = new Player1Controls();
	public static KeyControl player2Controls = new Player2Controls();
	private static ArrayList<Entity> entities = new ArrayList<Entity>();
	public static Font font = new Font("TimesRoman", Font.PLAIN, 60);

	public Game() {
		createLevel();
		window.add(this);
		window.addKeyListener(player1Controls);
		window.addKeyListener(player2Controls);
		addKeyListener(player1Controls);
		addKeyListener(player2Controls);
		addMouseListener(new Mouse());
		setFocusable(true);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		thread.start();

	}

	public void createLevel() {
		int a = Window.WIDTH - (Map.WIDTH * Tile.SIZE);
		Camera.position.x = a / 2;
		Camera.position.y = -(Map.HEIGHT * Tile.SIZE) + Tile.SIZE * (Window.HEIGHT / Tile.SIZE);
		player1 = new Player1();
		player2 = new Player2();
		for (int i = 0; i < Map.array.length; i++) {
			for (int j = 0; j < Map.array[0].length; j++) {
				Entity e = null;
				if (i == Map.array.length - 1 || i == 0) {
					if (i == Map.array.length - 1) {
						e = new RightFence(Map.array[i][j]);
						entities.add(e);
					}
					if (i == 0) {
						e = new LeftFence(Map.array[i][j]);
						entities.add(e);
					}
				} else {
					if (Math.random() * 10 > 7) {
						e = new Grass(Map.array[i][j]);
						entities.add(e);

					}
					if (j < Map.HEIGHT - 20 && Math.random() * 3000 > 2925 - (Map.HEIGHT - j)) {
						e = new Barrel(Map.array[i][j]);
						entities.add(e);

					}
				}

			}
		}
		entities.add(player1);
		entities.add(player2);
	}

	public static void update() {
		logic();
		draw();
	}

	private static void logic() {
		Camera.logic();
		map.logic();
		for (Entity e : entities) {
			e.logic();
		}

	}

	private static void draw() {
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		g.fillRect(0, 0, window.getWidth(), window.getHeight());	
		map.draw(g);
		for (Entity e : entities) {
			if (e.isVisible())
				e.draw(g);
		}
		g.dispose();
		strategy.show();

	}

	public static void main(String args[]) {
		new Game();
	}

	public static void gameOver(String string, Graphics2D g) {
		Camera.stop();
		GameClock.TPS = 0;
		g.setFont(font); 
		g.drawImage(ImageBank.getImages("gameOver.png")[0], 0, 0, null);
		g.setColor(Color.gray);
		g.drawString(string  + "Wins!", Window.WIDTH /2 - 200, Window.HEIGHT/2);
		
		
	}

}
