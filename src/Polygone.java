

import java.awt.Color;
import java.awt.Graphics;

public class Polygone extends FormesGeo{

	private int[] xPoints;
	private int[] yPoints;
	private boolean formeFini;
	
	public Polygone()
	{
		super();
		formeFini = false;
	}
	
	public void genererPolygone()
	{
		xPoints = new int[getNbPoints()];
		yPoints = new int[getNbPoints()];
		for(int i = 0; i < getNbPoints(); i++)
		{
			xPoints[i] = getPoints().get(i).getX();
			yPoints[i] = getPoints().get(i).getY();
		}
		formeFini = true;
	}
	
	public void dessiner(Graphics g)
	{
		if(formeFini)
		{
			g.setColor(new Color(getCouleurRemplissage(), true));
			g.fillPolygon(xPoints, yPoints, getPoints().size());
			g.setColor(new Color(getCouleurContour(), true));
			g.drawPolygon(xPoints, yPoints, getPoints().size());
		}
		else
		{
			for(int i = 0; i < getPoints().size(); i+=2)
			{
				g.setColor(new Color(getCouleurContour()));
				g.drawLine(getPoints().get(i).getX(), getPoints().get(i).getY(), getPoints().get(i+1).getX(), getPoints().get(i+1).getY());
			}
		}
	}
	
}
