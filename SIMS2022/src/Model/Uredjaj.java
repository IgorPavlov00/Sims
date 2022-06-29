package Model;

public class Uredjaj {
	private boolean stanje;

	public Uredjaj() {
	}

	public Uredjaj(boolean stanje) {
		this.stanje = stanje;
	}

	public boolean isEnabled() {
		return stanje;
	}

	public void setStanje(boolean stanje) {
		this.stanje = stanje;
	}

	@Override
	public String toString() {
		return "Uredjaj [stanje=" + stanje + "]";
	}

}
