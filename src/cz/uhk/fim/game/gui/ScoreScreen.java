package cz.uhk.fim.game.gui;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen{
	
	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		
		for (int i = 0; i < ScoreManager.getList().size(); i++) {
			System.out.println(ScoreManager.getList().get(i));
			
		}
		ScoreManager.getList();
		
		JButton jButtonBack = new JButton("BACK");
		
		jButtonBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
		
		jButtonBack.setBounds(20, 20, 60, 60);
		jButtonBack.setFont(new Font("Arial",Font.PLAIN, 8));
		
		add(jButtonBack);
	}

}
