package br.com.tcc.model;

import java.util.Date;
import java.util.List;

public class Sprint {

	private List<Estoria> estorias;
	private List<ItemHistorico> itensHistorico;
	private Date dtInicio;
	private Date dtFim;
	private int qtdeDias;
	private Double totalHoras;
	
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	public Date getDtFim() {
		return dtFim;
	}
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	public List<Estoria> getEstorias() {
		return estorias;
	}
	public void setEstorias(List<Estoria> estorias) {
		this.estorias = estorias;
	}
	public Double getTotalHoras() {
		return totalHoras;
	}
	public void setTotalHoras(Double totalHoras) {
		this.totalHoras = totalHoras;
	}
	public int getQtdeDias() {
		return qtdeDias;
	}
	public void setQtdeDias(int qtdeDias) {
		this.qtdeDias = qtdeDias;
	}
	public List<ItemHistorico> getItensHistorico() {
		return itensHistorico;
	}
	public void setItensHistorico(List<ItemHistorico> itensHistorico) {
		this.itensHistorico = itensHistorico;
	}
}
