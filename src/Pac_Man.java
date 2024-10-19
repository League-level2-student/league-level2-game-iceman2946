import java.awt.Color;
import java.awt.Graphics;

public class Pac_Man extends GameObject {

	Pac_Man(int x, int y, int width, int height) {
		super(x, y, width, height);
		int speed=10;
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawOval(x, y, width, height);
		g.fillOval(x, y, width, height);
	}
	void up() {
		y-=speed;
	}
	void down() {
		y+=speed;
	}
	void right() {
		x+=speed;
	}
	void left() {
		x-=speed;
	}

}
