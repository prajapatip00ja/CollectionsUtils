import java.util.*;
class Db {
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
		PathReader rd = new PathReader(file);
		String texts = rd.readFile();
		String[] lines = texts.split("\r\n");
		for(int i = 0; i<lines.length; i++){
			cities.put(lines[i].split(" ")[0],lines[i].split(" ")[1].split(",")); 
		}
		return cities;
	}
}
