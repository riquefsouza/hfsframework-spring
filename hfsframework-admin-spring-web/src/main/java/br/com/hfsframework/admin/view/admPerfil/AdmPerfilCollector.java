/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admPerfil;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.service.AdmPerfilService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmPerfilCollector.
 */
//@Component
public class AdmPerfilCollector extends CustomCollectionEditor {

	/** The adm perfil service. */
	//@Autowired
	private AdmPerfilService admPerfilService;
	
    /**
     * Instantiates a new adm perfil collector.
     *
     * @param collectionType the collection type
     */
    @SuppressWarnings("rawtypes")
	public AdmPerfilCollector(Class<? extends Collection> collectionType) {
		super(collectionType);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.propertyeditors.CustomCollectionEditor#convertElement(java.lang.Object)
	 */
	@Override
    protected Object convertElement(Object element) {
        if (element instanceof String) {
            Long id = Long.parseLong((String) element);

            //AdmPerfil admPerfil = new AdmPerfil();
            //admPerfil.setId(id);
            admPerfilService = new AdmPerfilService();
            Optional<AdmPerfil> admPerfil = admPerfilService.load(Long.valueOf(id));
    		if (admPerfil.isPresent()) {            
    			return admPerfil;
    		} else {
    			return null;
    		}
        }
        //throw new RuntimeException(element);
        return null;
    }
	
}
