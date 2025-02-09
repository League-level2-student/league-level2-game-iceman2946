import java.awt.Color;
import java.awt.Graphics;

public class PacDots {
	int row;
	int column;
	PacDots(int row, int column,Graphics g){
		this.row= row;
		this.column= column;
		draw(g);
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(column * 50 + 19, row * 50 + 19, 12, 12);
	}
	void remove(Graphics g) {
		g.setColor(Color.BLACK);
	}
}
