package br.com.hfsframework.admin.restcontroller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.service.AdmUsuarioService;
import br.com.hfsframework.base.BaseRestController;
import br.com.hfsframework.security.model.UsuarioVO;
import br.com.hfsframework.util.exceptions.TransacaoException;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admUsuarios")
public class AdmUsuarioRestController extends BaseRestController<AdmUsuario, Long, AdmUsuarioService> {

	@ApiOperation("Find AdmUsuario By login")
	@GetMapping("/findByLogin/{login}")
	public ResponseEntity<AdmUsuario> findByLogin(Principal principal, @PathVariable String login) {
		validateUser(principal);
		Optional<AdmUsuario> obj = servico.findByLogin(login);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj.get());
	}

	@ApiOperation("Find AdmUsuario By login And password")
	@GetMapping(value = "/login", params = { "login", "senha" })
	public ResponseEntity<AdmUsuario> login(Principal principal, 
			@RequestParam("login") String login, @RequestParam("senha") String senha) {
		validateUser(principal);
		Optional<AdmUsuario> obj = servico.login(login, senha);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj.get());
	}

	@ApiOperation("Update Login")
	@GetMapping(value = "/updateByLogin", params = { "cpf", "data", "email", "ldapDN", "nome", "matricula",
			"login" })
	public int updateByLogin(Principal principal, 
			@RequestParam("cpf") BigDecimal cpf, @RequestParam("data") Date data,
			@RequestParam("email") String email, @RequestParam("ldapDN") String ldapDN,
			@RequestParam("nome") String nome, @RequestParam("matricula") Long matricula,
			@RequestParam("login") String login) throws TransacaoException {
		validateUser(principal);
		return servico.updateByLogin(cpf, data, email, ldapDN, nome, matricula, login);
	}

	@ApiOperation("Update Password")
	@GetMapping(value = "/updateSenha", params = { "login", "senha" })
	public int updateSenha(Principal principal, 
			@RequestParam("login") String login, @RequestParam("senha") String senha) {
		validateUser(principal);
		return servico.updateSenha(senha, login);
	}

	@ApiOperation("Find IP Oracle")
	@GetMapping("/findIPByOracle")
	public String findIPByOracle(Principal principal) {
		validateUser(principal);
		return servico.findIPByOracle();
	}

	@ApiOperation("Find IP PostgreSQL")
	@GetMapping("/findIPByPostgreSQL")
	public String findIPByPostgreSQL(Principal principal) {
		validateUser(principal);
		return servico.findIPByPostgreSQL();
	}

	@ApiOperation("Set Login for PostgreSQL")
	@GetMapping("/setLoginPostgreSQL/{login}")
	public String setLoginPostgreSQL(Principal principal, @PathVariable String login) {
		validateUser(principal);
		return servico.setLoginPostgreSQL(login);
	}

	@ApiOperation("Set Ip for PostgreSQL")
	@GetMapping("/setIPPostgreSQL/{ip}")
	public String setIPPostgreSQL(Principal principal, @PathVariable String ip) {
		validateUser(principal);
		return servico.setIPPostgreSQL(ip);
	}

	@ApiOperation("Find Banco")
	@GetMapping("/findBanco")
	public String findBanco(Principal principal) {
		validateUser(principal);
		return servico.findBanco();
	}

	@ApiOperation("Set Oracle Login And Ip")
	@GetMapping(value = "/setOracleLoginAndIP", params = { "login", "ip" })
	public boolean setOracleLoginAndIP(Principal principal, 
			@RequestParam("login") String login, @RequestParam("ip") String ip) {
		validateUser(principal);
		return servico.setOracleLoginAndIP(login, ip);
	}

	@ApiOperation("Get AdmUsuario")
	@GetMapping(value = "/getUsuario", params = { "matricula", "login", "nome", "cpf", "email", "ldapDN" })
	public ResponseEntity<AdmUsuario> getUsuario(Principal principal, @RequestParam("matricula") Long matricula,
			@RequestParam("login") String login, @RequestParam("nome") String nome, @RequestParam("cpf") BigDecimal cpf,
			@RequestParam("email") String email, @RequestParam("ldapDN") String ldapDN) {
		validateUser(principal);
		Optional<AdmUsuario> obj = servico.getUsuario(matricula, login, nome, cpf, email, ldapDN);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj.get());
	}
	
	@ApiOperation("List all Usuario IPs")
	@GetMapping("/getListaUsuarioIps")
	public Iterable<UsuarioVO> getListaUsuarioIps(Principal principal) {
		validateUser(principal);
		return servico.getListaUsuarioIps();
	}
}
