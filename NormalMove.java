package SE350Final;

import java.awt.Point;
import java.util.ArrayList;

public class NormalMove implements MoveStrategy {

	Point og;
	Point change;
	@Override
	public void movePirateShip(PirateShip pirate, int x) {
			
			System.out.println("Identifier: " + x + " " + shipLocation + " Normal Move");
			
			og = pirate.getCurrentLocation();
			change = og;
			 if(rand.nextInt(2)==1){ 
				 try{
				 if (change.x - shipLocation.x < 0 && oceanMap.isOcean(change.x+1, change.y))
					 change.x++;
				 else if(oceanMap.isOcean(change.x-1,change.y))
					 change.x--;
				 
				 if (change.y - shipLocation.y < 0 && oceanMap.isOcean(change.x,change.y+1))

					 change.y++;
				 else if(oceanMap.isOcean(change.x, change.y-1))
					 change.y--;

				 }
				 catch(ArrayIndexOutOfBoundsException e){
					 change = og;
				 }
			 
			 }
		pirate.setLocation(change);
	}
	@Override
	public String getStrategy() {
		return "Normal Move";
	}

}
