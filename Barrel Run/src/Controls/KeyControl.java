package Controls;

import java.awt.event.KeyAdapter;

public abstract class KeyControl extends KeyAdapter {
	public boolean up, down, left, right;
	protected boolean leftReleased = true, rightReleased = true, upReleased = true, downReleased = true;
}
