import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	String color= "";
	int row;
	int column;
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed=2;
		row = 9;
		column = 19; 
	}
	void draw(Graphics g) {
		g.setColor(Color.getColor(color));
		g.drawRoundRect(column * 50, row * 50, 50, 50, 10, 10);
	}
	void update() {
		super.update();
	}

}
