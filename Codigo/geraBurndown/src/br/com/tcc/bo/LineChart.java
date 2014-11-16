package br.com.tcc.bo;

import java.util.Date;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import br.com.tcc.util.DataUtil;

public class LineChart extends JFrame {

	private static final long serialVersionUID = 1L;

	public LineChart(String applicationTitle, String chartTitle, Map<Date,Double> grafico, Double totalHoras, Double queimaDiariaIdeal) {
		
		super(applicationTitle);
		// based on the dataset we create the chart
		JFreeChart chart = createChart(chartTitle, grafico, totalHoras, queimaDiariaIdeal);
	    // we put the chart into a panel
	    ChartPanel chartPanel = new ChartPanel(chart);
	    // default size
	        
	    chartPanel.setPreferredSize(new java.awt.Dimension(800, 370));
	    // add it to our application
	    setContentPane(chartPanel);
	}

	public LineChart(String applicationTitle, String chartTitle, Map<Date,Integer> grafico, Integer totalPontos, Double queimaDiariaIdeal) {
		
		super(applicationTitle);
		// based on the dataset we create the chart
		JFreeChart chart = createChartPontos(chartTitle, grafico, totalPontos, queimaDiariaIdeal);
		// we put the chart into a panel
		ChartPanel chartPanel = new ChartPanel(chart);
		
		// default size
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 370));
		// add it to our application
		setContentPane(chartPanel);
	}
	  
	//Creates a chart
	private JFreeChart createChart(String title, Map<Date,Double> grafico, Double totalHoras, Double queimaDiariaIdeal) {
	        
		Double totalHorasIdeal = totalHoras;
	    	
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		//ds.addValue(totalHoras, "real", "0");
		//ds.addValue(totalHoras, "ideal", "0");
	    	
		for (Date data : grafico.keySet()) {
			if (grafico.get(data) != null){
				totalHoras = totalHoras - grafico.get(data);
				ds.addValue(totalHoras, "real", DataUtil.dateToString(data));
			}
			else{
				ds.addValue(null, "real", DataUtil.dateToString(data));
			}
			totalHorasIdeal = totalHorasIdeal - queimaDiariaIdeal;
			ds.addValue(totalHorasIdeal, "ideal", DataUtil.dateToString(data));
		}
		JFreeChart chart = ChartFactory.createLineChart(title, "Date", "Remaining Work", ds);

		return chart;
	}
	    
	//Creates a chart
	private JFreeChart createChartPontos(String title, Map<Date,Integer> grafico, Integer totalPontos, Double queimaDiariaIdeal) {
	        
		Integer totalPontosIdeal = totalPontos;
	    	
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		//ds.addValue(totalHoras, "real", "0");
		//ds.addValue(totalHoras, "ideal", "0");
	    	
		for (Date data : grafico.keySet()) {
			if (grafico.get(data) != null){
				totalPontos = totalPontos - grafico.get(data);
				ds.addValue(totalPontos, "real", DataUtil.dateToString(data));
			}
			else{
				ds.addValue(null, "real", DataUtil.dateToString(data));
			}
			totalPontosIdeal = totalPontosIdeal - queimaDiariaIdeal.intValue();
			ds.addValue(totalPontosIdeal, "ideal", DataUtil.dateToString(data));
		}
		JFreeChart chart = ChartFactory.createLineChart(title, "Date", "Remaining Work", ds);

		return chart;
	}
}