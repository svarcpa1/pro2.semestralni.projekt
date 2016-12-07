package cz.uhk.fim.pro2.game;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.SchemaOutputResolver;

public class ScoreManager {
	
	private List<Integer> scoreList;	
	private ScoreManager() {
		this.scoreList = new ArrayList<Integer>();
	}	
	public void addScore(int score){
		scoreList.add(score);
	}
	public List<Integer> getAll(){
		return scoreList;
	}
	
	
	//singleton
	private static ScoreManager instance;
	public static ScoreManager getInstance(){
		if (instance == null){
			instance = new ScoreManager();
		}
		return instance;
	}
	
	
	//verejne stat. metody
	public static void putScore(int score){
		getInstance().addScore(score);
	}
	public static List<Integer> getList(){
		return getInstance().getAll();
	}
	
	public static int getItemsNumber(){
		return ScoreManager.getList().size();
	}
	
	public static int getItemIndex(int index){
		return ScoreManager.getList().get(index);
	}
	

}	

