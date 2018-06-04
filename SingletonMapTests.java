package SE350Final;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Point;
public class SingletonMapTests {
	@Test
	public void testUniqueness(){
		singletonMap sM1 = singletonMap.getInstance();
		singletonMap sM2 = singletonMap.getInstance();
		assertTrue(sM1==sM2);
	}
	@Test
	public void testRandomCoordinates(){
		singletonMap sM = singletonMap.getInstance();
		Point firstCoordinates = sM.giveCoordinates();
		Point secondCoordinates = sM.giveCoordinates();
		assertFalse(firstCoordinates.equals(secondCoordinates));
	} 
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
}
