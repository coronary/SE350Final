package SE350Final;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class PirateShip implements Observer {

	static Point shipLocation;
	static ArrayList<Point> locations;
	ArrayList<Point> updated;
	Point og;
	Random rand = new Random();
	singletonMap oceanMap = singletonMap.getInstance();
	
	MoveStrategy moveStrategy;
	String level;
	
	Image pirateImage;
	ImageView pirateIV;
	
	/* constructor takes an OceanMap as a parameter*/
	public PirateShip(String image){
		
		System.out.println(image);
		locations = oceanMap.getPirates();
		
		pirateImage = new Image(image,50,50,true,true);
		pirateIV = new ImageView(pirateImage);
	}
	
	public ImageView getPirateImageView() {
		return pirateIV;
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
	
	
	
	


