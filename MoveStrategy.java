package SE350Final;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public interface MoveStrategy {
	public void movePirateShip();
	public String getStrategy();
	singletonMap oceanMap = singletonMap.getInstance();
	Random rand = new Random();
	Point shipLocation=PirateShip.shipLocation;
	ArrayList<Point> locations = PirateShip.locations;
	
	

	

}
