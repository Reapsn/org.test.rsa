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

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("publicKey:\n").append(this.publicKey.toString()).append("\n");
		buffer.append("privateKey:\n").append(this.privateKey.toString());
		return buffer.toString();
	}

}
