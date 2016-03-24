package reapsn.rsa;

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
			plainData[i] = (int) MontgomeryUtil.PowMod(cipherData[i], privateKey.getD(), privateKey.getN());
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
			cipherData[i] = (int) MontgomeryUtil.PowMod(plainData[i], publicKey.getE(), publicKey.getN());
		}
		return cipherData;
	}

}
