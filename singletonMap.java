package finalproject;

public class singletonMap {
	private static singletonMap map;
	private singletonMap(){}
	public static singletonMap getInstance(){
		if(map==null){
			map = new singletonMap();
		}
		return map;
	}

}
