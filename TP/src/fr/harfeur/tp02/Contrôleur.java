package fr.harfeur.tp02;

import java.awt.Checkbox;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Contr�leur implements ItemListener {

	Mod�le mod�le;

	public Contr�leur(Mod�le mod�le) {
		super();
		this.mod�le = mod�le;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getSource().getClass() == List.class) {
				List l = (List) e.getSource();
				this.mod�le.changerImage(l.getSelectedItem());
			} else if (e.getSource().getClass() == Checkbox.class) {
				Checkbox c = (Checkbox) e.getSource();
				this.mod�le.changerNote(Character.getNumericValue(c.getLabel().charAt(0)));
			}
		}
	}

}
