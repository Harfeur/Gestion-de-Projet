package fr.harfeur.tp01;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class GestionImage extends Frame implements ItemListener, WindowListener {
	
	AWT_ListeImages l;
	AWT_AfficheurImage c;
	AWT_NoteImage n;
	
	public GestionImage() {
		
		LayoutManager layout = new BorderLayout();
		this.setLayout(layout);
		
		this.c = new AWT_AfficheurImage();
		this.n = new AWT_NoteImage(this);
		this.l = new AWT_ListeImages(this);
		
		this.add(c, BorderLayout.CENTER);
		this.add(n, BorderLayout.SOUTH);
		this.add(this.l, BorderLayout.WEST);
		
		this.addWindowListener(this);
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GestionImage();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getSource().getClass() == List.class) {
				String image = this.l.get((int) e.getItem());
				System.out.println("Nouvelle image selectionnée : " + image);
				this.c.changeImage(image);
			} else {
				System.out.println("Nouvelle note : " + e.getItem() + " étoile(s)");
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
