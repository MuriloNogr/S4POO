package br.fiap.sprint.modelo;

public class Endereco {

	private int idEndereco;
	private String cep;
	private int numero;
	private String estado;
	private String complemento;

	public Endereco() {

	}

	public Endereco(int idEndereco, String cep, int numero, String estado, String complemento) {
		super();
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.numero = numero;
		this.estado = estado;
		this.complemento = complemento;
	}

	public Endereco(String cep, int numero, String estado, String complemento) {
		super();
		this.cep = cep;
		this.numero = numero;
		this.estado = estado;
		this.complemento = complemento;
	}

	public Endereco(String cep, int numero, String estado) {
		super();
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.numero = numero;
		this.estado = estado;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public int getNumero() {
		return numero;
	}

	public String getEstado() {
		return estado;
	}

	public String getComplemento() {
		return complemento;
	}

}
