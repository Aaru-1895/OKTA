package com.conServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		List<Integer> i1 = Arrays.asList(1, 2, 2, 7, 6,25,30,7);
		List<Integer> i2 = Arrays.asList(1, 2, 2, 6, 10, 7);
		Set<Integer> set2 = new HashSet<>();
		Set<Integer> duplicateList = new HashSet<>();
		
		
		set2.addAll(i1);
		i2.forEach(singleInteger -> {
			if(set2.contains(singleInteger)) {
				duplicateList.add(singleInteger);
			}
		});
		System.out.println(duplicateList);
		
		
		
//		
//		
//		
//		
//		
//.
		
//		List<Integer> intval = Arrays.asList(0, 2, 0, 1, 0, 3);
//		List<Integer> intval1 = new ArrayList<>();
//		int temp;
//
//		for (int i = 1; i < intval.size(); i++) {
//
//			if (intval.get(i) == 0) {
//				intval1.add(0, 0);
//			} else {
//				intval1.add(intval.get(i));
//			}
//
//		}
//		System.out.println("....." + intval1);
//
//		List<Integer> intval2 = new ArrayList<>();
//
//		intval2.add(0, 1);
//		intval2.add(1, 5);
//		intval2.add(2, 10);
//		intval2.add(2, 20);
//		intval2.add(2, -10);
//
//		System.out.println("list 2 .." + intval2);

		/*
		 * List<Integer> i1 = Arrays.asList(1,2,2,1,8,5); List<Integer> i2 =
		 * Arrays.asList(1,2,2,6 ,10,25); Set<Integer> set2 = new HashSet<>();
		 * Set<Integer> set1 = new HashSet<>(); set1.addAll(i1); set2.addAll(i2);
		 * 
		 * i1.sort(null); i2.retainAll(i1); System.out.println("===list"+i2);
		 * 
		 * set2.retainAll(set1);
		 * 
		 * System.out.println(set2);
		 */

		/*
		 * for(int i =0;i<intval.size();i++ ) {
		 * 
		 * if(intval.get(i)!=0) { intval1.add(intval.get(i)); }}
		 */

		/*
		 * List<Integer> nums = new ArrayList<>(Arrays.asList(0, 2, 0, 1, 0, 3));
		 * System.out.println("Before: " + nums); Collections.sort(nums, new
		 * java.util.Comparator<Integer>() { public int compare(Integer a, Integer b) {
		 * if (a == 0 && b != 0) { return -1; } else if (a != 0 && b == 0) { return 1; }
		 * else { return 0; } } }); System.out.println("After: " + nums);
		 */

		// System.out.println(intval1);

		/*
		 * List<Integer> input = new ArrayList<>(); input.add(0); input.add(2);
		 * input.add(0); input.add(1); input.add(0); input.add(3);
		 * 
		 * List<Integer> output = new ArrayList<>(); for (int i = 0; i < input.size();
		 * i++) { if (input.get(i) == 0) { output.add(0, 0); // add zero to beginning of
		 * output list } else { System.out.println("else .."+input.get(i));
		 * output.add(input.get(i)); // add non-zero element to end of output list } }
		 * 
		 * System.out.println(output); // prints [0, 0, 0, 2, 1, 3]
		 */ }
}