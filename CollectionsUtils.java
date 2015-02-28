import java.util.ArrayList;
import java.util.List;

interface ListMapper<E> {
    public E giveElement(E element);
}



public class CollectionsUtils{
	
	public static<E> List<E> map(List<E> list,ListMapper<E> callback){

		List<E> list1 = new ArrayList<E>();

		for(int i=0;i<list.size();i++){
			list1.add(callback.giveElement(list.get(i)));
		}

		return list;
	}

}
