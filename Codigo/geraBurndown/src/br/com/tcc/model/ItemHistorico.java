package br.com.tcc.model;

import java.util.Date;

public class ItemHistorico {

	private Integer codEstoria;
	private Date data;
	private double tempoGasto;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getTempoGasto() {
		return tempoGasto;
	}
	public void setTempoGasto(double tempoGasto) {
		this.tempoGasto = tempoGasto;
	}
	public Integer getCodEstoria() {
		return codEstoria;
	}
	public void setCodEstoria(Integer codEstoria) {
		this.codEstoria = codEstoria;
	}
}
