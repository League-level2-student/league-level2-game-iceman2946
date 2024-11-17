import java.awt.Color;
import java.awt.Graphics;

public class Bit extends GameObject {

	Bit(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.width=2;
		this.height=2;
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawOval(x, y, width, height);
	}

}
