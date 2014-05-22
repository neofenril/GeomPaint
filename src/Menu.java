import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class Menu extends JPanel implements Observer{//VUE
	private Bouton[] bouton = new Bouton[tailleMenu];
	private static final int tailleMenu = 10;
	private static Object o;
	private static Color couleur = Color.black;
	private static int choix = 0;
	private static boolean deplace = false;
	private static boolean redim = false;
	
	
	public Menu(){
		this.o=new Object();
		setPreferredSize(new Dimension(710,35));
		setLayout(new GridLayout(1, 10, 39, 5));
		
		//Définition d"un groupe de boutons radio pour ne sélectionner qu'une figure à dessiner à la fois
		ButtonGroup radio=new ButtonGroup(); 
		String[] labelImage={"Retour","Refaire","Rectangle","Cercle","Triangle","Polygone","Move","Resize"};
		String[] commentaire={"Retour","Refaire","Dessiner un Rectangle","Dessiner un Cercle","Dessiner un Triangle","Dessiner un Polygone","Deplacer","Redimensionner"};
		for(int i=0;i<8;i++){
			bouton[i]=(Bouton)this.add(new Bouton(new ImageIcon("../image/"+labelImage[i]+".png"), labelImage[i]));
			bouton[i].setBackground(new Color(255, 255, 255));
			bouton[i].setToolTipText(commentaire[i]);
		}
		for(int i=0;i<4;i++){
			radio.add(bouton[i]);
		}
		bouton[8]=(Bouton)this.add(new Bouton());
		bouton[8].setBackground(new Color(255, 255, 255));
		
		ActionListener act = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String selection = ((Bouton)e.getSource()).getNom();
				
				if (deplace == true){
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					deplace = false;
				}
				
				if (redim == true){
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					redim = false;
				}
				
				switch (selection){
					case "Retour":
						System.out.println("Retour");
						choix = 0;
						break;
						
					case "Refaire":
						System.out.println("Refaire");
						choix = 1;
						break;
						
					case "Rectangle":
						System.out.println("Rectangle");
						bouton[2].isSelected();
						choix = 2;
						break;

					case "Cercle":
						System.out.println("Cercle");
						bouton[3].isSelected();
						choix = 3;
						break;
						
					case "Triangle":
						System.out.println("Triangle");
						bouton[4].isSelected();
						choix = 4;
						break;

					case "Polygone":
						System.out.println("Polygone");
						bouton[5].isSelected();
						choix = 5;
						break;
						
					case "Move":
						System.out.println("Move");
						setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
						choix = 6;
						deplace = true;
						break;	
						
					case "Resize":
						System.out.println("Resize");
						setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						choix = 7;
						redim = true;
						break;
						
					
				}
			}
		};

		for (int i = 0; i < (tailleMenu-1); i++){
			bouton[i].addActionListener(act);	
		}
		
		
		// Bouton ouvrant une palette permettant le changement de couleur
		bouton[9]=(Bouton)this.add(new Bouton());
		bouton[9].setBackground(new Color(0, 0, 0));
		bouton[9].setToolTipText("Changer la Couleur");
        
        MouseAdapter actionListener = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Color background = JColorChooser.showDialog(null,"Changer de Couleur", null);
                if (background != null) {
                	bouton[9].setBackground(background);
                	couleur = background;
                }
            }
        };
        bouton[9].addMouseListener(actionListener);
	}

	public boolean getDeplace(){
		return deplace;
	}
	
	public boolean getRedim(){
		return redim;
	}
	
	public Bouton getBouton(){
		return bouton[9];
	}
	
	public void setBackgroundBouton9(Color c){
		bouton[9].setBackground(c);
	}
	
	public Color getCouleur(){
		return couleur;
	}
	
	public void setCouleur(Color c){
		couleur = c;
	}
	public void update(Observable arg0, Object o){
		System.out.println("update menu");
	}
}
