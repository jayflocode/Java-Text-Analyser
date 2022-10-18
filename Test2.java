package application;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class Test2 {

	@Test
	public void test() throws FileNotFoundException {
       
		
		File module2 = new File("mod50.htm");   //Test case uses wrong file name, expected to fail 
		
        int range = 20;
		
		counter.reader(module2, range);
	}

}
