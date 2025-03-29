import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Tile implements ActionListener {
	int row;
	int column;
	int tileType;
	boolean isBlocked= false;
	Timer timer; 
	PacDots pacdot;
	private Color color;
	Tile(int row, int column, int tileType) {
		this.row=row;
		this.column=column;
		this.tileType=tileType;
		color = Color.RED;
		if(tileType == 5) {
			timer = new Timer(300,this);
			timer.start();
		}
		if(tileType==0) {
			isBlocked=false;
		}
		else if(tileType==1) {
			isBlocked=true;
		}
		else if(tileType==2) {
			isBlocked=true;
		}
		else if(tileType==3) {
			isBlocked=true;
		}
		else if(tileType==4) {
			isBlocked=false;
		}
		else if(tileType==5) {
			isBlocked=false;
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		//g.drawRect(column * 50, row * 50, 50, 50);
		if (tileType == 0) {
			pacdot = new PacDots(row,column);
			pacdot.draw(g);
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
		if(tileType == 4) {
			g.setColor(Color.BLACK);
			g.drawRect(column * 50, row * 50, 50, 50);
		}
		if(tileType == 5) {
			g.setColor(color);
			g.fillOval(column * 50 + 12, row * 50 + 12, 26, 26);
			
			//g.setColor(Color.RED);
			//g.fillOval(column * 50 + 13, row * 50 + 13, 25, 25);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(tileType != 5) {
			timer.stop();
		}
		else {
			if(color == Color.RED) {
				color = Color.BLACK;
			}
			else {
				color = Color.RED;
			}
		}
	}

	
	
}
