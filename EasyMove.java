package SE350Final;

import java.awt.Point;

public class EasyMove implements MoveStrategy{

	Point og;
	Point change;
	@Override
	//moves pirate ships slowly one in five chance that pirate ships will move
	public void movePirateShip(PirateShip pirate, Point shipLocation) {
			System.out.println(shipLocation + " Easy Move");
			og = pirate.getCurrentLocation();
			change = og;
			
			 if(rand.nextInt(5)==1){ 
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
	//returns type of strategy
	public String getStrategy() {
		return "Easy Strategy";
	}
	

}
