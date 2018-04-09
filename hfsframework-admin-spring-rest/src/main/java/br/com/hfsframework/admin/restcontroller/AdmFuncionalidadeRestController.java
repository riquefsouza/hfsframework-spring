package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmFuncionalidade;
import br.com.hfsframework.admin.service.AdmFuncionalidadeService;
import br.com.hfsframework.base.BaseRestController;

@RestController
@RequestMapping("/admFuncionalidades")
public class AdmFuncionalidadeRestController
		extends BaseRestController<AdmFuncionalidade, Long, AdmFuncionalidadeService> {
/*
		extends BaseResourceRestController<AdmFuncionalidade, Long, AdmFuncionalidadeService, AdmFuncionalidadeResource> {

	@ApiOperation("Search with Resource by id")
	@GetMapping(value = "/{id}", produces = "application/json")
	@Override
	public AdmFuncionalidadeResource search(@PathVariable(value="id") Long id) {
		return new AdmFuncionalidadeResource(this, servico.load(id).get());
	}

	@ApiOperation("List all with Resource")
	@GetMapping(produces = "application/json")
	@Override
	public Resources<AdmFuncionalidadeResource> listar() {
		Iterable<AdmFuncionalidade> lista = servico.findAll();
		return AdmFuncionalidadeResource.getLista(this, lista);
	}
	
	@ApiOperation("Pages2")
	@GetMapping("/pages2")
	@ResponseBody
	public BasePageResource<AdmFuncionalidade> pages2(Pageable p) {  
		return new BasePageResource<AdmFuncionalidade>(super.pages(p),"page","size");
	}
*/
}
