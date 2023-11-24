package br.fiap.sprint.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.sprint.dao.ClienteDAO;
import br.fiap.sprint.modelo.Cliente;

/**
 * Servlet implementation class ListagemServlet
 */
@WebServlet("/listagem")
public class ListarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente;		
		
		String cpf = request.getParameter("cpf");
		cliente = dao.pesquisarCpf(cpf);
		
		if(cliente != null) {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/form/formListagem.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}

