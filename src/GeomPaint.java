import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.*;

public class GeomPaint extends JPanel{//CONTROLEUR
	private FormesGeo figure;
	
	private ArrayList Dessin;
	private final Plateau plateau;
	private final Menu menu;
	
	private JPopupMenu jpm = new JPopupMenu();
	private JMenu couleur = new JMenu("Couleur");

	private JMenuItem effacer = new JMenuItem("Effacer");      
	
	public GeomPaint(Object o){
		Dessin=new ArrayList();
		Dessin.add(0, o);
		
		menu = new Menu();
		plateau = new Plateau(menu);
		
		plateau.addMouseListener(new MouseAdapter(){
		      public void mouseReleased(MouseEvent event){
		        if(event.isPopupTrigger()){
		          MouseAdapter actionListener = new java.awt.event.MouseAdapter() {
		              public void mouseClicked(java.awt.event.MouseEvent evt) {
		                  Color background = JColorChooser.showDialog(null,"Changer de Couleur", null);
		                  if (background != null) {
		                	menu.setBackgroundBouton9(background);
		                	menu.setCouleur(background);
		                  }
		              }
		          };
		  		  System.out.print("mouse released GeomPaint");
		          couleur.addMouseListener(actionListener);
		          jpm.add(effacer);
		          jpm.add(couleur);
		          jpm.show(plateau, event.getX(), event.getY());
		        }
		      }
		    });
		this.add(menu, BorderLayout.NORTH);
		this.add(plateau);
	}	
	
	

	public Menu getMenu(){
		return menu;
	}
	
	public Plateau getPlateau(){
		return plateau;
	}	
	
	public void update(Observable o,Object arg1){
		
		//Dessin.set(Dessin.size(),o);
		System.out.println("update !!!");
		repaint();
	}
	public void paint(Graphics g){
		super.paint(g);
		if(Dessin.size()>0){
			//g.drawOval(0, 0, ((Cercle)Dessin.get(Dessin.size()-1)).getTaille(), ((Cercle)Dessin.get(Dessin.size()-1)).getTaille());
		}
	}
}
