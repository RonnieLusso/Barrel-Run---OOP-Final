package Main;

import java.awt.geom.Point2D;

public class Camera {
	public static final double CAMERADRAG = 0.90, CAMERAACCEL = 1.00025;
	public static Point2D.Double position = new Point2D.Double();
	private static Point2D.Double velocity = new Point2D.Double();
	private static double speed = 4;

	public static void logic() {
		velocity.y =  speed;

		position.x += velocity.x;
		position.y += velocity.y;
		velocity.x *= CAMERADRAG;
		velocity.y *= CAMERADRAG;
		if (speed < 6 && !(speed < 2)){
			speed = (speed + 0.0025);
			if(speed > 4){
				GameClock.TPS = 6;
			}
		}else{
			GameClock.TPS = 12;
		}
	}

	public static void stop() {
		speed = 0;
		
	}

}
