/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.template;

import java.io.IOException;

import br.com.hfsframework.template.TemplateEnum;
import br.com.hfsframework.template.TemplateUtil;
import freemarker.template.TemplateException;

// TODO: Auto-generated Javadoc
/**
 * The Class TemplateUtil.
 */
public class TemplateExemplo {

	/** The Constant pacote. */
	private static final String pacote = "br.com.hfsframework.admin";
	
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TemplateException
	 *             the template exception
	 */
	public static void main(String[] args) throws IOException, TemplateException {
		String[][] classes = {		
				{"AdmMenu", "Long"},
				{"AdmPagina", "Long"},
				{"AdmParametro", "Long"},
				{"AdmParametroCategoria", "Long"},
				{"AdmPerfil", "Long"},
				{"AdmUsuario", "Long"},
				{"VwAdmLog", "Long"},
				{"VwAdmLogValor", "Long"}
		};
		
        String saida = "C:/VM";
        
        String caminhoModelo = "";
        //String caminhoModelo = "C:/demoiselle3/workspace/hfssistema/src/main/java/br/com/hfsframework/template";
        
        TemplateUtil.gerarCodigoFonte(TemplateEnum.CadastroController, caminhoModelo, pacote, classes, saida);
        TemplateUtil.gerarCodigoFonte(TemplateEnum.RelController, caminhoModelo, pacote, classes, saida);
	}

}
