package com.example.codekata;

import java.util.ArrayList;
import java.util.List;

public class FlattenList {
	int index = 0;
	List<Integer> flattenedList = new ArrayList<>();
	
	public static FlattenList getList(List<List<Integer>> lists){
		FlattenList flattenList = new FlattenList();
		flattenList.flatten(lists);
		return flattenList;
	}

	private void flatten(List<List<Integer>> lists) {
		for(List<Integer> list : lists){
			flattenedList.addAll(list);
		}
	}
	
	public boolean hasNext(){
		return flattenedList.size() > index; 
	}
	
	public Integer next(){
		Integer result = flattenedList.get(index);
		index++;
		return result;
	}
}
