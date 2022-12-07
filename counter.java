package com.example.projectfinal;

import java.io.File;


import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;


/**
 * This Class focuses on the extraction of html file , sort of the elements, and storing those elements into a public array that could 
 be accessed by the main class. 
 */

public class counter  {
	
	
	/**
	 * This array stores the final results of the array after its sorted and clean
	 */
	 // Public array used to store information so it can be accessed by action listener 
	public static ArrayList<String> array;  
	
	/**
	 * This Method takes a List of Strings 
	 * @param Paramer uses a List <String> 
	 */
	
	//method sorts List elements that include numbers from high to low
	
	public static List<String> sort (List<String> clean) {
		
		/**
		 * The collections sort method uses a comparator that extracts the strings and evaluates by the numbers included in the array
		 Then it returns the array sorted. 
		 */
		
		
		Collections.sort(clean, new Comparator<String>() {
		    public int compare(String o1, String o2) {
		        return extractInt(o2) - extractInt(o1);
		    }

		    int extractInt(String s) {
		        String num = s.replaceAll("\\D", "");
		        // return 0 if no digits found
		        return num.isEmpty() ? 0 : Integer.parseInt(num);
		    }
		});
		
		return clean;
		
	}
	
	/**
	 * Sets title to Frequency Counter App
	 */
	
	
	/**
	 * This method uses a file object as a parameter and also an int number to represent the range of results
	 *
	 */
	
	//function that takes in html File Object and int that represents the number for results we want
	
	 public static void reader(File module2, int resultsRange) throws FileNotFoundException {
		
		// reading html file, calling it module 2 since it is related to module 2 assignment
		
		
		
		// creating a scanner object called reader to read from module 2 html assignment file or any html file
		 
		 /**
		Scanner object is created to read document, while loop is initiated to read the current lines. 	
		  */
		
		Scanner reader = new Scanner(module2);
		
		//Arraylist will be used to store all information
		
		ArrayList<String> list = new ArrayList<String>();
		
		
		
		//int line is used to keep track of which line the reader is on
		
		
		int line = 0;
		
		
		 
		//while loop is used to read all lines of the document
		
		while (reader.hasNextLine()) { 
			 
			 
			 String reading = reader.nextLine();
			 
			 reading = reading.toLowerCase();
			 
			 /**
			 * Specifies the lines we need to add 
		     */
			 
			 if (line > 77 && line < 243)  {
			 
			 /**
			 * replaces every special character with empty string
			 */	 
			 	 
 			 reading = reading.replaceAll("\\<[^>]*>","");
 			 reading = reading.replaceAll("&mdash;", " ");
 			 reading = reading.replaceAll("[^a-zA-Z0-9\\s+]", "");
 			 
 			 //finished cleaning up code, now need to split string and move it into an array list
 			 
 			 
 			/**
 			 * String is split and broken down after each space
 			 */
 			 
 			 String broken[] = reading.split(" ");
 			 
 			 // creates a list to be used to split the line which is called SplitList
 			 
 			 List<String> splitList = new ArrayList<String>();
 			 
 			 // Split list becomes an array containing elements created from the List
 			 splitList = Arrays.asList(broken);
 			 
 			 // adds full line to aray
 			 
 			/**
 			 * after the html code is cleaned, it adds the cleaned string as an element
 			 */
 			 
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
		
		/**
		 * List is sorted by alphabetical name 
		 */
		
		Collections.sort(list);
		
		// copies list to a new list so that we can keep the original list the same way it is and use another list to remove repeated elements
		
		/**
		 * Hashmap is added to remove frequencies of words so we can store it in an array to use for comparison purposes
		 * This array will allow us to compare it against the array that includes multiple frequencies
		 */
		
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
		
		sort(frequencyCount);
		
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
	     
	     
	     ArrayList<String> copy = new ArrayList<String>();
	     
		
         for (int i = 0; i < resultsRange; i++) {
		
        String counterString = counter.toString();	 
        
        /**
		 * A new array adds the comparative array and also the amount of times its found in the document into one element
		 */
        	 
			
		System.out.println(counterString + ". " + frequencyCount.get(i));
		
		
		copy.add(counterString + ". " + frequencyCount.get(i));
		
		
		
		
		//number sequence counter
		counter++;
			
			
		}
         
         /**
		* Copies the content of the array to the public array
		*/
         
         array = copy;
       
		//closes reader after running function 
         
         
        
		
		 reader.close();
		
	  
	}
	

	// remove main 

	

}
