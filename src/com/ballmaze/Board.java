package com.ballmaze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel {
	
	private Image backgroundImage;
	private Ball ball;
	private boolean ingame;
	private Timer timer;
	private final int DELAY = 10;

	public Board() {
		initBoard();
	}
	
	private void initBoard() {
		
		loadBackgroundImage();
		
		ingame = true;
		
	}
	
	private void loadBackgroundImage(){
		ImageIcon ii = new ImageIcon("image//Background1.png");
		backgroundImage = ii.getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, null);
		drawBall(g);
		
	}
	
	private void drawWalls(Graphics g) {
		//
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
