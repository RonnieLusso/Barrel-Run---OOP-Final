package Main;

public class GameClock extends Thread {
	// TPS(Ticks Per Second) Animation - determines the image change per second
	private final int FPS = 100;
	public static double tick, TPS = 4;

	public void run() {
		while (true) {
			Game.update();
			tick = tick + (1.0 / (FPS / TPS));
			try {
				sleep(1000 / FPS);
			} catch (Exception e) {
			}
		}
	}

}
