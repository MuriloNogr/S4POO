package br.fiap.sprint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.sprint.conexao.Conexao;
import br.fiap.sprint.modelo.TipoConta;

public class TipoContaDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public void inserir(int id, TipoConta tipoConta) {
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "insert into TB_TP_CONTA (id_tp_conta, tp_conta) values(?, ?)";

		try {
			ps = connection.prepareStatement(sql);	
			ps.setInt(1, id);
			ps.setString(2, tipoConta.getTipoConta());
			ps.execute(); // ps.executeUpdate();
			ps.close();
			conexao.desconectar();
			System.out.println("Tipo de conta inserido com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir tipo conta\n" + e);
		}
	}

}
