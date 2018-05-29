/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class DataUtil.
 */
public final class DataUtil implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant DATA_PADRAO. */
	public static final String DATA_PADRAO = "dd/MM/yyyy";

	/** The Constant DATA_HORA_PADRAO. */
	public static final String DATA_HORA_PADRAO = "dd/MM/yyyy HH:mm:ss";

	/** The Constant DATA_NUMERO_PADRAO. */
	public static final String DATA_NUMERO_PADRAO = "yyyyMMdd";

	/** The Constant DATA_JSON_PADRAO. */
	public static final String DATA_JSON_PADRAO = "YYYY-MM-dd";
	
	/** The Constant DATA_HORA_NUMERO_PADRAO. */
	public static final String DATA_HORA_NUMERO_PADRAO = "yyyyMMddHHmmss";
	
	/** The Constant DATA_HORA_JSON_PADRAO. */
	public static final String DATA_HORA_JSON_PADRAO = "YYYY-MM-dd HH:mm:ss";

	/** The meses. */
	public static String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
			"Setembro", "Outubro", "Novembro", "Dezembro" };

	/**
	 * Pega o the meses.
	 *
	 * @return o the meses
	 */
	public String[] getMeses() {
		return meses;
	}

	/**
	 * Gets the data padrao.
	 *
	 * @return the data padrao
	 */
	public String getDataPadrao() {
		return DATA_PADRAO;
	}

	/**
	 * Gets the data hora padrao.
	 *
	 * @return the data hora padrao
	 */
	public String getDataHoraPadrao() {
		return DATA_HORA_PADRAO;
	}

	/**
	 * Gets the lista ano.
	 *
	 * @return the lista ano
	 */
	public static List<Integer> getListaAno() {
		List<Integer> listaAno = new ArrayList<Integer>();
		for (int i = 1990; i <= 2100; i++) {
			listaAno.add(i);
		}
		return listaAno;
	}

	/**
	 * Gets the local date from date.
	 *
	 * @param data the data
	 * @return the local date from date
	 */
	public static LocalDate getLocalDateFromDate(Date data){
	    GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance();
	    gregorianCalendar.setTime(data);
	    ZonedDateTime zonedDateTime = gregorianCalendar.toZonedDateTime();
	    return zonedDateTime.toLocalDate();	
	}
	
	/*
	public static String Formatar(Date data, String padrao) {
		if (data == null) {
			return "";
		}
		if (padrao.isEmpty()) {
			padrao = DATA_PADRAO;
		}
		LocalDate ld = getLocalDateFromDate(data);  
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern(padrao);
		return ld.format(formatador);		
	}
	*/
	
	/**
	 * Formatar.
	 *
	 * @param data the data
	 * @param padrao the padrao
	 * @return the string
	 */
	public static String Formatar(Date Data, String Padrao) {
		if (Data == null) {
			return "";
		}
		if (Padrao.isEmpty()) {
			Padrao = DATA_PADRAO;
		}
		SimpleDateFormat formatD = new SimpleDateFormat(Padrao);
		return formatD.format(Data).toLowerCase();
	}
	
	/**
	 * To long.
	 *
	 * @param data the data
	 * @param padrao the padrao
	 * @return the long
	 */
	public static Long toLong(Date data, String padrao) {
		if (data == null) {
			return null;
		}
		if (padrao.isEmpty()) {
			padrao = DATA_NUMERO_PADRAO;
		}
		return Long.parseLong(Formatar(data, padrao));
	}
	
	/**
	 * To date.
	 *
	 * @param data the data
	 * @param padrao the padrao
	 * @return the date
	 */
	public static Date toDate(String sdata, String padrao) {
		if (sdata == null || sdata.isEmpty()) {
			return null;
		}
		if (padrao.isEmpty()) {
			padrao = DATA_HORA_PADRAO;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(padrao);
		LocalDate dateTime = LocalDate.parse(sdata, formatter);
		return Date.from(dateTime.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
