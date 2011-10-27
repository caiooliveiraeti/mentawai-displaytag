package br.com.javacia.mentawai.displaytag.model.pojo;

import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idCliente;

	private String razaoSocial;

	private String nomeFantasia;

	private boolean ativo;
	
	
	public Cliente( String razaoSocial, String nomeFantasia, boolean ativo) {
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.ativo = ativo;
	}

	public Cliente(int idCliente, String razaoSocial, String nomeFantasia, boolean ativo) {
		this(razaoSocial, nomeFantasia, ativo);
		this.idCliente = idCliente;
	}

	public Cliente() {
	}

	public Cliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNomeFantasia() == null) ? 0 : getNomeFantasia().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (getNomeFantasia() == null) {
			if (other.getNomeFantasia() != null) {
				return false;
			}
		} else if (!getNomeFantasia().equals(other.getNomeFantasia())) {
			return false;
		}
		return true;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

}
