/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the ADM_PARAMETRO database table.
 * 
 */
@Entity
@Table(name="ADM_PARAMETRO")
@NamedQueries({
	@NamedQuery(name = "AdmParametro.getDescricaoById", query = "SELECT c.descricao FROM AdmParametro c WHERE c.id = ?1"),
	@NamedQuery(name = "AdmParametro.countNovo", query = "SELECT COUNT(c) FROM AdmParametro c WHERE LOWER(c.descricao) = ?1"),
	@NamedQuery(name = "AdmParametro.countAntigo", query = "SELECT COUNT(c) FROM AdmParametro c WHERE LOWER(c.descricao) <> ?1 AND LOWER(c.descricao) = ?2"),
	@NamedQuery(name = "AdmParametro.getValorByCodigo", query = "SELECT c.valor FROM AdmParametro c WHERE c.codigo= ?1")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AdmParametro implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GenericGenerator(name = "ADM_PARAMETRO_ID_GENERATOR",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
    	@Parameter(name = "sequence_name", value = "ADM_PARAMETRO_SEQ"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
	})				
	@SequenceGenerator(name="ADM_PARAMETRO_ID_GENERATOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADM_PARAMETRO_ID_GENERATOR")
	@Column(name="PAR_SEQ")
	private Long id;

	/** The codigo. */
	@Column(name="PAR_CODIGO")
	private String codigo;

	/** The descricao. */
	@NotNull
	@Column(name="PAR_DESCRICAO", unique = true)
	private String descricao;

	/** The valor. */
	@Column(name="PAR_VALOR")
	private String valor;
	
	/** The id adm parametro categoria. */
	@Column(name = "PAR_PMC_SEQ", nullable=false)
	private Long idAdmParametroCategoria;

	/** The adm parametro categoria. */
	//bi-directional many-to-one association to AdmParametroCategoria
	@ManyToOne(optional = false, fetch=FetchType.EAGER)
	@JoinColumn(name="PAR_PMC_SEQ", nullable=false, insertable = false, updatable = false)
	private AdmParametroCategoria admParametroCategoria;

	/**
	 * Instantiates a new adm parametro.
	 */
	public AdmParametro() {
		limpar();
	}
	
	/**
	 * Instantiates a new adm parametro.
	 *
	 * @param id the id
	 * @param valor the valor
	 * @param descricao the descricao
	 * @param codigo the codigo
	 * @param idAdmParametroCategoria the id adm parametro categoria
	 */
	public AdmParametro(Long id, String valor, String descricao, String codigo, Long idAdmParametroCategoria) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.idAdmParametroCategoria = idAdmParametroCategoria;
	}

	/**
	 * Limpar.
	 */
	public void limpar() {
		this.id = null;
		this.codigo = null;
		this.descricao = null;
		this.valor = null;
		this.admParametroCategoria = new AdmParametroCategoria();
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
	 * Pega o the codigo.
	 *
	 * @return o the codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * Atribui o the codigo.
	 *
	 * @param codigo
	 *            o novo the codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * Pega o the valor.
	 *
	 * @return o the valor
	 */
	public String getValor() {
		return this.valor;
	}

	/**
	 * Atribui o the valor.
	 *
	 * @param valor
	 *            o novo the valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * Pega o the adm parametro categoria.
	 *
	 * @return o the adm parametro categoria
	 */
	public AdmParametroCategoria getAdmParametroCategoria() {
		return this.admParametroCategoria;
	}

	/**
	 * Atribui o the adm parametro categoria.
	 *
	 * @param admParametroCategoria
	 *            o novo the adm parametro categoria
	 */
	public void setAdmParametroCategoria(AdmParametroCategoria admParametroCategoria) {
		this.admParametroCategoria = admParametroCategoria;
	}

	/**
	 * Pega o the id adm parametro categoria.
	 *
	 * @return o the id adm parametro categoria
	 */
	public Long getIdAdmParametroCategoria() {
		return idAdmParametroCategoria;
	}

	/**
	 * Atribui o the id adm parametro categoria.
	 *
	 * @param idAdmParametroCategoria
	 *            o novo the id adm parametro categoria
	 */
	public void setIdAdmParametroCategoria(Long idAdmParametroCategoria) {
		this.idAdmParametroCategoria = idAdmParametroCategoria;
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
		AdmParametro other = (AdmParametro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}