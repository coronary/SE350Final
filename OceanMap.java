package SE350Final;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class OceanMap {
	static int dimension;
	
	public OceanMap(int dimension) {
		//Constructor defines dimension
		this.dimension = dimension;
	}
	
	private static boolean[][] makeGrid(){
		//Constructs map that will be used. Adds in the fixed number of islands 10
		 boolean grid [][] = new boolean[dimension][dimension];
		 for (boolean[] row: grid) {
			 Arrays.fill(row,  false); 
		 }
		return addIslands(grid, 10);
	}
	
	private static boolean[][] addIslands(boolean[][] grid, int numIslands) {
		//Adds islands onto map taking care not to double place them
		int islandX;
		int islandY;
		Random rand = new Random();
		ArrayList<Point> islands = new ArrayList<Point>();
		for (int i = 0; i < numIslands; i++) {
			while(true) {
				islandX = rand.nextInt(dimension);
				islandY = rand.nextInt(dimension);
				Point tempIsland = new Point(islandX, islandY);
				if (!islands.contains(tempIsland)) {
					islands.add(tempIsland);
					break;
				}
			}
			grid[islandX][islandY] = true; 
		}
		return grid;
	}
	
	public static boolean[][] getMap(){
		//Returns the map made by makeGrid
		return makeGrid();
	}

}
