
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	final int LOSE = 2;
	final int WIN = 3;
	int currentState = MENU;
	Font font;
	Timer frameDraw;
	Pac_Man pacMan;
	GamePanel(){
		font= new Font("Roboto",Font.BOLD,30);
		frameDraw= new Timer(1000/60,this);
		pacMan= new Pac_Man(200,700,20,20);
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
		g.setFont(font);
		g.drawString("PAC - MAN", 300, 400);
		g.drawString("Press ENTER to play!",250 , 600);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, PacMan.WIDTH, PacMan.HEIGHT);
		pacMan.draw(g);
	}
	void drawLoseState(Graphics g) {
		
	}
	void drawWinState(Graphics g) {
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(currentState==MENU) {
			updateMenuState();
		}
		else if(currentState==GAME) {
			updateGameState();
		}
		else if(currentState==WIN) {
			updateWinState();
		}
		else if(currentState==LOSE) {
			updateLoseState();
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()== KeyEvent.VK_ENTER) {
			if(currentState==MENU) {
				currentState=GAME;
				
			}
			else if(currentState==WIN || currentState==LOSE) {
				currentState=MENU;
			}
		}
		if(arg0.getKeyCode()==KeyEvent.VK_UP) {
			pacMan.up();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
