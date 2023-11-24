package br.fiap.sprint.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.sprint.dao.ClienteDAO;
import br.fiap.sprint.dao.TelefoneDAO;
import br.fiap.sprint.modelo.Cliente;
import br.fiap.sprint.modelo.Telefone;

/**
 * Servlet implementation class AlterarServlet
 */
@WebServlet("/alterar")
public class AlterarDadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		Cliente cliente = new Cliente();
		Telefone telefone = new Telefone();
				
		cliente.setNome(request.getParameter("nome"));
		telefone.setTelefone(request.getParameter("telefone"));

		clienteDAO.alterar(cliente);
		telefoneDAO.alterar(telefone);
		
		// redireciona para index.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/formListar.jsp");
		dispatcher.forward(request, response);
		
	}

}
