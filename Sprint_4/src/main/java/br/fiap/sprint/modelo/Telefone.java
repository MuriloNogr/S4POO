package br.fiap.sprint.modelo;

public class Telefone {

	private int idTelefone;
	private String telefone;
	
	public Telefone() {
		
	}
	
	public Telefone(int idTelefone, String telefone) {
		super();
		this.idTelefone = idTelefone;
		this.telefone = telefone;
	}
	
	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Telefone(String telefone) {
		super();
		this.telefone = telefone;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public String getTelefone() {
		return telefone;
	}
}
