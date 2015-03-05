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

	public Map createDbFromFile(String file){
		Map<String,String[]> cities = new HashMap<String,String[]>();
		String texts = new Reader(file).readFile();
		String[] lines = texts.split("\r\n");
		for(int i = 0; i<lines.length; i++){
			cities.put(lines[i].split(" ")[0],lines[i].split(" ")[1].split(",")); 
		}
		return cities;
	}
}


class PathFinder {
	String src;
	String des;

	public PathFinder(String source,String destination){
		src=source;
		des=destination;
	}	

	public Boolean searchInDesLst(Map cities,String city,ArrayList<String> path) throws Exception{
		for(String destination : (String[])cities.get(city)){
			if(des.equals(destination)){
				path.add(destination);
				this.toString(path);
				return true;
			}
		}
		for(String destination : (String[])cities.get(city)){
			if(path.contains(destination)==false){
				path.add(destination);
				return (new PathFinder(destination,des)).isRoute(cities,path);
			}
		}
		return false;
	}

	public Boolean isRoute(Map cities,ArrayList<String> path) throws Exception{
		Set<String> citySet = cities.keySet();
		for(String city : citySet){
			if(src.equals(city)){
				return this.searchInDesLst(cities,city,path);
			}
		}
		throw new Exception("No city named "+ src + " in database");
	}

	public void toString(ArrayList<String> path){
		String route = "";
		for(String city : path){
			if(!city.equals(des))
				route = route+city+"->";
		}
		System.out.println(route+des);
	}
}

public class Paths {

	public Boolean isOptionPresentIn(String[] args){
		for(int i =0; i<args.length; i++){
			if(args[i].indexOf("-")==0){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
	    ArrayList<String> route = new ArrayList<String>();
    	Map cities;
	    PathFinder path;
  	  	if((new Paths()).isOptionPresentIn(args)){
    		cities = (new db()).createDbFromFile(args[1]);
    		path = new PathFinder(args[2],args[3]);
    		route.add(args[2]);
    	}
    	else{
    		cities = (new db()).createDb();
	    	path = new PathFinder(args[0],args[1]);
	    	route.add(args[0]);
    	}
    	try{
    		Boolean isDircetWay = path.isRoute(cities,route);
    		System.out.println(isDircetWay);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
	}
}

