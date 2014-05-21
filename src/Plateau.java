import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


public class Plateau extends JPanel implements MouseListener{
	private Menu menu;
	
	    
	
	public Plateau(Menu m){
		setPreferredSize(new Dimension(710,350));
		menu = m;
		
		addMouseListener(this);	
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
	
	
	
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {
		PopupMenu pm = new PopupMenu();
	}

}
