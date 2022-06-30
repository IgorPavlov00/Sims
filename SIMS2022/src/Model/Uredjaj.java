package Model;

public class Uredjaj {
	private int id;
	private boolean stanje;

	public Uredjaj() {
	}

	public Uredjaj(boolean stanje) {
		this.stanje = stanje;
	}

	public Uredjaj(int id, boolean stanje) {
		this.id = id;
		this.stanje = stanje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return stanje;
	}

	public void setStanje(boolean stanje) {
		this.stanje = stanje;
	}

	@Override
	public String toString() {
		return "Uredjaj [id=" + id + ", stanje=" + stanje + ", getClass()=" + getClass().getSimpleName() + "]";
	}

}
