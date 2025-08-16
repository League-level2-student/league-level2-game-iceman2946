import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

public class Pac_Man extends GameObject {
	int direction=4;
	Timer moveTimer;
	int row;
	int column;
	Pac_Man(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed=5;
		row=17;
		column=20;
		//moveTimer = 
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(column *50 +15, row *50 + 15, 20,20);
	}
	void up() {
		//y-=speed;
		if(row>0) {
			if(ObjectManager.tiles[row-1][column].tileType==0 || ObjectManager.tiles[row-1][column].tileType==4 || ObjectManager.tiles[row-1][column].tileType==5) {
				row --;
				if(ObjectManager.tiles[row][column].tileType==0) {
					//ObjectManager.tilesinCoding[row][column]=4;
					ObjectManager.score+=10;
					ObjectManager.dotCount-=1;
					ObjectManager.tiles[row][column].tileType=4;
				}
				if(ObjectManager.tiles[row][column].tileType==5) {
					//ObjectManager.tilesinCoding[row][column]=4;
					ObjectManager.dotCount-=1;
					ObjectManager.score+=20;
					ObjectManager.tiles[row][column].tileType = 4;
					ObjectManager.powerPelletActive=true;
					if(	ObjectManager.colorSwitch.isRunning()) {
						ObjectManager.colorSwitch.restart();
					}
				}

			}

		}
	}
	void down() {
		//y+=speed;
		if(row<ObjectManager.tiles.length-1) {
			if(ObjectManager.tiles[row+1][column].tileType==0 || ObjectManager.tiles[row+1][column].tileType==4 || ObjectManager.tiles[row+1][column].tileType==5) {
				row ++;
				if(ObjectManager.tiles[row][column].tileType==0) {
					//ObjectManager.tilesinCoding[row][column]= 4;
					ObjectManager.score+=10;
					ObjectManager.dotCount-=1;
					ObjectManager.tiles[row][column].tileType=4;
				}
				if(ObjectManager.tiles[row][column].tileType==5) {
					//ObjectManager.tilesinCoding[row][column]=4;
					ObjectManager.score+=20;
					ObjectManager.dotCount-=1;
					ObjectManager.tiles[row][column].tileType = 4;
					ObjectManager.pelletActive();
					if(	ObjectManager.colorSwitch.isRunning()) {
						ObjectManager.colorSwitch.restart();
					}
				}
			}
		}
	}
	void right() {
		//x+=speed;
		if(column<ObjectManager.tiles[0].length-1) {
			if(ObjectManager.tiles[row][column+1].tileType==0 || ObjectManager.tiles[row][column+1].tileType==4 || ObjectManager.tiles[row][column+1].tileType==5 ) {
				column ++;
				if(ObjectManager.tiles[row][column].tileType==0) {
					//ObjectManager.tilesinCoding[row][column]= 4;
					ObjectManager.score+=10;
					ObjectManager.dotCount-=1;
					ObjectManager.tiles[row][column].tileType= 4;
				}
				if(ObjectManager.tiles[row][column].tileType==5) {
					//ObjectManager.tilesinCoding[row][column]=4;
					ObjectManager.score+=20;
					ObjectManager.dotCount-=1;
					ObjectManager.tiles[row][column].tileType = 4;
					ObjectManager.pelletActive();
					if(	ObjectManager.colorSwitch.isRunning()) {
						ObjectManager.colorSwitch.restart();
					}
				}
			}
		}
	}
	void left() {
		if(column>0) {
			if(ObjectManager.tiles[row][column-1].tileType==0 || ObjectManager.tiles[row][column-1].tileType==4 || ObjectManager.tiles[row][column-1].tileType==5) {
				column --;
				if(ObjectManager.tiles[row][column].tileType==0) {
					//ObjectManager.tilesinCoding[row][column]= 4;
					ObjectManager.score+=10;
					ObjectManager.dotCount-=1;
					ObjectManager.tiles[row][column].tileType= 4; 
				}
				if(ObjectManager.tiles[row][column].tileType==5) {
					//ObjectManager.tilesinCoding[row][column]=4;
					ObjectManager.score+=20;
					ObjectManager.dotCount-=1;
					ObjectManager.tiles[row][column].tileType = 4;
					ObjectManager.pelletActive();
					if(	ObjectManager.colorSwitch.isRunning()) {
						ObjectManager.colorSwitch.restart();
					}
				}

			}
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
	public void setDirection(int i) {
		if(i==1) {
			if(row>0) {
				if(ObjectManager.tilesinCoding[row-1][column]==0 || ObjectManager.tilesinCoding[row-1][column]==4 || ObjectManager.tilesinCoding[row-1][column]==5) {	
					direction=1;
				}
			}
		}
		if(i==2) {
			if(row<ObjectManager.tilesinCoding.length-1) {
				if(ObjectManager.tilesinCoding[row+1][column]==0 || ObjectManager.tilesinCoding[row+1][column]==4 || ObjectManager.tilesinCoding[row+1][column]==5)  {	
					direction=2;
				}
			}
		}
		if(i==3) {
			if(column<ObjectManager.tilesinCoding[0].length-1) {
				if(ObjectManager.tilesinCoding[row][column+1]==0 || ObjectManager.tilesinCoding[row][column+1]==4 || ObjectManager.tilesinCoding[row][column+1]==5) {	
					direction=3;
				}
			}
		}
		if(i==4) {
			if(column>0) {
				if(ObjectManager.tilesinCoding[row][column-1]==0 || ObjectManager.tilesinCoding[row][column-1]==4 || ObjectManager.tilesinCoding[row][column-1]==5) {	
					direction=4;
				}
			}
		}

	}
	void reset() {
		row = 17;
		column= 20;
	}

}
