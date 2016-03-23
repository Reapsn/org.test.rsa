package reapsn.rsa;

import java.math.BigInteger;

/**
 * @author Reapsn
 * @date 2016年3月24日
 */
public class RSACipher {

	public static BigInteger[] decode(PrivateKey privateKey, BigInteger[] cipherData) {
		if (cipherData == null) {
			throw new IllegalArgumentException("参数 cipherData 不能为 null。");
		}
		BigInteger[] plainData = new BigInteger[cipherData.length];
		for (int i = 0; i < cipherData.length; i++) {
			BigInteger element = cipherData[i];
			BigInteger pData = element.pow(privateKey.getD()).mod(BigInteger.valueOf(privateKey.getN()));
			plainData[i] = pData;
		}
		return plainData;
	}

	public static BigInteger[] encode(PublicKey publicKey, BigInteger[] plainData) {
		if (plainData == null) {
			throw new IllegalArgumentException("参数 plainData 不能为 null。");
		}
		BigInteger[] cipherData = new BigInteger[plainData.length];
		for (int i = 0; i < plainData.length; i++) {
			BigInteger element = plainData[i];
			BigInteger cData = element.pow(publicKey.getE()).mod(BigInteger.valueOf(publicKey.getN()));
			cipherData[i] = cData;
		}
		return cipherData;
	}

}
