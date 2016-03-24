package reapsn.rsa;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Reapsn
 * @date 2016��3��23��
 */
public class Main {

	public static void main(String[] args) {
		genKeyTest();
		cipherTest();
	}

	public static void cipherTest() {
		KeyPair keyPair = KeyFactory.genearateKeyPair("RSA", 16);

		Scanner scanner = new Scanner(System.in);

		System.out.println("���������ģ�");

		String plainText = scanner.nextLine();

		int[] cipherData = RSACipher.encode(keyPair.getPublicKey(), plainText);

		System.out.println("���ܺ�����ģ�");

		System.out.println(Arrays.toString(cipherData));

		String plainText2 = RSACipher.decode(keyPair.getPrivateKey(), cipherData);

		System.out.println("���ܺ�����ģ�");

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
