import java.util.Arrays.*;
import java.util.*;
class Db {
	public Map createDb(){
		Map<String, List<String>> db = new HashMap<String, List<String>>();
        List<String> fromBanglore = new ArrayList<String>();
        fromBanglore.add("Singapore");
        db.put("Banglore",fromBanglore);

        List<String> fromSingapore = new ArrayList<String>();
        fromSingapore.add("Banglore");
        fromSingapore.add("Seoul");
        fromSingapore.add("Dubai");
        db.put("Singapore",fromSingapore);

        List<String> fromSeoul = new ArrayList<String>();
        fromSeoul.add("Singapore");
        fromSeoul.add("Beijing");
        db.put("Seoul",fromSeoul);

        List<String> fromBeijing = new ArrayList<String>();
        fromBeijing.add("Seoul");
        fromBeijing.add("Tokyo");
        db.put("Beijing", fromBeijing);

        List<String> fromTokyo = new ArrayList<String>();
        fromTokyo.add("Beijing");
        db.put("Tokyo",fromTokyo);

        List<String> fromDubai = new ArrayList<String>();
        fromDubai.add("Seoul");
        db.put("Dubai",fromDubai);

        return db;
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


	public Map createDbFromFile(String file) {
		Map<String,List<String>> cities = new HashMap<String,List<String>>();
        String texts = this.giveTextsFromFile(file);
        String[] lines = texts.split("\r\n");
        for(int i = 0; i<lines.length; i++){
            List<String> destination = new ArrayList<String>(Arrays.asList(lines[i].split(" ")[1].split(",")));
            cities.put(lines[i].split(" ")[0],destination); 
        }
		return cities;
	}
}	
