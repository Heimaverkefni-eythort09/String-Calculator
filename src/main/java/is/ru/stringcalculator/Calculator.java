package is.ru.stringcalculator;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator{

	public static int add(String text){

		if (text.equals(""))
			return 0;
		else if (text.contains(",") || text.contains("\n"))
			return sum(splitNumbers(text));
		else
			return 1;

	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String number){
		
		//athuga hvort við viljum nota nýja delimiter
		if(number.startsWith("//")){
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(number);
			m.matches();
			String delimiter = m.group(1);
			String restOfNumber = m.group(2);
			return restOfNumber.split(delimiter);
		}

		return number.split(",|\n");
	}

	private static int sum(String[] numbers){
		int total = 0;
			for(int i = 0; i < numbers.length; i++){
				total += toInt(numbers[i]);
				//Here I check if the number is larger than 1000 and 
				if(toInt(numbers[i]) > 1000){
					total -= toInt(numbers[i]);
				}	
				
			}
			return total;
	}

	private static void illegalNegatives(String text) throws IllegalArgumentException{
		String[] inputs = text.split("-");
		String message = "Negatives not allowed ";
		for(int i = 1; i <  inputs.length; i++){
			message += "-" + inputs[i].substring(0,1);
			if(i < inputs.length - 1){
				message += ", ";
			}
		}
	}

	// private static int[] handleNewDelimeter(String numbers){

	// 	if(!containsDelimiter(numbers)){
	// 		String delimiter = String.valueOf(numbers.charAt(2));
	// 		String newStr = numbers.substring(4);
	// 		String[] numbers = newStr.split(String.valueOf(delimiter));

	// 		return 0;
	// 	}

	// 	String delimiterString =



}


