package SE350Final;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public interface MoveStrategy {
	public void movePirateShip(PirateShip ship, Point shipLocation);
	public String getStrategy();
	
	singletonMap oceanMap = singletonMap.getInstance();
	Random rand = new Random();
	
	
	

	

}
