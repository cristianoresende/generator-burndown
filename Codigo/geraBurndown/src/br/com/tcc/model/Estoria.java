package br.com.tcc.model;

public class Estoria {

	private Integer codEstoria;
	private double tempoRestante;
	private double tempoGasto = 0;
	private double tempoEstimado;
	private Integer qtdePontos;
	
	public double getTempoRestante() {
		return tempoRestante;
	}
	public void setTempoRestante(double tempoRestante) {
		this.tempoRestante = tempoRestante;
	}
	public double getTempoGasto() {
		return tempoGasto;
	}
	public void setTempoGasto(double tempoGasto) {
		this.tempoGasto = this.tempoGasto + tempoGasto;
		this.setTempoRestante(getTempoRestante() - tempoGasto);
	}
	public double getTempoEstimado() {
		return tempoEstimado;
	}
	public void setTempoEstimado(double estimated) {
		this.tempoEstimado = estimated;
		this.tempoRestante = estimated;
	}
	public Integer getCodEstoria() {
		return codEstoria;
	}
	public void setCodEstoria(Integer codEstoria) {
		this.codEstoria = codEstoria;
	}
	public Integer getQtdePontos() {
		return qtdePontos;
	}
	public void setQtdePontos(Integer qtdePontos) {
		this.qtdePontos = qtdePontos;
	}
}
