package cz.uhk.fim.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Ground;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Music;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;
import interfaces.WorldListener;

public class GameScreen extends Screen  implements WorldListener{
	
	private long lastTimeMillis;
	private Timer timer;
	private Bird bird;
	private JLabel jLabelScore, jLabelLifes;


	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		JButton jButtonPause = new JButton("PAUSE");
		
		jButtonBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				mainFrame.setScreen(new HomeScreen(mainFrame));
				Music music = new Music("assets/click.wav");
			}
		});
		
		jButtonPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer.isRunning() == true){
					timer.stop();
				}else{
					lastTimeMillis = System.currentTimeMillis();
					timer.start();
				}
				Music music = new Music("assets/click.wav");
			}
		});
		
		jButtonBack.setBounds(320, 10, 60, 30);
		jButtonBack.setFont(new Font("Arial",Font.PLAIN, 8));
		jButtonPause.setBounds(400, 10, 60, 30);
		jButtonPause.setFont(new Font("Arial",Font.PLAIN, 8));
		
		add(jButtonPause);
		add(jButtonBack);
		
		jLabelScore = new JLabel("Score: " + Bird.DEFAULT_SCORE);
		jLabelLifes = new JLabel("�ivoty: " + Bird.DEFAULT_LIFES);
		
		
		jLabelScore.setOpaque(true);
		jLabelScore.setBackground(Color.LIGHT_GRAY);
		jLabelLifes.setOpaque(true);		
		jLabelLifes.setBackground(Color.pink);

		jLabelScore.setBounds(20, 10, 80, 30);
		jLabelLifes.setBounds(100, 10, 80, 30);	

		add(jLabelLifes);
		add(jLabelScore);

		//WORLD	
		bird = new Bird("Pavel", 150, 400);
		
		World world = new World(bird, this);
		world.generateRandom();
		
		/*
		world.addTubet(new Tube(400, 400, Color.green));
		world.addTubet(new Tube(600, 300, Color.green));
		world.addTubet(new Tube(800, 500, Color.green));
		*/
		/*
		world.addHeart(new Heart(500, 450));
		world.addHeart(new Heart(700, 600));
		*/
		GameCanvas gamecanvas = new GameCanvas(world);
		gamecanvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		
		gamecanvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				bird.goUp();
				Music music = new Music("assets/wings.wav");
			}
		});
		
		add(gamecanvas);

		timer = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long currentTimeMillis = System.currentTimeMillis();
				
				float delta = (currentTimeMillis - lastTimeMillis) / 1000f;				
				world.update(delta);
				
				jLabelLifes.setText("  �ivoty: " +bird.getLifes());
				jLabelScore.setText("  Score: "+ bird.getScore());
				
				if(!bird.isAlive()){
					timer.stop();
					FinishScreen finishScreen= new FinishScreen(mainFrame, world) ;
					mainFrame.setScreen(finishScreen);
					Music music = new Music("assets/gmae_over.wav");
				}	
				repaint();
				
				lastTimeMillis = currentTimeMillis;
			}
		});
		
		lastTimeMillis = System.currentTimeMillis();
		timer.start();
	}

	@Override
	public void crashTube(Tube tube) {
		bird.removeLive();
		bird.setPositionY(tube.getCenterY());
		Music music = new Music("assets/dead_bird.wav");
		
	}

	@Override
	public void catchHeart(Heart heart) {
		heart.setPositionY(-100);
		bird.catchHeart();
		Music music = new Music("assets/picked_coin.wav");

		
	}

	@Override
	public void outOf() {
		bird.setPositionY(MainFrame.HEIGHT/2);
		bird.setSpeed(Bird.JUMP/2);
		
		bird.removeLive();
		Music music = new Music("assets/dead_bird.wav");
	}
}

