import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

class db {
	public Map createDb(){
		Map<String,String[]> cities = new HashMap<String,String[]>();
    	String[] Descity1 = {"Singapore"};
    	String[] Descity2 = {"Banglore","Seoul","Dubai"};
    	String[] Descity3 = {"Singapore","Beijing"};
    	String[] Descity4 = {"Seoul","Tokyo"};
    	String[] Descity5 = {"Beijing"};
    	cities.put("Banglore",Descity1);
    	cities.put("Singapore",Descity2);
    	cities.put("Seoul",Descity3);
    	cities.put("Beijing",Descity4);
    	cities.put("Tokyo",Descity5);
    	return cities;
	}
}


public class Path{
	String src;
	String des;

	public Path(String source,String destination){
		src=source;
		des=destination;
	}	

	public Boolean searchInDesLst(Map cities,String city,ArrayList<String> path) throws Exception{
		for(String dcity : (String[])cities.get(city)){
			if(des.equals(dcity)){
				path.add(dcity);
				this.toString(path);
				return true;
			}
		}
		for(String dcity : (String[])cities.get(city)){
			if(path.contains(dcity)==false){
				path.add(dcity);
				return (new Path(dcity,des)).isRoute(cities,path);
			}
		}
		return false;
	}

	public Boolean isRoute(Map cities,ArrayList<String> path) throws Exception{
		Set<String> citySet = cities.keySet();
		for(String city : citySet){
			if(src.equals(city)){
				Boolean isDircetWay = this.searchInDesLst(cities,city,path);
				return isDircetWay;
			}
		}
		throw new Exception("No city named "+ src + " in database");
	}

	public void toString(ArrayList<String> path){
		String route = "";
		for(String s : path){
			if(!s.equals(des)){
				route = route+s+"->";
			}
		}
		System.out.println(route+des);
	}

	public static void main(String[] args) {
    	Path path = new Path(args[0],args[1]);

    	Map cities = (new db()).createDb();
    	ArrayList<String> route = new ArrayList<String>();
    	route.add(args[0]);
    	try{
    		Boolean isDircetWay = path.isRoute(cities,route);
    		System.out.println(isDircetWay);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
	}
}