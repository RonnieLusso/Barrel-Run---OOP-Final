package Main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = 550, HEIGHT = 550;

	public Window() {
		setTitle("Barrel Run - Goals: Avoid the Barrels! - Controls: WASD, Arrow Keys");
		setSize(WIDTH, HEIGHT);
		setLocation((int) (screenSize.getWidth() / 2) - (WIDTH / 2), (int) (screenSize.getHeight() / 2) - (HEIGHT / 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

}
