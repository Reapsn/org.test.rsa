package reapsn.rsa;

import java.math.BigInteger;

/**
 * �ɸ������㷨
 *
 * @author gaodq
 * @date 2016��3��24��
 */
public class MontgomeryUtil {

	public static long MulMod(long a, long b, long n) {
		return a * b % n;
	}

	/*
	 * �ɸ������㷨��ģ�����㣬����ֵ remainder = base^pow mod n
	 */
	public static long PowMod(long base, long pow, long n) {
		long a = base;
		long b = pow;
		long remainder = 1;
		while (b > 0) {
			while ((b & 1) <= 0) {
				b >>= 1;
				// a=a * a % n; //
				a = MulMod(a, a, n);
			}
			b--;
			// remainder=a * remainder % n; //
			remainder = MulMod(a, remainder, n);
		}
		if (remainder < 0) {
			throw new IllegalAccessError();
		}
		return remainder;
	}

	public static int PowModDependBigInt(int base, int pow, int n) {
		BigInteger bigB = BigInteger.valueOf(base);
		BigInteger bigRemainder = bigB.pow(pow).mod(BigInteger.valueOf(n));
		return bigRemainder.intValue();
	}

}
