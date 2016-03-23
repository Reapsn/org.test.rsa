package reapsn.rsa;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author Reapsn
 * @date 2016��3��23��
 */
public class PrimeNumberUtil {

	private static final List<Integer> PRIME_NUMBERS = new ArrayList<Integer>();

	static {
		PRIME_NUMBERS.add(2);
	}

	public static int generateRandomPrimeNumber(int upperLimit) {

		if (upperLimit < 2) {
			throw new IllegalArgumentException("���� upperLimit ����СֵΪ2");
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
		if ((a <= 0) || (b <= 0) || (a == b)) { // ������������С�ڻ����0
			return false;
		} else if ((a == 1) || (b == 1)) { // �����������У�ֻ������һ����ֵΪ1������������Ϊ������
			return true;
		} else {
			// ������������������Լ��
			int maxCommonFactor = EuclidUtil.gcd(a, b);
			if (maxCommonFactor > 1) {
				// ������Լ������1����ʾ����������������
				return false;
			} else {
				// ������Լ������1,��ʾ��������������
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
