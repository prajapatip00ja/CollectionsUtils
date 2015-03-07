
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

	public String toStringWithCountry(ArrayList<String> route,String file){
		String path = "";
		for(int i = 0 ; i< route.size(); i++){
			if(i!=route.size()-1)
			path = path+this.mapWithCountry(file,route.get(i))+"->";
			else
			path = path+this.mapWithCountry(file,route.get(i)); 
		}
		return path;
	}
