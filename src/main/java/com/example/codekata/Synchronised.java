package com.example.codekata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Synchronised {
	
	private static Map<String, List<String>> synchronizedMap = Collections.synchronizedMap(
			new HashMap<String, List<String>>());

	  public void doWork(String key) {
	    List<String> values = null;
	    while ((values = synchronizedMap.remove(key)) != null) {
	      //do something with values
	    }
	  }

	  public static void addToMap(String key, String value) {
	    
		  synchronized (synchronizedMap) {
		      if (synchronizedMap.containsKey(key)) {
		        synchronizedMap.get(key).add(value);
		      }
		      else {
		        List<String> valuesList = new ArrayList<String>();
		        valuesList.add(value);
		        synchronizedMap.put(key, valuesList);
		      }
	    }
		  
	  }
}
