package fr.harfeur.tp03.xml;

import java.awt.List;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class AWT_ListeImages extends Panel implements Observer {

	List liste;

	public AWT_ListeImages(Contrôleur cListe) {
		super();
		this.liste = new List(20, false);

		this.liste.addItemListener(cListe);

		this.add(this.liste);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.getClass() == Integer.class) {
			int index = this.liste.getSelectedIndex();
			String img = this.liste.getItem(index).split(" ")[0];

			img += " ";
			for (int i = 0; i < (int) arg; i++) {
				img += "*";
			}

			this.liste.remove(index);
			this.liste.add(img, index);
			this.liste.select(index);
		} else if (arg.getClass() == ArrayList.class) {
			@SuppressWarnings("unchecked")
			ArrayList<ImageModèle> l = (ArrayList<ImageModèle>) arg;
			for (ImageModèle imageModèle : l) {
				System.out.println(imageModèle.image);
				String img = imageModèle.image.split("\\.")[0];
				img += " ";
				
				for (int i = 0; i < imageModèle.note; i++) {
					img += "*";
				}
				
				this.liste.add(img);
			}
			this.liste.select(0);
		}
	}

}
