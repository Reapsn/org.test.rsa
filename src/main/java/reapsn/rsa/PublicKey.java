package reapsn.rsa;

/**
 * @author Reapsn
 * @date 2016Äê3ÔÂ23ÈÕ
 */
public class PublicKey {

	private int n;

	private int e;

	public PublicKey(int n, int e) {
		super();
		this.n = n;
		this.e = e;
	}

	public int getE() {
		return this.e;
	}

	public int getN() {
		return this.n;
	}

}
