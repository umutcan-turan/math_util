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
		// TODO: Exception handling on bad input
		java.util.Scanner kb = new java.util.Scanner(System.in);
		printWelcomeMsg();
		{
			int mode;
			do {
				printMenu();
				mode = kb.nextInt();
				if (mode == 1)
					IsPrimeApp.run(kb);
				else if (mode == 2)
					NextPrimeApp.run(kb);
				else if (mode == 3)
					FactorsApp.run(kb);
				else if (mode == 4)
					SquareFactorsApp.run(kb);
				else if (mode == 5)
					PrimeFactorsApp.run(kb);
			} while (mode != 0);
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
		System.out.println("2) Get the smallest prime number greater than given integer.");
		System.out.println("3) Display an integer's factors.");
		System.out.println("4) Display an integer's factors which happen to be perfect squares.");
		System.out.println("5) Display the prime factorization of an integer.");
		System.out.println("0) Quit");
	}
}

class IsPrimeApp {
	public static void run(java.util.Scanner kb)
	{
		long number;
		
		Utils.printHelpMsg();
		while ((number = kb.nextLong())!= 0)
			printResult(number, Utils.isPrime(number));
	}
	
	public static void printResult(long number, boolean isprime)
	{
		if (isprime)
			System.out.printf("> %d is a prime number.%n", number);
		else
			System.out.printf("> %d is not a prime number.%n", number);
	}
}

class NextPrimeApp {
	public static void run(java.util.Scanner kb)
	{
		long number;
		
		Utils.printHelpMsg();
		while ((number = kb.nextLong()) != 0)
			printNextPrime(number);
	}
	
	public static void printNextPrime(long number)
	{
		System.out.printf("> %d is the smallest prime number greater than %d\n",
				Utils.nextPrime(number), number);
	}
}

class FactorsApp {
	public static void run(java.util.Scanner kb)
	{
		long number;
		
		Utils.printHelpMsg();
		while ((number = kb.nextLong()) != 0)
			printFactors(number);
	}
	
	public static void printFactors(long number)
	{
		for (long i = 1; i * i <= number; i++)
			if (number % i == 0)
				Utils.printFactor(number, i);
	}
}

class SquareFactorsApp {
	public static void run(java.util.Scanner kb)
	{
		long number;
		
		Utils.printHelpMsg();
		while ((number = kb.nextLong()) != 0)
			printSquareFactors(number);
	}
	
	public static void printSquareFactors(long number)
	{
		for (long i = 2; Math.pow(i, 4) <= number; i++)
			if (number % (i * i) == 0)
				Utils.printFactor(number, i * i);
	}
}

class PrimeFactorsApp {
	public static void run(java.util.Scanner kb)
	{
		long number;
		
		Utils.printHelpMsg();
		while ((number = kb.nextLong()) != 0)
			printPrimeFactors(number);
	}
	
	public static void printPrimeFactors(long number)
	{
		boolean isFirstPrint = true;
		
		System.out.printf("%d = ", number);
		for (long i = 2; i <= number; i = Utils.nextPrime(i)) {
			long exp = Utils.getFactorExp(number, i);
			if (exp == 0)
				continue;
			if (!isFirstPrint)
				System.out.print(" * ");
			printPrimeFactor(i, exp);
			if (isFirstPrint)
				isFirstPrint = false;
			number /= Math.pow(i, exp);
		}
		System.out.println();
	}
	
	public static void printPrimeFactor(long prime, long exp)
	{
		System.out.printf("%d^%d", prime, exp);
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
	
	public static long getFactorExp(long number, long factor)
	{
		long exp = 0;
		
		while (number % factor == 0) {
			exp++;
			number /= factor;
		}
		return exp;
	}
	
	public static void printHelpMsg()
	{
		System.out.println("> Keep entering integers. Enter 0 to return to menu:");
	}
	
	public static void printFactor(long number, long factor)
	{
		System.out.printf("> %d = %d * %d%n", number, factor, number / factor);
	}
}