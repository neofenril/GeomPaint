import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class Menu extends JPanel {
	private Bouton[] bouton = new Bouton[tailleMenu];
	private static final int tailleMenu = 10;
	private static Color couleur = Color.black;
	private static int choix = 0;
	
	
	public Menu(){
		setPreferredSize(new Dimension(710,35));
		setLayout(new GridLayout(1, 10, 39, 5));
		
		// Boutons selectionnant le forme a dessiner
		bouton[0]=(Bouton)this.add(new Bouton(new ImageIcon("image/Rectangle.png"), "Rectangle"));
		bouton[0].setBackground(new Color(255, 255, 255));
		
		bouton[1]=(Bouton)this.add(new Bouton(new ImageIcon("image/Cercle.png"), "Cercle"));
		bouton[1].setBackground(new Color(255, 255, 255));

		bouton[2]=(Bouton)this.add(new Bouton(new ImageIcon("image/Triangle.png"), "Triangle"));
		bouton[2].setBackground(new Color(255, 255, 255));
		
		bouton[3]=(Bouton)this.add(new Bouton(new ImageIcon("image/Poligone.png"), "Poligone"));
		bouton[3].setBackground(new Color(255, 255, 255));
		
		bouton[4]=(Bouton)this.add(new Bouton());
		bouton[4].setBackground(new Color(255, 255, 255));
		bouton[5]=(Bouton)this.add(new Bouton());
		bouton[5].setBackground(new Color(255, 255, 255));
		bouton[6]=(Bouton)this.add(new Bouton());
		bouton[6].setBackground(new Color(255, 255, 255));
		bouton[7]=(Bouton)this.add(new Bouton());
		bouton[7].setBackground(new Color(255, 255, 255));
		bouton[8]=(Bouton)this.add(new Bouton());
		bouton[8].setBackground(new Color(255, 255, 255));
		
		

		ActionListener act = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String selection = ((Bouton)e.getSource()).getNom();
				
				switch (selection){
					case "Rectangle":
						System.out.println("Rectangle");
						choix = 1;
						break;

					case "Cercle":
						System.out.println("Cercle");
						choix = 2;
						break;
						
					case "Triangle":
						System.out.println("Triangle");
						choix = 3;
						break;

					case "Poligone":
						System.out.println("Poligone");
						choix = 4;
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

}
