package SE350Final;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;




public class Ship implements Subject{
	Point currentLocation;
	singletonMap map;
	
	List<Observer> observers = new LinkedList<Observer>();

	/* constructor take ocean mao as constructor*/
	public Ship() {
		map = singletonMap.getInstance();
		currentLocation = map.getShipLocation();
	}
	
	/* returns point of ships location*/
	public Point getCurrentLocation(){
		//System.out.println(currentLocation);
		return currentLocation;
	}
	
	/* if the coordinate east of location is free, then move ship east
	 * notifies observers*/
	public void goEast(){
		if (currentLocation.x<map.getDimensionsX()-1 && map.isOcean(currentLocation.x+1, currentLocation.y)){
			currentLocation.x++;
			//notifyObservers();
		}
	}
	/* if the coordinate west of location is free, then move ship west
	 * notifies observers*/
	public void goWest(){
		if(currentLocation.x >0 && map.isOcean(currentLocation.x-1, currentLocation.y)){
	    		currentLocation.x--;
	    		//notifyObservers();
	    	}  		
		
	}
	/*if the coordinate north of location is free, then move ship north
	 * notifies observers*/
	public void goNorth(){
		if(currentLocation.y>0 && map.isOcean(currentLocation.x, currentLocation.y-1)){
    		currentLocation.y--;
    		//notifyObservers();
    	} 
	}
	/* if the coordinate south of location is free, then move ship south
	 * notifies observers*/
	public void goSouth(){
		if(currentLocation.y<map.getDimensionsY()-1 && map.isOcean(currentLocation.x, currentLocation.y+1)){
    		currentLocation.y++;
    		//notifyObservers();
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
