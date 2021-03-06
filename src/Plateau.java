import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PopupMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Plateau extends JPanel implements Observer, MouseListener, MouseMotionListener{//VUE
	private final static int MAXTAILLE=10000;	
    private int x,y;
    private FormesGeo o;
    private static Color couleur;
    private int hauteur,largeur;
    private int[] tab = new int[MAXTAILLE];
    private static int i = 0;
    private int lastX,lastY,oriX,oriY,deuxX,deuxY,h,l;
    private int indexDessin;
    private int index;
    private static int numeroFig;
    
    private Object last;
    
    private static boolean dep = false;
    private static boolean siz = false;
    private static int choix = 0;
    private static int nbForme = 0;
    
    
    

	
	public Plateau(){
		this.couleur=Color.black;
		this.indexDessin=0;
		this.o=new FormesGeo();
		setPreferredSize(new Dimension(710,455));
		addMouseListener(this);
    	addMouseMotionListener(this);
	}
	
	public void update(Observable arg0, Object o){
		System.out.println("update plateau");
	}
	
	public static Color getcoul(){
		return couleur;
	}
	
	public void mouseEntered(MouseEvent arg0) {
		System.out.println(dep);
		System.out.println(siz);
		if(dep == true){
			setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		}
		if(siz == true){
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		if((dep == false)&&(siz == false)){
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}
	
	
	
	public void mouseClicked(MouseEvent e) {
		
		
		
	}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		
		if (SwingUtilities.isLeftMouseButton(e)) {
			
			o.ajouterPoint(new Point(this.lastX,this.lastY));
				
			
			this.lastX=e.getX();
			this.lastY=e.getY();
			Graphics g=getGraphics();
			//if(!menu.getDeplace()||!menu.getRedim())
				//g.drawRect(lastX-1,lastY-1,2,2);
			
		}
		else if (SwingUtilities.isMiddleMouseButton(e)) {
	    	repaint();
	    	//this.dessin=new Trait[MAXTAILLE];
	    	this.indexDessin=0;
		}
		
		numeroFig = select(lastX, lastY);
		if (numeroFig != -1){
			
			index = 1;
			
		}
		
	}
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.x=e.getX();
			this.y=e.getY();
			System.out.println("mouse released Plateau");
			Graphics g=getGraphics();
	    	GeomPaint.setColor(couleur);
	    	switch(choix){
	    	case 2:
	    		if(lastX<x){
		    		//l = x-lastX;
		    		deuxX = x;
		    		oriX = lastX;
		    	}
		    	else{
		    		//l = lastX-x;
		    		deuxX = lastX;
		    		oriX = x;
		    	}
		    	if(lastY<y){
		    		//h = y-lastY;
		    		deuxY = y;
		    		oriY = lastY;
		    	}
		    	else{
		    		//h = lastY-y;
		    		deuxY = lastY;
		    		oriY = y;
		    	}
		    	GeomPaint.getGeomPaint().formeGeo.add(new Rectangle(new Point(oriX, oriY), new Point(deuxX, deuxY)));
		    	//g.fillRect(oriX,oriY,l,h);
		    	repaint();
		    	break;
	    	case 3:
	    		
		    	GeomPaint.getGeomPaint().formeGeo.add(new Cercle(new Point(lastX, lastY), new Point(x, y)));
		    	repaint();
	    		break;
	    	case 4:
	    		
	    		GeomPaint.addNb();
	    		GeomPaint.getGeomPaint().addPoint(new Point(x,y));
	    		if(GeomPaint.getNb()==3){
	    		
	    			System.out.print("on rentre dans la boucle ");
	    			//GeomPaint.getGeomPaint().formeGeo.add(new Triangle(new Point(lastX, lastY), new Point(x, y), new Point(5,5)));
	    			GeomPaint.getGeomPaint().creerTriangle();
	    			
	    			GeomPaint.razNb();
	    			GeomPaint.razPoints();
	    		
	    		}
	    		repaint();
	    		break;
	    	case 5:
	    		
	    		GeomPaint.addNb();
	    		GeomPaint.getGeomPaint().addPoint(new Point(x,y));
	    		break;
	    		
	    	case 6:
	    			if (index == 1){
	    			FormesGeo r = GeomPaint.getGeomPaint().getFormeGeo().get(numeroFig);
	    			int p1x = r.getPoints().get(0).getX();
	    			int p1y = r.getPoints().get(0).getY();
	    			int p2x = r.getPoints().get(1).getX();
	    			int p2y = r.getPoints().get(1).getY();
	    			System.out.print(numeroFig);
	    			GeomPaint.getGeomPaint().getFormeGeo().set(numeroFig, new Rectangle(new Point(x, y), new Point(p2x-((p1x)-x),p2y-((p1y)-y))));
	    			repaint();
	    			index=0;
	    			}
	    			break;
	    	case 7:
	    		if (index == 1){
	    			FormesGeo r = GeomPaint.getGeomPaint().getFormeGeo().get(numeroFig);
	    			int p1x = r.getPoints().get(0).getX();
	    			int p1y = r.getPoints().get(0).getY();
	    			int p2x = r.getPoints().get(1).getX();
	    			int p2y = r.getPoints().get(1).getY();
	    			System.out.print("la on doit dire au rect a la place fsedibvs");
	    			GeomPaint.getGeomPaint().getFormeGeo().set(numeroFig, new Rectangle(new Point(x, y), new Point(p2x,p2y)));
	    			repaint();
	    			index=0;
	    			}	
	    			
	    	
	    	
	    	}
		}
	}
	public void mouseDragged(MouseEvent e) {
		if(this.indexDessin<MAXTAILLE){
			//Graphics g=getGraphics();
			this.x=e.getX();
			this.y=e.getY();
			//couleur = menu.getCouleur();
			//g.setColor(couleur);
			
			/*
			//this.dessin[indexDessin]=new Trait(lastX,lastY,x,y,couleur);
			this.indexDessin++;
			System.out.print(lastX+" "+lastY);
			*/
			
		}
	}
	public void mouseMoved(MouseEvent e){
		
	}
	public void setDep(boolean b){
		dep = b;
	}
	
	public void setSiz(boolean b){
		siz = b;
	}
	
	public void setChoix(int i){
		choix = i;
	}
	
	public void setCouleur(Color c){
		couleur = c;
	}
	
	public ArrayList<FormesGeo> getDessin(){
		return GeomPaint.getGeomPaint().getFormeGeo();
	}
	
	public int getNbforme(){
		return nbForme;
	}
	public void retour(){
		last = GeomPaint.getGeomPaint().getFormeGeo().get(GeomPaint.getGeomPaint().getFormeGeo().size()-1);
		GeomPaint.getGeomPaint().getFormeGeo().remove(GeomPaint.getGeomPaint().getFormeGeo().size()-1);
		repaint();
	}
	
	public void avance(){
		GeomPaint.getGeomPaint().getFormeGeo().add((FormesGeo) last);
		repaint();
	}
	
	public int select(int x, int y){
		int pX = x;
		int pY = y;
		int taille = GeomPaint.getGeomPaint().getFormeGeo().size();
		int piece = -1;
		
		for(int j = 0; j < taille; j++){
			int tailleTabl = GeomPaint.getGeomPaint().getFormeGeo().get(j).getPoints().size();
			for(int i=0; i<tailleTabl;i++){
			if ((GeomPaint.getGeomPaint().getFormeGeo().get(j).getPoints().get(i).getX() <= pX+3)&&(GeomPaint.getGeomPaint().getFormeGeo().get(j).getPoints().get(i).getY() <= pY+3)&&(GeomPaint.getGeomPaint().getFormeGeo().get(j).getPoints().get(i).getX() >= pX-3)&&(GeomPaint.getGeomPaint().getFormeGeo().get(j).getPoints().get(i).getY() >= pY-3)){
				piece = j;
				System.out.println(j);
			}
			}
		}	
		System.out.println(piece);
		return piece;
	
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int taille = GeomPaint.getGeomPaint().formeGeo.size();
		for(int j = 0; j < taille; j++){
			
			
			GeomPaint.getGeomPaint().getFormeGeo().get(j).dessiner(g);
				
				
				/*
				Point a = rect.getP1();
				Point b = rect.getP2();
				l = b.getX();
				h = b.getY();
				g.drawRect(a.getX(), a.getY(), l, h);
				*/
			}
			
	}
	
}
