package reapsn.rsa;

import java.math.BigInteger;

/**
 * @author Reapsn
 * @date 2016��3��23��
 */
public class Main {

	public static void main(String[] args) {

		KeyPair keyPair = KeyFactory.genearateKeyPair();

		String plainText = "abcd";

		BigInteger[] cipherData = RSACipher.encode(keyPair.getPublicKey(),
				ByteUtil.toBigIntArray(plainText.getBytes()));
		BigInteger[] plainData = RSACipher.decode(keyPair.getPrivateKey(), cipherData);

		System.out.println(new String(ByteUtil.toByteArray(plainData)));
	}

}
