package fr.harfeur.tp02;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

public class Modèle extends Observable {
	
	protected ArrayList<ImageModèle> listeImages;
	protected Integer imageSélectionnée;
	
	public Modèle() {
		super();
		File dossier = new File("assets/images");
		File[] images = dossier.listFiles();
		
		this.listeImages = new ArrayList<ImageModèle>(images.length);
		
		for (File file : images) {
			this.listeImages.add(new ImageModèle(file.getName(), file.getAbsolutePath()));
		}
		this.imageSélectionnée = 0;
	}
	
	public void changerImage(String img) {
		int i = 0;
		while (i < this.listeImages.size() && !this.listeImages.get(i).image.equals(img.split(" ")[0] + ".jpg")) {
			++i;
		}
		this.imageSélectionnée = i;
		this.setChanged();
		this.notifyObservers(this.listeImages.get(this.imageSélectionnée));
	}

	public void changerNote(Integer note) {
		this.listeImages.get(this.imageSélectionnée).note = note;
		this.setChanged();
		this.notifyObservers(this.listeImages.get(this.imageSélectionnée).note);
	}
	
}
