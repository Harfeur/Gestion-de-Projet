package fr.harfeur.tp02;

import java.awt.List;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class AWT_ListeImages extends Panel implements Observer {
	
	List liste;
	
	public AWT_ListeImages(Contrôleur cListe) {
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

		this.liste.addItemListener(cListe);
		this.liste.select(5);
		
		this.add(this.liste);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.getClass() != Integer.class) return;
		int index = this.liste.getSelectedIndex();
		StringBuilder img = new StringBuilder(this.liste.getItem(index).split(" ")[0]);
		
		img.append(' ');
		for (int i = 0; i < (int) arg; i++) {
			img.append('*');
		}
		
		this.liste.remove(index);
		this.liste.add(img.toString(), index);
		this.liste.select(index);
	}
	
}
