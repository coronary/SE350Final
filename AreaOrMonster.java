package SE350Final;


import java.awt.Point;

import javafx.scene.image.ImageView;

public interface AreaOrMonster {
	public void move();
	public void addChildren(AreaOrMonster obj);
	public void removeChildren(AreaOrMonster obj);
	public int getX();
	public int getY();
	public ImageView getImageView();
	public boolean checkShip(Point ship);
}
