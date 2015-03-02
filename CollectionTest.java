import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


class IterableInt implements ListMapper<Integer,Integer>{
    public Integer giveElement(Integer element){
        return element;
    };
}

class FilterInt implements ListFilter<Integer>{
     public Boolean filterElement(Integer element){
        return (element%2==0);
    };
}

class IterableStr implements ListMapper<String,String>{
    public String giveElement(String element){
        return element;
    };
}

class ConvertIntToStr implements ListMapper<Integer,String>{
    public String giveElement(Integer element){
        return element+"pooja";
    }
}

class ReduceInt implements ListReducer<Integer,Integer>{
    public Integer reducer(Integer element1 , Integer element2){
       Integer i = element1.intValue()+element2.intValue();
       return i;
    }
}



public class CollectionTest {

    @Test
    public void calcAdd() {
    	assertEquals(2,1+1);
    }

    @Test
    public void TestMap_01(){
        List<Integer> list1 = new ArrayList<Integer>();
        ListMapper callback = new IterableInt();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = CollectionsUtils.<Integer,Integer>map(list1,callback);
        assertEquals(list2.get(0),(Integer)1);
        assertEquals(list2.get(1),(Integer)2);
        assertEquals(list2.get(2),(Integer)3);
    }



    @Test
    public void TestMap_02(){
        List<String> list1 = new ArrayList<String>();
        ListMapper callback = new IterableStr();
        list1.add("pooja");
        list1.add("dolly");
        list1.add("sayli");
        List<Integer> list2 = CollectionsUtils.<String,String>map(list1,callback);
        assertEquals(list2.get(0),(String)"pooja");
        assertEquals(list2.get(1),(String)"dolly");
        assertEquals(list2.get(2),(String)"sayli");
    }

    @Test
    public void TestFilter_01(){
        List<Integer> list1 = new ArrayList<Integer>();
        ListFilter callback = new FilterInt();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = CollectionsUtils.<Integer>filter(list1,callback);
        assertEquals(list2.get(0),(Integer)2);
        
    } 

    @Test
    public void TestMap_001(){
        List<Integer> list1 = new ArrayList<Integer>();
        ListMapper callback = new ConvertIntToStr();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<String> list2 = CollectionsUtils.<Integer,String>map(list1,callback);
        assertEquals(list2.get(0),(String)"1pooja");
        assertEquals(list2.get(1),(String)"2pooja");
        assertEquals(list2.get(2),(String)"3pooja");
    }

    @Test
    public void TestReduce_001(){
        List<Integer> list1 = new ArrayList<Integer>();
        ListReducer callback = new ReduceInt();
        Integer i = 5;
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Integer list2 = CollectionsUtils.<Integer,Integer>reduce(list1,callback,i);
        assertEquals(11,(int)list2);
    }
}    