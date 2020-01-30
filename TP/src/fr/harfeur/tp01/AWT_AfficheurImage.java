package fr.harfeur.tp01;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class AWT_AfficheurImage extends Canvas {
	
	private String image;
	
	public AWT_AfficheurImage() {
		super();
		image = "paris";
		this.setSize(640, 360);
	}
	
	@Override
	public void paint(Graphics g) {
		try {
			g.drawImage(ImageIO.read(new File(String.format(".//assets//images//%s.jpg", this.image))), 0,0, 640, 360, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeImage(String image) {
		this.image = image;
		this.repaint();
	}
}
