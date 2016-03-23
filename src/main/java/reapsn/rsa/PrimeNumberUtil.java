package reapsn.rsa;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author Reapsn
 * @date 2016年3月23日
 */
public class PrimeNumberUtil {

	private static final List<Integer> PRIME_NUMBERS = new ArrayList<Integer>();

	static {
		PRIME_NUMBERS.add(2);
	}

	public static int generateRandomPrimeNumber(int upperLimit) {

		if (upperLimit < 2) {
			throw new IllegalArgumentException("参数 upperLimit 的最小值为2");
		}

		if (PRIME_NUMBERS.get(PRIME_NUMBERS.size() - 1) < upperLimit) {
			List<Integer> numbers = seekPrimeNumber(PRIME_NUMBERS.get(PRIME_NUMBERS.size() - 1) + 1, upperLimit);
			PRIME_NUMBERS.addAll(numbers);
		}

		int closeToUpperIndex = 0;
		for (closeToUpperIndex = 0; closeToUpperIndex < PRIME_NUMBERS.size(); closeToUpperIndex++) {
			if (PRIME_NUMBERS.get(closeToUpperIndex) > upperLimit) {
				closeToUpperIndex--;
				break;
			}
		}

		int randomIndex = RandomUtils.nextInt(0, closeToUpperIndex);

		return PRIME_NUMBERS.get(randomIndex);
	}

	public static int generateRandomPrimeNumber(int upperLimit, int escapedNumber) {
		int prime = 2;
		while (true) {
			prime = generateRandomPrimeNumber(upperLimit);
			if (prime != escapedNumber) {
				break;
			}
		}
		return prime;
	}

	public static boolean isPrimeNumber(int number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}
		for (int i = 2; i < number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isRelativelyPrime(int a, int b) {
		if ((a <= 0) || (b <= 0) || (a == b)) { // 互质整数不能小于或等于0
			return false;
		} else if ((a == 1) || (b == 1)) { // 两个正整数中，只有其中一个数值为1，两个正整数为互质数
			return true;
		} else {
			// 求出两个正整数的最大公约数
			int maxCommonFactor = EuclidUtil.gcd(a, b);
			if (maxCommonFactor > 1) {
				// 如果最大公约数大于1，表示两个正整数不互质
				return false;
			} else {
				// 如果最大公约数等于1,表示两个正整数互质
				return true;
			}
		}
	}

	public static List<Integer> seekPrimeNumber(int lowerLimit, int upperLimit) {
		if (lowerLimit < 2) {
			lowerLimit = 2;
		}
		List<Integer> primeNumbers = new ArrayList<>();
		for (int i = lowerLimit; i <= upperLimit; i++) {
			if (isPrimeNumber(i)) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers;
	}

	public static int seekRandomNumberIsRelativelyPrimeNumberForOlaN(int ola_n) {
		while (true) {
			int number = RandomUtils.nextInt(2, ola_n);
			if (isRelativelyPrime(number, ola_n)) {
				return number;
			}
		}
	}
}
