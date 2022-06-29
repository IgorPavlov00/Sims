package Model;

import Model.Enums.TipVozila;

public class Tag {
	private int id;
	private String ime;
	private String prezime;
	private TipVozila tipVozila;
	private int kolicinaNovca;

	public Tag() {
	}

	public Tag(int id) {
		this.id = id;
	}

	public Tag(int id, String ime, String prezime, TipVozila tipVozila, int kolicinaNovca) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.tipVozila = tipVozila;
		this.kolicinaNovca = kolicinaNovca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public TipVozila getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(TipVozila tipVozila) {
		this.tipVozila = tipVozila;
	}

	public int getKolicinaNovca() {
		return kolicinaNovca;
	}

	public void setKolicinaNovca(int kolicinaNovca) {
		this.kolicinaNovca = kolicinaNovca;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", tipVozila=" + tipVozila
				+ ", kolicinaNovca=" + kolicinaNovca + "]";
	}

}
