package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.VwAdmLog;
import br.com.hfsframework.admin.service.VwAdmLogService;
import br.com.hfsframework.base.BaseRestController;

@RestController
@RequestMapping("/vwAdmLogs")
public class VwAdmLogRestController 
	extends BaseRestController<VwAdmLog, Long, VwAdmLogService> {
}
