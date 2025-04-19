import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	Color color;
	int row;
	int column;
	boolean immortalState = true; 
	Alien(int x, int y, int width, int height,int row, int column) {
		super(x, y, width, height);
		this.speed=2;
		this.row = row;
		this.column = column; 
	}
	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(column * 50, row * 50, width, height);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	void update() {
		super.update();
	}

}
