package reapsn.rsa;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Reapsn
 * @date 2016年3月23日
 */
public class Main {

	public static void main(String[] args) {
		genKeyTest();
		cipherTest();
	}

	public static void cipherTest() {
		KeyPair keyPair = KeyFactory.genearateKeyPair("RSA", 16);

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

	public static void genKeyTest() {
		for (int i = 0; i < 20; i++) {

			System.out.println("Keypair " + (i + 1));

			KeyPair keyPair = KeyFactory.genearateKeyPair("RSA", 16);

			System.out.println(keyPair.toString() + "\n");
		}
	}

}
