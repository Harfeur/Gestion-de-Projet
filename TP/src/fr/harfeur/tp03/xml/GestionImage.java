package fr.harfeur.tp03.xml;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class GestionImage extends Frame {
	
	public GestionImage() {
		
		Mod�le mod�le = new Mod�le();
		
		Contr�leur controleur = new Contr�leur(mod�le);
		
		AWT_ListeImages vueListe = new AWT_ListeImages(controleur);
		AWT_AfficheurImage vueImage = new AWT_AfficheurImage();
		AWT_NoteImage vueNote = new AWT_NoteImage(controleur);
		
		mod�le.addObserver(vueImage);
		mod�le.addObserver(vueNote);
		mod�le.addObserver(vueListe);
		
		LayoutManager layout = new BorderLayout();
		this.setLayout(layout);
		this.add(vueImage, BorderLayout.CENTER);
		this.add(vueNote, BorderLayout.SOUTH);
		this.add(vueListe, BorderLayout.WEST);
		
		mod�le.initialisation();
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println(mod�le);
				mod�le.enregistrer();
				System.exit(0);
			}
		});
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GestionImage();
	}
	
}
