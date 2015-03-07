import java.io.*;

public class PathReader {
	String file;
	
	public PathReader(String file){
		this.file = file;
	}

	public String readFile(){
		BufferedReader inputFile;	
		File fr = new File(this.file);
		int length = (int)fr.length();
		char cbuf[] = new char[length];
		try{
		    inputFile = new BufferedReader(new FileReader (file));
			inputFile.read(cbuf,0,length);
	    }   
        catch (IOException ioe){
            System.out.println (ioe.getMessage());
            ioe.printStackTrace ();
        }
        return new String(cbuf);
	}
}


