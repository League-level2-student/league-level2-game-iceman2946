import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	int row;
	int column;
	int tileType;
	boolean isBlocked= false;
	Tile(int row, int column, int tileType) {
		this.row=row;
		this.column=column;
		if(tileType==0) {
			isBlocked=false;
		}
		else if(tileType==1) {
			isBlocked=true;
		}
		else if(tileType==2) {
			isBlocked=false;
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		//g.drawRect(column * 50, row * 50, 50, 50);
		if(isBlocked) {
			g.setColor(Color.blue);
			g.fillRect(column * 50, row * 50, 50,50);;
		}
	}
	
	
}
