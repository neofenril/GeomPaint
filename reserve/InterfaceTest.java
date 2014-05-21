import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.JFrame;

//Programme principal
public class InterfaceTest {

	public static void main(String[] args){
		Cercle c=new Cercle();
		
		VueScribble scribble=new VueScribble(c);
		VueTexte clavier=new VueTexte();
		
		c.addObserver(scribble);
		c.addObserver(clavier);
		
		JFrame frame=new JFrame();
		scribble.setPreferredSize(new Dimension(300,300));
		frame.setContentPane(scribble);

		frame.pack();
		frame.setSize(new Dimension(300,300));
		frame.setVisible(true);
		
		c.setTaille(10);
		
		Scanner sc=new Scanner(System.in);
		int choix=sc.nextInt();
		while(choix>0){
		/*	switch(choix){
			case "a"://annuler
				break;
			case "c"://cercle
				
				break;
			case "r"://refaire
				break;
			default:
				
			}*/
			c.setTaille(choix);
			choix=sc.nextInt();
		}
		sc.close();
		System.exit(1);
	}

}
