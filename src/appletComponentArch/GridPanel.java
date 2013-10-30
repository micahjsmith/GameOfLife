/**
 * GridPanel.java
 * @author Micah Smith
 */
package appletComponentArch;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GridPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer t;
	private int interval = 30;
	private Grid grid1;
	private final int NUMBER_OF_CELLS = 80;
	private final int CELL_WIDTH = 8;
	private final int GRID_WIDTH = NUMBER_OF_CELLS * CELL_WIDTH;
	private int lastX = -1;
	private int lastY = -1;

	public GridPanel() {
		grid1 = new Grid(NUMBER_OF_CELLS,CELL_WIDTH);

		t = new Timer(interval, new TimerListener());

		addMouseListener(new CellAddListener());
		addMouseMotionListener(new CellDragListener());
		loadShapes();
		setPreferredSize(new Dimension(GRID_WIDTH+1,GRID_WIDTH+1));
	}

	public void changeCell(int x, int y) {
		x = x/CELL_WIDTH;
		y = y/CELL_WIDTH;
		if (grid1.isAlive(x, y))
			grid1.setDead(x, y);
		else
			grid1.setAlive(x, y);
	}

	private void loadShapes(){
		addShape(Shapes.gliderGun(),5,5);
	}
	
	public void addShape(Point[] cells, int xpos, int ypos) {
		for (int i = 0; i < cells.length; i++) {
			grid1.setAlive(cells[i].x+xpos, cells[i].y+ypos);
		}
	}

	public void animateStart() {
		t.start();
	}

	public void animateStop() {
		t.stop();
	}

	public void animateReset() {
		t.stop();
		grid1.setDeadAll();
		loadShapes();
		repaint();
		
	}

	public void animateNext() {
		t.stop();
		grid1.analyzeLife();
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		grid1.draw(g2);
	}

	public void saveCells() {
		grid1.save();
	}

	public void loadCells() {
		grid1.load();
		repaint();
	}

	public void setInterval(int interval) {
		t.setDelay(interval);
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			grid1.analyzeLife();
			repaint();
		}
	}

	private class CellAddListener implements MouseListener{
		public void mousePressed(MouseEvent e) {
			changeCell(e.getX(), e.getY());
			repaint();
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
		
	}
	
	private class CellDragListener implements MouseMotionListener{
		public void mouseDragged(MouseEvent e){
			int x = e.getX()/CELL_WIDTH;
			int y = e.getY()/CELL_WIDTH;
			if (x != lastX && y != lastY){				
				changeCell(e.getX(),e.getY());
				repaint();
				lastX = x;
				lastY = y;
			}
		}
		
		public void mouseMoved(MouseEvent e) {
			
		}
		
	}
}
