package br.com.hfsframework.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The Class BooleanToStringConverter.
 */
@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 */
	@Override
	public String convertToDatabaseColumn(Boolean value) {
		return (value != null && value) ? "S" : "N";
	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public Boolean convertToEntityAttribute(String value) {
		return "S".equals(value);
	}

}
