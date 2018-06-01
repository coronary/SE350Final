package SE350Final;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class Area implements AreaOrMonster {
	//Only horizontal for now
	//singletonMap map;
	Point origin;
	ArrayList<AreaOrMonster> children;
	int size;
	Monster monster;
	
	ArrayList<ImageView> childImages = new ArrayList<ImageView>();
	
	public Area(Point origin) {
		//map = singletonMap.getInstance();
		this.origin = origin;
		children = new ArrayList<AreaOrMonster>();
		size = 3;
		
		monster = new Monster(origin);
		addChildren(monster);
	}
	
	public String toString() {
		return (origin.toString());
	}
	
	@Override
	public void move() {
		for (AreaOrMonster child : children) {
			child.move();
		}

	}

	@Override
	public void addChildren(AreaOrMonster obj) {
		children.add(obj);

	}

	@Override
	public void removeChildren(AreaOrMonster obj) {
		// TODO Auto-generated method stub
		children.remove(obj);

	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		for (AreaOrMonster child : children) {
			return child.getX();
		}
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return origin.y;
	}
	
	public ImageView getImageView() {
//		for (AreaOrMonster child : children) {
//			if (child instanceof Monster) {
//				childImages.add(child.getImageView());
//			}
//		}
		return children.get(0).getImageView();
	}
	
	public ArrayList<ImageView> getImageList(){
		return childImages;
	}

	public ArrayList<AreaOrMonster> getChildren(){
		return children;
	}
}
