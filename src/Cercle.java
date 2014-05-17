import java.util.Observable;

//Types de classes développées par Arthur
public class Cercle extends FigureGeom{
	int taille;
	
	public Cercle(){
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
