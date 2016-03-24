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

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("d=").append(this.d).append(",");
		buffer.append("e=").append(this.e).append(",");
		buffer.append("n=").append(this.n).append(",");
		buffer.append("ola_n=").append(this.ola_n).append(",");
		buffer.append("p=").append(this.p).append(",");
		buffer.append("q=").append(this.q);
		return buffer.toString();
	}

}
