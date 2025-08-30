
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener,MouseListener{
	static final int MENU = 0;
	static final int GAME = 1;
	static final int LOSE = 2;
	static final int WIN = 3;
	static int currentState = MENU;
	Font font;
	Font scoreFont;
	Timer frameDraw;
	Pac_Man pacMan;
	ObjectManager object;
	static int frameCount = 0;
	public JLabel counter;
	GamePanel(){
		font= new Font("Impact",Font.BOLD,30);
		scoreFont = new Font("Impact",Font.BOLD,40);
		frameDraw= new Timer(1000/30,this);
		frameDraw.start();
		pacMan= new Pac_Man(200,700,20,20);
		object= new ObjectManager(pacMan);
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
		if(frameCount==3) {
			object.checkCollision();
			pacMan.update();
			object.update();
		  	frameCount = 0;
		}else {
			frameCount++;
		}
		if(ObjectManager.dotCount==0) {
			currentState = WIN;
		}
		
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
		g.drawString("PAC - MAN", 760, 215);
		g.drawString("Press ENTER to play!",700 , 444);
		g.drawString("Press SPACE for instructions", 647,631);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, PacMan.WIDTH, PacMan.HEIGHT);
	    object.draw(g);
		pacMan.draw(g);
		g.setColor(Color.WHITE);  
		g.setFont(font);
		g.drawString("Score: "+ObjectManager.score, 865, 440);
		g.drawString("Lives: "+object.lives, 922, 900);
	}
	void drawLoseState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0,0,PacMan.WIDTH,PacMan.HEIGHT);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("YOU LOST!", 760, 215);
		g.drawString("You scored "+ObjectManager.score+" points", 700, 444);
		g.drawString("Press ENTER to restart game", 647, 631);
	}
	void drawWinState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0,PacMan.WIDTH, PacMan.HEIGHT);
		g.setColor(Color.blue);
		g.setFont(font);
		g.drawString("Congratulations!",760,215);
		g.drawString("Final Score: "+ObjectManager.score, 762, 349);
		g.drawString("Lives Remaning: "+object.lives, 734, 520);
		g.drawString("You got all of the coins and outlasted all of the aliens!", 468, 634);
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()== KeyEvent.VK_ENTER) {
			if(currentState==MENU) {
				currentState=GAME;
				
			}
			else if(currentState==WIN || currentState==LOSE) {
				currentState=MENU;
				resetGame();
			}
			
			System.out.println("current state is : " + currentState);
		}
		if(arg0.getKeyCode()==KeyEvent.VK_SPACE&& currentState==MENU) {
			JOptionPane.showMessageDialog(null, "3 lives. Get all of the coins and pellets to win the game. Kill aliens"
					+ " when the pellet is active to get extra points. Survive.");
		}
		if(arg0.getKeyCode()==KeyEvent.VK_UP) {
			pacMan.setDirection(1);
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_DOWN) {
			pacMan.setDirection(2);
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
			pacMan.setDirection(3);
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			pacMan.setDirection(4);
		}
		
	}

	public void resetGame() {
		pacMan = new Pac_Man(200,700,20,20);	
		ObjectManager.dotCount=0;
		object = new ObjectManager(pacMan);
		object.pelletInactive();
	
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX()+" , "+e.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
