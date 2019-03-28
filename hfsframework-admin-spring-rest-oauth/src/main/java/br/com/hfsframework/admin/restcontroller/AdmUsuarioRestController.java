/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.restcontroller;

import java.math.BigDecimal;
import java.security.Principal;
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

// TODO: Auto-generated Javadoc
/**
 * The Class AdmUsuarioRestController.
 */
@RestController
@RequestMapping("/admUsuarios")
public class AdmUsuarioRestController extends BaseRestController<AdmUsuario, Long, AdmUsuarioService> {

	/**
	 * Find by login.
	 *
	 * @param principal the principal
	 * @param login the login
	 * @return the response entity
	 */
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

	/**
	 * Login.
	 *
	 * @param principal the principal
	 * @param login the login
	 * @param senha the senha
	 * @return the response entity
	 */
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

	/**
	 * Update by login.
	 *
	 * @param principal the principal
	 * @param cpf the cpf
	 * @param email the email
	 * @param ldapDN the ldap DN
	 * @param nome the nome
	 * @param matricula the matricula
	 * @param login the login
	 * @return the int
	 * @throws TransacaoException the transacao exception
	 */
	@ApiOperation("Update Login")
	@GetMapping(value = "/updateByLogin", params = { "cpf", "email", "ldapDN", "nome", "matricula",
			"login" })
	public int updateByLogin(Principal principal, 
			@RequestParam("cpf") BigDecimal cpf, @RequestParam("email") String email, @RequestParam("ldapDN") String ldapDN,
			@RequestParam("nome") String nome, @RequestParam("matricula") Long matricula,
			@RequestParam("login") String login) throws TransacaoException {
		validateUser(principal);
		return servico.updateByLogin(cpf, email, ldapDN, nome, matricula, login);
	}

	/**
	 * Update senha.
	 *
	 * @param principal the principal
	 * @param login the login
	 * @param senha the senha
	 * @return the int
	 */
	@ApiOperation("Update Password")
	@GetMapping(value = "/updateSenha", params = { "login", "senha" })
	public int updateSenha(Principal principal, 
			@RequestParam("login") String login, @RequestParam("senha") String senha) {
		validateUser(principal);
		return servico.updateSenha(senha, login);
	}

	/**
	 * Find IP by oracle.
	 *
	 * @param principal the principal
	 * @return the string
	 */
	@ApiOperation("Find IP Oracle")
	@GetMapping("/findIPByOracle")
	public String findIPByOracle(Principal principal) {
		validateUser(principal);
		return servico.findIPByOracle();
	}

	/**
	 * Find IP by postgre SQL.
	 *
	 * @param principal the principal
	 * @return the string
	 */
	@ApiOperation("Find IP PostgreSQL")
	@GetMapping("/findIPByPostgreSQL")
	public String findIPByPostgreSQL(Principal principal) {
		validateUser(principal);
		return servico.findIPByPostgreSQL();
	}

	/**
	 * Sets the login postgre SQL.
	 *
	 * @param principal the principal
	 * @param login the login
	 * @return the string
	 */
	@ApiOperation("Set Login for PostgreSQL")
	@GetMapping("/setLoginPostgreSQL/{login}")
	public String setLoginPostgreSQL(Principal principal, @PathVariable String login) {
		validateUser(principal);
		return servico.setLoginPostgreSQL(login);
	}

	/**
	 * Sets the IP postgre SQL.
	 *
	 * @param principal the principal
	 * @param ip the ip
	 * @return the string
	 */
	@ApiOperation("Set Ip for PostgreSQL")
	@GetMapping("/setIPPostgreSQL/{ip}")
	public String setIPPostgreSQL(Principal principal, @PathVariable String ip) {
		validateUser(principal);
		return servico.setIPPostgreSQL(ip);
	}

	/**
	 * Find banco.
	 *
	 * @param principal the principal
	 * @return the string
	 */
	@ApiOperation("Find Banco")
	@GetMapping("/findBanco")
	public String findBanco(Principal principal) {
		validateUser(principal);
		return servico.findBanco();
	}

	/**
	 * Sets the oracle login and IP.
	 *
	 * @param principal the principal
	 * @param login the login
	 * @param ip the ip
	 * @return true, if successful
	 */
	@ApiOperation("Set Oracle Login And Ip")
	@GetMapping(value = "/setOracleLoginAndIP", params = { "login", "ip" })
	public boolean setOracleLoginAndIP(Principal principal, 
			@RequestParam("login") String login, @RequestParam("ip") String ip) {
		validateUser(principal);
		return servico.setOracleLoginAndIP(login, ip);
	}

	/**
	 * Gets the usuario.
	 *
	 * @param principal the principal
	 * @param matricula the matricula
	 * @param login the login
	 * @param nome the nome
	 * @param cpf the cpf
	 * @param email the email
	 * @param ldapDN the ldap DN
	 * @return the usuario
	 */
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
	
	/**
	 * Gets the lista usuario ips.
	 *
	 * @param principal the principal
	 * @return the lista usuario ips
	 */
	@ApiOperation("List all Usuario IPs")
	@GetMapping("/getListaUsuarioIps")
	public Iterable<UsuarioVO> getListaUsuarioIps(Principal principal) {
		validateUser(principal);
		return servico.getListaUsuarioIps();
	}
}
