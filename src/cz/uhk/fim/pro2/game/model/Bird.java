package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.game.gui.MainFrame;


public class Bird {

	public static final int DEFAULT_SCORE =0;
	public static final int DEFAULT_LIFES =3;
	private static final int GRAVITY = 400;
	private static final int JUMP = 650;
	
	private String name;
	private float positionX, positionY;
	//tato promená øíká jak rychle bude stoupat
	private float speed;
	private int lifes;
	private int score;

	public Bird(String name, float positonX, float positionY) {
		super();
		this.name=name;
		this.positionX=positonX;
		this.positionY=positionY;		
		speed = 0;
		lifes = DEFAULT_LIFES;
		score = DEFAULT_SCORE; 
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);		
		Rectangle rectangle = getRectangle();
		
		g.fillRect(
				(int)rectangle.getX(),
				(int)rectangle.getY(),
				(int)rectangle.getWidth(),
				(int)rectangle.getHeight());
	}
	
	//vraáti souøadnice ke kolizím	
	public Rectangle getRectangle() {
		return new Rectangle(
				(int)(getPositionX()-25),
				(int)getPositionY()-25,
				50,
				50);
	}
	
	//metoda rozpohybovájící ftáka
	public void update(float deltaTime){
		positionY -= speed *deltaTime;
		//positionX += World.SPEED * deltaTime;
		positionY +=  GRAVITY*deltaTime;
		//øeší skok
		speed -= speed * deltaTime;
	}
	
	//kolize s trubou
	public Boolean collideWith(Tube tube){
		Rectangle rectangle = getRectangle();
		//intersect za nás poèítá, jestli se nám ty ètverce nepøekrývají!
		return rectangle.intersects(tube.getBottomRectangle()) || rectangle.intersects(tube.getTopRectangle());
	}
	
	//kolize se srdce
	public Boolean collideWith(Heart heart){
		return getRectangle().intersects(heart.getRectangle());
	}
	
	//kolize se zemí
	public Boolean isOutOf() {
		Rectangle rectangle = getRectangle();
		
		//porovnani min hodnot
		if (rectangle.getMinX()<0 || rectangle.getMinY() <0){
			return true;
		}
		
		if (rectangle.getMaxX()> MainFrame.WIDTH || rectangle.getMaxY() > MainFrame.HEIGHT){
			return true;
		}else{
			return false;
		}
		
			
	}
	
	public void addPoint(){
		score++;
	}
	
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void catchHeart(){
		lifes++;
	}
	
	public void die(){
		
	}
	
	public void addLive(){
		
	}
	
	public void removeLive(){
		lifes--;
	}
	
	
	public void goUp(){
		speed = JUMP;
	}
	
	public String getName(){
		return name;
	}
	
		public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

}
