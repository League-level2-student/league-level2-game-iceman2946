import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {
	Color color;
	int row;
	int column;
	final int startingRow; 
	final int startingColumn;
	boolean immortalState = true; 
	int randomDirection = 0;
	Random random;
	boolean inSpawn = true;
	int up = 1;
	int down =2;
	int right = 3;
	int left = 4; 
	boolean powerPelletActive = false;
	Alien(int x, int y, int width, int height,int row, int column) {
		super(x, y, width, height);
		this.speed=2;
		this.row = row;
		this.column = column; 
		random = new Random();
		startingRow = row;
		startingColumn= column; 
	}
	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(column * 50, row * 50, width, height);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	void changeDirection() {
		int temp = randomDirection;
		
	while(temp == randomDirection) {
		randomDirection= (int)random.nextInt(4);
	}
	
	}
	void reset() {
		row = startingRow;
		column= startingColumn;
		inSpawn= true;
		powerPelletActive=false;
	}
	void update() {
		if(inSpawn == false) {
			if(randomDirection==0 && row > 0 && (ObjectManager.tiles[row-1][column].tileType==0 || ObjectManager.tiles[row-1][column].tileType==3 || ObjectManager.tiles[row-1][column].tileType==4)) {
				row--;
			}
			else if(randomDirection==0 && row > 0 && ObjectManager.tiles[row-1][column].tileType==1) {
				changeDirection();
			}
			if(randomDirection==1 && row < ObjectManager.tiles.length-1 && (ObjectManager.tiles[row+1][column].tileType==0 || ObjectManager.tiles[row+1][column].tileType==4)) {
				row++;
		    }
			else if(randomDirection==1 && row < ObjectManager.tiles.length-1 && ObjectManager.tiles[row+1][column].tileType==1) {
				changeDirection();
			}
			if(randomDirection==2 && column > 0 && (ObjectManager.tiles[row][column-1].tileType==0|| ObjectManager.tiles[row][column-1].tileType==4)) {
				column--;
		    }
			else if(randomDirection==2 && column > 0 && ObjectManager.tiles[row][column-1].tileType==1) {
				changeDirection();
			}
			if(randomDirection==3 && column < ObjectManager.tiles[row].length-1 && (ObjectManager.tiles[row][column+1].tileType==0|| ObjectManager.tiles[row][column+1].tileType==4)) {
				column++;
		    }
			else if(randomDirection==3 && column < ObjectManager.tiles[row].length-1 && ObjectManager.tiles[row][column+1].tileType==1) {
				changeDirection();
			}
		}
		super.update();
	}

}
