package caveExplorer;

import java.util.Arrays;

public class TwoDArrayPractice {
	
	
	
	public static void main(String[] args) {
	String[][] pic = new String[6][10];
	for(int row=0; row<pic.length;row++) {
		for(int col = 0;col<pic[row].length;col++) {
			pic[row][col] = " ";
			
		}
	
	}
	drawBox(pic,0,0);
	print(pic);
	

	}
	/**
	 * Box looks like this
	 * ___
	 * |*|
	 * |_|
	 * but the *marks the coordinates of the box
	 * 
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawBox(String[][] pic, int i, int j) {
	/*  if(j>0 && i>0) {
		if(j<pic[i].length-1 && i<pic[i].length-1) {
		  pic[i-1][j] = "__";
		  drawSlot(pic,i,j);
		  pic[i][j]	= "*";  
		  drawSlot(pic,i+1,j);
          pic[i+1][j] = "_";
		}
		*/
		drawSlot(pic,i,j);
		drawSlot(pic,i+1,j);
		drawIfInBounds("_",pic,i+1,j);
		for(int col = j-1;col<=j+1;col++) {
			drawIfInBounds("_",pic,i-1,col);
		}
	  }
	  
	  
	  
	  
		
	
	private static void drawIfInBounds(String string, String[][] pic, int i, int j) {
		//SPECIAL NOTE: ALWAYS check row before column
		//(IOW, check row exists before checking if a column exists in the row)
		if(i>=0 && i<pic.length && j>=0 && j<pic[i].length) {
			pic[i][j] = string;
		}
		
	}
	/** 
	 * A slot looks like this:
	 *  | |
	 *  It is two vertical lines with a space between them
	 *  The coordinates, i,j are the coordinates of the space
	 *  In other words a lot is a vertical line in front of i,j and after i,j
	 *  Catch: No ARRAYINDEXOUTOFBOUNDSEXCEPTIONS
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawSlot(String[][] pic, int i, int j) {
		if(i>=0 && i<pic.length) {
		if(j>0) {
			pic[i][j-1] = "|";
		}
		if(j<pic[i].length-1) {
			pic[i][j+1] = "|";
		}
		}

		
	}
	private static void drawVerticalLine(String[][] pic, int col ) {
		for(int row =0;row<pic.length;row++) {
			pic[row][col] = "|";
			}
		}
	
	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int col =0;col<pic[row].length;col++) {
			pic[row][col] = "-";
		}
		
	}
	/**
	 * prints contents of picture, row by row
	 * NO BRACKETS OR COMMAS
	 * @param pic
	 */

	private static void print(String[][] pic) {
	   String line = "";
	   for(int row=0; row<pic.length;row++) {
			for(int col = 0;col<pic[row].length;col++) {
				line+=pic[row][col];
				
			}
		line+="\n";
		

	   	}
	   System.out.print(line);
	}

}
