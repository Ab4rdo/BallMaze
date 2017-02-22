package com.ballmaze;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Application extends JFrame{
	
	public Application() {
		init();
	}
	
	private void init() {
		
		add(new Board());
		setSize(100, 150);
		setTitle("Ball Maze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Application ex = new Application();
				ex.setVisible(true);
			}
		});
	}
}
