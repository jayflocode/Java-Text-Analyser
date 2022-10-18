package application;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class Test1 {

	@Test
	public void test() throws FileNotFoundException {
		
		File module2 = new File("mod2.htm");   //Test Case uses right file name, expected to pass
		int range = 20;
		
		counter.reader(module2, range);
		
	}

}
