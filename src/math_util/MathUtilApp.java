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
		printWelcomeMsg();
		{
			int mode;
			do {
				printMenu();
				mode = kb.nextInt();
				if (mode == 1)
					IsPrimeApp.run(kb);
			} while (mode != 0)
		}
		kb.close();
	}
	
	public static void printWelcomeMsg()
	{
		System.out.println("\tWelcome to math_util!");
	}
	
	public static void printMenu()
	{
		System.out.println("1) Check if an integer is a prime number.");
		System.out.println("0) Quit");
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
	
	public static void printHelpMsg()
	{
		System.out.println("> Keep entering integers. Enter 0 to return to menu:");
	}
	
	public static void printResult(long number, boolean isprime)
	{
		if (isprime)
			System.out.printf("> %d is a prime number.%n", number);
		else
			System.out.printf("> %d is not a prime number.%n", number);
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