import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class PathTest {
    
    @Test
    public void isRoute_test_checks_the_route_between_banglore_to_singapore() throws Exception {
    	String src = "Banglore";
    	String des = "Singapore";
      Path path = new Path(src,des);
      Map cities = (new db()).createDb();
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
      assertEquals(path.isRoute(cities,route),true);
    }

    @Test
    public void isRoute_test_checks_the_route_between_banglore_to_tokyo() throws Exception {
    	String src = "Banglore";
    	String des = "Tokyo";
      Path path = new Path(src,des);
      Map cities = (new db()).createDb();
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
      assertEquals(path.isRoute(cities,route),true);
    }

    @Test
    public void isRoute_test_checks_the_route_between_chennai_to_tokyo() {
      String src = "Chennai";
      String des = "Tokyo";
      Path path = new Path(src,des);
      Map cities = (new db()).createDb();  
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
    	try{
      	Boolean a = path.isRoute(cities,route);
    	}
    	catch(Exception e){
  		  assertEquals(e.getMessage(),"No city named Chennai in database");    		
  	 }
    }

    @Test
    public void isRoute_test_checks_the_route_between_tokyo_to_banglor() throws Exception {
    	String src = "Tokyo";
    	String des = "Banglore";
      Path path = new Path(src,des);
      Map cities = (new db()).createDb();
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
      assertEquals(path.isRoute(cities,route),true);
    }

    @Test
    public void isRoute_test_checks_the_route_between_banglore_to_Finland() throws Exception {
      String src = "Banglore";
      String des = "Finland";
      Path path = new Path(src,des);
      Map cities = (new db()).createDb();
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
      assertEquals(path.isRoute(cities,route),false);
    }
}
																																												