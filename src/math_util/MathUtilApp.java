package math_util;

class MathUtilApp {
	public static void main(String [] args)
	{
		App.run();
	}
}

class App {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		kb.close();
	}
}

class IsPrimeApp {
	public static void run(java.util.Scanner kb)
	{
		long number;
		
		printHelpMsg();
		while ((number = kb.nextLong())!= 0)
			printResult(number, Utils.isPrime(number));
	}
}

class Utils {
	public static boolean isPrime(long number)
	{
		if (number < 2)
			return false;
		if (number % 2 == 0)
			return number == 2;
		if (number % 3 == 0)
			return number == 3;
		if (number % 5 == 0)
			return number == 5;
		if (number % 7 == 0)
			return number == 7;
		for (long i = 11; i * i < number; i += 2)
			if (number % i == 0)
				return false;
		return true;
	}
	
	public static long nextPrime(long number)
	{
		while (!isPrime(++number))
			;
		return number;
	}
}