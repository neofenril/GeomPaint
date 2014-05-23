import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;


public class VueGraph extends JPanel implements Observer{
	FormesGeo modele;
	
	public void update(Observable o,Object arg1){
		modele=(FormesGeo)o;
		repaint();
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
	}

}
