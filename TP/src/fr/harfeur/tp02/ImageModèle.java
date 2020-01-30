package fr.harfeur.tp02;

public class ImageModèle {
	
	protected String image, chemin;
	protected Integer note;
	
	public ImageModèle(String image, String chemin) {
		super();
		this.image = image;
		this.chemin = chemin;
		this.note = new Integer(0);
	}
	
}
