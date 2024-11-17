import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Pac_Man pacMan;
	ArrayList <Alien> aliens;
	ArrayList <Bit> bits;
	Random random;
	ObjectManager(Pac_Man pacMan){
		this.pacMan=pacMan;
		aliens= new ArrayList<Alien>();
		bits= new ArrayList<Bit>();
		random= new Random();
	}
	void addBits(Bit b) {
		bits.add(b);
	}
	void addAlien() {
		aliens.add(new Alien(416,422,10,10));
	}
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
}
