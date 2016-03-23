package reapsn.rsa;

/**
 * @author Reapsn
 * @date 2016Äê3ÔÂ23ÈÕ
 */
public class KeyPair {

	private PublicKey publicKey;
	private PrivateKey privateKey;

	public KeyPair(PublicKey publicKey, PrivateKey privateKey) {
		super();
		this.publicKey = publicKey;
		this.privateKey = privateKey;
	}

	public PrivateKey getPrivateKey() {
		return this.privateKey;
	}

	public PublicKey getPublicKey() {
		return this.publicKey;
	}

}
