
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

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener,MouseListener{
	final int MENU = 0;
	final int GAME = 1;
	final int LOSE = 2;
	final int WIN = 3;
	int currentState = MENU;
	Font font;
	Timer frameDraw;
	Pac_Man pacMan;
	ObjectManager object;
	public static BufferedImage image;
	public static boolean gotImage=false;
	public static boolean needImage=true;
	GamePanel(){
		font= new Font("Lucida Bright",Font.BOLD,30);
		frameDraw= new Timer(1000/60,this);
		frameDraw.start();
		pacMan= new Pac_Man(200,700,20,20);
		object= new ObjectManager(pacMan);
		//loadImage("pacman board.png");
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
		pacMan.update();
		
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
		g.drawString("PAC - MAN", 300, 200);
		g.drawString("Press ENTER to play!",250 , 600);
	}
	void drawGameState(Graphics g) {
	   if(gotImage) {
		   g.drawImage(image,0, 0, PacMan.WIDTH, PacMan.HEIGHT, null);
	   }
		
		else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, PacMan.WIDTH, PacMan.HEIGHT);
	   }
	    object.draw(g);
		pacMan.draw(g);
	}
	void drawLoseState(Graphics g) {
		
	}
	void drawWinState(Graphics g) {
		
	}
//	void loadImage(String imageFile) {
//		if(needImage) {
//			try {
//				image= ImageIO.read(this.getClass().getResourceAsStream(imageFile));
//				gotImage=true;
//			} catch(Exception e) {
//				
//			}
//			needImage=false;
//		}
//	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()== KeyEvent.VK_ENTER) {
			if(currentState==MENU) {
				currentState=GAME;
				
			}
			else if(currentState==WIN || currentState==LOSE) {
				currentState=MENU;
			}
			
			System.out.println("current state is : " + currentState);
		}
		if(arg0.getKeyCode()==KeyEvent.VK_UP) {
			pacMan.direction=1;
			System.out.println("UP");
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_DOWN) {
			pacMan.direction=2;
			System.out.println("DOWN");
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
			pacMan.direction=3;
			System.out.println("RIGHT");
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			pacMan.direction=4;
			System.out.println("LEFT");
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
