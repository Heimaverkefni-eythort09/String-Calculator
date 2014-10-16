package is.ru.stringcalculator;

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
		return number.split(",|\n");
	}

	private static int sum(String[] splitNumbers){
		int total = 0;
			for(int i = 0; i < splitNumbers.length; i++){
				total += toInt(splitNumbers[i]);
			}
			return total;
	}

}


