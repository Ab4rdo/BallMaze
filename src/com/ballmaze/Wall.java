package com.ballmaze;

import java.awt.Rectangle;

public class Wall {
	
	private int x1, y1, x2, y2;
	private int length;
	
	public Wall(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.length = (int) Math.sqrt((x1-x2)*(x1-x2) - (y1-y2)*(y1-y2));
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}
	
	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public Rectangle getBounds() {
		if(y1 == y2){
			return new Rectangle(x1, y1, Math.abs(x1-x2), 1 );
		} else {
			return new Rectangle(x1, y1, 1 , Math.abs(y1-y2) );
		}
		
	}
	
}
