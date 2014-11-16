package br.com.tcc.bo;

import br.com.tcc.model.Estoria;
import br.com.tcc.model.Sprint;

/**
 * Classe de negório responsável pelos cálculos dos valores relativos a sprint
 * @author kessia
 *
 */
public class SprintBO {

	/**
	 * Método responsável por somar o total de horas da sprint baseado
	 * nas horas estimadas para cada estória.
	 * @param sprint
	 * @return
	 */
	public Double calculaTotalHoras(Sprint sprint){

		Double totalHorasSprint = 0.0;
		for (Estoria est : sprint.getEstorias()) {
			totalHorasSprint += est.getTempoRestante();
		}
		
		return totalHorasSprint;
	}
	
	/**
	 * Método responsável por somar o total de pontos da sprint baseado
	 * nos pontos de cada estória.
	 * @param sprint
	 * @return
	 */
	public Integer calculaTotalPontos(Sprint sprint){

		Integer totalPontosSprint = 0;
		for (Estoria est : sprint.getEstorias()) {
			totalPontosSprint += est.getQtdePontos();
		}
		
		return totalPontosSprint;
	}

}
