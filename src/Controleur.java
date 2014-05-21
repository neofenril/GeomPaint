import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controleur extends JSlider {
	
	Cercle modele1;
	Rectangle modele2;
	
	public Controleur(Cercle d){
		super();
		modele1=d;
		
		setMaximum(100);
		setMinimum(1);
		
		addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent arg0){
				modele1.setTaille(getValue());
				
			}
		});
		
	}
	public Controleur(Rectangle r){
		super();
		modele2=r;
		
		setMaximum(100);
		setMinimum(1);
		
		addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent arg0){
				modele2.setTaille(getValue());
			}
		});
		
	}

}
