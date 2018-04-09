package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.service.AdmPaginaService;
import br.com.hfsframework.base.BaseRestController;

@RestController
@RequestMapping("/admPaginas")
public class AdmPaginaRestController 
	extends BaseRestController<AdmPagina, Long, AdmPaginaService> {
}
