package SE350Final;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;




public class Ship implements Subject{
	Point currentLocation;
	singletonMap oceanMap;
	int shipX;
	int shipY;
	List<Observer> observers = new LinkedList<Observer>();

	/* constructor take ocean map as constructor*/
	public Ship(singletonMap oceanMap) {
		this.oceanMap = oceanMap;
		currentLocation = oceanMap.shipLocation;
	}
	/* returns point of ships location*/
	public Point getShipLocation(){
		System.out.println(currentLocation);
		return currentLocation;
	}
	
	/* if the coordinate east of location is free, then move ship east
	 * notifies observers*/
	public void goEast(){
		if (currentLocation.x< oceanMap.getDimensionsx()-1 && oceanMap.isOcean(currentLocation.x+1, currentLocation.y)){
			currentLocation.x++;
			notifyObservers();
		}
	}
	/* if the coordinate west of location is free, then move ship west
	 * notifies observers*/
	public void goWest(){
		if(currentLocation.x >0 && oceanMap.isOcean(currentLocation.x-1, currentLocation.y)){
	    		currentLocation.x--;
	    		notifyObservers();
	    	}  		
		
	}
	/*if the coordinate north of location is free, then move ship north
	 * notifies observers*/
	public void goNorth(){
		if(currentLocation.y>0 && oceanMap.isOcean(currentLocation.x, currentLocation.y-1)){
    		currentLocation.y--;
    		notifyObservers();
    	} 
	}
	/* if the coordinate south of location is free, then move ship south
	 * notifies observers*/
	public void goSouth(){
		if(currentLocation.y<oceanMap.getDimensionsy()-1 && oceanMap.isOcean(currentLocation.x, currentLocation.y+1)){
    		currentLocation.y++;
    		notifyObservers();
    	}
	}
	/* registers observer to subject aka pirate ship to ship*/
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}
	/* removes observer from subject aka removes pirateship from observingship*/
	public void removeObserver(Observer o) {
		if(observers.contains(o)){
			observers.remove(o);
		}
		
	}

	@Override
	/*notifies observers of subject movement aka notifies pirate ship that ship moved*/
	public void notifyObservers() {
		for(Observer shipObserver:observers){
			shipObserver.update(this);
		}
		
		
	}


}
