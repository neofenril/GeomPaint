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

public class Plateau extends JPanel implements Observer, MouseListener, MouseMotionListener{
	private final static int MAXTAILLE=10000;	
	private Menu menu;
    private int x,y;
    private Color couleur;
    private int lastX,lastY;
    private ArrayList dessin;
    private int indexDessin;

	
	public Plateau(Menu m){
		this.couleur=Color.black;
		this.dessin=new ArrayList();
		this.indexDessin=0;
		setPreferredSize(new Dimension(710,350));
		menu = m;
		addMouseListener(this);
    	addMouseMotionListener(this);
	}
	
	public void update(Observable arg0, Object o){
		
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
			this.lastX=e.getX();
			this.lastY=e.getY();
		}
		else if (SwingUtilities.isMiddleMouseButton(e)) {
	    	repaint();
	    	//this.dessin=new Trait[MAXTAILLE];
	    	this.indexDessin=0;
		}
	}
	public void mouseReleased(MouseEvent e) {
		PopupMenu pm = new PopupMenu();
		System.out.println("mouse released Plateau");
	}
	public void mouseDragged(MouseEvent e) {
		if(this.indexDessin<MAXTAILLE){
			this.x=e.getX();
			this.y=e.getY();
			Graphics g=getGraphics();
	    	g.setColor(couleur);
			//this.dessin[indexDessin]=new Trait(lastX,lastY,x,y,couleur);
			this.indexDessin++;
	    	g.drawLine(x,y,lastX,lastY);
			this.lastX=e.getX();
			this.lastY=e.getY();
			System.out.print(lastX+" "+lastY);
		}
	}
	public void mouseMoved(MouseEvent e){
		
	}
}
