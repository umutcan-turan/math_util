package math_util;

class MathUtilApp {
	public static void main(String [] args)
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		long a = IOUtils.getLong(kb);
		System.out.println(a);
		kb.close();
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

class IOUtils {
	public static long getLong(java.util.Scanner kb)
	{
		// TODO: Properly handle creating and destroying objects
		// TODO: Exception handling
		long number = kb.nextLong();
		return number;
	}
}