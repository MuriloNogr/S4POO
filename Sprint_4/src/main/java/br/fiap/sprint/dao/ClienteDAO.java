package br.fiap.sprint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.sprint.conexao.Conexao;
import br.fiap.sprint.modelo.Cliente;

public class ClienteDAO {

	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public void inserir(Cliente cliente, int idEndereco, int idConta, int idTelefone) {
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "insert into TB_CLIENTE (id_cliente, nm_cliente, cpf_cliente, dt_nascimento_cliente, id_endereco, id_conta, id_telefone) values(?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getCpf());
			ps.setString(4, cliente.getDataNasminento());
			ps.setInt(5, idEndereco);
			ps.setInt(6, idConta);
			ps.setInt(7, idTelefone);
			ps.execute(); // ps.executeUpdate();
			ps.close();
			conexao.desconectar();
			System.out.println("Cliente inserido com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir cliente\n" + e);
		}
	}
	
	
	public boolean clienteRegistrado(String cpf) {
		boolean aux = false;
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "select * from TB_CLIENTE where cpf_cliente = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, cpf);
			rs = ps.executeQuery();
			aux = rs.next();
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o cliente pelo cpf\n" + e);
		}
		return aux;
	}
	
	public Cliente pesquisarId(int id) {
		Cliente cliente = null;
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "select * from TB_CLIENTE where id_cliente = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente(id, rs.getString("nm_cliente"), rs.getString("cpf_cliente"),
						rs.getString("dt_nascimento_cliente"));
			}
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o cliente pelo id\n" + e);
		}
		return cliente;
	}
	
	public Cliente pesquisarCpf(String cpf) {
		Cliente cliente = null;
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "select * from TB_CLIENTE where cpf_cliente = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, cpf);
			rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nm_cliente"), cpf,
						rs.getString("dt_nascimento_cliente"));
			}
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o cliente pelo id\n" + e);
		}
		
		return cliente;
	}
	
	public List<Cliente> listar() {
		List<Cliente> lista = new ArrayList<Cliente>();
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "SELECT C.id_cliente, C.nm_cliente, C.cpf_cliente, T.nr_telefone, E.cep_endereco, A.nr_conta FROM TB_CLIENTE C "
				+ "INNER JOIN TB_CONTA A ON C.id_conta = A.id_conta "
				+ "INNER JOIN  TB_TELEFONE T ON C.id_telefone = T.id_telefone "
				+ "INNER JOIN  TB_ENDERECO E ON C.id_endereco = E.id_endereco";
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Cliente(rs.getInt("id_cliente"), rs.getString("nm_cliente"), rs.getString("cpf_cliente"),
						rs.getString("nr_telefone"), rs.getString("cep_endereco"), rs.getInt("nr_conta")));
			}
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("Erro ao listar a tabela cliente\n" + e);
		}
		return lista;
	}
	
	public void alterar(Cliente cliente) {
		Conexao conexao = new Conexao();
		connection = conexao.conectar();
		sql = "update TB_CLIENTE set nm_cliente = ? where id_cliente = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getIdCliente());
			ps.execute();		
			ps.close();
			conexao.desconectar();
			System.out.println("Cliente alterado com sucesso!\n");
		}
		catch(SQLException e) {
			System.out.println("Erro ao alterar dados do cliente na base de dados\n" + e);
		}		
	}
}
