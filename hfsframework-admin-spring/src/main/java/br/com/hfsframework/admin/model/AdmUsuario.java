/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hfsframework.admin.serializer.AdmUsuarioIpListSerializer;
import br.com.hfsframework.security.model.UsuarioVO;
import br.com.hfsframework.util.CPFCNPJUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmUsuario.
 */
@Entity
@Table(name = "ADM_USUARIO")

@NamedQueries({
	@NamedQuery(name = "AdmUsuario.findByLogin", query = "SELECT DISTINCT a FROM AdmUsuario a WHERE a.login=?1"),
	@NamedQuery(name = "AdmUsuario.login", query = "SELECT a FROM AdmUsuario a WHERE a.login=?1 AND a.senha=?2")
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "AdmUsuario.findIPByOracle", query = "SELECT SYS_CONTEXT('USERENV', 'IP_ADDRESS', 15) FROM DUAL"),
	@NamedNativeQuery(name = "AdmUsuario.findIPByPostgreSQL", query = "SELECT substr(CAST(inet_client_addr() AS VARCHAR),1,strpos(CAST(inet_client_addr() AS VARCHAR),'/')-1)"),
	@NamedNativeQuery(name = "AdmUsuario.setLoginPostgreSQL", query = "select set_config('myvars.usuario_login', ?1, false)"),
	@NamedNativeQuery(name = "AdmUsuario.setIPPostgreSQL", query = "select set_config('myvars.usuario_ip', ?1, false)")
})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@EntityListeners(AuditingEntityListener.class)
public class AdmUsuario implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The matricula. */
	@Id
	@Column(name = "USU_MATRICULA")
	private Long id;

	/** The cpf. */
	@Column(name = "USU_CPF")
	private BigDecimal cpf;

	/** The data. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USU_DATA")
	private Date data;

	/** The email. */
	@Column(name = "USU_EMAIL")
	private String email;

	/** The ldap DN. */
	@Column(name = "USU_LDAP_DN")
	private String ldapDN;

	/** The login. */
	@Column(name = "USU_LOGIN")
	private String login;

	/** The nome. */
	@Column(name = "USU_NOME")
	private String nome;

	/** The senha. */
	@JsonIgnore
	@Column(name = "USU_SENHA")	
	private String senha;

	/** The adm usuarioIps. */
	//bi-directional many-to-one association to AdmUsuarioIp
	//@JsonIgnore
	@JsonSerialize(using = AdmUsuarioIpListSerializer.class)	
	@OneToMany(mappedBy="admUsuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<AdmUsuarioIp> admUsuarioIps;
	
	/** The ip. */
	@Transient
	private String ip;
	
	@Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;
 
    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;
 
    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;
    
	/**
	 * Instantiates a new adm usuario.
	 */
	public AdmUsuario() {
		super();
		this.admUsuarioIps = new ArrayList<AdmUsuarioIp>();
		limpar();
	}

	/**
	 * Limpar.
	 */
	public void limpar() {
		this.id = 0L;
		this.cpf = BigDecimal.ZERO;
		this.data = new Date();
		this.email = "";
		this.ldapDN = "";
		this.login = "";
		this.nome = "";
		this.senha = "";
		this.admUsuarioIps.clear();
		this.ip = "";		
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
	 * Pega o the cpf.
	 *
	 * @return o the cpf
	 */
	public BigDecimal getCpf() {
		return this.cpf;
	}

	/**
	 * Atribui o the cpf.
	 *
	 * @param cpf
	 *            o novo the cpf
	 */
	public void setCpf(BigDecimal cpf) {
		this.cpf = cpf;
	}

	/**
	 * Pega o the data.
	 *
	 * @return o the data
	 */
	public Date getData() {
		return this.data;
	}

	/**
	 * Atribui o the data.
	 *
	 * @param data
	 *            o novo the data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Pega o the email.
	 *
	 * @return o the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Atribui o the email.
	 *
	 * @param email
	 *            o novo the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Pega o the ldap DN.
	 *
	 * @return o the ldap DN
	 */
	public String getLdapDN() {
		return this.ldapDN;
	}

	/**
	 * Atribui o the ldap DN.
	 *
	 * @param ldapDN
	 *            o novo the ldap DN
	 */
	public void setLdapDN(String ldapDN) {
		this.ldapDN = ldapDN;
	}

	/**
	 * Pega o the login.
	 *
	 * @return o the login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Atribui o the login.
	 *
	 * @param login
	 *            o novo the login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Pega o the nome.
	 *
	 * @return o the nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Atribui o the nome.
	 *
	 * @param nome
	 *            o novo the nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the senha.
	 *
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Sets the senha.
	 *
	 * @param senha the new senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Pega o the adm usuarioIps.
	 *
	 * @return o the adm usuarioIps
	 */
	public List<AdmUsuarioIp> getAdmUsuarioIps() {
		return this.admUsuarioIps;
	}

	/**
	 * Atribui o the adm usuarioIps.
	 *
	 * @param admUsuarioIps
	 *            o novo the adm usuarioIps
	 */
	public void setAdmUsuarioIps(List<AdmUsuarioIp> admUsuarioIps) {
		this.admUsuarioIps = admUsuarioIps;
	}

	/**
	 * Adiciona o adm usuarioIp.
	 *
	 * @param admUsuarioIp
	 *            the adm usuarioIp
	 * @return the adm usuarioIp
	 */
	public AdmUsuarioIp addAdmUsuarioIp(AdmUsuarioIp admUsuarioIp) {
		getAdmUsuarioIps().add(admUsuarioIp);
		admUsuarioIp.setAdmUsuario(this);

		return admUsuarioIp;
	}

	/**
	 * Remove o adm usuarioIp.
	 *
	 * @param admUsuarioIp
	 *            the adm usuarioIp
	 * @return the adm usuarioIp
	 */
	public AdmUsuarioIp removeAdmUsuarioIp(AdmUsuarioIp admUsuarioIp) {
		getAdmUsuarioIps().remove(admUsuarioIp);
		admUsuarioIp.setAdmUsuario(null);

		return admUsuarioIp;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
		
	/**
	 * Gets the cpf formatado.
	 *
	 * @return the cpf formatado
	 */
	public String getCpfFormatado() {
		try {
			return CPFCNPJUtil.formatCPForCPNJ(cpf.longValue(), false);
		} catch (Exception e) {
			return this.cpf.toString();
		}
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
		AdmUsuario other = (AdmUsuario) obj;
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
		return nome;
	}

	/**
	 * To usuario VO.
	 *
	 * @return the usuario VO
	 */
	public UsuarioVO toUsuarioVO(){
		UsuarioVO u = new UsuarioVO();

		u.setMatricula(this.getId());
		u.setIp(ip);
		u.setCpf(cpf);
		u.setData(data);
		u.setEmail(email);
		u.setLdapDN(ldapDN);
		u.setLogin(login);
		u.setNome(nome);
		u.setSenha(senha);
		
		return u;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}