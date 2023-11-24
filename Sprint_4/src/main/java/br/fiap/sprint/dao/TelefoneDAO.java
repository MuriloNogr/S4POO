package br.fiap.sprint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.sprint.conexao.Conexao;
import br.fiap.sprint.modelo.Telefone;

public class TelefoneDAO {

	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public void inserir(Telefone telefone) {
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "insert into tb_telefone (nr_telefone) values(?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, telefone.getTelefone());
			ps.execute(); // ps.executeUpdate();
			ps.close();
			conexao.desconectar();
			System.out.println("Telefone inserido com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir telefone\n" + e);
		}
	}

	public boolean telefoneRegistrado(String nrTelefone) {
		boolean aux = false;
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "select * from TB_TELEFONE where nr_telefone = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, nrTelefone);
			rs = ps.executeQuery();
			aux = rs.next();
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o telefone pelo id\n" + e);
		}
		return aux;
	}

	public Telefone pesquisarTelefone(String nrTelefone) {
		Telefone telefone = null;
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "select * from TB_TELEFONE where nr_telefone = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, nrTelefone);
			rs = ps.executeQuery();
			if (rs.next()) {
				telefone = new Telefone(rs.getInt("id_telefone"), nrTelefone);
			}
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o endereço pelo id\n" + e);
		}
		return telefone;
	}
	
	public String pesquisarNrTelefone(int id) {
		Telefone telefone = null;
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "select * from TB_TELEFONE where id_telefone = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				telefone = new Telefone(id, rs.getString("nr_telefone"));
			}
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o endereço pelo id\n" + e);
		}
		return telefone.getTelefone();
	}

	public void alterar(Telefone telefone) {
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "update tb_telefone set nr_telefone = ? where id_telefone = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, telefone.getTelefone());
			ps.setInt(2, telefone.getIdTelefone());
			ps.execute();
			ps.close();
			conexao.desconectar();
			System.out.println("Telefone alterado com sucesso!\n");
		} catch (SQLException e) {
			System.out.println("Erro ao carregar o telefone\n" + e);
		}
	}
}
