package br.fiap.sprint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.sprint.conexao.Conexao;
import br.fiap.sprint.modelo.Endereco;

public class EnderecoDAO {

	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public void inserir(int id, Endereco endereco) {
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "insert into TB_ENDERECO (id_endereco, cep_endereco, nr_endereco, estado_endereco, complemento_endereco) values(?, ?, ?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, endereco.getCep());
			ps.setInt(3, endereco.getNumero());
			ps.setString(4, endereco.getEstado());
			ps.setString(5, endereco.getComplemento());
			ps.execute(); // ps.executeUpdate();
			ps.close();
			conexao.desconectar();
			System.out.println("Endereço inserido com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir endereço\n" + e);
		}
	}
	

	public boolean enderecoRegistrado(int idEndereco) {
		boolean aux = false;
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "select * from TB_ENDERECO where id_endereco = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idEndereco);
			rs = ps.executeQuery();
			aux = rs.next();
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar a conta pelo numero\n" + e);
		}
		return aux;
	}
	

	public Endereco pesquisarEndereco(int idEndereco) {
		Endereco endereco = null;
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "select * from TB_ENDERECO where id_endereco = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idEndereco);
			rs = ps.executeQuery();
			if (rs.next()) {
				endereco = new Endereco(idEndereco, rs.getString("cep_endereco"), rs.getInt("nr_endereco"), rs.getString("estado_endereco"),
						rs.getString("complemento_endereco"));
			}
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o endereço pelo id\n" + e);
		}
		return endereco;
	}
}
