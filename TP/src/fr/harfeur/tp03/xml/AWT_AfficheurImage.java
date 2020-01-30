package fr.harfeur.tp03.xml;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class AWT_AfficheurImage extends Canvas implements Observer {
	
	private String image;
	
	public AWT_AfficheurImage() {
		super();
		this.setSize(640, 360);
	}
	
	@Override
	public void paint(Graphics g) {
		try {
			g.drawImage(ImageIO.read(new File(this.image)), 0, 0, 640, 360, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.getClass() != ImageModèle.class) return;
		ImageModèle img = (ImageModèle) arg;
		this.image = img.chemin;
		this.repaint();
	}
}
