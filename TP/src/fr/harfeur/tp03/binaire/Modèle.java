package fr.harfeur.tp03.binaire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;

public class Mod�le extends Observable {
	
	protected ArrayList<ImageMod�le> listeImages;
	protected Integer imageS�lectionn�e;
	protected File fichier;
	
	@SuppressWarnings("unchecked")
	public Mod�le() {
		super();
		this.fichier = new File("assets/images.dat");
		
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			this.listeImages = (ArrayList<ImageMod�le>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			File dossier = new File("assets/images");
			File[] images = dossier.listFiles();
			
			this.listeImages = new ArrayList<ImageMod�le>(images.length);
			
			for (File file : images) {
				this.listeImages.add(new ImageMod�le(file.getName(), file.getPath()));
			}
		}
		
		this.imageS�lectionn�e = 0;
	}
	
	public void envoyerListe() {
		this.setChanged();
		this.notifyObservers(this.listeImages);
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
	
	public void enregistrer() {
		try {
			FileOutputStream fos = new FileOutputStream(this.fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(this.listeImages);
			
			oos.close();
			fos.close();
		} catch (IOException e) {
			throw new RuntimeException("Impossible d'�crire les donn�es");
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.listeImages.toString();
	}
	
}
