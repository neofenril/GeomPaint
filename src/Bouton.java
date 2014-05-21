import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Bouton extends JButton{
	private String nom;
	
	public Bouton(ImageIcon i, String n){
		super(i);
		nom = n;
	}
	
	public Bouton(){
		super();
	}

	public String getNom(){
		return nom;
	}
}
