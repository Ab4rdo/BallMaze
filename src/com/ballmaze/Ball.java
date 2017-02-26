package com.ballmaze;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Ball {
	
	private int x;
	private int y;
	private int dx;
	private int dy;
	private Image img;
	private boolean isVisible;
	private int radius;
	
	public Ball() {
		initBall();
	}
	
	private void initBall() {
		ImageIcon ii = new ImageIcon("image//Ball2.png");
		img = ii.getImage();
		this.isVisible = true;
		x = 0;
		y = 0;
	}
	
	public void move(){
		x += dx;
		y += dy;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Image getImg() {
		return img;
	}

	public int getRadius() {
		return radius;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 50);
	}
	
	public boolean isVisible(){
		return isVisible;
	}
	
	public void setVisible(boolean vis) {
		this.isVisible = vis;
	}
	
	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }
	
	public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
	
}
