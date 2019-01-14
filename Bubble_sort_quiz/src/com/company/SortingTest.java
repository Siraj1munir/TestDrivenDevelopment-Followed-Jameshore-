package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Array;

public class SortingTest {

    BubbleSort bubbleSort;
    public SortingTest(){
        bubbleSort = new BubbleSort();
    }
    @Test
    public void SwappingTest(){
        boolean result = false;
        SwapObject swappedValues = bubbleSort.swap(9,1);
        if(swappedValues.value1 == 1 && swappedValues.value2 == 9)
        { result = true;}

        assertEquals(true,result);
    }

    @Test
    public  void isSwappable(){
        boolean CanSwapable = bubbleSort.canSwap(9,1);

        assertEquals(true,CanSwapable);

    }

    @Test
    public void ArraySorted(){
        boolean isSortedArray = true;
        int[] unsortedArray = {6,2,7,4,1};
        int[] sortedArray = {1,2,4,6,7};

        int[] resultArray = bubbleSort.SortArray(unsortedArray);
        for (int i =0; i< resultArray.length;i++) {
            if (resultArray[i] != sortedArray[i]) {
                isSortedArray = false;
                break;
            }
        }
        assertEquals(true,isSortedArray);


    }


}


