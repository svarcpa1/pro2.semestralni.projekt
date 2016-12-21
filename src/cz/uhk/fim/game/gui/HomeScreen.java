package cz.uhk.fim.game.gui;

import sun.audio.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import cz.uhk.fim.pro2.game.model.Music;

public class HomeScreen extends Screen {
	
	ButtonGroup group1 = new ButtonGroup();
	JRadioButton jRadioButtonZvukyON = new JRadioButton("Sounds ON");
	JRadioButton jRadioButtonZvukyOFF = new JRadioButton("Sounds OFF");
	
	public HomeScreen (MainFrame mainFrame) {
		super(mainFrame);
		
		
		JButton jButtonPlay = new JButton("PLAY");	
		JButton jButtonScore = new JButton("SCORE");	
		JLabel jLabelTitle = new JLabel("FIM BIRD");
		
		jButtonPlay.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//co se stane kdyz na tohle tlacitko kliknu
				mainFrame.setScreen(new GameScreen(mainFrame));
				if(jRadioButtonZvukyON.isSelected()){
					Music music = new Music("assets/click.wav");
				}
				
			}
		});
		
		jButtonScore.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				mainFrame.setScreen(new ScoreScreen(mainFrame));
				if(jRadioButtonZvukyON.isSelected()){
					Music music = new Music("assets/click.wav");
				}

			}
		});
		
		jLabelTitle.setFont(new Font("Arial",Font.BOLD, 40));
		jLabelTitle.setForeground(Color.black);
		
		//nastavím velikost a pozici
		jLabelTitle.setBounds(150, 150, 400, 50);
		jButtonPlay.setBounds(100, 400, 280, 50);
		jButtonScore.setBounds(100, 460, 280, 50);
		
		jRadioButtonZvukyOFF.setBounds(100, 530, 300, 30);
		jRadioButtonZvukyON.setBounds(100, 570, 300, 30);
		
	
		
		group1.add(jRadioButtonZvukyOFF);
		group1.add(jRadioButtonZvukyON);
		
		add(jRadioButtonZvukyOFF);
		add(jRadioButtonZvukyON);
		add(jLabelTitle);
		add(jButtonPlay);
		add(jButtonScore);
		
	
		
	}
}
