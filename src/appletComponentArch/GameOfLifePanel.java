/**
 * GameOfLifePanel.java
 * @author Micah Smith
 */
package appletComponentArch;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameOfLifePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final GridPanel gridPanel;
	private JButton playButton;
	private JButton nextButton;
	private JButton resetButton;
	private JSlider speedSlider;
	private JButton saveButton;
	private JPanel buttonPanel;

	public GameOfLifePanel() {
		createButtonPanel();
		add(buttonPanel);
		gridPanel = new GridPanel();
		add(gridPanel);
		setPreferredSize(new Dimension(600, 600));
	}

	private void createButtonPanel() {
		buttonPanel = new JPanel();
		createPlayButton();
		buttonPanel.add(playButton);
		createNextButton();
		buttonPanel.add(nextButton);
		createResetButton();
		buttonPanel.add(resetButton);
		createSaveButton();
		buttonPanel.add(saveButton);
		createSpeedSlider();
		buttonPanel.add(speedSlider);
	}

	private void createPlayButton() {
		playButton = new JButton("Play");
		class PlayButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (playButton.getText().equals("Play")) {
					gridPanel.animateStart();
					playButton.setText("Pause");
				} else if (playButton.getText().equals("Pause")) {
					gridPanel.animateStop();
					playButton.setText("Play");
				}
			}
		}
		playButton.addActionListener(new PlayButtonListener());
	}

	private void createNextButton() {
		nextButton = new JButton();
		nextButton.setText("Next");
		class NextButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				gridPanel.animateNext();
			}
		}
		nextButton.addActionListener(new NextButtonListener());
	}

	private void createResetButton() {
		resetButton = new JButton();
		resetButton.setText("Reset");
		class ResetButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				gridPanel.animateReset();
				playButton.setText("Play");
			}
		}
		resetButton.addActionListener(new ResetButtonListener());
	}

	private void createSpeedSlider() {
		speedSlider = new JSlider(5,50);
		speedSlider.setInverted(true);
		class SpeedSliderListener implements ChangeListener {
			public void stateChanged(ChangeEvent e) {
				if (!speedSlider.getValueIsAdjusting())
					gridPanel.setInterval(speedSlider.getValue());
			}
		}
		speedSlider.addChangeListener(new SpeedSliderListener());

		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(45), new JLabel("Slow"));
		labelTable.put(new Integer(10), new JLabel("Fast"));
		speedSlider.setLabelTable(labelTable);
		speedSlider.setPaintLabels(true);
	}

	private void createSaveButton() {
		saveButton = new JButton();
		saveButton.setText("Save");
		class SaveButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (saveButton.getText().equals("Save")) {
					gridPanel.saveCells();
					saveButton.setText("Load");
				} else if (saveButton.getText().equals("Load")) {
					gridPanel.loadCells();
					saveButton.setText("Save");
				}
			}
		}
		saveButton.addActionListener(new SaveButtonListener());
	}

}
