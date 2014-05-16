import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;


public class VueRect extends JPanel implements Observer{
	Rectangle modele2;
	
	public void update(Observable o,Object arg1){
		modele2=(Rectangle)o;
		repaint();
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
		if(modele2!=null)
			g.drawRect(0, 0, modele2.getTaille(), modele2.getTaille());
	}

}
