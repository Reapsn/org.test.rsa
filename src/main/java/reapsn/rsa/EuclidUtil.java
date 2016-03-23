package reapsn.rsa;

/**
 * @author Reapsn
 * @date 2016��3��23��
 */
public class EuclidUtil {

	private static int x;
	private static int y;

	/**
	 * ŷ������㷨 <br>
	 * շת����� <br>
	 * ��������������Լ��
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static synchronized int gcd(int a, int b) {
		if (b == 0) {
			x = 1;
			y = 0;
			return a;
		}
		int q = gcd(b, a % b);
		int t = x;
		x = y;
		y = t - ((a / b) * y);
		return q;
	}

	/**
	 * ��չŷ������㷨 <br>
	 * ���һ��x��y
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static synchronized int[] gcdEx(int a, int b) {
		gcd(a, b);
		return new int[] { x, y };
	}

}
