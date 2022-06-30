package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Naplata {
	private LocalTime vremeUlaska;
	private LocalTime vremeIzlaska;
	private NaplatnaStanica mestoUlaska;
	private NaplatnaStanica mestoIzlaska;
	private String tabliceVozila;
	private float prosecnaBrzina;
	private Cena cena;

	public Naplata() {
	}

	public Naplata(LocalTime vremeUlaska, NaplatnaStanica mestoUlaska, String tabliceVozila, float prosecnaBrzina) {
		this.vremeUlaska = vremeUlaska;
		this.mestoUlaska = mestoUlaska;
		this.tabliceVozila = tabliceVozila;
		this.prosecnaBrzina = prosecnaBrzina;
	}

	public Naplata(LocalTime vremeUlaska, LocalTime vremeIzlaska, NaplatnaStanica mestoUlaska,
			NaplatnaStanica mestoIzlaska, String tabliceVozila, float prosecnaBrzina, Cena cena) {
		this.vremeUlaska = vremeUlaska;
		this.vremeIzlaska = vremeIzlaska;
		this.mestoUlaska = mestoUlaska;
		this.mestoIzlaska = mestoIzlaska;
		this.tabliceVozila = tabliceVozila;
		this.prosecnaBrzina = prosecnaBrzina;
		this.cena = cena;
	}

	public LocalTime getVremeUlaska() {
		return vremeUlaska;
	}

	public void setVremeUlaska(LocalTime vremeUlaska) {
		this.vremeUlaska = vremeUlaska;
	}

	public LocalTime getVremeIzlaska() {
		return vremeIzlaska;
	}

	public void setVremeIzlaska(LocalTime vremeIzlaska) {
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
		return "Naplata [vremeUlaska=" + vremeUlaska.format(DateTimeFormatter.ofPattern("HH:mm")) + ", vremeIzlaska=" + vremeIzlaska.format(DateTimeFormatter.ofPattern("HH:mm")) + ", mestoUlaska=" + mestoUlaska
				+ ", mestoIzlaska=" + mestoIzlaska + ", tabliceVozila=" + tabliceVozila + ", prosecnaBrzina="
				+ prosecnaBrzina + ", cena=" + cena + "]";
	}

}
