import java.awt.Dimension;

import javax.swing.JFrame;

public class PacMan {
	JFrame frame;
	public static final int WIDTH= 1900;
	public static final int HEIGHT= 900;
	GamePanel panel;
	PacMan(){
		frame= new JFrame();
	}
	void setup() {
		panel= new GamePanel();
		frame.add(panel);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.addMouseListener(panel);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		PacMan man= new PacMan();
		man.setup();
	}
}
//MAYBE YOU SHOULD SIGN OUT NEXT TIME BUT ITS FINE ILL JUST BREAK IN AGAIN (your game is very cool and fun)
