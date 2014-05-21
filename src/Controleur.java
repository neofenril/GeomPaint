import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controleur {
	FormesGeo modele;
	
	public Controleur(FormesGeo m){
		super();
		modele=m;
		
		
		addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent arg0){
				modele.setTaille(getValue());
			}
		});
		
	}


}
