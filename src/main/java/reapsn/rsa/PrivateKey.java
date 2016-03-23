package reapsn.rsa;

/**
 * @author Reapsn
 * @date 2016Äê3ÔÂ23ÈÕ
 */
public class PrivateKey {

	private int p;
	private int q;
	private int n;
	private int ola_n;
	private int e;
	private int d;

	public PrivateKey(int p, int q, int n, int ola_n, int e, int d) {
		super();
		this.p = p;
		this.q = q;
		this.n = n;
		this.ola_n = ola_n;
		this.e = e;
		this.d = d;
	}

	public int getD() {
		return this.d;
	}

	public int getE() {
		return this.e;
	}

	public int getN() {
		return this.n;
	}

	public int getOla_n() {
		return this.ola_n;
	}

	public int getP() {
		return this.p;
	}

	public int getQ() {
		return this.q;
	}

}
