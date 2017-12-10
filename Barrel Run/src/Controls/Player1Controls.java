package Controls;

import java.awt.event.KeyEvent;

public class Player1Controls extends KeyControl {
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W && upReleased) {
			up = true;
			upReleased = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S && downReleased) {
			down = true;
			downReleased = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A && leftReleased) {
			left = true;
			leftReleased = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D && rightReleased) {
			right = true;
			rightReleased = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			up = false;
			upReleased = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			down = false;
			downReleased = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			left = false;
			leftReleased = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			right = false;
			rightReleased = true;
		}

	}

}
