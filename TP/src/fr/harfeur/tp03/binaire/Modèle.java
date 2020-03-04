package fr.harfeur.tp03.binaire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;

public class Modèle extends Observable {
	
	protected ArrayList<ImageModèle> listeImages;
	protected Integer imageSélectionnée;
	protected File fichier;
	
	@SuppressWarnings("unchecked")
	public Modèle() {
		super();
		this.fichier = new File("assets/images.dat");
		
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			this.listeImages = (ArrayList<ImageModèle>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			File dossier = new File("assets/images");
			File[] images = dossier.listFiles();
			
			this.listeImages = new ArrayList<ImageModèle>(images.length);
			
			for (File file : images) {
				this.listeImages.add(new ImageModèle(file.getName(), file.getPath()));
			}
		}
		
		this.imageSélectionnée = 0;
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
		this.imageSélectionnée = i;
		this.setChanged();
		this.notifyObservers(this.listeImages.get(this.imageSélectionnée));
	}

	public void changerNote(Integer note) {
		this.listeImages.get(this.imageSélectionnée).note = note;
		this.setChanged();
		this.notifyObservers(this.listeImages.get(this.imageSélectionnée).note);
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
