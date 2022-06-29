package Model;

import java.time.LocalDate;

public class Naplata {
	private LocalDate vremeUlaska;
	private LocalDate vremeIzlaska;
	private NaplatnaStanica mestoUlaska;
	private NaplatnaStanica mestoIzlaska;
	private String tabliceVozila;
	private float prosecnaBrzina;
	private Cena cena;

	public Naplata() {
	}

	public Naplata(LocalDate vremeUlaska, NaplatnaStanica mestoUlaska, String tabliceVozila, float prosecnaBrzina) {
		this.vremeUlaska = vremeUlaska;
		this.mestoUlaska = mestoUlaska;
		this.tabliceVozila = tabliceVozila;
		this.prosecnaBrzina = prosecnaBrzina;
	}

	public LocalDate getVremeUlaska() {
		return vremeUlaska;
	}

	public void setVremeUlaska(LocalDate vremeUlaska) {
		this.vremeUlaska = vremeUlaska;
	}

	public LocalDate getVremeIzlaska() {
		return vremeIzlaska;
	}

	public void setVremeIzlaska(LocalDate vremeIzlaska) {
		this.vremeIzlaska = vremeIzlaska;
	}

	public NaplatnaStanica getMestoUlaska() {
		return mestoUlaska;
	}

	public void setMestoUlaska(NaplatnaStanica mestoUlaska) {
		this.mestoUlaska = mestoUlaska;
	}

	public NaplatnaStanica getMestoIzlaska() {
		return mestoIzlaska;
	}

	public void setMestoIzlaska(NaplatnaStanica mestoIzlaska) {
		this.mestoIzlaska = mestoIzlaska;
	}

	public String getTabliceVozila() {
		return tabliceVozila;
	}

	public void setTabliceVozila(String tabliceVozila) {
		this.tabliceVozila = tabliceVozila;
	}

	public float getProsecnaBrzina() {
		return prosecnaBrzina;
	}

	public void setProsecnaBrzina(float prosecnaBrzina) {
		this.prosecnaBrzina = prosecnaBrzina;
	}

	public Cena getCena() {
		return cena;
	}

	public void setCena(Cena cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Naplata [vremeUlaska=" + vremeUlaska + ", vremeIzlaska=" + vremeIzlaska + ", mestoUlaska=" + mestoUlaska
				+ ", mestoIzlaska=" + mestoIzlaska + ", tabliceVozila=" + tabliceVozila + ", prosecnaBrzina="
				+ prosecnaBrzina + ", cena=" + cena + "]";
	}

}
