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
		this.tileType=tileType;
		if(tileType==0) {
			isBlocked=false;
		}
		else if(tileType==1) {
			isBlocked=true;
		}
		else if(tileType==2) {
			isBlocked=true;
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		//g.drawRect(column * 50, row * 50, 50, 50);
		if (tileType == 0) {
			new PacDots(row,column,g);
		}
		if(isBlocked && tileType==1) {
			g.setColor(Color.blue);
			g.fillRoundRect(column * 50, row * 50, 50, 50, 10, 10);
			}
		if(isBlocked && tileType==2) {
			g.setColor(Color.blue);
			g.fillRect(column * 50, row * 50, 50, 50);
		}
		if(isBlocked && tileType ==3) {
			g.setColor(Color.BLACK);
			g.fillRect(column * 50, row * 50, 50, 50);
		}
	}

	
	
}
