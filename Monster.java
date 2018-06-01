package SE350Final;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Monster implements AreaOrMonster {
	int x;
	int ogX;
	int y;
	int offset;
	boolean leftRight;
	Image monsPic;
	ImageView monsView;
	
	
	public Monster(Point location) {
		monsPic = new Image("monster.jpg",50,50,true,true);
		monsView = new ImageView(monsPic);
		ogX = location.x;
		x = location.x;
		y = location.y;
		offset = 0;
	}
	
	@Override
	public void move() {
		x = ogX;
		// TODO Auto-generated method stub
		//System.out.println(offset);
		if (offset == 0) leftRight = true;
		if (offset == 3) leftRight = false;
		
		if (leftRight) {
			offset++;
		}
		if (!leftRight) {
			offset--;
		}
		//System.out.println(x);
		x = x + offset;
	}

	@Override
	public void addChildren(AreaOrMonster obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeChildren(AreaOrMonster obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	public ImageView getImageView() {
		return monsView;
	}

	@Override
	public boolean checkShip(Point ship) {
		// TODO Auto-generated method stub
		return ship.equals(new Point(x,y));
	}

}
