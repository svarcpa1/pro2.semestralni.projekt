package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

public class World {

	//atributy
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	
	//konstruktor
	public World(Bird bird) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	//metody
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	public void addTubet(Tube tube){
		tubes.add(tube);
	}
	
	
	
}
