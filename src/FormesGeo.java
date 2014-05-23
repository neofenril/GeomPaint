

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;

public class FormesGeo extends Observable{//MODELE

	private ArrayList<Point> points;//tableau des points composant une figure géométrique
	private boolean selected;
	private int couleurRemplissage; //Couleur des bordures
	private int couleurContour; //Couleur de remplissage
	
	public FormesGeo()
	{
		points = new ArrayList<Point>();
		selected = true;
	}
	public  void dessiner(Graphics g) {
	}
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
		setChanged();//une forme géométrique sélectionnée doit être différentiable des autres formes
		notifyObservers();
	}
	
	public void unSelected()
	{
		selected = false;
		setChanged();//les formes non sélectionnées doivent être différentiable des autres formes
		notifyObservers();
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setCouleurRemplissage(int rgba)
	{
		couleurRemplissage = rgba;
		setChanged();//MAJ de l'affichage nécessaire à tout changement de remplissage
		notifyObservers();
	}
	
	public void setCouleurContour(int rgba)
	{
		couleurContour = rgba;
		setChanged();//MAJ de l'affichage nécessaire à tout changement de contour
		notifyObservers();
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
