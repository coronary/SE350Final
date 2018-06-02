package SE350Final;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;



public class PirateShip implements Observer {

	Point pirateLocationOne;
	Point pirateLocationTwo;
	static Point shipLocation;
	static ArrayList<Point> locations;
	ArrayList<Point> updated;
	Point og;
	Random rand = new Random();
	singletonMap oceanMap = singletonMap.getInstance();
	MoveStrategy moveStrategy;
	String level;
	/* constructor takes an OceanMap as a parameter*/
	public PirateShip(){
		locations = oceanMap.getPirates();
	}
	public void setStrategy(MoveStrategy strategy){
		moveStrategy = strategy;
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
		//have if/if-else statements to check if user selected easy/normal/hard and then set the strategy accordingly
		level = OceanExplorer.getDifficulty();
		if (level=="Easy"){
			setStrategy(new EasyMove());	
		}
		else if(level=="Hard"){
			setStrategy(new HardMove());
		}
		else{
			setStrategy(new NormalMove());
		}
		moveStrategy.movePirateShip();
		
		

	}
	 
	/*returns list of pirate locations*/
	public ArrayList<Point> getPirates(){
		return locations;
	}

}
	
	
	
	


