package br.com.hfsframework.admin.restcontroller;

import java.math.BigDecimal;
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
	public ResponseEntity<AdmUsuario> findByLogin(@PathVariable String login) {
		Optional<AdmUsuario> obj = servico.findByLogin(login);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj.get());
	}

	@ApiOperation("Find AdmUsuario By login And password")
	@GetMapping(value = "/login", params = { "login", "senha" })
	public ResponseEntity<AdmUsuario> login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
		Optional<AdmUsuario> obj = servico.login(login, senha);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj.get());
	}

	@ApiOperation("Update Login")
	@GetMapping(value = "/updateByLogin", params = { "cpf", "data", "email", "ldapDN", "nome", "matricula",
			"login" })
	public int updateByLogin(@RequestParam("cpf") BigDecimal cpf, @RequestParam("data") Date data,
			@RequestParam("email") String email, @RequestParam("ldapDN") String ldapDN,
			@RequestParam("nome") String nome, @RequestParam("matricula") Long matricula,
			@RequestParam("login") String login) throws TransacaoException {
		return servico.updateByLogin(cpf, data, email, ldapDN, nome, matricula, login);
	}

	@ApiOperation("Update Password")
	@GetMapping(value = "/updateSenha", params = { "login", "senha" })
	public int updateSenha(@RequestParam("login") String login, @RequestParam("senha") String senha) {
		return servico.updateSenha(senha, login);
	}

	@ApiOperation("Find IP Oracle")
	@GetMapping("/findIPByOracle")
	public String findIPByOracle() {
		return servico.findIPByOracle();
	}

	@ApiOperation("Find IP PostgreSQL")
	@GetMapping("/findIPByPostgreSQL")
	public String findIPByPostgreSQL() {
		return servico.findIPByPostgreSQL();
	}

	@ApiOperation("Set Login for PostgreSQL")
	@GetMapping("/setLoginPostgreSQL/{login}")
	public String setLoginPostgreSQL(@PathVariable String login) {
		return servico.setLoginPostgreSQL(login);
	}

	@ApiOperation("Set Ip for PostgreSQL")
	@GetMapping("/setIPPostgreSQL/{ip}")
	public String setIPPostgreSQL(@PathVariable String ip) {
		return servico.setIPPostgreSQL(ip);
	}

	@ApiOperation("Find Banco")
	@GetMapping("/findBanco")
	public String findBanco() {
		return servico.findBanco();
	}

	@ApiOperation("Set Oracle Login And Ip")
	@GetMapping(value = "/setOracleLoginAndIP", params = { "login", "ip" })
	public boolean setOracleLoginAndIP(@RequestParam("login") String login, @RequestParam("ip") String ip) {
		return servico.setOracleLoginAndIP(login, ip);
	}

	@ApiOperation("Get AdmUsuario")
	@GetMapping(value = "/getUsuario", params = { "matricula", "login", "nome", "cpf", "email", "ldapDN" })
	public ResponseEntity<AdmUsuario> getUsuario(@RequestParam("matricula") Long matricula,
			@RequestParam("login") String login, @RequestParam("nome") String nome, @RequestParam("cpf") BigDecimal cpf,
			@RequestParam("email") String email, @RequestParam("ldapDN") String ldapDN) {
		Optional<AdmUsuario> obj = servico.getUsuario(matricula, login, nome, cpf, email, ldapDN);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj.get());
	}
	
	@ApiOperation("List all Usuario IPs")
	@GetMapping("/getListaUsuarioIps")
	public Iterable<UsuarioVO> getListaUsuarioIps() {
		return servico.getListaUsuarioIps();
	}
}
