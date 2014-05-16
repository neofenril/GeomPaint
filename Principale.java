import java.awt.Dimension;

import javax.swing.*;
import javax.swing.UIManager.*;

/**
 * Class Principale 	
 * @author Yohann
 * generant la fenetre et le JPanel DessinLumiere
 */
public class Principale{

	public static void main(String[] args){			
		JFrame fenetre = new JFrame("GeomPaint");
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fenetre.setResizable(false);
	    DessinLumiere dessin = new DessinLumiere();
	    dessin.setPreferredSize(new Dimension(710,500));
	    fenetre.setContentPane(dessin);
	    fenetre.pack();
	    fenetre.setVisible(true);
	    dessin.setFocusable(true);
	  }
}