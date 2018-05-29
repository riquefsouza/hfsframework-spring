/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admPerfil;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.service.AdmPerfilService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmPerfilPropertyEditor.
 */
@Component
public class AdmPerfilPropertyEditor extends PropertyEditorSupport {

	/** The adm perfil service. */
	@Autowired
	private AdmPerfilService admPerfilService;

	/* (non-Javadoc)
	 * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
	 */
	@Override
	public void setAsText(String id) {
		Optional<AdmPerfil> admPerfil = admPerfilService.load(Long.valueOf(id));
		if (admPerfil.isPresent()) {
			setValue(admPerfil.get());
		}
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyEditorSupport#getAsText()
	 */
	@Override
	public String getAsText() {
		AdmPerfil admPerfil = (AdmPerfil) getValue();
		if (admPerfil != null) {
			return admPerfil.getId().toString();
		} else {
			return "";
		}
	}
}
