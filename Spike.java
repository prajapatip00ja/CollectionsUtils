import java.util.*;

class Spike{

	public void isRoute(Map cities,List<String> path,String src, String des,List<List<String>> list){
		path.add(src);
		if(des.equals(src)){
			list.add(new ArrayList(path));
			path.remove(src);
			System.out.println(path);
			return;
		}
		String[] destination = (String[])cities.get(src);
		for(String dest : destination){
			if(!path.contains(dest)){
				isRoute(cities,path,dest,des,list);
			}
		}
		path.remove(src);
		System.out.println(path);
	}

	public static void main(String[] args) {
		Map<String,String[]> cities = new HashMap<String,String[]>();
		String[] Descity1 = {"Singapore 7000","Japan 12000"};
		cities.put("Banglore",Descity1);
		System.out.println(cities);	
	}
}