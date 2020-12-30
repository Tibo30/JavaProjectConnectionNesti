package projetFilRouge;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class DragFrameListener extends MouseAdapter {
	private final JFrame frame;
	private Point mouseCoords = null;
	
	public DragFrameListener(JFrame frame) {
		this.frame=frame;
	}
	
	public void mouseRelease(MouseEvent e) {
		mouseCoords=null;
	}
	
	public void mousePressed(MouseEvent e) {
		mouseCoords=e.getPoint();
	}
	
	public void mouseDragged(MouseEvent e) {
		Point currentCoords = e.getLocationOnScreen();
		frame.setLocation(currentCoords.x-mouseCoords.x,currentCoords.y-mouseCoords.y);
	}
}
