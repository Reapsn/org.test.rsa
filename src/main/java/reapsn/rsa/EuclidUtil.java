package reapsn.rsa;

/**
 * @author Reapsn
 * @date 2016年3月23日
 */
public class EuclidUtil {

	private static int x;
	private static int y;

	/**
	 * 欧几里得算法 <br>
	 * 辗转相除法 <br>
	 * 求的两个数的最大公约数
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
	 * 扩展欧几里得算法 <br>
	 * 求的一组x和y
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
