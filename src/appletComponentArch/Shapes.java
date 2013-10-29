/**
 * Shapes.java
 * @author Micah Smith
 */
package appletComponentArch;

import java.awt.Point;

public class Shapes {
	
	public static Point[] glider(){
		//This does not work, should return an array of points, relative to the starting point?
		Point[] glider = new Point[5];
		glider[0] = new Point(1,0);
		glider[1] = new Point(2,1);
		glider[2] = new Point(2,2);
		glider[3] = new Point(1,2);
		glider[4] = new Point(0,2);
		return glider;
	}
	
	public static Point[] gliderGun(){
		Point[] gliderGun = new Point[36];
		gliderGun[0] = new Point(0,4);
		gliderGun[1] = new Point(0,5);
		gliderGun[2] = new Point(1,4);
		gliderGun[3] = new Point(1,5);
		gliderGun[4] = new Point(10,4);
		gliderGun[5] = new Point(10,5);
		gliderGun[6] = new Point(10,6);
		gliderGun[7] = new Point(11,3);
		gliderGun[8] = new Point(11,7);
		gliderGun[9] = new Point(12,2);
		gliderGun[10] = new Point(12,8);
		gliderGun[11] = new Point(13,2);
		gliderGun[12] = new Point(13,8);
		gliderGun[13] = new Point(14,5);
		gliderGun[14] = new Point(15,3);
		gliderGun[15] = new Point(15,7);
		gliderGun[16] = new Point(16,4);
		gliderGun[17] = new Point(16,5);
		gliderGun[18] = new Point(16,6);
		gliderGun[19] = new Point(17,5);
		gliderGun[20] = new Point(20,2);
		gliderGun[21] = new Point(20,3);
		gliderGun[22] = new Point(20,4);
		gliderGun[23] = new Point(21,2);
		gliderGun[24] = new Point(21,3);
		gliderGun[25] = new Point(21,4);
		gliderGun[26] = new Point(22,1);
		gliderGun[27] = new Point(22,5);
		gliderGun[28] = new Point(24,0);
		gliderGun[29] = new Point(24,1);
		gliderGun[30] = new Point(24,5);
		gliderGun[31] = new Point(24,6);
		gliderGun[32] = new Point(34,2);
		gliderGun[33] = new Point(34,3);
		gliderGun[34] = new Point(35,2);
		gliderGun[35] = new Point(35,3);
		return gliderGun;
	}

	public static int[][] lightSpaceShip(){
		int [][] lightSpaceShip=new int[9][2];
		return lightSpaceShip;
	}
	
	public static int[][] middleSpaceShip(){
		int [][] middleSpaceShip=new int[11][2];
		return middleSpaceShip;
	}

	
}

