package SE350Final;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;



public class PirateShip implements Observer {
	Point pirateLocationOne;
	Point pirateLocationTwo;
	Point shipLocation;
	ArrayList<Point> locations;
	ArrayList<Point> updated;
	Point og;

	
	
	Random rand = new Random();
	OceanMap oceanMap;
	/* constructor takes an OceanMap as a parameter*/
	public PirateShip(OceanMap oceanMap){
		this.oceanMap = oceanMap;
		locations = oceanMap.getPirates();
	}
	
	/* updates pirateship when ship moves*/
	public void update(Ship ship) {
		if(ship instanceof Ship){
			  shipLocation = ((Ship)ship).getShipLocation();
			  movePirateShip();
		  }
	}
	/* moves pirate ship closer to ships location */
	public void movePirateShip(){
	
		for(Point ship:locations){
			og =ship;
			 if(rand.nextInt(2)==1){ 
				 try{
				 if (ship.x - shipLocation.x < 0 && oceanMap.isOcean(ship.x+1, ship.y))
					 ship.x++;
				 else if(oceanMap.isOcean(ship.x-1,ship.y))
					 ship.x--;
				 
				 if (ship.y - shipLocation.y < 0 && oceanMap.isOcean(ship.x,ship.y+1))

					 ship.y++;
				 else if(oceanMap.isOcean(ship.x, ship.y-1))
	
					 ship.y--;

				 }
				 catch(ArrayIndexOutOfBoundsException e){
				ship=og;
				 }
			 
			 }
			 
			
		}

	}
	 
	/*returns list of pirate locations*/
	public ArrayList<Point> getPirates(){
		return locations;
	}
	
	}
	
	
	
	


