/**
 * Hieu Duong
 * CSC 201
 * Assignment 7
 * Problem 7.15:
 * (Eliminate duplicates) Write a method that returns a new array by eliminating the
 * duplicate values in the array using the following method header:
 * public static int[] eliminateDuplicates(int[] list)
 * Write a test program that reads in ten integers, invokes the method, and displays
 * the result.
 *
 * 09/16/2017
 *
 */


import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);

        int ArrayLength = 10;
        int[] newArray = new int[ArrayLength];

        for(int i=0; i < ArrayLength; i++) {
            boolean IsNotANumber = true;
            while (IsNotANumber) {
                System.out.println("Enter value "+i+": ");
                String input = keyboard.next();
                try {
                    int RealNumber = Integer.parseInt(input);
                    newArray[i] = RealNumber;
                    IsNotANumber = false;
                } catch (Exception e) {
                    System.out.println("Not a integer. ");
                    IsNotANumber = true;
                }
            }
        }

        System.out.println("Original Array: "+DisplayArray(newArray));

        //Need to sort the array first
        int[] SortedArray = SortArray(newArray);
        System.out.println("Sorted Array: "+DisplayArray(SortedArray));

        //Eliminate duplicates after sorted array
        int[] NonDuplicateArray = eliminateDuplicates(SortedArray);
        System.out.println("Non duplicates Array: "+DisplayArray(NonDuplicateArray));

    }

    /**
     * Sort array method
     * @param list
     * @return
     */

    public static int[] SortArray(int[] list){

        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i..list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                    }
                }

            // Swap list[i] with list[currentMinIndex] if necessary
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
                }
            }

        return list;
    }

    /**
     * Elmiminate duplicate array method
     * @param list
     * @return
     */

    public static int[] eliminateDuplicates(int[] list){

        int CurrentIndex=0;
        list[CurrentIndex]=list[0];
        for(int i=0;i<list.length;i++)
        {
            //If the current index value is the same with compared value, do nothing
            //Else replace current index value with compared value
            //Then increment current index by one and keep checking
            if (list[CurrentIndex]!=list[i])
            {
                CurrentIndex++;
                list[CurrentIndex]=list[i];
            }
        }

        int[] nonDuplicatesArray = new int[CurrentIndex+1];
        for (int i=0;i<=CurrentIndex;i++ )
        {
            nonDuplicatesArray[i] = list[i];
        }

        return nonDuplicatesArray;
    }

    /**
     * Display content in the array
     * @param list
     * @return
     */
    private static String DisplayArray(int[] list) {
        String ArrayContent = "";
        if(list.length > 0)
        {
            for(int i=0; i < list.length; i++) {
                ArrayContent += list[i] + " ";
            }
        }
        return  ArrayContent;
    }
}
