package cz.uhk.fim.game.gui;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.model.Music;

public class ScoreScreen extends Screen{
	
	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		
		for (int i = 0; i < ScoreManager.getItemsNumber(); i++) {
			int score = ScoreManager.getItemIndex(i);
			ScoreItem scoreItem = new ScoreItem(i+1, score);
			scoreItem.setBounds(50,200+ i*50 ,300,50);
			
			add(scoreItem);
			
		}
		ScoreManager.getList();
		
		JButton jButtonBack = new JButton("BACK");
		
		jButtonBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
				Music music = new Music("assets/dead_bird.wav");
			}
		});
		
		jButtonBack.setBounds(20, 20, 60, 60);
		jButtonBack.setFont(new Font("Arial",Font.PLAIN, 8));
		
		add(jButtonBack);
	}

}
