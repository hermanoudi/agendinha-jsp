package br.agenda.model.dto;

public class Contato {

	private Long id;
	private String nome;
	private String endereco;
	private Bairro idBairro;
	private Cidade idCidade;
	private String residencial;
	private String comercial;
	private String celular;
	private String email;
	private String msn;
	private Pais idPais;
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getComercial() {
		return comercial;
	}
	public void setComercial(String comercial) {
		this.comercial = comercial;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Bairro getIdBairro() {
		return idBairro;
	}
	public void setIdBairro(Bairro idBairro) {
		this.idBairro = idBairro;
	}
	public Cidade getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Cidade idCidade) {
		this.idCidade = idCidade;
	}
	public Pais getIdPais() {
		return idPais;
	}
	public void setIdPais(Pais idPais) {
		this.idPais = idPais;
	}
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getResidencial() {
		return residencial;
	}
	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((celular == null) ? 0 : celular.hashCode());
		result = PRIME * result + ((comercial == null) ? 0 : comercial.hashCode());
		result = PRIME * result + ((email == null) ? 0 : email.hashCode());
		result = PRIME * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((idBairro == null) ? 0 : idBairro.hashCode());
		result = PRIME * result + ((idCidade == null) ? 0 : idCidade.hashCode());
		result = PRIME * result + ((idPais == null) ? 0 : idPais.hashCode());
		result = PRIME * result + ((msn == null) ? 0 : msn.hashCode());
		result = PRIME * result + ((nome == null) ? 0 : nome.hashCode());
		result = PRIME * result + ((residencial == null) ? 0 : residencial.hashCode());
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
		final Contato other = (Contato) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (comercial == null) {
			if (other.comercial != null)
				return false;
		} else if (!comercial.equals(other.comercial))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idBairro == null) {
			if (other.idBairro != null)
				return false;
		} else if (!idBairro.equals(other.idBairro))
			return false;
		if (idCidade == null) {
			if (other.idCidade != null)
				return false;
		} else if (!idCidade.equals(other.idCidade))
			return false;
		if (idPais == null) {
			if (other.idPais != null)
				return false;
		} else if (!idPais.equals(other.idPais))
			return false;
		if (msn == null) {
			if (other.msn != null)
				return false;
		} else if (!msn.equals(other.msn))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (residencial == null) {
			if (other.residencial != null)
				return false;
		} else if (!residencial.equals(other.residencial))
			return false;
		return true;
	}
	
	
	
}
