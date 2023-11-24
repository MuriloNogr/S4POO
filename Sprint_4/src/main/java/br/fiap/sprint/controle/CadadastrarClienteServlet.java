package br.fiap.sprint.controle;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.sprint.dao.ClienteDAO;
import br.fiap.sprint.dao.ContaDAO;
import br.fiap.sprint.dao.EnderecoDAO;
import br.fiap.sprint.dao.TelefoneDAO;
import br.fiap.sprint.dao.TipoContaDAO;
import br.fiap.sprint.modelo.Cliente;
import br.fiap.sprint.modelo.Conta;
import br.fiap.sprint.modelo.Endereco;
import br.fiap.sprint.modelo.Telefone;
import br.fiap.sprint.modelo.TipoConta;
import br.fiap.sprint.utils.Utils;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro")
public class CadadastrarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id = 0;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Utils util = new Utils();

			Telefone telefone = new Telefone();
			telefone.setTelefone(request.getParameter("nrTelefone"));
			cadastrarTelefone(telefone);

			Endereco endereco = new Endereco();
			endereco.setCep(request.getParameter("cep"));
			endereco.setEstado(request.getParameter("estado"));
			endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
			endereco.setComplemento(request.getParameter("complemento"));
			cadastrarEndereco(endereco);

			TipoConta tpConta = new TipoConta();
			tpConta.setTipoConta(request.getParameter("tpConta"));
			definirTpConta(tpConta);
			
			Conta conta = new Conta();
			conta.setAgencia(Integer.parseInt(request.getParameter("agencia")));
			cadastrarConta(conta);

			Cliente cliente = new Cliente();
			ClienteDAO clienteDAO = new ClienteDAO();
			cliente.setIdCliente(getId());
			cliente.setNome(request.getParameter("nome"));
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setDataNasminento(request.getParameter("dtNascimento").toString());

			clienteDAO.inserir(cliente, getId(), getId(), getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// redireciona para index.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/form/formCadastro.jsp");
		dispatcher.forward(request, response);

	}

	private void cadastrarTelefone(Telefone telefone) {
		// String cep, int numero, String estado
		TelefoneDAO dao = new TelefoneDAO();

		try {
			dao.inserir(telefone);
			setId(dao.pesquisarTelefone(telefone.getTelefone()).getIdTelefone());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cadastrarEndereco(Endereco endereco) {
		// String cep, int numero, String estado
		EnderecoDAO dao = new EnderecoDAO();

		try {
			dao.inserir(getId(), endereco);
		} catch (Exception e) {
			cadastrarEndereco(endereco);
		}
	}

	private void definirTpConta(TipoConta tipoConta) {
		TipoContaDAO dao = new TipoContaDAO();

		try {
			dao.inserir(getId(), tipoConta);
		} catch (Exception e) {
			definirTpConta(tipoConta);
		}
	}
	
	private void cadastrarConta(Conta conta) {
		ContaDAO dao = new ContaDAO();

		int nrConta = new Random().nextInt(100000, 999999);
		conta.setNumeroConta(nrConta);
		try {
			dao.inserir(getId(), conta);
		} catch (Exception e) {
			cadastrarConta(conta);
		}
	}
	
	private void setId(int id) {
		this.id = id;
	}

	private int getId() {
		return id;
	}
}
