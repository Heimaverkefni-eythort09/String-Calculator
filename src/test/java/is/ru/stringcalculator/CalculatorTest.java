package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]){
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator");
	}

	@Test
	public void testEmptyString(){
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testOneTwoNumber(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers(){
		assertEquals(28, Calculator.add("1,2,3,4,5,6,7"));
	}

	@Test
	public void testNewLine(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testMultipleNewLine(){
		assertEquals(45, Calculator.add("1\n2\n3\n4\n5\n6,7,8\n9"));
	}

	@Test
	public void testNewDelimiter(){
		assertEquals(6, Calculator.add("//;\n1;2;3"));
		assertEquals(6, Calculator.add("//#\n1#2#3"));
	}

	@Test 
	public void testLargerThanThousand(){
		assertEquals(6, Calculator.add("1,2,3,1002"));
		assertEquals(45, Calculator.add("//;\n5;10;20;2000;10;4999"));
	}

	@Test 
	public void testNegativeNumbers(){
		try{
			Calculator.add("-1,-2,-3,1,2,3");
		}
		catch(IllegalArgumentException foo){
			//assertEquals(foo.getMessage(),"Negatives not allowed: -1, -2, -3", foo.getMessage());
			assertEquals("Negatives not allowed: -1, -2, -3",foo.getMessage());
		}
	}

	@Test 
	public void testMultipleDelimiterLength(){
		assertEquals(6, Calculator.add("//[**]\n1**2**3"));
	}

	@Test
	public void testMultipleAspects(){
		assertEquals(10, Calculator.add("//&\n1&2&1900&3&4"));
	}

	@Test
	public void testNegativeAgain(){
		assertEquals("Negatives not allowed: -1, -5", Calculator.add("-1,1,2,3,-5"));
	}


}