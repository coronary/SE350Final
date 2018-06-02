package SE350Final;

import java.awt.Point;

public class EasyMove implements MoveStrategy{

	Point og;
	@Override
	public void movePirateShip() {
	
		for(Point ship:locations){
			og =ship;
			 if(rand.nextInt(5)==1){ 
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
	@Override
	public String getStrategy() {
		return "Easy Strategy";
	}
	

}
