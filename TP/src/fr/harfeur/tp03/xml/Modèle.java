package fr.harfeur.tp03.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

public class Modèle extends Observable {
	
	protected ArrayList<ImageModèle> listeImages;
	protected Integer imageSélectionnée;
	protected File fichier;
	
	@SuppressWarnings("unchecked")
	public Modèle() {
		super();
		this.fichier = new File("assets/images.xml");
		
		XMLDecoder decoder = null;
		try {
			FileInputStream fis = new FileInputStream(fichier);
			BufferedInputStream bis = new BufferedInputStream(fis);
			decoder = new XMLDecoder(bis);
			
			this.listeImages = (ArrayList<ImageModèle>) decoder.readObject();
		} catch (IOException e) {
			File dossier = new File("assets/images");
			File[] images = dossier.listFiles();
			
			this.listeImages = new ArrayList<ImageModèle>();
			
			if (images != null)
				for (File file : images) {
					this.listeImages.add(new ImageModèle(file.getName(), file.getPath()));
				}
		} finally {
			if (decoder != null) decoder.close();
		}
		
		this.imageSélectionnée = 0;
	}
	
	public void initialisation() {
		this.setChanged();
		this.notifyObservers(this.listeImages);
		this.setChanged();
		this.notifyObservers(this.listeImages.get(this.imageSélectionnée));
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
		XMLEncoder encoder = null;
		try {
			FileOutputStream fos = new FileOutputStream(this.fichier);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			encoder = new XMLEncoder(bos);
			
			encoder.writeObject(this.listeImages);
			encoder.flush();
		} catch (IOException e) {
			throw new RuntimeException("Impossible d'�crire les donn�es");
		} finally {
			if (encoder != null) encoder.close();
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.listeImages.toString();
	}
	
}
