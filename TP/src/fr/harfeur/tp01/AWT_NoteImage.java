package fr.harfeur.tp01;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Panel;

@SuppressWarnings("serial")
public class AWT_NoteImage extends Panel {
	
	public AWT_NoteImage(GestionImage gestionImage) {
		super();
		CheckboxGroup chkgrp = new CheckboxGroup();

		Checkbox cb1 = new Checkbox("1", chkgrp, false);
		Checkbox cb2 = new Checkbox("2", chkgrp, false);
		Checkbox cb3 = new Checkbox("3", chkgrp, false);
		Checkbox cb4 = new Checkbox("4", chkgrp, false);
		Checkbox cb5 = new Checkbox("5", chkgrp, false);

		cb1.addItemListener(gestionImage);
		cb2.addItemListener(gestionImage);
		cb3.addItemListener(gestionImage);
		cb4.addItemListener(gestionImage);
		cb5.addItemListener(gestionImage);
		
		this.add(cb1);
		this.add(cb2);
		this.add(cb3);
		this.add(cb4);
		this.add(cb5);
		
	}
	
}
