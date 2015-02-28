import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

    @Test
    public void calcAdd() {
    	assertEquals(2,1+1);
    }

    @Test
    public void TestMap(){
        List<Integer> list1 = new ArrayList<Integer>();
        ListMapper callback = new iterable();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = CollectionsUtils.map(list1,callback);
        assertEquals(list2.get(0),(Integer)2);
        assertEquals(list2.get(1),(Integer)3);
        assertEquals(list2.get(2),(Integer)4);
    }
    
    

}    