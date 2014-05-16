import java.util.Observable;
// la classe herite de Observable
public class Cercle extends Observable {
	// declaration de l'attribut
	int taille;


	// constructeur
	public Cercle() {
		taille = 10;
	}
	//getter pour la vue
	public int getTaille() {
		return (taille);
	}
	//setter pour le controleur
	public void setTaille(int t){
		if (t>0) taille=t;
		//prevenir la modification, methode de Observable
		setChanged();
		//notifier Observer, methode de Observable
		notifyObservers();
	}
}