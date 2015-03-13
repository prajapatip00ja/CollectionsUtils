import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


public class PathTest {
    
    @Test
    public void isRoute_test_checks_the_route_between_banglore_to_singapore() throws Exception {
    	String src = "Banglore";
    	String des = "Singapore";
      PathFinder pathFinder = new PathFinder(src,des);
      Map cities = (new Db()).createDb();
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
      assertEquals(pathFinder.isRoute(cities,route),true);
    }

    @Test
    public void isRoute_test_checks_the_route_between_banglore_to_tokyo() throws Exception {
    	String src = "Banglore";
    	String des = "Tokyo";
      PathFinder pathFinder = new PathFinder(src,des);
      Map cities = (new Db()).createDb();
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
      assertEquals(pathFinder.isRoute(cities,route),true);
    }

    @Test
    public void isRoute_test_checks_the_route_between_chennai_to_tokyo() {
      String src = "Chennai";
      String des = "Tokyo";
      PathFinder pathFinder = new PathFinder(src,des);
      Map cities = (new Db()).createDb();  
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
    	try{
      	Boolean a = pathFinder.isRoute(cities,route);
    	}
    	catch(Exception e){
  		  assertEquals(e.getMessage(),"No city named Chennai in database");    		
  	 }
    }

    @Test
    public void isRoute_test_checks_the_route_between_tokyo_to_banglor() throws Exception {
    	String src = "Tokyo";
    	String des = "Banglore";
      PathFinder pathFinder = new PathFinder(src,des);
      Map cities = (new Db()).createDb();
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
      assertEquals(pathFinder.isRoute(cities,route),true);
    }

    @Test
    public void isRoute_test_checks_the_route_between_tokyo_to_dubai() throws Exception {
      String src = "Tokyo";
      String des = "Dubai";
      PathFinder pathFinder = new PathFinder(src,des);
      Map cities = (new Db()).createDb();
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
      assertEquals(pathFinder.isRoute(cities,route),true);
    }

    @Test
    public void isRoute_test_checks_the_route_between_banglore_to_Finland() throws Exception {
      String src = "Banglore";
      String des = "Finland";
      PathFinder pathFinder = new PathFinder(src,des);
      Map cities = (new Db()).createDb();
      ArrayList<String> route = new ArrayList<String>();
      route.add(src);
      assertEquals(pathFinder.isRoute(cities,route),false);
    }

    @Test
    public void giveCost_give_cost_between_two_direct_city(){
      String src = "Banglore";
      String des = "Singapore";
      AllPathFinder pf = new AllPathFinder();
      Map cities = (new Db()).createDbFromFile("PathS.txt");
      int cost  = pf.giveCost(src,des,cities);
      assertEquals(cost,7000);
    }

    @Test
    public void giveCost_give_cost_between_two_indirect_city() throws Exception {
      String src = "Banglore";
      String des = "Tokyo";
      AllPathFinder pathFinder = new AllPathFinder();
      List<String> route = new ArrayList<String>();
      Map cities = (new Db()).createDbFromFile("PathS.txt");
      route.add("Banglore");
      route.add("Singapore");
      route.add("Seoul");
      route.add("Beijing");
      route.add("Tokyo"); 
      assertEquals(pathFinder.calculateCost(cities,route),16000);
    }


}
																																												