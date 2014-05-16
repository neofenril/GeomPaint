
import java.util.Observable;
import java.util.Observer;


public class VueTexte implements Observer{
	public void update(Observable o,Object arg){
		System.out.println("vue texte : "+((Cercle)o).getTaille());
	}
	//public void update1(Observable o,Object arg){
	//	System.out.println("vue texte1 : "+((Rectangle)o).getTaille());
	//}
}
