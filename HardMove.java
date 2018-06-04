package SE350Final;

import java.awt.Point;

public class HardMove implements MoveStrategy {

	Point og;
	Point change;
	@Override
	//moves pirate ships fast. They will always move and they move two spaces at once
	public Point movePirateShip(Point pirate, Point shipLocation) {
			System.out.println(shipLocation + " Easy Move");
			og = pirate;
			change = og;
	
			 try{
			 if (change.x - shipLocation.x < 0 && oceanMap.isOcean(change.x+1, change.y))
				 change.x+=2;
			 else if(oceanMap.isOcean(change.x-1,change.y))
				 change.x-=2;
			 
			 if (change.y - shipLocation.y < 0 && oceanMap.isOcean(change.x,change.y+1))

				 change.y+=2;
			 else if(oceanMap.isOcean(change.x, change.y-1))

				 change.y-=2;

			 }
			 catch(ArrayIndexOutOfBoundsException e){
				 change = og;
			 }
			 return change;

	}

	@Override
	//returns the type of strategy
	public String getStrategy() {
		return "Hard Strategy";
	}

}
