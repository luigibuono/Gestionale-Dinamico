package model;

import java.util.Date;

public class Storico {
	
private int idStorico;
private int matricola;
private int idRuolo;
private Date dataInizio;
private Date dataFine;


public int getIdRuolo() {
	return idRuolo;
}
public void setIdRuolo(int idRuolo) {
	this.idRuolo = idRuolo;
}
public Date getDataInizio() {
	return dataInizio;
}
public void setDataInizio(Date dataInizio) {
	this.dataInizio = dataInizio;
}
public Date getDataFine() {
	return dataFine;
}
public void setDataFine(Date dataFine) {
	this.dataFine = dataFine;
}

public int getIdStorico() {
	return idStorico;
}
public void setIdStorico(int idStorico) {
	this.idStorico = idStorico;
}
public int getMatricola() {
	return matricola;
}
public void setMatricola(int matricola) {
	this.matricola = matricola;
}

}
