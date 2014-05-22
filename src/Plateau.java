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
	private Menu menu;
    private int x,y;
    private FormesGeo o;
    private Color couleur;
    private int hauteur,largeur;
    private int[] tab = new int[MAXTAILLE];
    private static int i = 0;
    private int lastX,lastY,oriX,oriY,deuxX,deuxY,h,l;
    private ArrayList<Object> dessin;
    private int indexDessin;
    

	
	public Plateau(Menu m){
		this.couleur=Color.black;
		this.dessin=new ArrayList<Object>();
		this.indexDessin=0;
		this.o=new FormesGeo();
		setPreferredSize(new Dimension(710,455));
		menu = m;
		addMouseListener(this);
    	addMouseMotionListener(this);
	}
	
	public void update(Observable arg0, Object o){
		System.out.println("update plateau");
	}
	
	public void mouseEntered(MouseEvent arg0) {
		System.out.println(menu.getCursor());
		boolean dep = menu.getDeplace();
		System.out.println(dep);
		boolean siz = menu.getRedim();
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
	
	
	
	public void mouseClicked(MouseEvent e) {}
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
	}
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.x=e.getX();
			this.y=e.getY();
			System.out.println("mouse released Plateau");
			Graphics g=getGraphics();
	    	g.setColor(couleur);
	    	switch(menu.getChoix()){
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
		    	dessin.add(new Rectangle(new Point(oriX, oriY), new Point(deuxX, deuxY)));
		    	//g.fillRect(oriX,oriY,l,h);
		    	repaint();
		    	break;
	    	/*case 3:
	    		if(lastX<x){
		    		l = x-lastX;
		    		oriX = lastX;
		    	}
		    	else{
		    		l = lastX-x;
		    		oriX = x;
		    	}
		    	if(lastY<y){
		    		h = y-lastY;
		    		oriY = lastY;
		    	}
		    	else{
		    		h = lastY-y;
		    		oriY = y;
		    	}
	    		g.fillOval(oriX, oriY, l, h);
	    		break;
	    	*/
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
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int taille = dessin.size();
		for(int j = 0; j < taille; j++){
			couleur = menu.getCouleur();
			g.setColor(couleur);
			
			switch(menu.getChoix()){
			case 2:
				Rectangle rect = (Rectangle)dessin.get(j);
				rect.dessiner(g);
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
	
}
