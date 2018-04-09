package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmLogColuna;
import br.com.hfsframework.admin.service.AdmLogColunaService;
import br.com.hfsframework.base.BaseRestController;

@RestController
@RequestMapping("/admLogColunas")
public class AdmLogColunaRestController 
	extends BaseRestController<AdmLogColuna, String, AdmLogColunaService> {
}
