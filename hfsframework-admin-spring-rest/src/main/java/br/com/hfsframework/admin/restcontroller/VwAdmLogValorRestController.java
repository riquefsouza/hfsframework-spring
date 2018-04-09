package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.VwAdmLogValor;
import br.com.hfsframework.admin.service.VwAdmLogValorService;
import br.com.hfsframework.base.BaseRestController;

@RestController
@RequestMapping("/vwAdmLogValores")
public class VwAdmLogValorRestController 
	extends BaseRestController<VwAdmLogValor, Long, VwAdmLogValorService> {

}
