import java.awt.Color;
import java.awt.Graphics;

public class PacDots {
	int row;
	int column;
	PacDots(int row, int column){
		this.row= row;
		this.column= column;
	}
	void draw(Graphics g) {
		g.setColor(Color.orange);
		g.fillOval(column * 50 + 19, row * 50 + 19, 12, 12);
	}

}
