package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import cz.uhk.fim.game.gui.MainFrame;

public class Tube {

	private float positionX;
	private float height;
	private Color color;
	private boolean counted = false;
	private  static final int WIDTH =70; 
	
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
				(int)(getPositionX())-(WIDTH/2), 
				(int) height, 
				WIDTH, 
				(int)(MainFrame.HEIGHT- height)
				);	
	}
	public Rectangle getBottomRectangle(){
		return new Rectangle(
				(int)(getPositionX())-(WIDTH/2),
				0,
				WIDTH,
				(int) (height - GAP));	
	}
	
	public static float getRandomHeight(){
		//varci èislo od 0 - 1 
		return (new Random().nextFloat()*450 + 250);
	}
	
	
	
	public int getCenterY(){
		
		return (int) (height - (GAP/2.0));
	}
	
	public float getPositionX() {
		return positionX;
	}
	
	public int getMinX(){
		return (int) positionX -(WIDTH/2);
	}
	public int getMaxX(){
		return (int) positionX +(WIDTH/2);
	}
	
	public boolean isCounted() {
		return counted;
	}

	public void setCounted(boolean counted) {
		this.counted = counted;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}
	
	//sam - rozpohybuje tubu
	public void update(float deltaTime){
		positionX -= World.SPEED * deltaTime;
	}
	
	

}
