package Controls;

import java.awt.event.KeyEvent;

public class Player2Controls extends KeyControl {

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && upReleased) {
			up = true;
			upReleased = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && downReleased) {
			down = true;
			downReleased = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && leftReleased) {
			left = true;
			leftReleased = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && rightReleased) {
			right = true;
			rightReleased = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
			upReleased = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
			downReleased = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
			leftReleased = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
			rightReleased = true;
		}

	}

}
