package fr.harfeur.tp03.xml;

import java.io.Serializable;

public class ImageModèle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String image, chemin;
	public Integer note;
	
	public ImageModèle() {
		super();
	}
	
	public ImageModèle(String image, String chemin) {
		super();
		this.image = image;
		this.chemin = chemin;
		this.note = 0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.image + " " + this.note;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}
}
