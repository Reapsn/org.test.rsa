package reapsn.rsa;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Reapsn
 * @date 2016年3月23日
 */
public class Main {

	public static void main(String[] args) {
		genKeyTest(30);
		cipherTest(30);
	}

	public static void cipherTest(int keyLength) {
		KeyPair keyPair = KeyFactory.genearateKeyPair("RSA", keyLength);

		Scanner scanner = new Scanner(System.in);

		System.out.println("请输入明文：");

		String plainText = scanner.nextLine();

		int[] cipherData = RSACipher.encode(keyPair.getPublicKey(), plainText);

		System.out.println("加密后的密文：");

		System.out.println(Arrays.toString(cipherData));

		String plainText2 = RSACipher.decode(keyPair.getPrivateKey(), cipherData);

		System.out.println("解密后的明文：");

		System.out.println(plainText2);
	}

	public static void genKeyTest(int keyLength) {
		for (int i = 0; i < 20; i++) {

			System.out.println("Keypair " + (i + 1));

			KeyPair keyPair = KeyFactory.genearateKeyPair("RSA", keyLength);

			System.out.println(keyPair.toString() + "\n");
		}
	}

}
