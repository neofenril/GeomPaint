import java.util.Observable;


public class Rectangle extends Observable{
	
int taille;
	
	public Rectangle(){
		taille=10;
	}
	public int getTaille(){
		return taille;
	}
	public void setTaille(int t){
		if(t>0)
		taille=t;
		setChanged();
		notifyObservers();
	}

}
