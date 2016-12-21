package cz.uhk.fim.pro2.game.model;



import java.net.MalformedURLException;
import java.net.URL;
import java.applet.*;


public class Music {

	private URL soubor;
	
	public Music(String cesta) {
		
		try {
			soubor=new URL("file:"+cesta);
		} catch (MalformedURLException e) {
			System.err.println(e);
		}

		Applet.newAudioClip(soubor).play();
	}
	
	
}
