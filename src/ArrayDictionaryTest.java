
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDictionaryTest {

    @Test
    public void demo() {
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        assertTrue(dict.add(2, 82));
        assertTrue(dict.add(4, 84));
        assertTrue(dict.add(7, 87));
        System.out.println(dict);
    }

    @Test
    public void remove() {
        ArrayDictionary dict;

        // empty dictionary
        dict = new ArrayDictionary(5);
        assertTrue(dict.remove(0) == false);
        assertTrue(dict.remove(-1) == false);

        // key exists in a dictionary that has no collision
        dict = new ArrayDictionary(5);
        dict.add(1, 1);
        dict.add(2, 2);

        assertTrue(dict.remove(0) == false);
        assertTrue(dict.remove(1) == true);
        assertTrue(dict.contains(1) == false);
        assertTrue(dict.contains(2) == true);

        // key does not exists in a dictionary that has no collision
        dict = new ArrayDictionary(5);
        dict.add(1, 1);
        dict.add(2, 2);
        assertTrue(dict.remove(3) == false);
        assertTrue(dict.contains(3) == false);

        // key exists in a dictionary that has collision, key is in the collision.
        dict = new ArrayDictionary(5);
        dict.add(1, 1);
        dict.add(11, 11);
        dict.add(21, 11);

        assertTrue(dict.remove(21) == true);
        assertTrue(dict.contains(21) == false);
        assertTrue(dict.remove(1) == true);
        assertTrue(dict.contains(1) == false);

        // key exists in a dictionary that has collision, key is not in the collision.
        dict = new ArrayDictionary(5);
        dict.add(1, 1);
        dict.add(11, 11);
        dict.add(21, 11);
        dict.add(22, 22);

        assertTrue(dict.remove(22) == true);
        assertTrue(dict.contains(22) == false);
        assertTrue(dict.remove(23) == false);
        assertTrue(dict.contains(23) == false);

        // key does not exists in a dictionary that has collision.
        assertTrue(dict.remove(23) == false);
        assertTrue(dict.contains(23) == false);
        assertTrue(dict.remove(-1) == false);
        assertTrue(dict.contains(-1) == false);
    }

    @Test
    public void contains() {
        // homework
        int testSize = 5;
        ArrayDictionary dict;
        dict = new ArrayDictionary(testSize);
        // empty dictionary<int, int>, contain returns false with key -1 
        assertFalse(dict.contains(-1));
        // empty dictionary<int, int>, contain returns false with key 0 
        assertFalse(dict.contains(0));
        // empty dictionary<int, int>, contain returns false with key 1 
        assertFalse(dict.contains(1));

        dict = new ArrayDictionary(1);
        dict.add(0, 103);
        // dictionary<int, int>, capacity 1, init values {0:103}, key=2 returns false 
        assertFalse(dict.contains(2));
        // dictionary<int, int>, capacity 1, init values {0:103}, key=0 returns true 
        assertTrue(dict.contains(0));

        dict = new ArrayDictionary(2);
        dict.add(0, 103);
        dict.add(1, 105);
        assertTrue(dict.contains(0));
        assertTrue(dict.contains(1));
        assertFalse(dict.contains(2));
        assertFalse(dict.contains(3));

        dict = new ArrayDictionary(3);
        dict.add(0, 103);
        dict.add(1, 105);
        dict.add(2, 206);
        dict.add(4, 407);

        assertTrue(dict.contains(1));
        assertTrue(dict.contains(4));
        assertFalse(dict.contains(7));
        assertFalse(dict.contains(8));
    }

}
