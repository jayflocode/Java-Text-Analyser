package Frequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class counter {
	
	
	//function that takes in html File Object and int that represents the number for results we want
	
	public static void reader(File module2, int resultsRange) throws FileNotFoundException {
		
		// reading html file, calling it module 2 since it is related to module 2 assignment
		
		
		
		// creating a scanner object called reader to read from module 2 html assignment file or any html file
		
		Scanner reader = new Scanner(module2);
		
		//Arraylist will be used to store all information
		
		ArrayList<String> list = new ArrayList<String>();
		
		
		
		//int line is used to keep track of which line the reader is on
		
		
		int line = 0;
		
		
		 
		//while loop is used to read all lines of the document
		
		while (reader.hasNextLine()) { 
			 
			 
			 String reading = reader.nextLine();
			 
			 reading = reading.toLowerCase();
			 
			 
			 
			 if (line > 77 && line < 243)  {
				 
			 	 
 			 reading = reading.replaceAll("\\<[^>]*>","");
 			 reading = reading.replaceAll("&mdash;", " ");
 			 reading = reading.replaceAll("[^a-zA-Z0-9\\s+]", "");
 			 
 			 //finished cleaning up code, now need to split string and move it into an array list
 			 
 			 
 			 String broken[] = reading.split(" ");
 			 
 			 // creates a list to be used to split the line which is called SplitList
 			 
 			 List<String> splitList = new ArrayList<String>();
 			 
 			 // Split list becomes an array containing elements created from the List
 			 splitList = Arrays.asList(broken);
 			 
 			 // adds full line to aray
 			 
 			for(String s: splitList){
 			   
 				if (!s.isEmpty()) {
 				
 				list.add(s);
 				
 				
 				}
 				
 				
 			}
 			
 			
			 
			 }
			 
			 line++;  //keeps track of the line in document
			 
			// loop ends
		 }
		
	    //sorts "list" 
		
		Collections.sort(list);
		
		// copies list to a new list so that we can keep the original list the same way it is and use another list to remove repeated elements
		
		
		LinkedHashSet<String> hashSet = new LinkedHashSet<>(list);
		
		
		// arraylist is called reference cause it will be used for comp
		
		ArrayList<String> reference = new ArrayList<String>(hashSet);
		
		
		
		//testing 
		//prints values stored in Array
		
		List<String> frequencyCount = new ArrayList<>(); 
	
		//loop is used to add word and how many times the word is found
		 
		for (int i = 0; i < reference.size(); i ++) {
			
		
	    Integer num = Collections.frequency(list, reference.get(i));
	    
	    //converts word count per word from int to string
	    String numCount = num.toString();
	    
	    frequencyCount.add("\"" + reference.get(i) + "\""+ " "+ numCount);
	    
	  
			
		}
		
		//comparator used to extract integers and sort them by highest to lowest
		
		Collections.sort(frequencyCount, new Comparator<String>() {
		    public int compare(String o1, String o2) {
		        return extractInt(o2) - extractInt(o1);
		    }

		    int extractInt(String s) {
		        String num = s.replaceAll("\\D", "");
		        // return 0 if no digits found
		        return num.isEmpty() ? 0 : Integer.parseInt(num);
		    }
		});
		
		//limits the results range to the maximum value of the array
		
		 if (resultsRange > frequencyCount.size()) {
			 
			 resultsRange = frequencyCount.size();
			 
		 }
		 
		 // limits the results range to ignore 0 and any value lesser
		 
         if (resultsRange <= 0) {
			 
			 resultsRange = 1;
			 
		 }
 		
		 // used to represent the numbered sequence to "number" the results
	     Integer counter = 1;
	     
	     //prints out results
	     
	     System.out.println();
	     System.out.println("Top " + resultsRange + " Results found in the html document");
	     System.out.println();
		
         for (int i = 0; i < resultsRange; i++) {
		
        String counterString = counter.toString();	 
        	 
			
		System.out.println(counterString + ". " + frequencyCount.get(i));
		
		//number sequence counter
		counter++;
			
			
		}
         
       
		//closes reader after running function 
		
		 reader.close();
		
	
	}
	

	

	public static void main(String[] args) throws FileNotFoundException {
		
		// string used to assign file name
		String htmlFile = "mod2.htm";
		// int used to assign results range, default set at 20
		int resultsRange = 20;

		//declaring File Object 
		
		File module2 = new File(htmlFile);
		
	    // calling method that takes in a File object, and an integer that represents the range of results
		
		reader(module2, resultsRange);
	    
		
		
		
		
		
	}

}
