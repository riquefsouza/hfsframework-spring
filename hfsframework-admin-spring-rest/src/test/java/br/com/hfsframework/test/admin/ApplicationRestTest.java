/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.test.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationTest.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({	
	AdmMenuRestTest.class,
	AdmPaginaRestTest.class,
	AdmParametroRestTest.class,
	AdmParametroCategoriaRestTest.class,
	AdmPerfilRestTest.class,
	AdmUsuarioRestTest.class,
	VwAdmLogRestTest.class,
	VwAdmLogValorRestTest.class
})
public class ApplicationRestTest {

	/**
	 * Context loads.
	 */
	@Test
	public void contextLoads() {
	}

}
