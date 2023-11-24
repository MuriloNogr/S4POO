package br.fiap.sprint.modelo;

public class Conta {

	private int idConta;
	private int numeroConta;
	private int agencia;
	
	public Conta() {
		
	}
	
	public Conta(int numeroConta, int agencia) {
		super();
		this.numeroConta = numeroConta;
		this.agencia = agencia;
	}
	
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public Conta(int idConta, int numeroConta, int agencia) {
		super();
		this.idConta = idConta;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
	}
	
	@Override
	public String toString() {
		String ret = "\nID: " + idConta + " | ";
		ret += "Numero conta: " + numeroConta + " | ";
		ret += "Agendia: " + agencia + "\n";
		return ret;
	}
	
	public int getIdConta() {
		return idConta;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public int getAgencia() {
		return agencia;
	}

}
