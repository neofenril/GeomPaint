import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.*;

public class GeomPaint extends JPanel{//CONTROLEUR
	private static GeomPaint instance = null;
	private FormesGeo figure;
	static ArrayList<FormesGeo> formeGeo;
	static ArrayList<Point> points;
	private ArrayList Dessin;
	private  Plateau plateau;
	private  Menu menu;
	private static int nbPoints;
	private static int nb;
	private static Color couleurForme;
	
	
	private JPopupMenu jpm = new JPopupMenu();
	private JMenu couleur = new JMenu("Couleur");

	private JMenuItem effacer = new JMenuItem("Effacer");      
	

////////////////////////////
	
	


private int forme;
public GeomPaint()
{

points = new ArrayList<Point>();
formeGeo = new ArrayList<FormesGeo>();
forme = 0;
nbPoints = 0;
nb = 0;
couleurForme = Color.black;

}

public static GeomPaint getGeomPaint()
{
	if(instance == null)
		instance = new GeomPaint();
	return instance;
}

/////////////////////////////

	
	
	public GeomPaint(Object o){
		Dessin=new ArrayList();
		Dessin.add(0, o);
		
		plateau = new Plateau();
		menu = new Menu(plateau);
		
		
		plateau.addMouseListener(new MouseAdapter(){
		      public void mouseReleased(MouseEvent event){
		        if(event.isPopupTrigger()){
		          MouseAdapter actionListener = new java.awt.event.MouseAdapter() {
		              public void mouseClicked(java.awt.event.MouseEvent evt) {
		                  Color background = JColorChooser.showDialog(null,"Changer de Couleur", null);
		                  if (background != null) {
		                	menu.setBackgroundBouton9(background);
		                	menu.setCouleur(background);
		                  }
		              }
		          };
		  		  System.out.print("mouse released GeomPaint");
		          couleur.addMouseListener(actionListener);
		          jpm.add(effacer);
		          jpm.add(couleur);
		          jpm.show(plateau, event.getX(), event.getY());
		        }
		      }
		    });
		this.add(menu, BorderLayout.NORTH);
		this.add(plateau);
	}	
	
	public static void setColor(Color c){
		couleurForme = c;
	}
	
	public static Color getColor(){
		return couleurForme;
	}

	public Menu getMenu(){
		return menu;
	}
	
	public Plateau getPlateau(){
		return plateau;
	}	
	
	public void update(Observable o,Object arg1){
		
		//Dessin.set(Dessin.size(),o);
		System.out.println("update !!!");
		repaint();
	}
	
	public static void razPoints()
	{
		points.clear();
		nbPoints = 0;
	}
	
	public ArrayList<Point> getPoints()
	{
		return points;
	}
	
	public void addPoint(Point p)
	{
		points.add(p);
		nbPoints++;
	}
	public static void addNb()
	{
		nb++;
	}
	
	public static int getNb()
	{
		return nb;
	}
	
	public static void razNb()
	{
		nb = 0;
	}
	
	
	
	
	public void paint(Graphics g){
		super.paint(g);
		if(Dessin.size()>0){
			//g.drawOval(0, 0, ((Cercle)Dessin.get(Dessin.size()-1)).getTaille(), ((Cercle)Dessin.get(Dessin.size()-1)).getTaille());
		}
	}
	
	public void creerTriangle()
	{
		 
		formeGeo.add(new Triangle(points.get(0), points.get(1), points.get(2)));
	}



	public static ArrayList<FormesGeo> getFormeGeo() {
		// TODO Auto-generated method stub
		return formeGeo;
	}
}
