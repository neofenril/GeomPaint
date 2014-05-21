import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GeomPaint extends JPanel {

	private final Plateau plateau;
	private final Menu menu;
	
	
	public GeomPaint(){
		menu = new Menu();
		plateau = new Plateau(menu);
		
	
		this.add(menu, BorderLayout.NORTH);
		this.add(plateau);
	}	
	
	

	public Menu getMenu(){
		return menu;
	}
	
	public Plateau getPlateau(){
		return plateau;
	}	
}
