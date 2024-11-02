import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	String color= "";
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed=2;
	}
	void draw(Graphics g) {
		g.setColor(Color.getColor(color));
		g.drawRoundRect(x, y, width, height, 10, 10);
	}
	void update() {
		super.update();
	}

}
