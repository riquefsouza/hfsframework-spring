package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.service.AdmParametroCategoriaService;
import br.com.hfsframework.base.BaseRestController;

@RestController
@RequestMapping("/admParametroCategorias")
public class AdmParametroCategoriaRestController
		extends BaseRestController<AdmParametroCategoria, Long, AdmParametroCategoriaService> {

}
