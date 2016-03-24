package reapsn.rsa;

import java.math.BigInteger;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Reapsn
 * @date 2016年3月24日
 */
public class RSACipher {

	public static String decode(PrivateKey privateKey, int[] cipherData) {
		if (cipherData == null) {
			throw new IllegalArgumentException("参数 cipherData 不能为 null。");
		}
		int[] plainData = new int[cipherData.length];
		for (int i = 0; i < cipherData.length; i++) {
			BigInteger element = BigInteger.valueOf(cipherData[i]);
			BigInteger pData = element.pow(privateKey.getD()).mod(BigInteger.valueOf(privateKey.getN()));
			plainData[i] = pData.intValue();
		}
		String plainText = new String(Base64.decodeBase64(ByteUtil.toByteArray(plainData)));
		return plainText;
	}

	public static int[] encode(PublicKey publicKey, String plainText) {
		if (plainText == null) {
			throw new IllegalArgumentException("参数 plainData 不能为 null。");
		}
		int[] plainData = ByteUtil.toBigIntArray(Base64.encodeBase64(plainText.getBytes()));
		int[] cipherData = new int[plainData.length];
		for (int i = 0; i < plainData.length; i++) {
			BigInteger element = BigInteger.valueOf(plainData[i]);
			BigInteger cData = element.pow(publicKey.getE()).mod(BigInteger.valueOf(publicKey.getN()));
			cipherData[i] = cData.intValue();
		}
		return cipherData;
	}

}
