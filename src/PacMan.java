import java.awt.Component;

import javax.swing.JFrame;

public class PacMan {
	JFrame frame;
	public static final int WIDTH= 865;
	public static final int HEIGHT= 872;
	GamePanel panel;
	PacMan(){
		frame= new JFrame();
	}
	void setup() {
		panel= new GamePanel();
		frame.add(panel);
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.addMouseListener(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		PacMan man= new PacMan();
		man.setup();
	}
}
