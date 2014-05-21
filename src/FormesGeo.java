

import java.awt.*;
import java.util.ArrayList;

public abstract class FormesGeo {

	private ArrayList<Point> points;
	private boolean selected;
	private int couleurRemplissage; //Couleur des bordures
	private int couleurContour; //Couleur de remplissage
	
	public FormesGeo()
	{
		points = new ArrayList<Point>();
		selected = true;
	}
	
	public abstract void dessiner(Graphics g);
	
	public int getNbPoints()
	{
		return points.size();
	}
	
	public Point getLastPoint()
	{
		return points.get(getNbPoints()-1);
	}
	
	public void setPointAt(int index, Point p)
	{
		points.get(index).setX(p.getX());
		points.get(index).setY(p.getY());
		setChanged();
		notifyObservers();
		
		
	}
	
	public void ajouterPoint(Point p)
	{
		points.add(p);
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<Point> getPoints()
	{
		return points;
	}
	
	public void selected()
	{
		selected = true;
	}
	
	public void unSelected()
	{
		selected = false;
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setCouleurRemplissage(int rgba)
	{
		couleurRemplissage = rgba;
	}
	
	public void setCouleurContour(int rgba)
	{
		couleurContour = rgba;
	}
	
	public int getCouleurRemplissage()
	{
		return couleurRemplissage;
	}
	
	public int getCouleurContour()
	{
		return couleurContour;
	}
}
