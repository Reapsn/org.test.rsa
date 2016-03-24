package reapsn.rsa;

/**
 * @author Reapsn
 * @date 2016��3��23��
 */
public class KeyFactory {

	public static KeyPair genearateKeyPair(String algrithom, int keyLength) {

		if (!"rsa".equalsIgnoreCase(algrithom)) {
			throw new IllegalArgumentException("��֧�ֵ��㷨��" + algrithom);
		}

		if (keyLength < 0 || keyLength % 2 != 0) {
			throw new IllegalArgumentException("���� keyLength ��������ż����");
		}

		if (keyLength > 30) {
			// ����ʹ�õ� int ��������ݣ����� 2 �� 31 �η������ݻ���ָ����������
			throw new IllegalArgumentException("���� keyLength ����С��31��");
		}

		int p = PrimeNumberUtil.generateRandomPrimeNumber((int) Math.pow(2, keyLength / 2));
		int q = PrimeNumberUtil.generateRandomPrimeNumber((int) Math.pow(2, keyLength / 2), p);
		int n = p * q;
		int ola_n = (p - 1) * (q - 1);
		int e = PrimeNumberUtil.seekRandomNumberIsRelativelyPrimeNumberForOlaN(ola_n);
		int d = EuclidUtil.gcdEx(e, ola_n)[0];

		while (d < 1) {
			e = PrimeNumberUtil.seekRandomNumberIsRelativelyPrimeNumberForOlaN(ola_n);
			d = EuclidUtil.gcdEx(e, ola_n)[0];
		}

		return new KeyPair(new PublicKey(n, e), new PrivateKey(p, q, n, ola_n, e, d));
	}

}
