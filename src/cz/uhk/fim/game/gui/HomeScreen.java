package cz.uhk.fim.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeScreen extends Screen {
	
	public HomeScreen (MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonPlay = new JButton("PLAY");	
		JButton jButtonScore = new JButton("SCORE");	
		JButton jButtonMute = new JButton("MUTE");
		
		jButtonPlay.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//co se stane kdyz na tohle tlacitko kliknu
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		});
		
		jButtonScore.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
			}
		});
		
		add(jButtonPlay);
		add(jButtonScore);
		add(jButtonMute);
	
		
	}
	

	
	

}
