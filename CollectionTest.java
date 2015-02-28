import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


class IterableInt implements ListMapper<Integer>{
    public Integer giveElement(Integer element){
        return element;
    };
}

class IterableStr implements ListMapper<String>{
    public String giveElement(String element){
        return element;
    };
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
        List<Integer> list2 = CollectionsUtils.<Integer>map(list1,callback);
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
        List<Integer> list2 = CollectionsUtils.<String>map(list1,callback);
        assertEquals(list2.get(0),(String)"pooja");
        assertEquals(list2.get(1),(String)"dolly");
        assertEquals(list2.get(2),(String)"sayli");
    } 






}    