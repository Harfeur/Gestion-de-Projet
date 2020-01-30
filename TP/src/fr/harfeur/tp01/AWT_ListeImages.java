package fr.harfeur.tp01;

import java.awt.List;
import java.awt.Panel;

@SuppressWarnings("serial")
public class AWT_ListeImages extends Panel {
	
	List liste;
	
	public AWT_ListeImages(GestionImage gestionImage) {
		super();
		this.liste = new List(20, false);
		
		this.liste.add("bretagne");
		this.liste.add("cellules");
		this.liste.add("espace");
		this.liste.add("gaudi");
		this.liste.add("lucane");
		this.liste.add("paris");
		this.liste.add("personnes");
		this.liste.add("sport");
		this.liste.add("tigre");

		this.liste.addItemListener(gestionImage);
		
		this.add(this.liste);
		
	}
	
	public String get(int i) {
		return this.liste.getItem(i);
	}
	
}
