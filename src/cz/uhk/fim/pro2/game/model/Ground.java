package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ground {
	private float height = 20;
	private Color color;
	
	
	public Ground(float heigh, Color color) {
		this.color=color;
		this.height=heigh;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(780, 0, 400, (int) height);
	}
	
	
	
	
	
	
}
