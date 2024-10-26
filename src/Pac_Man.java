import java.awt.Color;
import java.awt.Graphics;

public class Pac_Man extends GameObject {
	int direction=4;
	Pac_Man(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed=5;
		
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		//g.drawOval(x, y, width, height);
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
