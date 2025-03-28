import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Pac_Man pacMan;
	ArrayList <Alien> aliens;
	Random random;
	static int score;
	static int [][] tilesinCoding = {
			{ 0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{ 1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,1,0},
			{ 1,5,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0},
			{ 1,1,1,0,1,2,2,2,2,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,0},
			{ 1,0,0,0,1,2,2,2,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0},
			{ 1,0,0,0,1,2,2,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0},
			{ 0,0,1,0,1,1,0,0,2,2,2,1,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,1,1,0,0,0,0,1,0,1,0},
			{ 0,0,1,0,1,0,5,2,2,2,2,1,0,0,1,0,1,3,3,3,3,1,0,1,0,1,0,1,1,1,1,0,0,0,1,0,1,0},
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
		random= new Random();
		tiles= new Tile [tilesinCoding.length][tilesinCoding[0].length];
		for(int i=0; i< tilesinCoding.length; i++) {
			for(int x=0; x<tilesinCoding[i].length; x++) {
				tiles[i][x]= new Tile(i,x,tilesinCoding[i][x]);
			}
		}
	}

	//void addAlien(Graphics g) {
		//
	//}
	void setAlienColor() {
		for(int i=0; i<4; i++) {
			if(i==0) {
				aliens.get(i).color="RED";
			}
			else if(i==1) {
				aliens.get(i).color="YELLOW";
			}
			else if(i==2) {
				aliens.get(i).color="GREEN";
			}
			else if(i==3) {
				aliens.get(i).color="BLUE";
			}
		}
	}
	public void draw(Graphics g) {
		for(int i=0; i< tiles.length; i++) {
			for(int x=0; x < tiles[i].length; x++) {
				tiles[i][x].draw(g);
			}
		}
		
	}

}
	
