package br.fiap.sprint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.sprint.conexao.Conexao;
import br.fiap.sprint.modelo.Conta;

public class ContaDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public void inserir(int id, Conta conta) {
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "insert into TB_CONTA (id_conta, nr_conta, agencia_conta, id_tp_conta) values(?, ?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, conta.getNumeroConta());
			ps.setInt(3, conta.getAgencia());
			ps.setInt(4, id);
			ps.execute(); // ps.executeUpdate();
			ps.close();
			conexao.desconectar();
			System.out.println("Conta inserida com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir conta\n" + e);
		}
	}
	
	
	public boolean contaRegistrada(int numero) {
		boolean aux = false;
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "select * from TB_CONTA where nr_conta = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, numero);
			rs = ps.executeQuery();
			aux = rs.next();
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar a conta pelo numero\n" + e);
		}
		return aux;
	}
	
	
	public Conta pesquisarNumero(int numero) {
		Conta conta = null;
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "select * from TB_CONTA where nr_conta = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, numero);
			rs = ps.executeQuery();
			if (rs.next()) {
				conta = new Conta(rs.getInt("id_conta"), numero, rs.getInt("agencia_conta"));
			}
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o cliente pelo id\n" + e);
		}
		return conta;
	}
}
