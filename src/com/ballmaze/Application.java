package com.ballmaze;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Application extends JFrame{
	
	public Application() {
		init();
	}
	
	private void init() {
		
		add(new Board());
		setSize(400, 400);
		setTitle("Ball Maze");
		setResizable(false);
		pack();

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
