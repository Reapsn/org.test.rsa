package reapsn.rsa;

/**
 * @author Reapsn
 * @date 2016��3��24��
 */
public class ByteUtil {

	public static int[] toBigIntArray(byte[] bytes) {
		if (bytes == null) {
			throw new IllegalArgumentException("���� bytes ����Ϊ null��");
		}
		int[] ints = new int[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			if (bytes[i] >= 0 && bytes[i] < 256) {
				ints[i] = bytes[i];
			} else {
				throw new IllegalStateException("bytes[i] �����ɼ��㷶Χ��");
			}
		}
		return ints;
	}

	public static byte[] toByteArray(int[] ints) {
		if (ints == null) {
			throw new IllegalArgumentException("���� ints ����Ϊ null��");
		}
		byte[] bytes = new byte[ints.length];
		for (int i = 0; i < ints.length; i++) {
			bytes[i] = (byte) ints[i];
		}
		return bytes;
	}

}
