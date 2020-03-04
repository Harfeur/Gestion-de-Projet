package fr.harfeur.tp03.binaire;

import java.awt.Checkbox;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Contrôleur implements ItemListener {

	Modèle modèle;

	public Contrôleur(Modèle modèle) {
		super();
		this.modèle = modèle;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getSource().getClass() == List.class) {
				List l = (List) e.getSource();
				this.modèle.changerImage(l.getSelectedItem());
			} else if (e.getSource().getClass() == Checkbox.class) {
				Checkbox c = (Checkbox) e.getSource();
				this.modèle.changerNote(Character.getNumericValue(c.getLabel().charAt(0)));
			}
		}
	}

}
