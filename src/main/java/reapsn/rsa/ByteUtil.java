package reapsn.rsa;

import java.math.BigInteger;

/**
 * @author Reapsn
 * @date 2016��3��24��
 */
public class ByteUtil {

	public static BigInteger[] toBigIntArray(byte[] bytes) {
		if (bytes == null) {
			throw new IllegalArgumentException("���� bytes ����Ϊ null��");
		}
		BigInteger[] ints = new BigInteger[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			ints[i] = BigInteger.valueOf(bytes[i]);
		}
		return ints;
	}

	public static byte[] toByteArray(BigInteger[] ints) {
		if (ints == null) {
			throw new IllegalArgumentException("���� ints ����Ϊ null��");
		}
		byte[] bytes = new byte[ints.length];
		for (int i = 0; i < ints.length; i++) {
			bytes[i] = ints[i].byteValue();
		}
		return bytes;
	}

}
