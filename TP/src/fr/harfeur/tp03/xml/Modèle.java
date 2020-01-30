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

public class Mod�le extends Observable {
	
	protected ArrayList<ImageMod�le> listeImages;
	protected Integer imageS�lectionn�e;
	protected File fichier;
	
	@SuppressWarnings("unchecked")
	public Mod�le() {
		super();
		this.fichier = new File("assets/images.xml");
		
		XMLDecoder decoder = null;
		try {
			FileInputStream fis = new FileInputStream(fichier);
			BufferedInputStream bis = new BufferedInputStream(fis);
			decoder = new XMLDecoder(bis);
			
			this.listeImages = (ArrayList<ImageMod�le>) decoder.readObject();
		} catch (IOException e) {
			File dossier = new File("assets/images");
			File[] images = dossier.listFiles();
			
			this.listeImages = new ArrayList<ImageMod�le>(images.length);
			
			for (File file : images) {
				this.listeImages.add(new ImageMod�le(file.getName(), file.getPath()));
			}
		} finally {
			if (decoder != null) decoder.close();
		}
		
		this.imageS�lectionn�e = 0;
	}
	
	public void initialisation() {
		this.setChanged();
		this.notifyObservers(this.listeImages);
		this.setChanged();
		this.notifyObservers(this.listeImages.get(this.imageS�lectionn�e));
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
