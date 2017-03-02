package com.ballmaze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
	
	private Image backgroundImage;
	private Ball ball;
	private ArrayList<Wall> walls;
	private boolean inGame;
	private boolean ifWon;
	Rectangle winningField;
	private Timer timer;
	private final int DELAY = 10;
	
	private final int[][] pos = {
	{320,80,320,320},{80,80,320,80},{80,80,80,240},{80,240,160,240}
	,{160,240,160,320},{0,320,160,320},{160,160,240,160},{240,160,240,400}};

	public Board() {
		initBoard();
	}
	
	private void initBoard() {
		
		addKeyListener(new TAdapter());
		setFocusable(true);
		loadBackgroundImage();
		int w = backgroundImage.getWidth(this);
		int h = backgroundImage.getHeight(this);
		setPreferredSize(new Dimension(w,h));
		inGame = true;
		ifWon = false;
	
		ball = new Ball();
		initWalls();
		
		winningField = new Rectangle(0, 330, 70, 70);
		
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void initWalls(){
		walls = new ArrayList<>();
		for(int[] p: pos) {
			walls.add(new Wall(p[0],p[1],p[2],p[3]));
		}
	}
	
	private void loadBackgroundImage(){
		ImageIcon ii = new ImageIcon("image//Background1.png");
		backgroundImage = ii.getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, null);
		
		if(inGame && !ifWon) {
			drawWalls(g);
			drawBall(g);
		}else if(!inGame && ifWon){
			drawGameWon(g);
		} else {
			drawGameOver(g);
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void drawWalls(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for(Wall w : walls){
			g2d.drawLine(w.getX1(), w.getY1(), w.getX2(), w.getY2());
		}
		
	}
	
	private void drawBall(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(ball.isVisible()){
			g2d.drawImage(ball.getImg(), ball.getX(), ball.getY(), this);
		}
	}
	
	private void drawGameOver(Graphics g){
		 String msg = "Game Over";
	     Font small = new Font("Helvetica", Font.BOLD, 20);
	     FontMetrics fm = getFontMetrics(small);

	        g.setColor(Color.WHITE);
	        g.setFont(small);
	        g.drawString(msg, (backgroundImage.getWidth(this) - fm.stringWidth(msg)) / 2,
	        		backgroundImage.getHeight(this) / 2);
	}
	
	private void drawGameWon(Graphics g){
		 String msg = "Game Won!";
	     Font small = new Font("Helvetica", Font.BOLD, 20);
	     FontMetrics fm = getFontMetrics(small);

	        g.setColor(Color.WHITE);
	        g.setFont(small);
	        g.drawString(msg, (backgroundImage.getWidth(this) - fm.stringWidth(msg)) / 2,
	        		backgroundImage.getHeight(this) / 2);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		inGame();
		
		updateBall();
		checkCollisions();
		checkIfWon();
		checkBorders();
		
		repaint();
	}
	
	private void inGame() {
		if(!inGame){
			timer.stop();
		}
	}
	
	private void updateBall() {
		if(ball.isVisible()){
			ball.move();
		}
	}
	
	public void checkCollisions() {
		Rectangle r3 = ball.getBounds();
		
		for(Wall w : walls){
		Rectangle r2 = w.getBounds();
			if(r3.intersects(r2)){
				ball.setVisible(false);
				this.inGame = false;
			}
		}
	}
	
	public void checkIfWon() {
		Rectangle r3 = ball.getBounds();
		
		if(r3.intersects(winningField)){
			ball.setVisible(false);
			this.inGame = false;
			this.ifWon = true;
		}
		
	}

	public void checkBorders() {

		if (ball.getX() <= 0 ) {
			ball.setX(0);
		}
		if(ball.getX() >= 350) {
			ball.setX(350);
		}
		if (ball.getY() <= 0 ) {
			ball.setY(0);
		}
		if(ball.getY() >= 350) {
			ball.setY(350);
		}
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
