import java.util.*;
class Stringjoin {
		
	public static void main(String[] args) {
		ArrayList<String> m = new ArrayList<String>();
		m.add("pooja");
		m.add("shikha");
		String o = String.join("->",m);
		System.out.println(o);
	}
}