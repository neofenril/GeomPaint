

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends FormesGeo {

	private int[] xPoints;
	private int[] yPoints;
	
	public Triangle(Point p1, Point p2, Point p3)
	{
		super();
		ajouterPoint(p1);
		ajouterPoint(p2);
		ajouterPoint(p3);
		
		xPoints = new int[3];
		yPoints = new int[3];
		
		xPoints[0] = p1.getX();
		xPoints[1] = p2.getX();
		xPoints[2] = p3.getX();

		yPoints[0] = p1.getY();
		yPoints[1] = p2.getY();
		yPoints[2] = p3.getY();
	}
	
	public Point getP1()
	{
		return getPoints().get(0);
	}
	
	public Point getP2()
	{
		return getPoints().get(1);
	}
	
	public Point getP3()
	{
		return getPoints().get(3);
	}
	
	public void setP2(Point p)
	{
		setPointAt(1, p);
		xPoints[1] = p.getX();
		yPoints[1] = p.getY();
	}
	
	public void setP3(Point p)
	{
		setPointAt(2, p);
		xPoints[2] = p.getX();
		yPoints[2] = p.getY();
	}
	
	public void dessiner(Graphics g)
	{
		for(int i = 0; i < getPoints().size(); i++)
		{
			g.drawRect(getPoints().get(i).getX()-5, getPoints().get(i).getY()-5, 10, 10);
		}
		g.setColor(GeomPaint.getColor());
		g.drawPolygon(xPoints, yPoints, 3);
	}

}
