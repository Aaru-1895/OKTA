package com.user.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;




public class SacnnerDemo {
	
	/*
	 * static List<String> generateCombinations(List<String> strings) { if (strings
	 * == null || strings.size() == 0) { return new ArrayList<>(); }
	 * 
	 * List<String> result = new ArrayList<>(); generateCombinationsHelper(strings,
	 * 0, "", result); return result; }
	 * 
	 * static void generateCombinationsHelper(List<String> strings, int index,
	 * String current, List<String> result) {
	 * System.out.println("results.."+result);
	 * System.out.println("Strings.."+strings); System.out.println("index.."+index);
	 * if (index == strings.size()) { result.add(current); return; }
	 * 
	 * String s = strings.get(index);
	 * 
	 * System.out.println( "Str========="+ s); for (int i = 0; i < s.length(); i++)
	 * { System.out.println("current   "+current + s.charAt(i));
	 * generateCombinationsHelper(strings, index + 1, current + s.charAt(i),
	 * result); } }
	 * 
	 * 
	 * public static void number(){ List<Integer> integers= Arrays.asList(1,2,3);
	 * //System.out.println(integers); HashMap<Number,String> numberStringHashMap =
	 * new HashMap<>(); numberStringHashMap.put(1,"abc");
	 * numberStringHashMap.put(2,"def"); numberStringHashMap.put(3,"ghi");
	 * //System.out.println(numberStringHashMap);
	 * 
	 * List<String> strings= integers.stream().map(n1-> numberStringHashMap.get(n1)
	 * ).collect(Collectors.toList());
	 * 
	 * //System.out.println(strings);
	 * 
	 * List<String> combinations = generateCombinations(strings);
	 * //System.out.println(combinations);
	 * 
	 * 
	 * }
	 * 
	 * public static void main(String[] args) { number(); }
	 */
	/*
	 * static Set<Integer> findNonDuplicate(List<Integer> listVal) { Set<Integer>
	 * setval = new HashSet<>(); return listVal.stream() .filter(n ->
	 * !setval.add(n)) // Set.add() returns false if the element was already in the
	 * set. .collect(Collectors.toSet());
	 * 
	 * 
	 * }
	 * 
	 * 
	 * public static void main(String[] args) { List<Integer> intVal =
	 * Arrays.asList(1,5,3,4,6,1);
	 * 
	 * Set<Integer> result = findNonDuplicate(intVal);
	 * 
	 * System.out.println("result..."+result); }
	 */
	
	public static void main(String[] args) {
		Set<Integer> duplicate = new HashSet<>();
		List<Integer> intList = Arrays.asList(1,8,6,4,2,7,1);
		List<Integer> intList1= intList.stream().filter(n -> duplicate.add(n)).
		collect(Collectors.toList());
		System.out.println("intList..."+intList1);
		
		
	}
	

	
}
