import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends FormesGeo{

	public Rectangle(Point p1, Point p2)
	{
		super();
		ajouterPoint(p1);
		ajouterPoint(p2);
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
		if(isSelected())
		{
			
			g.setColor(Color.black);
			for(int i = 0; i < getPoints().size(); i++)
			{
				g.drawRect(getPoints().get(i).getX()-5, getPoints().get(i).getY()-5, 10, 10);
			}
		}
		
		g.setColor(new Color(getCouleurRemplissage(),true));
		g.fillRect(getP1().getX(), getP1().getY(), getP2().getX()-getP1().getX(), getP2().getY()-getP1().getY());
		g.setColor(new Color(getCouleurContour()));
		g.drawRect(getP1().getX(), getP1().getY(), getP2().getX()-getP1().getX(), getP2().getY()-getP1().getY());
	}
	
}
