import java.awt.Color;
import java.awt.Graphics;


public class Cercle extends FormesGeo{

	private double rayon;
	
	public Cercle(Point p1, Point p2)
	{
		super();
		ajouterPoint(p1);
		ajouterPoint(p2);
		rayon = Math.sqrt((p1.getY()-p2.getY())*(p1.getY()-p2.getY())+(p1.getX()-p2.getX())*(p1.getX()-p2.getX()));
	}
	
	public Point getP1()
	{
		return getPoints().get(0);
	}
	
	public Point getP2()
	{
		return getPoints().get(1);
	}
	
	public void dessiner(Graphics g)
	{
		g.setColor(new Color(getCouleurRemplissage(),true));
		rayon = Math.sqrt((getP1().getY()-getP2().getY())*(getP1().getY()-getP2().getY())+(getP1().getX()-getP2().getX())*(getP1().getX()-getP2().getX()));
		g.fillOval((int)(getP1().getX()-rayon), (int)(getP1().getY()-rayon), (int)(rayon*2), (int)(rayon*2));
		g.setColor(new Color(getCouleurContour()));
		g.drawOval((int)(getP1().getX()-rayon), (int)(getP1().getY()-rayon), (int)(rayon*2), (int)(rayon*2));
	}
}
