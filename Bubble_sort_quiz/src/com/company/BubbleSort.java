package com.company;

public class BubbleSort {

    public SwapObject swap(int value1, int value2){
        SwapObject obj = new SwapObject();
        obj.value1 = value2;
        obj.value2 = value1;
        return obj;
    }
    public boolean canSwap(int value1,int value2){
        return value1 > value2 ? true : false;
    }
    public int[] SortArray(int[] array){

        boolean valueSwapped = true;

        while (valueSwapped)
        {
            valueSwapped = false;
            for (int i = 0;i < array.length -1;i++){
                int value = array[i];
                if(canSwap(array[i],array[i+1]))
                {
                    SwapObject swappedObj = swap(array[i],array[i+1]);
                    array[i] = swappedObj.value1;
                    array[i+1] = swappedObj.value2;
                    valueSwapped = true;
                }
            }
        }

        return array;

    }
}
