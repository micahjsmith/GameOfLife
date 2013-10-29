/**
 * Grid.java
 * @author Micah Smith
 */
package appletComponentArch;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Grid {
	private int[][] cells;
	private int[][] cellsNext;
	private int[][] cellsSaved;
	private int numCells;
	private int cellSize;

	public Grid(int numberOfCells, int cellSize) {
		numCells = numberOfCells;
		this.cellSize=cellSize;
		cells = new int[numCells][numCells];
		cellsNext = new int[numCells][numCells];
		cellsSaved = new int[numCells][numCells];
	}

	public void draw(Graphics2D g2) {
		// Draw grid itself
		g2.setColor(Color.WHITE);
		// Draw vertical lines.
		for (int i = 0; i < numCells+1; i++) {
			g2.draw(new Line2D.Double(i * cellSize, 0, i
					* cellSize, numCells * cellSize));
		}
		
		//Draw horizontal lines.
		for (int i=0; i < numCells+1; i++){
			g2.draw(new Line2D.Double(0, i*cellSize, numCells*cellSize, i*cellSize));
		}
		g2.setColor(Color.BLACK);
		//Draw cells
		for (int i=0; i<numCells; i++){
			for (int j=0; j<numCells; j++){
				if (cells[i][j]==1)
					g2.fill(new Ellipse2D.Double(i*cellSize,j*cellSize,cellSize, cellSize));
			}
		}
	}

	public void load(){
		for (int i=0; i<numCells; i++){
			for (int j=0; j<numCells; j++){
				cells[i][j]=cellsSaved[i][j];
			}
		}
	}
	public void setAlive(int x, int y) {
		try {
			cells[x][y] = 1;
		} catch (ArrayIndexOutOfBoundsException e) {
		}

	}

	public boolean isAlive(int x, int y) {
		try {
			if (cells[x][y] == 1)
				return true;
			else
				return false;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}

	}

	public void save() {
		for (int i = 0; i < numCells; i++) {
			for (int j = 0; j < numCells; j++) {
				cellsSaved[i][j] = cells[i][j];
			}
		}
	}

	public void setDead(int x, int y) {
		try {
			cells[x][y] = 0;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
	}
	
	public void setDeadAll(){
		for (int i=0; i<numCells; i++){
			for (int j=0; j<numCells; j++){
				cells[i][j]=0;
			}
		}
	}

	public void analyzeLife() {
		int lifeScore;
		for (int i = 0; i < numCells; i++) {
			for (int j = 0; j < numCells; j++) {

				lifeScore = 0;
				try {
					if (cells[i - 1][j - 1] == 1)
						lifeScore += 1;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					if (cells[i][j - 1] == 1)
						lifeScore += 1;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					if (cells[i + 1][j - 1] == 1)
						lifeScore += 1;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					if (cells[i - 1][j] == 1)
						lifeScore += 1;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					if (cells[i + 1][j] == 1)
						lifeScore += 1;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					if (cells[i - 1][j + 1] == 1)
						lifeScore += 1;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					if (cells[i][j + 1] == 1)
						lifeScore += 1;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					if (cells[i + 1][j + 1] == 1)
						lifeScore += 1;
				} catch (ArrayIndexOutOfBoundsException e) {
				}

				if (lifeScore >= 4 || lifeScore < 2)
					cellsNext[i][j] = 0;
				else if (lifeScore == 3)
					cellsNext[i][j] = 1;
				else if (lifeScore == 2 && cells[i][j] == 1)
					cellsNext[i][j] = 1;
			}
		}

		for (int i = 0; i < numCells; i++) {
			for (int j = 0; j < numCells; j++) {
				cells[i][j] = cellsNext[i][j];
			}
		}

	}
}
