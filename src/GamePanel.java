import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	final int MENU = 0;
	final int GAME = 1;
	final int LOSE = 2;
	final int WIN = 3;
	int currentState = MENU;
	Font titleFont;
	GamePanel(){
		titleFont= new Font("Roboto Serif",Font.PLAIN,30);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(currentState==MENU) {
			drawMenuState(g);
		}
		else if(currentState==GAME) {
			drawGameState(g);
		}
		else if(currentState==LOSE) {
			drawLoseState(g);
		}
		else if(currentState==WIN) {
			drawWinState(g);
		}
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		
	}
	void updateLoseState() {
		
	}
	void updateWinState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0,PacMan.WIDTH,PacMan.HEIGHT);
		g.setColor(Color.ORANGE);
		g.setFont(titleFont);
		g.drawString("PAC - MAN", 100, 200);
	}
	void drawGameState(Graphics g) {
		
	}
	void drawLoseState(Graphics g) {
		
	}
	void drawWinState(Graphics g) {
		
	}
}
