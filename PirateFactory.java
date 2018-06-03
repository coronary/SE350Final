package SE350Final;

public class PirateFactory {
	
	public PirateShip createPirate(String type) {
		PirateShip pirate = null;
		if (type.equals("normal")) {
			pirate = new PirateShip("pirateship.png");
		}else if (type.equals("abnormal")) {
			pirate = new PirateShip("pirateship1.png");
		}
		return pirate;
	}
}
