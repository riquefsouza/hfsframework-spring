/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.security.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuVO.
 */
@Component
public class MenuVO implements Serializable, Comparable<MenuVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The descricao. */
	private String descricao;

	/** The ordem. */
	private Integer ordem;

	/** The id funcionalidade. */
	private Long idFuncionalidade;

	/** The funcionalidade. */
	private FuncionalidadeVO funcionalidade;

	/** The menu pai. */
	private MenuVO menuPai;

	/** The sub menus. */
	private List<MenuVO> subMenus;

	/**
	 * Instantiates a new menu VO.
	 */
	public MenuVO() {
		this.subMenus = new ArrayList<MenuVO>();
		limpar();
	}

	/**
	 * Limpar.
	 */
	public void limpar() {
		this.id = null;
		this.descricao = null;
		this.ordem = null;
		this.idFuncionalidade = null;
		this.funcionalidade = new FuncionalidadeVO();
		this.menuPai = null;
		this.subMenus.clear();
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
	 * Pega o the ordem.
	 *
	 * @return o the ordem
	 */
	public Integer getOrdem() {
		return this.ordem;
	}

	/**
	 * Atribui o the ordem.
	 *
	 * @param ordem
	 *            o novo the ordem
	 */
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	/**
	 * Pega o the adm funcionalidade.
	 *
	 * @return o the adm funcionalidade
	 */
	public FuncionalidadeVO getFuncionalidade() {
		return this.funcionalidade;
	}

	/**
	 * Atribui o the adm funcionalidade.
	 *
	 * @param funcionalidade
	 *            o novo the adm funcionalidade
	 */
	public void setFuncionalidade(FuncionalidadeVO funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	/**
	 * Pega o the adm menu.
	 *
	 * @return o the adm menu
	 */
	public MenuVO getMenuPai() {
		return this.menuPai;
	}

	/**
	 * Atribui o the adm menu.
	 *
	 * @param menuPai
	 *            o novo the adm menu
	 */
	public void setMenuPai(MenuVO menuPai) {
		this.menuPai = menuPai;
	}

	/**
	 * Pega o the adm menus.
	 *
	 * @return o the adm menus
	 */
	public List<MenuVO> getSubMenus() {
		if (this.subMenus!=null && !this.subMenus.isEmpty()){
			Collections.sort(this.subMenus, new Comparator<MenuVO>() {
				@Override
				public int compare(MenuVO o1, MenuVO o2) {
					return o1.getOrdem().compareTo(o2.getOrdem());
				}
			});
		}
		return this.subMenus;
	}

	/**
	 * Atribui o the adm menus.
	 *
	 * @param subMenus
	 *            o novo the adm menus
	 */
	public void setSubMenus(List<MenuVO> subMenus) {
		this.subMenus = subMenus;
	}

	/**
	 * Adiciona o adm sub menus.
	 *
	 * @param subMenus
	 *            the adm sub menus
	 * @return the adm menu
	 */
	public MenuVO addSubMenus(MenuVO subMenus) {
		getSubMenus().add(subMenus);
		subMenus.setMenuPai(this);

		return subMenus;
	}

	/**
	 * Remove o adm sub menus.
	 *
	 * @param subMenus
	 *            the adm sub menus
	 * @return the adm menu
	 */
	public MenuVO removeSubMenus(MenuVO subMenus) {
		getSubMenus().remove(subMenus);
		subMenus.setMenuPai(null);

		return subMenus;
	}
		
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuPai == null) ? 0 : menuPai.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		MenuVO other = (MenuVO) obj;
		if (menuPai == null) {
			if (other.menuPai != null)
				return false;
		} else if (!menuPai.equals(other.menuPai))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * Checks if is sub menu.
	 *
	 * @return true, if is sub menu
	 */
	public boolean isSubMenu() {
		return getFuncionalidade() == null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(MenuVO m) {
		return getDescricao().compareTo(m.getDescricao());
	}

	/**
	 * Gets the managed bean.
	 *
	 * @return the managed bean
	 */
	public String getManagedBean() {
		return this.funcionalidade != null ? this.funcionalidade.getPaginaInicial().getManagedBean() : null;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return this.funcionalidade != null ? this.funcionalidade.getPaginaInicial().getUrl() : null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.descricao;
	}

	/**
	 * Pega o the id funcionalidade.
	 *
	 * @return o the id funcionalidade
	 */
	public Long getIdFuncionalidade() {
		return idFuncionalidade;
	}

	/**
	 * Atribui o the id funcionalidade.
	 *
	 * @param idFuncionalidade
	 *            o novo the id funcionalidade
	 */
	public void setIdFuncionalidade(Long idFuncionalidade) {
		this.idFuncionalidade = idFuncionalidade;
	}

}
