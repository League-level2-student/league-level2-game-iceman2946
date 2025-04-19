import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Pac_Man pacMan;
	ArrayList <Alien> aliens;
	Random random;
	static int dotCount = 0;
	static int score;
	static int [][] tilesinCoding = {
			{ 0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{ 1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,1,0},
			{ 1,5,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0},
			{ 1,1,1,0,1,2,2,2,2,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,0},
			{ 1,0,0,0,1,2,2,2,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0},
			{ 1,0,0,0,1,2,2,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0},
			{ 0,0,1,0,1,1,0,0,2,2,2,1,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,1,1,0,0,0,0,1,0,1,0},
			{ 0,0,1,0,1,0,0,2,2,2,2,1,0,0,1,0,1,3,3,3,3,1,0,1,0,1,0,1,1,1,1,0,0,0,1,0,1,0},
			{ 0,0,1,0,1,0,2,2,2,2,2,1,0,0,1,0,1,3,3,3,3,1,0,1,0,1,0,1,0,0,1,1,1,0,1,0,1,0},
			{ 0,0,1,0,1,0,2,2,2,2,2,1,0,0,1,0,1,3,3,3,3,1,0,1,0,1,0,0,5,0,1,1,1,0,1,0,1,0},
			{ 0,0,1,0,1,0,0,2,2,2,2,1,0,0,1,0,1,1,1,1,1,1,0,1,0,1,0,1,1,0,0,0,0,0,1,0,1,0},
			{ 0,0,1,0,1,1,0,0,2,2,2,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,1,0,1,0},
			{ 0,0,1,0,1,1,1,0,0,2,2,1,0,0,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0},
			{ 0,0,1,0,1,2,2,2,0,0,1,1,0,0,1,2,2,2,2,2,2,2,0,1,0,1,1,0,0,0,0,0,0,0,1,0,1,0},
			{ 0,0,1,0,1,2,2,2,2,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0},
			{ 0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
			{ 0,1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,0,0,0,1,0,0,0,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0},
			{ 5,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,4,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,5}  
	};
	static Tile [][] tiles;
	
	
	
	
	ObjectManager(Pac_Man pacMan) {
		System.out.println("Rows: tilesinCoding.length = " + tilesinCoding.length);
		System.out.println("Cols: tilesinCoding[0].length = " + tilesinCoding[0].length);
		this.pacMan=pacMan;
		aliens= new ArrayList<Alien>();
		addAliens();
		random= new Random();
		tiles= new Tile [tilesinCoding.length][tilesinCoding[0].length];
		for(int i=0; i< tilesinCoding.length; i++) {
			for(int x=0; x<tilesinCoding[i].length; x++) {
				tiles[i][x]= new Tile(i,x,tilesinCoding[i][x]);
				if(tilesinCoding[i][x]==0 || tilesinCoding[i][x]==5) {
					dotCount+=1;
				}
			}
		}
	}

	void addAliens() {
		for (int i = 0; i<4; i++) {
			aliens.add(new Alien(942,457,50,50,9,17+i));
		}
		setAlienColor();
	}
	void setAlienColor() {
		for(int i=0; i<4; i++) {
			if(i==0) {
				aliens.get(i).setColor(Color.red);
			}
			else if(i==1) {
				aliens.get(i).setColor(Color.YELLOW);
			}
			else if(i==2) {
				aliens.get(i).setColor(Color.green);
			}
			else if(i==3) {
				aliens.get(i).setColor(Color.pink);
			}
		}
	}
	public void draw(Graphics g) {
		for(int i=0; i< tiles.length; i++) {
			for(int x=0; x < tiles[i].length; x++) {
				tiles[i][x].draw(g);
			}
		}
		for(int i = 0; i<4; i++) {
			aliens.get(i).draw(g);
		}
		
	}

}
	
