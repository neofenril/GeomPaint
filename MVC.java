import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


public class MVC {
	public static void main(String[] args){
		Cercle d=new Cercle();
		Rectangle r=new Rectangle();
		
		VueTexte vt=new VueTexte();
		VueGraph vg=new VueGraph();
		VueRect vr=new VueRect();
		
		d.addObserver(vt);
		d.addObserver(vg);
		
		
		r.addObserver(vr);
		
		Controleur c1=new Controleur(d);
		Controleur c2=new Controleur(r);
		
		JFrame frame=new JFrame();
		frame.setLayout(new BorderLayout());
		c1.setPreferredSize(new Dimension(100,50));
		c2.setPreferredSize(new Dimension(100,50));
		vg.setPreferredSize(new Dimension(200,200));
		vr.setPreferredSize(new Dimension(200,200));
		
		frame.getContentPane().add(vg,BorderLayout.NORTH);
		frame.getContentPane().add(vr,BorderLayout.NORTH);
		frame.getContentPane().add(c1,BorderLayout.SOUTH);
		frame.getContentPane().add(c2,BorderLayout.SOUTH);
		
		frame.pack();
		frame.setSize(new Dimension(300,300));
		frame.setVisible(true);
		d.setTaille(10);
		r.setTaille(10);
		c1.setValue(10);
		c2.setValue(10);
	}
}
