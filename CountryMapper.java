import java.util.*;
class CountryMapper {
	public String mapWithCountry(String texts,String city){
		
		String[] lines = texts.split("\r\n");
		String country="";
		for(int i = 0; i<lines.length; i++){
			if(city.equals(lines[i].split(",")[0])){
				country = lines[i].split(",")[1];
			}
		}
		return city+"["+country+"]";	
	}

	private String giveTextsFromFile(String file){
        String texts = new String();
        try{
            PathFileReader rd = new PathFileReader(file);
            texts = rd.readFile();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return texts;
    }

	public void toString(List<String> route,String file){
		String path = "";
		String texts = this.giveTextsFromFile(file);
		for(int i = 0 ; i< route.size(); i++){
			if(i!=route.size()-1)
			path = path+this.mapWithCountry(texts,route.get(i))+"->";
			else
			path = path+this.mapWithCountry(texts,route.get(i)); 
		}
		System.out.println(path);
	}
}