package br.fiap.sprint.modelo;

public class TipoConta {

	int idTipoConta;
	String tipoConta;

	public TipoConta() {

	}

	public TipoConta(int idTipoConta, String tipoConta) {
		super();
		this.idTipoConta = idTipoConta;
		this.tipoConta = tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		if (tipoConta.equals("1")) {
			this.tipoConta = "FISICA";
		} else {
			this.tipoConta = "JURIDICA";
		}
	}

	public void setIdTipoConta(int idTipoConta) {
		this.idTipoConta = idTipoConta;
	}

	public int getIdTipoConta() {
		return idTipoConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}
}
