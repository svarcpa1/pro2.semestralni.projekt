package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

public class World {

	//atributy
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	
	static final int SPEED = 100;
	
	//konstruktor
	public World(Bird bird) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	//metody
	//metoda update - star� se o pohyb, vol�me metudu update u pt�ka, trubky, srdce
	//for each proto�e pro ka�d� objekt ji zavol�me
	public void update(float deltaTime){
		bird.update(deltaTime);
		
		for(Heart hearts: hearts){
			hearts.update(deltaTime);
		}
		
		for(Tube tubes: tubes){
			tubes.update(deltaTime);
		}
		
	}
	
	
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	public void addTubet(Tube tube){
		tubes.add(tube);
	}
	
	public Bird getBird() {
		return bird;
	}
	
	
	public List<Tube> getTubes() {
		return tubes;
	}

	public List<Heart> getHearts() {
		return hearts;
	}

}
