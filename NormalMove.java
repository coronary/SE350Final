package SE350Final;

import java.awt.Point;
import java.util.ArrayList;

public class NormalMove implements MoveStrategy {

	Point og;
	Point change;
	@Override
	//moves pirate ships normally, one in two chance that they will move
	public Point movePirateShip(Point pirate, Point shipLocation) {
			
			System.out.println(shipLocation + " Normal Move");
			
			og = pirate;
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
		return change;
	}
	@Override
	//returns strategy
	public String getStrategy() {
		return "Normal Move";
	}

}
