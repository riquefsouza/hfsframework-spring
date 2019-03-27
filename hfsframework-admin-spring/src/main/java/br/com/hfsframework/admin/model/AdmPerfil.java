/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hfsframework.admin.serializer.AdmPaginaListSerializer;
import br.com.hfsframework.admin.serializer.AdmUsuarioListSerializer;
import br.com.hfsframework.converter.BooleanToStringConverter;
import br.com.hfsframework.security.model.PaginaVO;
import br.com.hfsframework.security.model.PerfilVO;
import br.com.hfsframework.security.model.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the ADM_PERFIL database table.
 * 
 */
@Entity
@Table(name = "ADM_PERFIL")
@NamedQueries({
	@NamedQuery(name = "AdmPerfil.getDescricaoById", query = "SELECT c.descricao FROM AdmPerfil c WHERE c.id = ?1"),
	@NamedQuery(name = "AdmPerfil.countNovo", query = "SELECT COUNT(c) FROM AdmPerfil c WHERE LOWER(c.descricao) = ?1"),
	@NamedQuery(name = "AdmPerfil.countAntigo", query = "SELECT COUNT(c) FROM AdmPerfil c WHERE LOWER(c.descricao) <> ?1 AND LOWER(c.descricao) = ?2"),
	@NamedQuery(name = "AdmPerfil.findPaginasPorPerfil", query = "SELECT distinct pag FROM AdmPerfil p inner join p.admPaginas pag where p = ?1"),
	@NamedQuery(name = "AdmPerfil.findUsuariosPorPerfil", query = "SELECT distinct fp.id.usuarioSeq FROM AdmPerfil p, AdmUsuarioPerfil fp where p.id = fp.id.perfilSeq AND p = ?1"),
	@NamedQuery(name = "AdmPerfil.findPerfisPorUsuario", query = "SELECT distinct p FROM AdmPerfil p, AdmUsuarioPerfil fp where p.id = fp.id.perfilSeq AND fp.id.usuarioSeq = ?1"),	
	@NamedQuery(name = "AdmPerfil.findAdminMenuPaiByPerfil", query="SELECT DISTINCT t FROM AdmMenu t WHERE t.id IN (SELECT m.admMenuPai.id FROM AdmPerfil p INNER JOIN p.admPaginas f INNER JOIN f.admMenus m WHERE p = ?1 AND m.id <= 9) ORDER BY t.ordem, t.id"),
	@NamedQuery(name = "AdmPerfil.findMenuPaiByPerfil", query="SELECT DISTINCT t FROM AdmMenu t WHERE t.id IN (SELECT m.admMenuPai.id FROM AdmPerfil p INNER JOIN p.admPaginas f INNER JOIN f.admMenus m WHERE p = ?1 AND m.id > 9) ORDER BY t.ordem, t.id"),
	@NamedQuery(name = "AdmPerfil.findAdminMenuByPerfil", query="SELECT DISTINCT m FROM AdmPerfil p INNER JOIN p.admPaginas f INNER JOIN f.admMenus m WHERE p = ?1 AND m.id <= 9 AND m.admMenuPai = ?2 ORDER BY m.ordem, m.id"),
	@NamedQuery(name = "AdmPerfil.findMenuByPerfil", query="SELECT DISTINCT m FROM AdmPerfil p INNER JOIN p.admPaginas f INNER JOIN f.admMenus m WHERE p = ?1 AND m.id > 9 AND m.admMenuPai = ?2 ORDER BY m.ordem, m.id"),
	@NamedQuery(name = "AdmPerfil.findAdminMenuPaiByIdPerfis", query="SELECT DISTINCT t FROM AdmMenu t WHERE t.id IN (SELECT m.admMenuPai.id FROM AdmPerfil p INNER JOIN p.admPaginas f INNER JOIN f.admMenus m WHERE p.id IN ?1 AND m.id <= 9) ORDER BY t.id, t.ordem"),
	@NamedQuery(name = "AdmPerfil.findMenuPaiByIdPerfis", query="SELECT DISTINCT t FROM AdmMenu t WHERE t.id IN (SELECT m.admMenuPai.id FROM AdmPerfil p INNER JOIN p.admPaginas f INNER JOIN f.admMenus m WHERE p.id IN ?1 AND m.id > 9) ORDER BY t.ordem, t.id"),
	@NamedQuery(name = "AdmPerfil.findAdminMenuByIdPerfis", query="SELECT DISTINCT m FROM AdmPerfil p INNER JOIN p.admPaginas f INNER JOIN f.admMenus m WHERE p.id IN ?1 AND m.id <= 9 AND m.admMenuPai = ?2 ORDER BY m.id, m.ordem"),
	@NamedQuery(name = "AdmPerfil.findMenuByIdPerfis", query="SELECT DISTINCT m FROM AdmPerfil p INNER JOIN p.admPaginas f INNER JOIN f.admMenus m WHERE p.id IN ?1 AND m.id > 9 AND m.admMenuPai = ?2 ORDER BY m.id, m.ordem")			
})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AdmPerfil implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@SequenceGenerator(name = "ADM_PERFIL_ID_GENERATOR", sequenceName="ADM_PERFIL_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADM_PERFIL_ID_GENERATOR")
	@Column(name = "PRF_SEQ")
	private Long id;

	/** The administrador. */
	@Convert(converter = BooleanToStringConverter.class)
	@Column(name = "PRF_ADMINISTRADOR")
	private Boolean administrador;

	/** The descricao. */
	@NotNull
	@NotBlank
	@NotEmpty	
	@Column(name = "PRF_DESCRICAO", unique = true)
	private String descricao;

	/** The geral. */
	@Convert(converter = BooleanToStringConverter.class)
	@Column(name = "PRF_GERAL")
	private Boolean geral;

	/** The adm paginas. */
	//@JsonIgnore
	@JsonSerialize(using = AdmPaginaListSerializer.class)
	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(fetch = FetchType.EAGER) //, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(name = "ADM_PAGINA_PERFIL", joinColumns = { 
			@JoinColumn(name = "PGL_PRF_SEQ") }, inverseJoinColumns = {	@JoinColumn(name = "PGL_PAG_SEQ") })
	private List<AdmPagina> admPaginas;
	
	/** The adm funcionarios. */
	//@JsonIgnore
	@JsonSerialize(using = AdmUsuarioListSerializer.class)
	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(fetch = FetchType.EAGER) //, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(name = "ADM_USUARIO_PERFIL", joinColumns = {
			@JoinColumn(name = "USP_PRF_SEQ") }, inverseJoinColumns = { @JoinColumn(name = "USP_USU_SEQ") })
	private List<AdmUsuario> admUsuarios;
		

	/**
	 * Instantiates a new adm perfil.
	 */
	public AdmPerfil() {
		super();
		this.admPaginas = new ArrayList<AdmPagina>();
		this.admUsuarios = new ArrayList<AdmUsuario>();
		limpar();
	}
		
	public AdmPerfil(Long id, String descricao, Boolean administrador, Boolean geral) {
		super();
		this.id = id;
		this.administrador = administrador;
		this.descricao = descricao;
		this.geral = geral;
	}

	/**
	 * Instantiates a new adm perfil.
	 *
	 * @param p
	 *            the p
	 */
	public AdmPerfil(PerfilVO p) {
		this();
		
		this.id = p.getId();
		this.administrador = p.getAdministrador();
		this.descricao = p.getDescricao();
		this.geral = p.getGeral();
		for (PaginaVO pagina : p.getPaginas()) {
			this.admPaginas.add(new AdmPagina(pagina));	
		}
		for (UsuarioVO usuario : p.getUsuarios()) {
			this.admUsuarios.add(new AdmUsuario(usuario));	
		}
	}

	/**
	 * Limpar.
	 */
	public void limpar() {
		this.id = null;
		this.administrador = null;
		this.descricao = null;
		this.geral = null;
		this.admPaginas.clear();
		this.admUsuarios.clear();		
	}

	/**
	 * Pega o the id.
	 *
	 * @return o the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Atribui o the id.
	 *
	 * @param id
	 *            o novo the id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Pega o the administrador.
	 *
	 * @return o the administrador
	 */
	public Boolean getAdministrador() {
		return this.administrador;
	}

	/**
	 * Atribui o the administrador.
	 *
	 * @param administrador
	 *            o novo the administrador
	 */
	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

	/**
	 * Pega o the descricao.
	 *
	 * @return o the descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Atribui o the descricao.
	 *
	 * @param descricao
	 *            o novo the descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Pega o the geral.
	 *
	 * @return o the geral
	 */
	public Boolean getGeral() {
		return this.geral;
	}

	/**
	 * Atribui o the geral.
	 *
	 * @param geral
	 *            o novo the geral
	 */
	public void setGeral(Boolean geral) {
		this.geral = geral;
	}

	/**
	 * Pega o the adm paginas.
	 *
	 * @return o the adm paginas
	 */
	public List<AdmPagina> getAdmPaginas() {
		return this.admPaginas;
	}

	/**
	 * Atribui o the adm paginas.
	 *
	 * @param admPaginas
	 *            o novo the adm paginas
	 */
	public void setAdmPaginas(List<AdmPagina> admPaginas) {
		this.admPaginas = admPaginas;
	}

	/**
	 * Gets the adm usuarios.
	 *
	 * @return the adm usuarios
	 */
	public List<AdmUsuario> getAdmUsuarios() {
		return admUsuarios;
	}

	/**
	 * Sets the adm usuarios.
	 *
	 * @param admUsuarios
	 *            the new adm usuarios
	 */
	public void setAdmUsuarios(List<AdmUsuario> admUsuarios) {
		this.admUsuarios = admUsuarios;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdmPerfil other = (AdmPerfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return descricao;
	}
	
	/**
	 * To perfil VO.
	 *
	 * @return the perfil VO
	 */
	public PerfilVO toPerfilVO(){
		PerfilVO p = new PerfilVO();
		p.setId(id);
		p.setAdministrador(administrador);
		p.setDescricao(descricao);
		p.setGeral(geral);
		for (AdmPagina admPagina : admPaginas) {
			p.getPaginas().add(admPagina.toPaginaVO());
		}
		for (AdmUsuario admUsuario : admUsuarios) {
			p.getUsuarios().add(admUsuario.toUsuarioVO());
		}
		return p;
	}
}