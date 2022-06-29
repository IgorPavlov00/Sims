package Model;

import Model.Enums.TipVozila;
import Model.Enums.Valuta;

public class Cena {
	private int iznos;
	private Valuta valuta;
	private TipVozila tipVozila;
	private Deonica deonica;

	public Cena() {
	}

	public Cena(int iznos, Valuta valuta, TipVozila tipVozila, Deonica deonica) {
		this.iznos = iznos;
		this.valuta = valuta;
		this.tipVozila = tipVozila;
		this.deonica = deonica;
	}

	public int getIznos() {
		return iznos;
	}

	public void setIznos(int iznos) {
		this.iznos = iznos;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public TipVozila getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(TipVozila tipVozila) {
		this.tipVozila = tipVozila;
	}

	@Override
	public String toString() {
		return "Cena [iznos=" + iznos + ", valuta=" + valuta + ", tipVozila=" + tipVozila + ", deonica=" + deonica
				+ "]";
	}

}
