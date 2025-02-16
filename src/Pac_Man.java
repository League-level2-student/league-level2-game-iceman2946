import java.awt.Color;
import java.awt.Graphics;

public class Pac_Man extends GameObject {
	int direction=4;

	int row;
	int column; 
	Pac_Man(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed=5;
		row=17;
		column=20;
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(column *50 +15, row *50 + 15, 20,20);
	}
	void up() {
		//y-=speed;
		if(row>0) {
			if(ObjectManager.tilesinCoding[row-1][column]==0 || ObjectManager.tilesinCoding[row-1][column]==4) {
				row --;
				if(ObjectManager.tilesinCoding[row][column]==0) {
					ObjectManager.tilesinCoding[row][column]=4;
					ObjectManager.score+=1;
					ObjectManager.tiles[row][column].tileType=4;
				}
			}

		}
	}
	void down() {
		//y+=speed;
		if(row<ObjectManager.tilesinCoding.length-1) {
			if(ObjectManager.tilesinCoding[row+1][column]==0 || ObjectManager.tilesinCoding[row+1][column]==4) {
				row ++;
				if(ObjectManager.tilesinCoding[row][column]==0) {
					ObjectManager.tilesinCoding[row][column]= 4;
					ObjectManager.score+=1;
					ObjectManager.tiles[row][column].tileType=4;
				}
			}
		}
	}
	void right() {
		//x+=speed;
		if(column<ObjectManager.tilesinCoding[0].length-1) {
			if(ObjectManager.tilesinCoding[row][column+1]==0 || ObjectManager.tilesinCoding[row][column+1]==4) {
				column ++;
				if(ObjectManager.tilesinCoding[row][column]==0) {
					ObjectManager.tilesinCoding[row][column]= 4;
					ObjectManager.score+=1;
					ObjectManager.tiles[row][column].tileType= 4;
				}
			}
		}
	}
	void left() {
		if(column>0) {
			if(ObjectManager.tilesinCoding[row][column-1]==0 || ObjectManager.tilesinCoding[row][column-1]==4) {
				column --;
				if(ObjectManager.tilesinCoding[row][column]==0) {
					ObjectManager.tilesinCoding[row][column]= 4;
					ObjectManager.score+=1;
					ObjectManager.tiles[row][column].tileType= 4; 
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
				if(ObjectManager.tilesinCoding[row-1][column]==0 || ObjectManager.tilesinCoding[row-1][column]==4 ) {	
					direction=1;
				}
			}
		}
		if(i==2) {
			if(row<ObjectManager.tilesinCoding.length-1) {
				if(ObjectManager.tilesinCoding[row+1][column]==0 || ObjectManager.tilesinCoding[row+1][column]==4)  {	
					direction=2;
				}
			}
		}
		if(i==3) {
			if(column<ObjectManager.tilesinCoding[0].length-1) {
				if(ObjectManager.tilesinCoding[row][column+1]==0 || ObjectManager.tilesinCoding[row][column+1]==4) {	
					direction=3;
				}
			}
		}
		if(i==4) {
			if(column>0) {
				if(ObjectManager.tilesinCoding[row][column-1]==0 || ObjectManager.tilesinCoding[row][column-1]==4) {	
					direction=4;
				}
			}
		}
		
		
	}

}
