package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Test5 {

	@Test
	public void test() {
		
		List<String> splitList = new ArrayList<String>();
		
			
		
		splitList.add("1. John");
		splitList.add("4. Abe");
		splitList.add("2. Gill");
		splitList.add("10. Jim");
		
		
		counter.sort(splitList);  //Test Case 5 tests for sorting of Array, expected to sort the elements by the numbers inside
		
		for (int i = 0; i < splitList.size(); i++) {
	    	
	    	
	    	
	    	System.out.println(splitList.get(i));
	    	
	    	
	    }
		
		
		
	}

}
