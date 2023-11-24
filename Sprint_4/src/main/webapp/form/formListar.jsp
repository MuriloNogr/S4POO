<%@page import="br.fiap.sprint.dao.ClienteDAO" %>
	<%@page import="br.fiap.sprint.modelo.Cliente" %>
		<%@page import="br.fiap.sprint.dao.TelefoneDAO" %>
			<%@page import="br.fiap.sprint.modelo.Telefone" %>
				<%@page import="java.util.List" %>
					<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

						<!DOCTYPE html>
						<html lang="en">

						<head>
							<meta charset="UTF-8">
							<meta name="viewport" content="width=device-width, initial-scale=1.0">
							<meta http-equiv="X-UA-Compatible" content="ie=edge">
							<script src="https://cdn.tailwindcss.com"></script>
							<title>Clientes - Lista</title>
							<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
							<script src="https://cdn.tailwindcss.com"></script>
						</head>

						<body class="bg-slate-900">
							<div class="bg-neutral-100 p-7">
								<table class="table-auto m-auto px-4">
									<thead>
										<tr>
											<th>ID</th>
											<th>Nome</th>
											<th>CPF</th>
											<th>Numero de telefone</th>
											<th>CEP</th>
											<th>Numero da conta</th>
											<th>Ação</th>
										</tr>
									</thead>
									<tbody>
										<% List<Cliente> lista = new ClienteDAO().listar();
											TelefoneDAO telefoneDAO = new TelefoneDAO();
											for (Cliente cliente : lista) {
											%>
											<tr>
												<td>
													<%=cliente.getIdCliente()%>
												</td>
												<td class="p-3">
													<%=cliente.getNome()%>
												</td>
												<td class="p-3">
													<%=cliente.getCpf()%>
												</td>
												<td class="p-3">
													<%=cliente.getNrTelefone()%>
												</td>
												<td class="p-3">
													<%=cliente.getCepEndereco()%>
												</td>
												<td class="p-3">
													<%=cliente.getNrConta()%>
												</td>

												<td class="p-3">
													<button class="transition ease-in-out delay-150 bg-slate-900 text-white hover:-translate-y-1 hover:scale-110 hover:bg-gray-700 duration-300 p-3 rounded-md w-32" type="submit">
														<a href="formAlterar.jsp?id=<%=cliente.getIdCliente()%>" class="flex items-center justify-around"> Alterar <i class="material-icons">send</i>
														</a>
													</button>
												</td>
											</tr>
											<% } %>

									</tbody>
								</table>

								<div class="mt-4 flex justify-center">
									<button class="transition ease-in-out delay-150 bg-slate-900 text-white hover:-translate-y-1 hover:scale-110 hover:bg-gray-700 duration-300 p-3 rounded-md flex">
										<a href="../index.jsp">Voltar</a>
									</button>
								</div>

							</div>
						</body>

						</html>