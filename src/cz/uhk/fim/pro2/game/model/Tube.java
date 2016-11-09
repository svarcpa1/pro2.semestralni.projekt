package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;

public class Tube {

	private float positionX;
	private float height;
	private Color color;
	
	public Tube(float positionX, float height, Color color) {
		super();
		this.positionX = positionX;
		this.height = height;
		this.color = color;
	}

	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect((int)getPositionX()-25,50, 50, 50);
	}
	
	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getHeight() {
		return height;
	}

	public Color getColor() {
		return color;
	}
	
	
	

}
