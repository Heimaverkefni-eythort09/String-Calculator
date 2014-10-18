package is.ru.stringcalculator;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator{

	public static int add(String text){

		// if (text.equals(""))
		// 	return 0;
		// else if (text.contains(",") || text.contains("\n"))
		// 	return sum(splitNumbers(text));
		// else
		// 	return 1;
		if(text.equals(""))
			return 0;
		
		if(text.contains("-")){
			illegalNegatives(text);
		}
		
		if(text.startsWith("//")){
			if(text.matches("^(//.\n.*)$"))
				return sum(newDelimiter(text));
			if(text.matches("^(//\\[.+\\]\n.*)$"))
				return (delimOfAnyLength(text));	
		}
		
		if (text.contains(",") || text.contains("\n"))
			return sum(splitNumbers(text));

		return toInt(text);

	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String number){
		
		return number.split(",|\n");
	}

	private static String[] newDelimiter(String number){
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(number);
		m.matches();
		String delimiter = m.group(1);
		String restOfNumber = m.group(2);
		return (restOfNumber.split(delimiter));
	}

	private static int sum(String[] number){
		int total = 0;
			for(int i = 0; i < number.length; i++){
				total += toInt(number[i]);
				//Here I check if the number is larger than 1000 and 
				if(toInt(number[i]) > 1000){
					total -= toInt(number[i]);
				}	
				
			}
			return total;
	}

	private static void illegalNegatives(String number) throws IllegalArgumentException{
		String[] inputs = number.split("-");
		String message = "Negatives not allowed: ";
		for(int i = 1; i <  inputs.length; i++){
			message += "-" + inputs[i].substring(0,1);
			if(i < inputs.length - 1){
				message += ", ";
			}
		}
		throw new IllegalArgumentException(message);
	}

	private static int delimOfAnyLength(String number){
		Matcher foo = Pattern.compile("//\\[(.*)\\]\n(.*)").matcher(number);
		foo.matches();
		String delimiter = foo.group(1);
		String restOfNumber = foo.group(2);
		return sum(restOfNumber.split(Pattern.quote(delimiter)));
	}

}


