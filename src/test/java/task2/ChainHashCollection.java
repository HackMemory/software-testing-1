package task2;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ChainHashSortTest {
    static ChainHashCollection<Integer> sorter;

    @BeforeAll
    static void init() {
        sorter = new ChainHashCollection<>();
    }

    @Test
    void sort() {
        BreadCrumbs bc = new BreadCrumbs();
        Integer[] arr = new Integer[]{436, 866, 876, 640, 756, 625, 337, 815, 649, 235};
        Integer[] sortedArr = new Integer[]{235, 337, 436, 625, 640, 649, 756, 815, 866, 876};
        String expected = "f4f9f9f7f8f6f3f8f7f2f235f337f436f625f640f649f756f815f866f876";
        sorter.sortBC(arr, bc);
        assertEquals(expected, bc.getTrace());
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    void checkMaxVals() {
        Integer[] maxValsArr = new Integer[]{1000, 999, -1000, -999};
        assertThrows(ValueException.class, () -> sorter.sort(maxValsArr));
    }

    @Test
    void checkNull() {
        Integer[] array = null;
        assertThrows(NullPointerException.class, () -> sorter.sort(array));
    }

    @Test
    void checkRepeatitions() {
        Integer[] repeatedArray = new Integer[]{0, 0, 0, 0, 0, 0};
        Integer[] repeatedResult = new Integer[]{0, 0, 0, 0, 0, 0};
        sorter.sort(repeatedArray);
        assertArrayEquals(repeatedResult, repeatedArray);
    }

}
