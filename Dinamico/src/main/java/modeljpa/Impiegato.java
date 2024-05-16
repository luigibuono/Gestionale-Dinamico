package modeljpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the impiegato database table.
 * 
 */
@Entity
@NamedQuery(name="Impiegato.findAll", query="SELECT i FROM Impiegato i")
public class Impiegato implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private String codicefiscale;

	private String cognome;


	private int idreparto;

	@Id
	private int matricola;

	private String nome;

	//bi-directional many-to-one association to Storico
	@OneToMany(mappedBy="impiegato")
	private List<Storico> storicos;

	public Impiegato() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodicefiscale() {
		return this.codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}



	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getIdreparto() {
		return this.idreparto;
	}

	public void setIdreparto(int idreparto) {
		this.idreparto = idreparto;
	}

	public int getMatricola() {
		return this.matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Storico> getStoricos() {
		return this.storicos;
	}

	public void setStoricos(List<Storico> storicos) {
		this.storicos = storicos;
	}

	public Storico addStorico(Storico storico) {
		getStoricos().add(storico);
		storico.setImpiegato(this);

		return storico;
	}

	public Storico removeStorico(Storico storico) {
		getStoricos().remove(storico);
		storico.setImpiegato(null);

		return storico;
	}

}