import java.io.*;
	
public class PathFileReader {
	String file;
	public PathFileReader(String file){
		this.file = file;
	}
	public String readFile() throws Exception{
		BufferedReader inputFile;	
		File fr = new File(this.file);
		int length = (int)fr.length();
		char cbuf[] = new char[length];
		inputFile = new BufferedReader(new FileReader (file));
		inputFile.read(cbuf,0,length);
        return new String(cbuf);
	}
}
