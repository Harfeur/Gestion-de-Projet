package fr.harfeur.tp02;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

public class Mod�le extends Observable {
	
	protected ArrayList<ImageMod�le> listeImages;
	protected Integer imageS�lectionn�e;
	
	public Mod�le() {
		super();
		File dossier = new File("assets/images");
		File[] images = dossier.listFiles();
		
		this.listeImages = new ArrayList<ImageMod�le>(images.length);
		
		for (File file : images) {
			this.listeImages.add(new ImageMod�le(file.getName(), file.getAbsolutePath()));
		}
		this.imageS�lectionn�e = 0;
	}
	
	public void changerImage(String img) {
		int i = 0;
		while (i < this.listeImages.size() && !this.listeImages.get(i).image.equals(img.split(" ")[0] + ".jpg")) {
			++i;
		}
		this.imageS�lectionn�e = i;
		this.setChanged();
		this.notifyObservers(this.listeImages.get(this.imageS�lectionn�e));
	}

	public void changerNote(Integer note) {
		this.listeImages.get(this.imageS�lectionn�e).note = note;
		this.setChanged();
		this.notifyObservers(this.listeImages.get(this.imageS�lectionn�e).note);
	}
	
}
