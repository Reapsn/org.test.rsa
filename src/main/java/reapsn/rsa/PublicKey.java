package reapsn.rsa;

/**
 * @author Reapsn
 * @date 2016��3��23��
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

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("e=").append(this.e).append(",");
		buffer.append("n=").append(this.n);
		return buffer.toString();
	}

}
