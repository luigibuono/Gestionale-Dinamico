package model;

public class Impiegato {
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private int matricola;
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
}
