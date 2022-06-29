package Model;

import java.util.List;

public class NaplatnaStanica {
	private String naziv;
	private String mesto;
	private List<NaplatnoMesto> naplatnaMesta;
	private SefStanice sefStanice;

	public NaplatnaStanica() {
	}

	public NaplatnaStanica(String naziv, String mesto) {
		this.naziv = naziv;
		this.mesto = mesto;
	}

	public NaplatnaStanica(String naziv, String mesto, List<NaplatnoMesto> naplatnaMesta, SefStanice sefStanice) {
		this.naziv = naziv;
		this.mesto = mesto;
		this.naplatnaMesta = naplatnaMesta;
		this.sefStanice = sefStanice;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public List<NaplatnoMesto> getNaplatnaMesta() {
		return naplatnaMesta;
	}

	public void setNaplatnaMesta(List<NaplatnoMesto> naplatnaMesta) {
		this.naplatnaMesta = naplatnaMesta;
	}

	public SefStanice getSefStanice() {
		return sefStanice;
	}

	public void setSefStanice(SefStanice sefStanice) {
		this.sefStanice = sefStanice;
	}

	@Override
	public String toString() {
		return "NaplatnaStanica [naziv=" + naziv + ", mesto=" + mesto + ", naplatnaMesta=" + naplatnaMesta
				+ ", sefStanice=" + sefStanice + "]";
	}

}
