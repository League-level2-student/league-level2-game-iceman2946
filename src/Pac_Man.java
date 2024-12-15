import java.awt.Color;
import java.awt.Graphics;

public class Pac_Man extends GameObject {
	int direction=4;

	int row;
	int column; 
	Pac_Man(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed=5;
		row=0;
		column=0;
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(column *50 +15, row *50 + 15, 20,20);
	}
	void up() {
		//y-=speed;
		if(row>0) {
			row--;
		}
	}
	void down() {
		//y+=speed;
		if(row<17) {
			row++;
		}
	}
	void right() {
		//x+=speed;
		if(column<37) {
			column++;
		}
	}
	void left() {
		if(column>0) {
			column--;
		}
	}
	void update() {
		if(direction==1) {
			up();
		}
		else if(direction==2) {
			down();
		}
		else if(direction==3) {
			right();
		}
		else if(direction==4) {
			left();
		}
	}

}
