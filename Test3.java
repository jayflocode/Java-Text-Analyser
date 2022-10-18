package application;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class Test3 {

	@Test
	public void test() throws FileNotFoundException {

		File module2 = new File("mod2.htm");   
		
         int range = -500;  //test case uses -500 as the range of results, program does not allow negative input, expected to pass
		
		counter.reader(module2, range);
	}

}
