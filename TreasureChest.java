package SE350Final;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TreasureChest {
	private static TreasureChest chest;
	Image chestPic;
	ImageView chestView;
	singletonMap map;
	static Point coords;
	
	private TreasureChest() {
		chestPic = new Image("treasure.jpg",50,50,true,true);
		chestView = new ImageView(chestPic);
		map = singletonMap.getInstance();
		coords = map.getTreasureLocatoin();
	}
	
	public static TreasureChest getInstance() {
		if (chest == null) {
			chest = new TreasureChest();
		}
		return chest;
	}
	
	public ImageView getImage() {
		return chestView;
	}
	
	public int getX() {
		return coords.x;
	}
	
	public int getY() {
		return coords.y;
	}
	
	public boolean checkChest(Point ship) {
		System.out.println("chest " + coords);
		return ship.equals(coords);
	}
	
	public void destroy() {
		chest = null;
	}
}
