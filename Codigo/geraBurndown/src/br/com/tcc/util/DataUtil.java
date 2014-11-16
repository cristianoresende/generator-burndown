package br.com.tcc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

	private static final String FORMATO_DATA = "dd/MM/yyyy";
	
	public static Date converteStringParaDate(String data) throws ParseException{
		if (data == null || data.equals(""))
			return null;
		
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat(FORMATO_DATA);
            date = (java.util.Date)formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
	}
	
	public static String dateToString(Date data){
		SimpleDateFormat formatBra = new SimpleDateFormat(FORMATO_DATA);  
		String result = formatBra.format(data); 
		return (result);  
	}
	
	public static Date adicionarDiasData(Date data, int dias){
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(data);  
		calendar.add(Calendar.DAY_OF_MONTH, dias);  
		return calendar.getTime();  
	}

}
