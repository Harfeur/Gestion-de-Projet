package fr.harfeur.tp02;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.LayoutManager;

@SuppressWarnings("serial")
public class GestionImage extends Frame {
	
	public GestionImage() {
		
		Modèle modèle = new Modèle();
		
		Contrôleur controleur = new Contrôleur(modèle);
		
		AWT_ListeImages vueListe = new AWT_ListeImages(controleur);
		AWT_AfficheurImage vueImage = new AWT_AfficheurImage();
		AWT_NoteImage vueNote = new AWT_NoteImage(controleur);
		
		modèle.addObserver(vueImage);
		modèle.addObserver(vueNote);
		modèle.addObserver(vueListe);
		
		LayoutManager layout = new BorderLayout();
		this.setLayout(layout);
		this.add(vueImage, BorderLayout.CENTER);
		this.add(vueNote, BorderLayout.SOUTH);
		this.add(vueListe, BorderLayout.WEST);
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GestionImage();
	}
	
}
