package br.com.tcc.bo;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.tcc.model.Estoria;
import br.com.tcc.model.ItemHistorico;
import br.com.tcc.model.Sprint;
import br.com.tcc.util.DataUtil;

/**
 * Classe de negócio responsável pelos cálculos de geração de gráficos de burndown.
 * @since 16/09/2014
 * @author kessia
 *
 */
public class BurndownBO {

	private double qtdeHorasConsumidas;
	private double qtdeHorasRestantes;
	private double totalHoras;
	private double consumoDiarioIdeal;
	private final static String TITLE_HORAS = "HOUR BURNDOWN CHART- Sprint 01";
	private final static String TITLE_PONTOS = "POINT BURNDOWN CHART- Sprint 01";
	
	/**
	 * @author kessia
	 * @since 16/09/2014
	 * @param sprint
	 */
	public void gerarBurndownHoras(Sprint sprint){
		
		Map<Date,Double> eixoXY = calculaEixosXYHoras(sprint);
		setTotalHoras(sprint.getTotalHoras());
		
		qtdeHorasRestantes = totalHoras - qtdeHorasConsumidas;
		
		setConsumoDiarioIdeal(totalHoras / sprint.getQtdeDias());
		
		LineChart demo = new LineChart("Comparison", TITLE_HORAS, eixoXY, totalHoras, consumoDiarioIdeal);
        demo.pack();
        demo.setVisible(true);
	}
	
	/**
	 * Método responsável por calcular os valores dos eixos X e Y do grafico de burndown, 
	 * onde o eixo X são as datas (dias do sprint) e o Y são as horas.
	 * @author kessia
	 * @since 16/09/2014
	 * @param sprint
	 * @return Map<Date, Double>
	 */
	private Map<Date, Double> calculaEixosXYHoras(Sprint sprint) {
		Map<Date,Double> eixoXY = new LinkedHashMap<Date,Double>();
	     
		//eixoY
		for (ItemHistorico item : sprint.getItensHistorico()) {
			if (eixoXY.get(item.getData()) != null){
				eixoXY.put(item.getData(), eixoXY.get(item.getData()) + item.getTempoGasto());
			} else {
				eixoXY.put(item.getData(), item.getTempoGasto());
			}
			qtdeHorasConsumidas += item.getTempoGasto();
		}
		
		//Dias ainda não trabalhados
		if (eixoXY.size() < sprint.getQtdeDias()){
			for (int i = 0; i < sprint.getQtdeDias(); i++){
				if (!eixoXY.containsKey(DataUtil.adicionarDiasData(sprint.getDtInicio(), i))){
					eixoXY.put(DataUtil.adicionarDiasData(sprint.getDtInicio(), i), null);
				}
			}
		}
		return eixoXY;
	}
	
	/**
	 * Método responsável por realizar os cálculos necessários para a geração do burndown de pontos.
	 * Se alguma estória já foi concluída, a quantidade de pontos "cai" no último dia 
	 * de registro dessa data.
	 * 
	 * @author kessia
	 * @since 23/09/2014
	 * @param sprint
	 * @return
	 */
	public Map<Date,Integer> gerarBurndownPontos(Sprint sprint){
		Integer totalPontos = 0;
		
		for (Estoria estoria : sprint.getEstorias()) {
			totalPontos += estoria.getQtdePontos();
		}
		
		Map<Date, Integer> eixoXY = eixoXYPontos(sprint);

		setConsumoDiarioIdeal(totalHoras / sprint.getQtdeDias());
		
		LineChart demo = new LineChart("Comparison", TITLE_PONTOS, eixoXY, totalPontos, consumoDiarioIdeal);
        demo.pack();
        demo.setVisible(true);
		
		return eixoXY;
	}

	/**
	 * Método responsável por calcular os valores dos eixos X e Y do grafico de burndown de pontos, 
	 * onde o eixo X são as datas (dias do sprint) e o Y são os pontos totais do sprint.
	 * @author kessia
	 * @since 23/09/2014
	 * @param sprint
	 * @return Map<Date, Integer>
	 */
	private Map<Date, Integer> eixoXYPontos(Sprint sprint) {
		Map<Date,Integer> eixoXY = new LinkedHashMap<Date,Integer>();
	    
		//eixoY
		for (ItemHistorico item : sprint.getItensHistorico()) {
			for (Estoria est : sprint.getEstorias()) {
				if (item.getCodEstoria().equals(est.getCodEstoria())){
					est.setTempoGasto(item.getTempoGasto());
					
					if (est.getTempoRestante() == 0){
						if (eixoXY.get(item.getData()) != null){
							eixoXY.put(item.getData(), eixoXY.get(item.getData()) + est.getQtdePontos());
						} else {
							eixoXY.put(item.getData(), est.getQtdePontos());
						}
					}
					
				}
			}
		}
		
		//Dias ainda não trabalhados
		if (eixoXY.size() < sprint.getQtdeDias()){
			for (int i = 0; i < sprint.getQtdeDias(); i++){
				if (!eixoXY.containsKey(DataUtil.adicionarDiasData(sprint.getDtInicio(), i))){
					eixoXY.put(DataUtil.adicionarDiasData(sprint.getDtInicio(), i), null);
				}
			}
		}
		return eixoXY;
	}
	
	public double getQtdeHorasRestantes() {
		return qtdeHorasRestantes;
	}

	public void setQtdeHorasRestantes(double qtdeHorasRestantes) {
		this.qtdeHorasRestantes = qtdeHorasRestantes;
	}

	public double getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(double totalHoras) {
		this.totalHoras = totalHoras;
	}

	public double getQtdeHorasConsumidas() {
		return qtdeHorasConsumidas;
	}


	public void setQtdeHorasConsumidas(double qtdeHorasConsumidas) {
		this.qtdeHorasConsumidas = qtdeHorasConsumidas;
	}


	public double getConsumoDiarioIdeal() {
		return consumoDiarioIdeal;
	}


	public void setConsumoDiarioIdeal(double consumoDiarioIdeal) {
		this.consumoDiarioIdeal = consumoDiarioIdeal;
	}
}
