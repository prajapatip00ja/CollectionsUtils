import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

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

	public String toString(ArrayList<String> route){
		return String.join("->",route);
	}

}

public class Path{
	public String mapWithCountry(String file,String city){
		String texts = (new PathReader(file)).readFile();
		String[] lines = texts.split("\r\n");
		String country="";
		for(int i = 0; i<lines.length; i++){
			if(city.equals(lines[i].split(",")[0])){
				country = lines[i].split(",")[1];
			}
		}
		return city+"["+country+"]";	
	}

	public void toStringWithCountry(ArrayList<String> route,String file){
		String path = "";
		for(int i = 0 ; i< route.size(); i++){
			if(i!=route.size()-1)
			path = path+this.mapWithCountry(file,route.get(i))+"->";
			else
			path = path+this.mapWithCountry(file,route.get(i)); 
		}
		System.out.println(path);
	}
	
	public void printRoute(PathFinder pf,ArrayList<String> route,Map cities,String option,String file){
		try{
    		Boolean isDircetWay = pf.isRoute(cities,route);
    		if(option.equals("-c")){
    			(new Path()).toStringWithCountry(route,file);
    		}
    		else
	    	System.out.println(pf.toString(route));
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
	}
	
	public static void main(String[] args) {
	    ArrayList<String> route = new ArrayList<String>();
    	Map cities=null;
	    PathFinder pf=null;
	    if(args.length==2){
	    	cities = (new Db()).createDb();
	    	pf = new PathFinder(args[0],args[1]);
	    	route.add(args[0]);
	    	(new Path()).printRoute(pf,route,cities,"","");
	    }
	    else if(args[0].equals("-f")){
	    	cities = (new Db()).createDbFromFile(args[1]);
	    	if(args[2].equals("-c")){
	    		pf = new PathFinder(args[4],args[5]);
	    		route.add(args[4]);
	    		(new Path()).printRoute(pf,route,cities,args[2],args[3]);
	    	}
	    	else{
	    	pf = new PathFinder(args[2],args[3]);
	    	route.add(args[2]);
	    	(new Path()).printRoute(pf,route,cities,"","");
	    	}
	    }
	}
}