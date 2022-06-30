package Model;

import java.util.List;

import Model.Enums.TipMesta;
import Model.Enums.TipNaplate;

public class NaplatnoMesto {
	
	private int id;
	private TipNaplate tipNaplate;
	private TipMesta tipMesta;
	private int brojKucice;
	private List<Uredjaj> periferniUredjaji;
	private ReferentNaplate referent;

	public NaplatnoMesto() {
	}

	public NaplatnoMesto(int id, TipNaplate tipNaplate, TipMesta tipMesta, int brojKucice, List<Uredjaj> periferniUredjaji, ReferentNaplate referent) {
		this.id = id;
		this.tipNaplate = tipNaplate;
		this.tipMesta = tipMesta;
		this.brojKucice = brojKucice;
		this.periferniUredjaji = periferniUredjaji;
		this.referent = referent;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipNaplate getTipNaplate() {
		return tipNaplate;
	}

	public void setTipNaplate(TipNaplate tipNaplate) {
		this.tipNaplate = tipNaplate;
	}

	public TipMesta getTipMesta() {
		return tipMesta;
	}

	public void setTipMesta(TipMesta tipMesta) {
		this.tipMesta = tipMesta;
	}

	public int getBrojKucice() {
		return brojKucice;
	}

	public void setBrojKucice(int brojKucice) {
		this.brojKucice = brojKucice;
	}

	public List<Uredjaj> getPeriferniUredjaji() {
		return periferniUredjaji;
	}

	public void setPeriferniUredjaji(List<Uredjaj> periferniUredjaji) {
		this.periferniUredjaji = periferniUredjaji;
	}

	public ReferentNaplate getReferent() {
		return referent;
	}

	public void setReferent(ReferentNaplate referent) {
		this.referent = referent;
	}

	@Override
	public String toString() {
		return "NaplatnoMesto [id=" + id +  ", tipNaplate=" + tipNaplate + ", tipMesta=" + tipMesta + ", brojKucice=" + brojKucice
				+ ", periferniUredjaji=" + periferniUredjaji + ", referent=" + referent + "]";
	}
	public String getNaplatnoId() {
		String niz="";
		for (Uredjaj uredjaj : periferniUredjaji) {
			niz+=uredjaj+",";
		}
		niz=niz.substring(0, niz.length()-1);
		return niz;
	}

}
