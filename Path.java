import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


public class Path{

	public Boolean searchInDesLst(String city,Map cities,String des) throws Exception{
		for(String dcity : (String[])cities.get(city)){
			if(des.equals(dcity))
				return true;
		}
		for(String dcity : (String[])cities.get(city)){
			return (new Path()).isRoute(dcity,des,cities);
		}
		return false;	
	}

	public Boolean isRoute(String src,String des,Map cities) throws Exception{
		Set<String> citySet = cities.keySet();
		for(String city : citySet){
			if(src.equals(city)){
				Boolean isDircetWay = this.searchInDesLst(city,cities,des);
				return isDircetWay;
			}
		}
		throw new Exception("No city named "+ src + " in database");
	}


	public static void main(String[] args) {
    	Map<String,String[]> cities = new HashMap<String,String[]>();
    	String[] Descity1 = {"Singapore","Tokyo"};
    	String[] Descity2 = {"Dubai","Seoul"};
    	String[] Descity3 = {"Beijing"};
    	String[] Descity4 = {"Tokyo"};
    	cities.put("Banglore",Descity1);
    	cities.put("Singapore",Descity2);
    	cities.put("Seoul",Descity3);
    	cities.put("Beijing",Descity4);
    	Path p = new Path();
    	try{
    		Boolean isDircetWay = p.isRoute(args[0],args[1],cities);
    		System.out.println(isDircetWay);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
	}


		
	

	
}