package snake_gui;

import java.util.Random;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;


class SnakePanel extends MyUtil {
	
	private Rect[][] map = new Rect[10][10];
	private Rect[] snake;
	private final int snackWidth = 500;
	private final int snackHeight = 500;
	private final int move = snackWidth*snackHeight;
	
	private final int x[] = new int[move];
	private final int y[] = new int[move];
	
	private boolean inGame = true;
	private JButton reset = new JButton();
	
	private int body;
	
	public SnakePanel() {
		setBounds(50,50,700,700);
		setBackground(Color.gray);
		init();
//		setResetButton();
	}
//	private void setResetButton() {
//		this.reset.setBounds(5, 5, 50, 50);
//		this.reset.setText("reset");
//		this.reset.addActionListener(this);
//		add(this.reset);
//	}
	private void init() {
		body = 4;
		for(int i=0;i<body;i++) {
			x[i] = 50 -i*10;
			y[i] = 50;
		}
	}
}
public class Game extends JFrame{
	private SnakePanel panel = new SnakePanel();
	public Game() {
		super("Snake Game");
		setLayout(null);
		setBounds(50,50,800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
		revalidate();
	}
}
