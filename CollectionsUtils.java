import java.util.ArrayList;
import java.util.List;

interface ListMapper<E,K> {
    public K giveElement(E element);
}

interface ListFilter<E> {
	public Boolean filterElement(E element);
}

interface ListReducer<E,K> {
	public K reducer(E element1, K element2);
}


public class CollectionsUtils{
	
	public static<E,K> List<K> map(List<E> list,ListMapper<E,K> callback){

		List<K> list1 = new ArrayList<K>();

		for(int i=0;i<list.size();i++){
			list1.add(callback.giveElement(list.get(i)));
		}

		return list1;
	}

	public static<E> List<E> filter(List<E> list, ListFilter callback){
		List<E> list1 = new ArrayList<E>();

		for(int i=0;i<list.size();i++){
			if((callback.filterElement(list.get(i)))==(Boolean)true){
				list1.add(list.get(i));
			}
		}
		return list1;	
	}

	public static<E,K> K reduce(List<E> list, ListReducer<E,K> callback, K intial){
		
		for(int i=0;i<list.size();i++){
			intial = callback.reducer(list.get(i), intial);
		}

		return intial;
	}

}
