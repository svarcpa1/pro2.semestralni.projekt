package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.game.gui.MainFrame;

public class Tube {

	private float positionX;
	private float height;
	private Color color;
	
	private static final int GAP = 200;
	
	public Tube(float positionX, float height, Color color) {
		super();
		this.positionX = positionX;
		this.height = height;
		this.color = color;
	}

	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		Rectangle rectangleTop = getTopRectangle();
		Rectangle rectangleBottom = getBottomRectangle();
		
		g.fillRect(
				(int)rectangleTop.getX(),
				(int)rectangleTop.getY(),
				(int)rectangleTop.getWidth(),
				(int)rectangleTop.getHeight());
		
		g.fillRect(
				(int)rectangleBottom.getX(),
				(int)rectangleBottom.getY(),
				(int)rectangleBottom.getWidth(),
				(int)rectangleBottom.getHeight());
	}
	
	public Rectangle getTopRectangle(){
		return new Rectangle(
				(int)(getPositionX())-25, 
				(int) height, 
				50, 
				(int)(MainFrame.HEIGHT- height)
				);	
	}
	public Rectangle getBottomRectangle(){
		return new Rectangle(
				(int)(getPositionX())-25,
				0,
				50,
				(int) (height - GAP));	
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
	
	//sam - rozpohybuje tubu
	public void update(float deltaTime){
		positionX -= World.SPEED * deltaTime;
	}
	
	

}
