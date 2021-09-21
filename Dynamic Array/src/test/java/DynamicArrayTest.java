import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrayTest {

    DynamicArray<Integer> da;
    DynamicArray<Integer> da2;

    @BeforeEach
    void setUp(){
        da = new DynamicArray<>();
        da2 = new DynamicArray<>(5);
    }

    @Test
    void addBasicTest(){
        da.add(5);
        da2.add(0);
        assertEquals(da.get(0),5);
        assertEquals(da2.get(0),0);
    }

    @Test
    void addElevenElements(){
        da2.add(1);
        da2.add(2);
        da2.add(3);
        da2.add(4);
        da2.add(5);
        da2.add(6);
        da2.add(7);
        da2.add(8);
        da2.add(9);
        da2.add(10);
        da2.add(11);
        assertEquals(da2.size(),11);
    }

    @Test
    void addAtIndexTest(){
        da2.add(1);
        da2.add(2);
        da2.add(3);
        da2.add(4);
        da2.add(5);
        da2.add(6);
        da2.add(7);
        da2.add(8);
        da2.add(9);
        da2.add(10);
        da2.add(11);
        da2.addAtIndex(7,111);

        assertEquals(da2.get(7),111);
        assertEquals(da2.get(8),8);
        assertEquals(da2.get(9),9);
        assertEquals(da2.get(10),10);
        assertEquals(da2.get(11),11);
    }

    @Test
    void addAtLastIndexTest(){
        da2.add(1);
        da2.add(2);
        da2.add(3);
        da2.add(4);

        da2.addAtIndex(3,111);


        assertEquals(da2.get(3),111);
        assertEquals(da2.get(4),4);
    }

    @Test
    void removeAtLastIndexTest(){
        da2.add(1);
        da2.add(2);
        da2.add(3);
        da2.add(4);

        da2.removeAtIndex(3);
        assertEquals(da2.get(0),1);
        assertEquals(da2.get(1),2);
        assertEquals(da2.get(2),3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            da2.get(3);
        });

    }

    @Test
    void addAtFirstIndexTest(){
        da2.add(1);
        da2.add(2);
        da2.add(3);
        da2.add(4);

        da2.addAtIndex(0,13);

        assertEquals(da2.get(0),13);
        assertEquals(da2.get(1),1);
        assertEquals(da2.get(2),2);
        assertEquals(da2.get(3),3);
        assertEquals(da2.get(4),4);

    }


    @Test
    void removeAtFirstIndexTest(){
        da2.add(1);
        da2.add(2);
        da2.add(3);
        da2.add(4);

        da2.removeAtIndex(0);
        assertEquals(da2.get(0),2);
        assertEquals(da2.get(1),3);
        assertEquals(da2.get(2),4);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            da2.get(3);
        });
    }

    @Test
    void removeTest(){
        da2.add(1);
        da2.add(2);
        da2.add(3);
        da2.add(4);

        da2.remove(4);

        assertEquals(da2.get(0),1);
        assertEquals(da2.get(1),2);
        assertEquals(da2.get(2),3);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            da2.get(3);
        });

    }


}
