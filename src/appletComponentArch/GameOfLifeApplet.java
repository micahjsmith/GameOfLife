package appletComponentArch;

import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;


public class GameOfLifeApplet extends JApplet {

	public void init(){
		try{
			SwingUtilities.invokeAndWait( new Runnable() {
				public void run(){
					createGUI();
				}
			});
		} catch (Exception e){e.printStackTrace();}
	}
		
	private void createGUI(){
		GameOfLifePanel newContentPane=new GameOfLifePanel();
		newContentPane.setOpaque(true);
		newContentPane.setFocusable(true);
		add(newContentPane);
		setSize(new Dimension(650,690));
		validate();
	}
}
