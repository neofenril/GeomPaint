import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;


public class VueGraph extends JPanel implements Observer{
	Cercle modele1;
	
	public void update(Observable o,Object arg1){
		modele1=(Cercle)o;
		repaint();
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
		if(modele1!=null)
			g.drawOval(0, 0, modele1.getTaille(), modele1.getTaille());
		
	}

}
