import java.util.ArrayList;
import java.util.List;

interface ListMapper {
	public int giveElement(int element);
}

class iterable implements ListMapper{
	public int giveElement(int element){
		return element+1;
	};
}


public class CollectionsUtils {
	
	public static List<Integer> map(List<Integer> list, ListMapper callback){
		List<Integer> list1 = new ArrayList<Integer>();

		for(int i=0;i<list.size();i++){
			list1.add(callback.giveElement(list.get(i)));
		}

		return list1;
	}

}