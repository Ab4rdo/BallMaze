package com.ballmaze;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
	
	private Image backgroundImage;
	private Ball ball;
	private Wall wall1;
	private boolean ingame;
	private Timer timer;
	private final int DELAY = 10;

	public Board() {
		initBoard();
	}
	
	private void initBoard() {
		
		loadBackgroundImage();
		int w = backgroundImage.getWidth(this);
		int h = backgroundImage.getHeight(this);
		setPreferredSize(new Dimension(w,h));
		
		addKeyListener(new TAdapter());
		setFocusable(true);
		//setBackground(Color.BLACK);
	
		ball = new Ball();
		wall1 = new Wall(50,100,250,100);
		
		
		timer = new Timer(DELAY, this);
		timer.start();
		
	}
	
	private void loadBackgroundImage(){
		ImageIcon ii = new ImageIcon("image//Background1.png");
		backgroundImage = ii.getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, null);
		drawWalls(g);
		drawBall(g);
		
		
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void drawWalls(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(wall1.getX1(), wall1.getY1(), wall1.getX2(), wall1.getY2());
		
		
	}
	
	private void drawBall(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(ball.getImg(), ball.getX(), ball.getY(), this);
	}
	
	public void actionPerformed(ActionEvent e) {
		ball.move();
		repaint();
	}
	
	private class TAdapter extends KeyAdapter {
		
		public void keyReleased(KeyEvent e){
			ball.keyReleased(e);
		}
		
		public void keyPressed(KeyEvent e) {
			ball.keyPressed(e);
		}
	}
	
	
	
	
	
	
	
}
