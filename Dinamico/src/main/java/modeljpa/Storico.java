package modeljpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the storico database table.
 * 
 */
@Entity
@NamedQuery(name="Storico.findAll", query="SELECT s FROM Storico s")
public class Storico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idstorico;

	@Temporal(TemporalType.DATE)
	private Date datafine;

	@Temporal(TemporalType.DATE)
	private Date datainizio;

	//bi-directional many-to-one association to Impiegato
	@ManyToOne
	@JoinColumn(name="matricola")
	private Impiegato impiegato;

	//bi-directional many-to-one association to Ruolo
	@ManyToOne
	@JoinColumn(name="idruolo")
	private Ruolo ruolo;

	public Storico() {
	}

	public int getIdstorico() {
		return this.idstorico;
	}

	public void setIdstorico(int idstorico) {
		this.idstorico = idstorico;
	}

	public Date getDatafine() {
		return this.datafine;
	}

	public void setDatafine(Date datafine) {
		this.datafine = datafine;
	}

	public Date getDatainizio() {
		return this.datainizio;
	}

	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}

	public Impiegato getImpiegato() {
		return this.impiegato;
	}

	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}

	public Ruolo getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

}