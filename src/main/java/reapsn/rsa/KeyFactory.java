package reapsn.rsa;

/**
 * @author Reapsn
 * @date 2016Äê3ÔÂ23ÈÕ
 */
public class KeyFactory {

	public static KeyPair genearateKeyPair() {
		return genearateKeyPair("RSA");
	}

	public static KeyPair genearateKeyPair(String algrithom) {

		int p = PrimeNumberUtil.generateRandomPrimeNumber(100);
		int q = PrimeNumberUtil.generateRandomPrimeNumber(100, p);
		int n = p * q;
		int ola_n = (p - 1) * (q - 1);
		int e = PrimeNumberUtil.seekRandomNumberIsRelativelyPrimeNumberForOlaN(ola_n);
		int d = EuclidUtil.gcdEx(e, ola_n)[0] > 0 ? EuclidUtil.gcdEx(e, ola_n)[0] : EuclidUtil.gcdEx(e, ola_n)[1];

		return new KeyPair(new PublicKey(n, e), new PrivateKey(p, q, n, ola_n, e, d));
	}

}
