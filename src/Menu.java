import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class Menu extends JPanel {
	private Bouton[] bouton = new Bouton[tailleMenu];
	private static final int tailleMenu = 10;
	private static Color couleur = Color.black;
	private static int choix = 0;
	private static boolean deplace = false;
	private static boolean redim = false;
	
	
	public Menu(){
		setPreferredSize(new Dimension(710,35));
		setLayout(new GridLayout(1, 10, 39, 5));
		
		// Boutons selectionnant le forme a dessiner
		bouton[0]=(Bouton)this.add(new Bouton(new ImageIcon("../image/retour.png"), "Retour"));
		bouton[0].setBackground(new Color(255, 255, 255));
		bouton[0].setToolTipText("Retour");
		
		bouton[1]=(Bouton)this.add(new Bouton(new ImageIcon("../image/avance.png"), "Refaire"));
		bouton[1].setBackground(new Color(255, 255, 255));
		bouton[1].setToolTipText("Refaire");
		
		bouton[2]=(Bouton)this.add(new Bouton(new ImageIcon("../image/Rectangle.png"), "Rectangle"));
		bouton[2].setBackground(new Color(255, 255, 255));
		bouton[2].setToolTipText("Dessiner un Rectangle");
		
		bouton[3]=(Bouton)this.add(new Bouton(new ImageIcon("../image/Cercle.png"), "Cercle"));
		bouton[3].setBackground(new Color(255, 255, 255));
		bouton[3].setToolTipText("Dessiner un Cercle");

		bouton[4]=(Bouton)this.add(new Bouton(new ImageIcon("../image/Triangle.png"), "Triangle"));
		bouton[4].setBackground(new Color(255, 255, 255));
		bouton[4].setToolTipText("Dessiner un Triangle");

		bouton[5]=(Bouton)this.add(new Bouton(new ImageIcon("../image/Poligone.png"), "Polygone"));
		bouton[5].setBackground(new Color(255, 255, 255));
		bouton[5].setToolTipText("Dessiner un Polygone");
	
		bouton[6]=(Bouton)this.add(new Bouton(new ImageIcon("../image/move-cursor.jpg"), "Move"));
		bouton[6].setBackground(new Color(255, 255, 255));
		bouton[6].setToolTipText("Deplacer");
		
		bouton[7]=(Bouton)this.add(new Bouton(new ImageIcon("../image/Cursor_Hand.png"), "Resize"));
		bouton[7].setBackground(new Color(255, 255, 255));
		bouton[7].setToolTipText("Redimensionner");
		
		
		
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
						choix = 1;
						break;
						
					case "Refaire":
						System.out.println("Refaire");
						choix = 2;
						break;
						
					case "Rectangle":
						System.out.println("Rectangle");
						choix = 3;
						break;

					case "Cercle":
						System.out.println("Cercle");
						choix = 4;
						break;
						
					case "Triangle":
						System.out.println("Triangle");
						choix = 5;
						break;

					case "Polygone":
						System.out.println("Polygone");
						choix = 6;
						break;
						
					case "Move":
						System.out.println("Move");
						setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
						choix = 7;
						deplace = true;
						break;	
						
					case "Resize":
						System.out.println("Resize");
						setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						choix = 8;
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
}
