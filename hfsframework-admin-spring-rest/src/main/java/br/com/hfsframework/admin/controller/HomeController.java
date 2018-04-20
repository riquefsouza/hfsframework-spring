/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeController.
 */
@Controller
@ApiIgnore
public class HomeController {
	
	//@Value("${server.contextPath}")
	//private String baseURL;

	/**
	 * Index.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/")
	public String index() {
		return "redirect:swagger-ui.html";
	}
}
