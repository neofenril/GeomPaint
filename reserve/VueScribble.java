import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.Graphics;
import javax.swing.JPanel;

//Classe rédigée par François
public class VueScribble extends JPanel implements Observer{
	ArrayList Dessin;//Tableau de figures composant le dessin final
	
	public VueScribble(Object o){
		Dessin=new ArrayList();
		Dessin.add(0, o);
	}
	public void update(Observable o,Object arg1){
		//Dessin.set(Dessin.size(),o);
		repaint();
	}
	public void paint(Graphics g){
		super.paint(g);
		if(Dessin.size()>0)
			g.drawOval(0, 0, ((Cercle)Dessin.get(Dessin.size()-1)).getTaille(), ((Cercle)Dessin.get(Dessin.size()-1)).getTaille());
	}
}
/*	
* add() permet d'ajouter un élément ;
*
* get(int index) retourne l'élément à l'indice demandé ;
*
* remove(int index) efface l'entrée à l'indice demandé ;
*
* isEmpty() renvoie « vrai » si l'objet est vide ;
*
* removeAll() efface tout le contenu de l'objet ;
*
*contains(Object element) retourne « vrai » si l'élément passé en paramètre est dans l'ArrayList.
*/