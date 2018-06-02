package SE350Final;

import java.awt.Point;

public class HardMove implements MoveStrategy {

	Point og;
	@Override
	public void movePirateShip() {
	
		for(Point ship:locations){
			og =ship;
	
			 try{
			 if (ship.x - shipLocation.x < 0 && oceanMap.isOcean(ship.x+1, ship.y))
				 ship.x+=2;
			 else if(oceanMap.isOcean(ship.x-1,ship.y))
				 ship.x-=2;
			 
			 if (ship.y - shipLocation.y < 0 && oceanMap.isOcean(ship.x,ship.y+1))

				 ship.y+=2;
			 else if(oceanMap.isOcean(ship.x, ship.y-1))

				 ship.y-=2;

			 }
			 catch(ArrayIndexOutOfBoundsException e){
			ship=og;
			 }
			 
			
			 
			
		}

	}

	@Override
	public String getStrategy() {
		return "Hard Strategy";
	}

}
