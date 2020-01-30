package fr.harfeur.tp03.xml;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class AWT_NoteImage extends Panel implements Observer {
	
	ArrayList<Checkbox> checkboxes;
	CheckboxGroup chkgrp;
	
	public AWT_NoteImage(Contrôleur cNote) {
		super();
		this.chkgrp = new CheckboxGroup();
		this.checkboxes = new ArrayList<Checkbox>(5);
		
		for (int i = 0; i < 5; i++) {
			this.checkboxes.add(new Checkbox(new Integer(i+1).toString(), this.chkgrp, false));
			this.checkboxes.get(i).addItemListener(cNote);
			this.add(this.checkboxes.get(i));
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg.getClass() != ImageModèle.class) return;
		this.chkgrp.setSelectedCheckbox(null);
		ImageModèle img = (ImageModèle) arg;
		if (img.note != 0) this.chkgrp.setSelectedCheckbox(this.checkboxes.get(img.note - 1));
	}
	
}
