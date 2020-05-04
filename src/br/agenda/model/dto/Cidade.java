package br.agenda.model.dto;

import java.io.Serializable;

public class Cidade implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6159790507288060916L;
	private Long id;
	private String nome;
	private String uf;
	private String ddd;
	
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((ddd == null) ? 0 : ddd.hashCode());
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((nome == null) ? 0 : nome.hashCode());
		result = PRIME * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Cidade other = (Cidade) obj;
		if (ddd == null) {
			if (other.ddd != null)
				return false;
		} else if (!ddd.equals(other.ddd))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	
	
}
