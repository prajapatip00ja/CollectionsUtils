import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Map;
import java.util.HashMap;

public class PathTest {
    
    @Test
    public void isDirectWayTest_01() throws Exception {
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
    public void isDirectWayTest_02() throws Exception {
    	String src = "Banglore";
    	String des = "Tokyo";
    	Map<String,String[]> cities = new HashMap<String,String[]>();
    	String[] Descity1 = {"Singapore"};
    	String[] Descity2 = {"Seoul","Dubai"};
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
    public void isDirectWayTest_03() {
    	String src = "Chennai";
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
    	try{
	    	Boolean a = p.isRoute(src,des,cities);
    	}
    	catch(Exception e){
			assertEquals(e.getMessage(),"No city named Chennai in database");    		
    	}
    }

    









}
																																												