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
		List<String> destinations = (List<String>)cities.get(city);
		for(String destination : destinations){
			if(des.equals(destination)){
				path.add(destination);
				return true;
			}
		}
		for(String destination : destinations){
			if(path.contains(destination)==false){
				path.add(destination);
				this.src = destination;
				return isRoute(cities,path);
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

	public PathFinder checkRoute(ArrayList<String> route,Map cities,String source,String destination){
        PathFinder pf = new PathFinder(source,destination);
        route.add(source);
        try{
            pf.isRoute(cities,route);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return pf;
    }

	public static void main(String[] args) {
        ArrayList<String> route = new ArrayList<String>();
        Map cities=null;
        if(args.length==2){
            cities = (new Db()).createDb();
           	PathFinder pf = (new Path()).checkRoute(route,cities,args[0],args[1]);
        	System.out.println(pf.toString(route));
        }
        else{
           cities = (new Db()).createDbFromFile(args[1]);
            if(args[2].equals("-c")){
            	AllPathFinder pf = new AllPathFinder();
            	List<List<String>> allPaths = pf.giveAllPaths(cities,args[4],args[5]);
            	for(List<String> path : allPaths){
                    (new CountryMapper()).toString(path,args[3]);
                   	System.out.println("total cost:-"+pf.calculateCost(cities,path));
            	}
            }
            else{
                PathFinder pf = (new Path()).checkRoute(route,cities,args[2],args[3]);
                System.out.println(pf.toString(route));
            }
        }
    }
}