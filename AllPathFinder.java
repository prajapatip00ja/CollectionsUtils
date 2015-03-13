    
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by poojap on 3/10/2015.
 */
public class AllPathFinder {

    public void findAllPaths(Map cities,List<String> path,String src, String des,List<List<String>> list){
        path.add(src);
        if(des.equals(src)){
            list.add(new ArrayList(path));
            path.remove(src);
            return;
        }
        List<String> destinations = (List<String>)cities.get(src);
        for(String destination : destinations){
            destination = destination.split("#")[0];
            if(!path.contains(destination)){
                findAllPaths(cities,path,destination,des,list);
            }
        }
        path.remove(src);
    }

    public int giveCost(String src , String des, Map cities){
        String cost = new String();
        List<String> destinations = (List<String>)cities.get(src);
        for(String destination : destinations){
            if(des.equals(destination.split("#")[0]))
                cost = destination.split("#")[1];
        }
        return Integer.parseInt(cost);
    }

    public int calculateCost(Map cities,List path){
        int cost = 0;
        for(int i = 0; i<path.size(); i++){
            if(i<path.size()-1){
                String src = (String)path.get(i);
                String des = (String)path.get(i+1);
                cost = cost+giveCost(src, des, cities);   
            }
        }
        return cost;
    }

    public List<List<String>> giveAllPaths(Map cities,String src,String des){
        List<String> path = new ArrayList<String>();
        List<List<String>> allPaths = new ArrayList<List<String>>();
        this.findAllPaths(cities,path,src,des,allPaths);
        return allPaths;
    }
}