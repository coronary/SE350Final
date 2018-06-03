package SE350Final;

import java.awt.Point;
import java.util.ArrayList;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class OceanExplorer extends Application {

	boolean[][] islandMap;
	boolean done;
	Pane root;
	final int scalingFactor = 50;
	
	ArrayList<ImageView> monsterImageViews;
	
	Image shipImage;
	ImageView shipImageView;
	ImageView shiponeImageView;
	ImageView shiptwoImageView;
	
	ImageView winIV;
	ImageView islandIV; 

	singletonMap map;
	Scene scene;
	Ship ship;
	
	PirateShip pirate1;
	PirateShip pirate2;
	
	TreasureChest chest;
	
	ArrayList<PirateShip> pirates = new ArrayList<PirateShip>();
	ArrayList<Area> areas;
	
	Button button;
	Button b1;
	Button b2;
	Button b3;
	static String diff;
	
	PirateFactory factory;
	
	public static void main(String[] args){
		launch(args);
		
	}

	@Override
	/*start will set the stage of the game,
	 * initiate the game and add a button to reset the game
	 * it return nothing*/
	public void start(Stage mapStage) throws Exception {
		map = singletonMap.getInstance();
		islandMap = map.getMap();

		root = new AnchorPane();
		done=false;
		drawMap();
		
		ship = new Ship();

		factory = new PirateFactory();
		
		pirates.add(pirate1 = factory.createPirate("normal", map.giveCoordinates()));
		pirates.add(pirate2 = factory.createPirate("abnormal", map.giveCoordinates()));
		
		observerStuff();
		loadPirates();
		loadTreasure();
		loadAreas();
		loadShipImage();	
		
		mapStage.setTitle("Columbus Game");
		scene = new Scene(root,1000,1000);
	    mapStage.setScene(scene);
		mapStage.show();
		
		button = new Button("Reset");

		button.setLayoutY(970);
			
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    	public void handle(ActionEvent ke) {
			 		try {
			 			singletonMap.destroy();
			 			chest.destroy();
			 			ship.clearObservers();
						start(mapStage);
					} catch (Exception e) {
						e.printStackTrace();
					}
			 	}
			});
		root.getChildren().add(button);
		b1 = new Button("Easy");
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    	public void handle(ActionEvent ke) {
			 		diff ="Easy";}
			});
		root.getChildren().add(b1);
		b2 = new Button("Normal");
		b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    	public void handle(ActionEvent ke) {
			 		diff ="Normal";}
			});
		b2.setLayoutX(50);
		root.getChildren().add(b2);
		b3 = new Button("Hard");
		b3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    	public void handle(ActionEvent ke) {
			 		diff ="Hard";}
			});
		b3.setLayoutX(115);
		root.getChildren().add(b3);
		
		
		startSailing();
	
	}
	
	private void observerStuff() {
		for(PirateShip pirate : pirates) {
			ship.registerObserver(pirate);
		}
	}
	 
	/*loadShipImage adds the ship image to the location of the ship
	 * it returns nothing */
    private void loadShipImage(){
		Image shipImage = new Image("ship.png",50,50,true,true);
		shipImageView = new ImageView(shipImage);
		
		shipImageView.setX(ship.getCurrentLocation().x*scalingFactor);
		shipImageView.setY(ship.getCurrentLocation().y*scalingFactor);		
		root.getChildren().add(shipImageView);
	
		
	}
	private void loadPirates(){
		/*loadPirates adds the pirate ship image to the location of each pirate ship
		 * returns nothing*/

		
		shiponeImageView = pirate1.getPirateImageView();
		shiponeImageView.setX(pirate1.getCurrentLocation().x*scalingFactor);
		shiponeImageView.setY(pirate1.getCurrentLocation().y*scalingFactor);
		root.getChildren().add(shiponeImageView);
		
		shiptwoImageView = pirate2.getPirateImageView();
		shiptwoImageView.setX(pirate2.getCurrentLocation().x*scalingFactor);
		shiptwoImageView.setY(pirate2.getCurrentLocation().y*scalingFactor);
		root.getChildren().add(shiptwoImageView);
		
	}
	
	private void loadTreasure() {
		chest = TreasureChest.getInstance();
		ImageView chestView = chest.getImage();
		
		chestView.setX(chest.getX()*scalingFactor);
		chestView.setY(chest.getY()*scalingFactor);
		
		root.getChildren().add(chestView);
	}
	
	private void loadAreas() {
		areas = map.getAreas();
//		System.out.println(areas);
		for (Area area : areas) {
			for (AreaOrMonster monster : area.getChildren()) {
				monster.getImageView().setX(monster.getX()*scalingFactor);
				monster.getImageView().setY(monster.getY()*scalingFactor);
				root.getChildren().add(monster.getImageView());
			}
		}
	}
	
	public void nuclearOption() {
		pirate1 = null;
		pirate2 = null;
	}
	
	private void youWin() {
		Image win = new Image("win.png",1000,0,true,true);
		ImageView winIV= new ImageView(win);
		winIV.setX(0);
		winIV.setY(500);
		root.getChildren().add(winIV);
	}
	
	private void youLose() {
		Image lose = new Image("lose.png",1000,0,true,true);
		ImageView loseIV = new ImageView(lose);
		loseIV.setX(0);
		loseIV.setY(300);
		root.getChildren().add(loseIV);
	}
	
	private void movePirates() {
		shiponeImageView.setX(pirate1.getCurrentLocation().x*scalingFactor);
    	shiponeImageView.setY(pirate1.getCurrentLocation().y*scalingFactor);
    	
    	shiptwoImageView.setX(pirate2.getCurrentLocation().x*scalingFactor);
    	shiptwoImageView.setY(pirate2.getCurrentLocation().y*scalingFactor);
	}
	
	private void movePlayer() {
		shipImageView.setX(ship.getCurrentLocation().x*scalingFactor);
		shipImageView.setY(ship.getCurrentLocation().y*scalingFactor);
		ship.notifyObservers();
	}
	
	private void moveMonsters() {
		//System.out.println(areas);
		for (AreaOrMonster obj : areas) {
			obj.move();
			obj.getImageView().setX(obj.getX()*scalingFactor);
			//System.out.println(obj.getX());
		}
	}
	
	private void startSailing(){
		/*startSailing contains the event handler thats tells the ship were to move when each key is pressed
		 * updates location of ship images
		 * adds a win image if game is completed
		 * if ship and pirate ship are at the same location then the game ends.
		 * does not return anything*/
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent ke) {
				if(!done){
					
					switch(ke.getCode()){
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				}
			}
				if (!done){
					movePlayer();
					map.setShipLocation(ship.getCurrentLocation());
					movePirates();
					moveMonsters();
		    	
					if (pirate1.getCurrentLocation().equals(ship.getCurrentLocation()) 
							|| pirate2.getCurrentLocation().equals(ship.getCurrentLocation())) {
						youLose();
						done=true;
					}
					
					if (chest.checkChest(ship.getCurrentLocation())) {
						youWin();
						done = true;
					}
					
					for (Area area : areas) {
						for (AreaOrMonster monster : area.getChildren()) {
							if (monster.checkShip(ship.getCurrentLocation())){
								youLose();
								done = true;
							}
						}
					}
			}
		    	
	  
				
			
	}
		    		
		});

	}
	
	/* draws ocean and adds island images
	 * returns nothing*/
	public void drawMap(){
		for(int x = 0; x < map.dimensionsx; x++){
			for(int y = 0; y < map.dimensionsy; y++){
				Rectangle rect = new Rectangle(x*scalingFactor,y*scalingFactor,scalingFactor,scalingFactor);
				rect.setStroke(Color.BLACK);
				if(islandMap[x][y]){
					Image isl = new Image("island.jpg",50,50,true,true);
					islandIV= new ImageView(isl);
					islandIV.setX(x*scalingFactor);
					islandIV.setY(y*scalingFactor);
					root.getChildren().add(islandIV);}
				else{
				rect.setFill(Color.PALETURQUOISE);
				root.getChildren().add(rect);}
			}
		}
	}
	public static String getDifficulty(){
		return diff; 
	}
	

	
}
