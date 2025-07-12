import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class ObjectManager implements ActionListener {
	Pac_Man pacMan;
	static ArrayList<Alien> aliens;
	Random random;
	static int dotCount = 0;
	static int score;
	static int[][] tilesinCoding = {
			{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0,
					0, 1, 0 },
			{ 1, 5, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
					0, 1, 0 },
			{ 1, 1, 1, 0, 1, 2, 2, 2, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1,
					0, 1, 0 },
			{ 1, 0, 0, 0, 1, 2, 2, 2, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
					0, 1, 0 },
			{ 1, 0, 0, 0, 1, 2, 2, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
					0, 1, 0 },
			{ 0, 0, 1, 0, 1, 1, 0, 0, 2, 2, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1,
					0, 1, 0 },
			{ 0, 0, 1, 0, 1, 0, 0, 2, 2, 2, 2, 1, 0, 0, 1, 0, 1, 3, 3, 3, 3, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1,
					0, 1, 0 },
			{ 0, 0, 1, 0, 1, 0, 2, 2, 2, 2, 2, 1, 0, 0, 1, 0, 1, 3, 3, 3, 3, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1,
					0, 1, 0 },
			{ 0, 0, 1, 0, 1, 0, 2, 2, 2, 2, 2, 1, 0, 0, 1, 0, 1, 3, 3, 3, 3, 1, 0, 1, 0, 1, 0, 0, 5, 0, 1, 1, 1, 0, 1,
					0, 1, 0 },
			{ 0, 0, 1, 0, 1, 0, 0, 2, 2, 2, 2, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1,
					0, 1, 0 },
			{ 0, 0, 1, 0, 1, 1, 0, 0, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1,
					0, 1, 0 },
			{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 2, 2, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1,
					0, 1, 0 },
			{ 0, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 1, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1,
					0, 1, 0 },
			{ 0, 0, 1, 0, 1, 2, 2, 2, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
					0, 1, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 1, 0 },
			{ 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0,
					0, 0, 0 },
			{ 5, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 4, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
					1, 0, 5 } };
	static Tile[][] tiles;
	static boolean powerPelletActive = false;
	static Timer colorSwitch;
	Timer alienTimer;

	ObjectManager(Pac_Man pacMan) {
		System.out.println("Rows: tilesinCoding.length = " + tilesinCoding.length);
		System.out.println("Cols: tilesinCoding[0].length = " + tilesinCoding[0].length);
		this.pacMan = pacMan;
		aliens = new ArrayList<Alien>();
		addAliens();
		random = new Random();
		colorSwitch = new Timer(20000, this);
		alienTimer = new Timer(10000, this);
		tiles = new Tile[tilesinCoding.length][tilesinCoding[0].length];
		for (int i = 0; i < tilesinCoding.length; i++) {
			for (int x = 0; x < tilesinCoding[i].length; x++) {
				tiles[i][x] = new Tile(i, x, tilesinCoding[i][x]);
				if (tilesinCoding[i][x] == 0 || tilesinCoding[i][x] == 5) {
					dotCount += 1;
				}
			}
		}

		alienTimer.setInitialDelay(0);
		alienTimer.start();
	}

	void addAliens() {
		for (int i = 0; i < 4; i++) {
			aliens.add(new Alien(942, 457, 50, 50, 9, 17 + i));

		}
		setAlienColor();
	}

	void setAlienColor() {
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				aliens.get(i).setColor(Color.red);
			} else if (i == 1) {
				aliens.get(i).setColor(Color.YELLOW);
			} else if (i == 2) {
				aliens.get(i).setColor(Color.green);
			} else if (i == 3) {
				aliens.get(i).setColor(Color.pink);
			}
			if (powerPelletActive == true) {
				changeAlienColor();
			}
		}

	} 

	public void draw(Graphics g) {
		for (int i = 0; i < tiles.length; i++) {
			for (int x = 0; x < tiles[i].length; x++) {
				tiles[i][x].draw(g);
			}
		}
		setAlienColor();
		for (int i = 0; i < 4; i++) {
			aliens.get(i).draw(g);
		}

	}

	void changeAlienColor() {
		for (int i = 0; i < 4; i++) {
			aliens.get(i).setColor(Color.BLUE);
		}
		colorSwitch.start();
	}

	void releaseAliens() {
		for (int i = 0; i < 4; i++) {
			if (aliens.get(i).inSpawn == true) {
				aliens.get(i).inSpawn = false;
				break;
			}
		}
	}

	void checkCollision() {
		for (int i = 0; i < 4; i++) {
			if (aliens.get(i).row == pacMan.row && aliens.get(i).column == pacMan.column) {
				if (aliens.get(i).color != Color.BLUE) {
					gameOver();
				}

				else {
					aliens.get(i).reset();
					score += 200;
				}
			}
			
			if (pacMan.direction == 1) {// up
				if (aliens.get(i).row == pacMan.row - 1 && aliens.get(i).column==pacMan.column) {
					if (aliens.get(i).randomDirection == 1){
						gameOver();
					}
				}
			}
				
		
			if (pacMan.direction == 2) {// down
				if (aliens.get(i).row == pacMan.row + 1 && aliens.get(i).column==pacMan.column) {
					if (aliens.get(i).randomDirection == 0) {
						gameOver();
					}
				}
			}
			if (pacMan.direction == 3) {// right
				if (aliens.get(i).column == pacMan.column - 1 && aliens.get(i).row==pacMan.row) {
					if (aliens.get(i).randomDirection == 2) {
						gameOver();
					}
				}
			}
			if (pacMan.direction == 4) {// left
				if (aliens.get(i).row == pacMan.row - 1 && aliens.get(i).row==pacMan.row) {
					if (aliens.get(i).randomDirection == 3) {
						gameOver();
					}
				}
			}
		}
		
}

	private void gameOver() {
		GamePanel.currentState = GamePanel.LOSE;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == colorSwitch) {
			colorSwitch.stop();
			powerPelletActive = false;
			setAlienColor();
		} else if (e.getSource() == alienTimer) {
			releaseAliens();
		}

	}

	int alienCount = 0;

	public void update() {
		alienCount += 1;
		if (alienCount == 6) {
			alienCount = 0;
			for (int i = 0; i < 4; i++) {
				if (new Random().nextBoolean()) {
					aliens.get(i).changeDirection();
				}

			}
		}

		for (int i = 0; i < 4; i++) {
			aliens.get(i).update();
		}

	}

}
