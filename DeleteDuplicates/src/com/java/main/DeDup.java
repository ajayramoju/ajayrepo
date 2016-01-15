package com.java.main;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ch.lambdaj.Lambda.selectDistinct;

public class DeDup {

    private int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
                                   20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
                                   13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};  
    
    // Traditional way of removing the duplicates from the array 
    public int[] removeDuplicates(int []s){
        int result[] = new int[s.length], j=0;
        for (int i : s) {
            if(!isExists(result, i))
                result[j++] = i;
        }
        int finalResult[] = new int[j];
        for (int i=0; i < j; i++) {
        	finalResult[i] = result[i];
         }
        return finalResult;
    }
   
    // method to check whether the element is in the array
    private boolean isExists(int[] array, int value){
        for (int i : array) {
            if(i==value)
                return true;
        }
        return false;
    }
    
    // method to remove the duplicate elements from the integer array using lambda
    private Collection<Integer> removeDupInIntArrayUsingLambda(int[] ints){
    	List<Integer> intArrayList = IntStream.of(ints).boxed().collect(Collectors.toList());
        return selectDistinct(intArrayList);
    }
    
    // method to remove the duplicate elements from the integer array using LinkedHashSet to preserve the order
    private Set<Integer> removeDupInIntArray(int[] ints){
        Set<Integer> setString = new LinkedHashSet<Integer>();
        for(int i=0;i<ints.length;i++){
            setString.add(ints[i]);
        }
        return setString;
    }
    
    // Utility method to convert Collection Integer to integer array
    private int[] convertCollectionIntegerToIntArray(Collection<Integer> setInteger) {
    	int[] uniqueRandomIntegers = new int[setInteger.size()];
    	Iterator<Integer> intItrObj = setInteger.iterator();
    	for (int i=0; intItrObj.hasNext(); i++) {
    		uniqueRandomIntegers[i] = intItrObj.next().intValue();
    	}
    	return uniqueRandomIntegers;
    }
    
    // method to display the integer array elements
    private void displayIntArray(int[] intArray) {
    	for (int i=0; i<intArray.length; i++)
    		System.out.print(intArray[i] + " ");
    	System.out.println();
    }
    
    // Implementation solution method 1
    public void implSolution1() {
    	displayIntArray(removeDuplicates(randomIntegers));
    }
    
    // Implementation solution method 2
    public void implSolution2() {
    	displayIntArray(convertCollectionIntegerToIntArray(removeDupInIntArrayUsingLambda(randomIntegers)));
    }
    
    // Implementation solution method 3
    public void implSolution3() {
    	displayIntArray(convertCollectionIntegerToIntArray(removeDupInIntArray(randomIntegers)));
    }
    
    public static void main(String [] args) {
    	DeDup dedupObj = new DeDup();
    	
    	System.out.println("Original array elements with duplicates:");
    	dedupObj.displayIntArray(dedupObj.randomIntegers);
    	System.out.println();
    	
    	System.out.println("Array elements with no duplicates using traditional method: ");
    	dedupObj.implSolution1();
    	System.out.println();
    	
    	System.out.println("Array elements with no duplicates using Lambda");
    	dedupObj.implSolution2();
    	System.out.println();
    	
    	System.out.println("Array elements with no duplicates using LinkedHashSet : Preserves the order");
    	dedupObj.implSolution3();
    }
}


