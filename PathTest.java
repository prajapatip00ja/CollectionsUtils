import static org.junit.Assert.*;

import org.junit.Test;
// import java.util.ArrayList;
// import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PathTest {
    @Test
    public void calcAdd() {
    	assertEquals(2,1+1);
    }
 //    Bangalore,Singapore
	// Singapore,Seoul
	// Singapore,Dubai
	// Seoul,Beijing
	// Beijing,Tokyo

    @Test
    public void isDirectWayTest_01() {
    	String src = "Banglore";
    	String des = "Singapore";
    	Map<String,String[]> cities = new HashMap<String,String[]>();
    	String[] Descity1 = {"Singapore"};
    	String[] Descity2 = {"Dubai","Seoul"};
    	String[] Descity3 = {"Beijing"};
    	String[] Descity4 = {"Tokyo"};
    	cities.put("Banglore",Descity1);
    	cities.put("Singapore",Descity2);
    	cities.put("Seoul",Descity3);
    	cities.put("Beijing",Descity4);
    	Path p = new Path();
    	Boolean a = p.isRoute(src,des,cities);
    	assertEquals(a,true);
    }

    @Test
    public void isDirectWayTest_02() {
    	String src = "Banglore";
    	String des = "Tokyo";
    	Map<String,String[]> cities = new HashMap<String,String[]>();
    	String[] Descity1 = {"Singapore"};
    	String[] Descity2 = {"Dubai","Seoul"};
    	String[] Descity3 = {"Beijing"};
    	String[] Descity4 = {"Tokyo"};
    	cities.put("Banglore",Descity1);
    	cities.put("Singapore",Descity2);
    	cities.put("Seoul",Descity3);
    	cities.put("Beijing",Descity4);
    	Path p = new Path();
    	Boolean a = p.isRoute(src,des,cities);
    	assertEquals(a,false);
    }
}
