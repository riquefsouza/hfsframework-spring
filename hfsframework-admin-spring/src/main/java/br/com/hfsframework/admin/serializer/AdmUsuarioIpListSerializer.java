package br.com.hfsframework.admin.serializer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.hfsframework.admin.model.AdmUsuarioIp;
import br.com.hfsframework.admin.model.AdmUsuarioIpPK;

public class AdmUsuarioIpListSerializer extends StdSerializer<List<AdmUsuarioIp>> {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(AdmUsuarioIpListSerializer.class);

	public AdmUsuarioIpListSerializer() {
		this(null);
	}

	public AdmUsuarioIpListSerializer(Class<List<AdmUsuarioIp>> t) {
		super(t);
	}

	@Override
	public void serialize(List<AdmUsuarioIp> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		Method metodo;
		AdmUsuarioIpPK valor;
		List<AdmUsuarioIpPK> ids = new ArrayList<AdmUsuarioIpPK>();

		for (AdmUsuarioIp item : items) {
			metodo = ReflectionUtils.findMethod(item.getClass(), "getId");
			valor = (AdmUsuarioIpPK) ReflectionUtils.invokeMethod(metodo, item);

			try {
				ids.add(valor);
			} catch (IllegalArgumentException e) {
				log.error(e.getMessage());
			}
		}
		generator.writeObject(ids);
	}
}
