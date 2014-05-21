import java.util.Observable;
import java.util.Observer;

//classe de test développée par Maxime
public class VueTexte implements Observer{
	public void update(Observable o,Object arg){
		System.out.println("vue texte : "+((Cercle)o).getTaille());
	}
}
