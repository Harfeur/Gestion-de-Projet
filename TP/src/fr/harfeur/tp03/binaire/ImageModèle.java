package fr.harfeur.tp03.binaire;

import java.io.Serializable;

public class ImageMod�le implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected String image, chemin;
	protected Integer note;
	
	public ImageMod�le(String image, String chemin) {
		super();
		this.image = image;
		this.chemin = chemin;
		this.note = new Integer(0);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.image + " " + this.note;
	}
}
