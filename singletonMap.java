package SE350Final;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class singletonMap {
	private static singletonMap map;
	int dimensionsy=14;
	int dimensionsx=20;
	int islandCount=20;
	boolean[][] islands;
	Random rand = new Random();
	Point shipLocation;
	ArrayList<Point> pirateLocations;
	Point p1;
	Point p2;
	
	
	private singletonMap(){makeGrid();
	placeIslands();
	shipLocation = placeShip();
	pirateLocations = new ArrayList();
	pirateLocations.add(placePirateShip());
	pirateLocations.add(placePirateShip());}
	
	public static singletonMap getInstance(){
		if(map==null){
			map = new singletonMap();
		}
		return map;
	}

	/* places the number of islands that were passed in the parameter on grid
	 * returns nothing*/
	private void placeIslands() {
		int islandsToPlace = islandCount;
		// while islands to places is greater than islandsToPlace place an island in a random spot that there is not already an island
		while(islandsToPlace>0){
			int  x = rand.nextInt(dimensionsx);
			int y = rand.nextInt(dimensionsy);
			if(islands[x][y]==false){
				islands[x][y]=true;
				islandsToPlace--;
			}
		}
		
	}
	/*places the ship on the grid where there is no island or other ship
	 * returns the point of the ships location*/
	private Point placeShip() {
		boolean placedShip = false;
		int x=0;
		int y=0;
		//searching for spot in the grid that is false so we can place the ship
		while(!placedShip){
			x = rand.nextInt(dimensionsx);
			y = rand.nextInt(dimensionsy);
			if(islands[x][y]==false){
				placedShip =true;
			}	
		}
		return new Point(x,y);
	}
	/*places pirate ship on ocean 
	 * returns point of the pirate ship location */
	private Point placePirateShip(){
		boolean placedShip = false;
		int x=0;
		int y=0;
		while(!placedShip){
			x = rand.nextInt(dimensionsx);
			y = rand.nextInt(dimensionsy);
		
		if(islands[x][y]==false){
			placedShip=true;
		}
	}
		return new Point(x,y);
	}


	/*make grid builds a 2D array and populates everything to be false
	 * returns nothing*/
	private void makeGrid(){
		//islands is a 2d array of booleans here we will populate the grid to be false
		islands = new boolean[dimensionsx][dimensionsy];
		for(int i=0;i<dimensionsx;i++){
			for(int j=0;j<dimensionsy;j++){
				islands[i][j]=false;
			}
		}
	}
	
	/*returns the grid*/
	public boolean[][] getMap(){
		return islands;
	}
	/*returns coordinates of the ship*/
	public Point getShipLocation(){
		return shipLocation;
	}
	/*returns dimensions of the grid*/
	public int getDimensions(){
		return dimensionsx;
	}
	/* returns array of pirate locations*/
	public ArrayList<Point> getPirates(){
		return pirateLocations;
	}


	/* returns boolean if an ocean is ocean or is not ocean*/
	public boolean isOcean(int x, int y){
		if (!islands[x][y]){
			return true;
		}
		else{
			return false;
		}
	}


	
}
