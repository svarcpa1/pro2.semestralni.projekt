package cz.uhk.fim.game.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreItem extends JPanel {
	
	JLabel jLabelIndex, jLabelScore;
	
	
	
	public ScoreItem(int index, int score) {
		
		jLabelIndex = new JLabel("ID: "+index + " ");
		jLabelIndex.setFont(new Font("Arial",Font.BOLD, 15));
		jLabelIndex.setBounds(0, 0, 100, 50);
		
		jLabelScore = new JLabel(String.valueOf(" score:" +score));
		jLabelScore.setFont(new Font("Arial",Font.BOLD, 15));
		jLabelIndex.setBounds(120, 0, 200, 50);
		
		
		add(jLabelIndex);
		add(jLabelScore);
		
	}

}
