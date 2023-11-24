package br.fiap.sprint.modelo;

public class Cliente {

	private int idCliente;
	private String nome;
	private String cpf;
	private String dataNasminento;
	private String nrTelefone;
	private String cepEndereco;
	private int nrConta;
	
	public Cliente() {
		
	}

	public Cliente(String nome, String cpf, String dataNasminento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasminento = dataNasminento;
	}
	
	public Cliente(int idCliente, String nome, String cpf, String dataNasminento) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasminento = dataNasminento;
	}
	
	public Cliente(int idCliente, String nome, String cpf, String nrTelefone, String cepEndereco, int nrConta) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.nrTelefone = nrTelefone;
		this.cepEndereco = cepEndereco;
		this.nrConta = nrConta;
	}

	@Override
	public String toString() {
		String ret = "\nID: " + idCliente + " | ";
		ret += "Nome: " + nome + " | ";
		ret += "CPF: " + cpf + " | ";
		ret += "Número da conta: " + nrConta + " | ";
		ret += "Numero de telefone: " + nrTelefone + "\n";
		ret += "Cep do endereço: " + cepEndereco + "\n";
		return ret;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNasminento(String dataNasminento) {
		this.dataNasminento = dataNasminento;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}

	public void setNrConta(int nrConta) {
		this.nrConta = nrConta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataNasminento() {
		return dataNasminento;
	}
	
	public String getNrTelefone() {
		return nrTelefone;
	}

	public String getCepEndereco() {
		return cepEndereco;
	}

	public int getNrConta() {
		return nrConta;
	}
}
