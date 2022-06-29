package Model;

public class Deonica {
	private NaplatnaStanica odStanice;
	private NaplatnaStanica doStanice;

	public Deonica() {
	}

	public Deonica(NaplatnaStanica odStanice, NaplatnaStanica doStanice) {
		this.odStanice = odStanice;
		this.doStanice = doStanice;
	}

	public NaplatnaStanica getOdStanice() {
		return odStanice;
	}

	public void setOdStanice(NaplatnaStanica odStanice) {
		this.odStanice = odStanice;
	}

	public NaplatnaStanica getDoStanice() {
		return doStanice;
	}

	public void setDoStanice(NaplatnaStanica doStanice) {
		this.doStanice = doStanice;
	}

	@Override
	public String toString() {
		return "Deonica [odStanice=" + odStanice + ", doStanice=" + doStanice + "]";
	}

}
