/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.boot.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.hfsframework.AplicacaoBundle;
import br.com.hfsframework.AplicacaoUtil;
import br.com.hfsframework.admin.data.AdmUsuarioRepository;
import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.model.AdmUsuarioIp;
import br.com.hfsframework.admin.model.AdmUsuarioIpPK;
import br.com.hfsframework.base.BaseBusinessService;
import br.com.hfsframework.config.MetadataExtractorIntegrator;
import br.com.hfsframework.security.model.MenuVO;
import br.com.hfsframework.security.model.PaginaVO;
import br.com.hfsframework.security.model.PermissaoVO;
import br.com.hfsframework.security.model.UsuarioAutenticadoVO;
import br.com.hfsframework.security.model.UsuarioVO;
import br.com.hfsframework.util.exceptions.TransacaoException;
import br.com.hfsframework.util.ldap.LdapBundle;
import br.com.hfsframework.util.ldap.LdapUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmUsuarioService.
 */
@Service
public class AdmUsuarioService extends BaseBusinessService<AdmUsuario, Long, AdmUsuarioRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The em. */
	@Autowired
	private EntityManager em;

	/** The adm usuario ip service. */
	@Autowired
	private AdmUsuarioIpService admUsuarioIpService;
	
	@Autowired
	private LdapUtil ldapUtil;
	
	@Autowired
	private AdmPerfilService admPerfilService;

	/** The vw adm funcionario Service. */
	@Autowired
	private AdmFuncionarioService admFuncionarioService;

	/** The aplicacao config. */
	@Autowired
	private AplicacaoBundle aplicacaoBundle;

	/** The aplicacao util. */
	@Autowired
	private AplicacaoUtil aplicacaoUtil;

	/** The usuario autenticado. */
	@Autowired
	protected UsuarioAutenticadoVO usuarioAutenticado;
	
	/** The usuario logado. */
	private AdmUsuario usuarioLogado;
	
	/**
	 * Find by login.
	 *
	 * @param login the login
	 * @return the optional
	 */
	public Optional<AdmUsuario> findByLogin(String login){
		return repositorio.findByLogin(login);
	}
	
	/**
	 * Login.
	 *
	 * @param login the login
	 * @param senha the senha
	 * @return the adm usuario
	 */
	public Optional<AdmUsuario> login(String login, String senha){
		return repositorio.login(login, senha);
	}
	
	/**
	 * Update by login.
	 *
	 * @param cpf the cpf
	 * @param data the data
	 * @param email the email
	 * @param ldapDN the ldap DN
	 * @param nome the nome
	 * @param matricula the matricula
	 * @param login the login
	 * @return the int
	 * @throws TransacaoException the transacao exception
	 */
	@Transactional
	public int updateByLogin(BigDecimal cpf, Date data, String email, String ldapDN, String nome, 
			Long matricula, String login) throws TransacaoException {
		try {
			return repositorio.updateByLogin(cpf, data, email, ldapDN, nome, matricula, login);
		} catch (Exception e) {
			throw new TransacaoException(log, ERRO_UPDATE + e.getMessage(), e);
		}
	}
	
	/**
	 * Update senha.
	 *
	 * @param senha the senha
	 * @param login the login
	 * @return the int
	 * @throws TransacaoException the transacao exception
	 */
	@Transactional
	public int updateSenha(String senha, String login) throws TransacaoException {
		try {
			return repositorio.updateSenha(senha, login);
		} catch (Exception e) {
			throw new TransacaoException(log, ERRO_UPDATE + e.getMessage(), e);
		}
	}
	
	/**
	 * Find IP by oracle.
	 *
	 * @return the string
	 */
	public String findIPByOracle() {
		List<Object> ip = repositorio.findIPByOracle();
		return ip.get(0).toString();
	}

	/**
	 * Find IP by postgre SQL.
	 *
	 * @return the string
	 */
	public String findIPByPostgreSQL() {
		List<Object> ip = repositorio.findIPByPostgreSQL();
		return ip.get(0).toString();
	}

	/**
	 * Atribui o login postgre SQL.
	 *
	 * @param login
	 *            the login
	 * @return the string
	 */
	public String setLoginPostgreSQL(String login) {
		String retorno = repositorio.setLoginPostgreSQL(login);
		return retorno;		
	}

	/**
	 * Atribui o IP postgre SQL.
	 *
	 * @param ip
	 *            the ip
	 * @return the string
	 */
	public String setIPPostgreSQL(String ip) {
		String retorno = repositorio.setIPPostgreSQL(ip);
		return retorno;
	}

	/**
	 * Find banco.
	 *
	 * @return the string
	 * @throws TransacaoException
	 *             the transacao exception
	 */
	public String findBanco() throws TransacaoException {
		String retorno = "";
		
		Metadata metadata = MetadataExtractorIntegrator.INSTANCE.getMetadata();
		
		String dialeto = metadata.getDatabase().getDialect().toString();
		
		
		if (dialeto.indexOf("Oracle") != -1) {
			retorno = "Oracle";
		}
		if (dialeto.indexOf("PostgreSQL") != -1) {
			retorno = "PostgreSQL";
		}
		if (dialeto.indexOf("mysql") != -1) {
			retorno = "MySQL";
		}
		
		/*
		final SQLException[] erro = new SQLException[1];

		if (em.isOpen()) {

			Session session = em.unwrap(Session.class);

			retorno = session.doReturningWork(new ReturningWork<String>() {
				@Override
				public String execute(Connection connection) {
					try {
						if (!connection.isClosed()) {
							DatabaseMetaData dbmd = connection.getMetaData();

							if (dbmd.getDriverName().indexOf("Oracle") != -1) {
								return "Oracle";
							}
							if (dbmd.getDriverName().indexOf("PostgreSQL") != -1) {
								return "PostgreSQL";
							}
							if (dbmd.getDriverName().indexOf("mysql") != -1) {
								return "MySQL";
							}
						}
					} catch (SQLException e) {
						erro[0] = e;
						return e.getMessage();
					}
					return "";
				}
			});

		}

		if (erro.length > 0) {
			if (erro[0] != null) {
				if (!erro[0].getMessage().isEmpty()) {
					throw new TransacaoException(erro[0]);
				}
			}
		}
		*/

		return retorno;
	}

	/*
	 * Atribui o oracle login and IP.
	 *
	 * @param login
	 *            the login
	 * @param ip
	 *            the ip
	 * @return true, if successful
	 * @throws TransacaoException
	 *             the transacao exception
	 *
	public boolean setOracleLoginAndIP(String login, String ip) throws TransacaoException {
		Integer retorno = -1;
		final SQLException[] erro = new SQLException[1];

		if (em.isOpen()) {

			Session session = em.unwrap(Session.class);

			retorno = session.doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) {
					try {
						if (!connection.isClosed()) {
							CallableStatement call = connection.prepareCall("{ call pkg_adm.setar_usuario_ip(?, ?) }");
							call.setString(1, login);
							call.setString(2, ip);
							call.executeUpdate();
						}
					} catch (SQLException e) {
						erro[0] = e;
						return -1;
					}
					return 0;
				}
			});

		}

		if (erro.length > 0) {
			if (erro[0] != null) {
				if (!erro[0].getMessage().isEmpty()) {
					throw new TransacaoException(erro[0]);
				}
			}
		}

		return (retorno == 0);
	}
	*/
	
	public boolean setOracleLoginAndIP(String login, String ip) throws TransacaoException {
		int retorno = -1;
		try {
			StoredProcedureQuery query = em.createStoredProcedureQuery("pkg_adm.setar_usuario_ip");
			
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

			query.setParameter(1, login);
			query.setParameter(2, ip);

			retorno = query.executeUpdate();
		} catch (Exception e) {
			throw new TransacaoException(e);
		}
		return (retorno > 0);
	}

	/**
	 * Gets the usuario.
	 *
	 * @param matricula
	 *            the matricula
	 * @param login
	 *            the login
	 * @param nome
	 *            the nome
	 * @param cpf
	 *            the cpf
	 * @param email
	 *            the email
	 * @param ldapDN
	 *            the ldap DN
	 * @return the usuario
	 * @throws TransacaoException
	 *             the transacao exception
	 */
	@Transactional
	public Optional<AdmUsuario> getUsuario(Long matricula, String login, String nome, 
			BigDecimal cpf, String email, String ldapDN) throws TransacaoException {
		AdmUsuarioIpPK admUsuarioIpPK = new AdmUsuarioIpPK();
		
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String ipAddress = attr.getRequest().getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = attr.getRequest().getRemoteAddr();
		}
		
		admUsuarioIpPK.setIp(ipAddress);
		admUsuarioIpPK.setMatricula(matricula);

		Optional<AdmUsuario> admUsuario = this.load(matricula);
		if (admUsuario.isPresent()) {
			AdmUsuario usuario = new AdmUsuario();
			usuario.setId(matricula);
			usuario.setLogin(login);
			usuario.setNome(nome);
			usuario.setData(new Date());
			usuario.setCpf(cpf);
			usuario.setEmail(email);
			usuario.setLdapDN(ldapDN);
			//this.insert(usuario);
		} 
		/*
		else {
			this.updateByLogin(cpf, new Date(), email, ldapDN, nome, 
					matricula, login);
		}
		 */
		
		admUsuario.get().setIp(admUsuarioIpPK.getIp());
		
		admUsuarioIpService.updateAtivoByMatricula(false, matricula);
		
		Optional<AdmUsuarioIp> admUsuarioIp = admUsuarioIpService.load(admUsuarioIpPK);
		if (!admUsuarioIp.isPresent()) {
			AdmUsuarioIp usuarioIp = new AdmUsuarioIp();
			usuarioIp.setId(admUsuarioIpPK);
			usuarioIp.setAtivo(true);
			admUsuarioIpService.insert(usuarioIp);
		} else {
			admUsuarioIpService.updateAtivoById(true, admUsuarioIpPK);
		}
		
		String banco = findBanco();
		if (banco.equals("Oracle")) {
			setOracleLoginAndIP(admUsuarioIpPK.getMatricula().toString(), admUsuarioIpPK.getIp());
		}
		if (banco.equals("PostgreSQL")) {
			setLoginPostgreSQL(admUsuarioIpPK.getMatricula().toString());
			setIPPostgreSQL(admUsuarioIpPK.getIp());
		}

		return admUsuario;
	}
	
	/**
	 * Gets the lista usuario ips.
	 *
	 * @return the lista usuario ips
	 */
	public List<UsuarioVO> getListaUsuarioIps() {
		List<UsuarioVO> lista = new ArrayList<UsuarioVO>();
		UsuarioVO usuarioVO;
		
		for (AdmUsuario item : findAll()) {
			
			for (AdmUsuarioIp itemIp : item.getAdmUsuarioIps()) {			
				usuarioVO = item.toUsuarioVO();
				usuarioVO.setIp(itemIp.getId().getIp());
				lista.add(usuarioVO);
			}
		}
		
		return lista;
	}
	
	
	public boolean autenticar(Optional<AdmUsuario> admUsuario) throws Exception {
		if (aplicacaoBundle.isHabilitarLDAP()) {
			if (autenticarViaLDAP(admUsuario)) {
				setPropriedades(admUsuario.get().getLogin());
				return true;
			}
		} else {
			if (autenticarViaBanco(admUsuario)) {
				setPropriedades(admUsuario.get().getLogin());
				return true;
			}
		}
		return false;
	}
	
	
	private void setPropriedades(String login) throws Exception {
		this.usuarioAutenticado.setUserName(login);
		if (!aplicacaoUtil.isDebugMode() && aplicacaoBundle.isHabilitarControlePerfil()) {
			
			if (aplicacaoBundle.isHabilitarLDAP()) 
				this.usuarioAutenticado.setFuncionario(admFuncionarioService.load(ldapUtil.getMatricula()).get().toFuncionarioVO());
			else
				this.usuarioAutenticado.setFuncionario(admFuncionarioService.load(usuarioLogado.getId()).get().toFuncionarioVO());
				
			this.usuarioAutenticado.setDisplayName(this.usuarioAutenticado.getFuncionario().getNome());
			this.usuarioAutenticado.setEmail(this.usuarioAutenticado.getFuncionario().getEmail());
			this.usuarioAutenticado.setListaPermissao(admPerfilService.getPermissao(usuarioAutenticado));

			if (!this.usuarioAutenticado.getListaPermissao().isEmpty()){
				this.usuarioAutenticado.setListaMenus(
						admPerfilService.findMenuPaiByPerfil(
								this.usuarioAutenticado.getListaPermissao().get(0).getPerfil()));
				
				this.usuarioAutenticado.setListaAdminMenus(
						admPerfilService.findAdminMenuPaiByPerfil(
								this.usuarioAutenticado.getListaPermissao().get(0).getPerfil()));
			}
			
			//try {
				if (aplicacaoBundle.isHabilitarLDAP()) {
					this.usuarioAutenticado.setUsuario(this.getUsuario(ldapUtil.getMatricula(),
						ldapUtil.getLogin(), ldapUtil.getNome(),
						this.usuarioAutenticado.getFuncionario().getCpf(),
						ldapUtil.getEmail(), ldapUtil.getLdapDN()).get().toUsuarioVO());
				} else {
					this.usuarioAutenticado.setUsuario(this.getUsuario(usuarioAutenticado.getFuncionario().getId(),
							usuarioLogado.getLogin(), usuarioAutenticado.getFuncionario().getNome(),
							this.usuarioAutenticado.getFuncionario().getCpf(),
							usuarioAutenticado.getFuncionario().getEmail(), "").get().toUsuarioVO());
				}
					
				aplicacaoUtil.setUsuarioAutenticado(this.usuarioAutenticado);
			/*	
			} catch (Exception e) {
				gerarMensagemErro(e, e.getMessage());
			}
			*/
			
			this.log.info(this.usuarioAutenticado.getUserName() + " : Setor: "
					+ this.usuarioAutenticado.getFuncionario().getSetor() + ", Perfis: "
					+ this.usuarioAutenticado.getListaPermissao().toString());
			mostrarPerfilURL();
			mostrarMenus();
		}
	}

	/**
	 * Mostrar perfil URL.
	 */
	public void mostrarPerfilURL() {
		for (PermissaoVO permissao : this.usuarioAutenticado.getListaPermissao()) {
			for (PaginaVO pagFuncionalidade : permissao.getPaginasFuncionalidade()) {
				log.info("Perfil: " + permissao.getPerfil().getDescricao() + " -> Funcionalidade Pagina inicial URL: "
						+ pagFuncionalidade.getUrl());
			}
			for (PaginaVO admPagina : permissao.getPaginas()) {
				log.info("Perfil: " + permissao.getPerfil().getDescricao() + " -> Pagina URL: " + admPagina.getUrl());
			}
		}
	}

	/**
	 * Mostrar menus.
	 */
	public void mostrarMenus() {		
		for (MenuVO menu : this.usuarioAutenticado.getListaMenus()) {
			log.info("Menu: " + menu.toString());
		}
		for (MenuVO menu : this.usuarioAutenticado.getListaAdminMenus()) {
			log.info("Menu Admin: " + menu.toString());
		}		
	}
	
	/**
	 * Gets the lista menus.
	 *
	 * @return the lista menus
	 */
	public List<MenuVO> getListaMenus() {
		return this.usuarioAutenticado.getListaMenus();
	}

	/**
	 * Gets the lista admin menus.
	 *
	 * @return the lista admin menus
	 */
	public List<MenuVO> getListaAdminMenus() {
		return this.usuarioAutenticado.getListaAdminMenus();
	}

	/**
	 * Gets the pagina.
	 *
	 * @param idMenu
	 *            the id menu
	 * @return the pagina
	 */
	public PaginaVO getPagina(Long idMenu) {
		return this.usuarioAutenticado.getPaginaByMenu(idMenu);
	}
	
	private boolean autenticarViaBanco(Optional<AdmUsuario> admUsuario) {
		if (!aplicacaoUtil.isDebugMode()) {
			
			//String csenha = DigestUtils.shaHex(senha);
			
			//if (!login.isEmpty() && !csenha.isEmpty()) {
			if (admUsuario.isPresent()) {
				//usuarioLogado = this.login(login, csenha);
				usuarioLogado = admUsuario.get();
				return (usuarioLogado!=null);
			}
		} else {
			return true;
		}
		return false;
	}
	
	private boolean autenticarViaLDAP(Optional<AdmUsuario> admUsuario) {
		if (!aplicacaoUtil.isDebugMode()) {
			//if (!login.isEmpty() && !senha.isEmpty()) {
			if (admUsuario.isPresent()) {
				LdapBundle config = new LdapBundle();
				log.info(config.toString());
				ldapUtil.configurar(config);
				ldapUtil.setListaLdapAtributo(ldapUtil.getAtributos(admUsuario.get().getLogin()));
				
				return ldapUtil.login(admUsuario.get().getLogin(), admUsuario.get().getSenha());
			}
		} else {
			return true;
		}

		return false;
	}
	
	public UsuarioAutenticadoVO getUsuarioAutenticado() {
		return usuarioAutenticado;
	}
	
}
