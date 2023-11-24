<%@page import="br.fiap.sprint.dao.ClienteDAO" %>
	<%@page import="br.fiap.sprint.modelo.Cliente" %>
		<%@page import="br.fiap.sprint.dao.TelefoneDAO" %>
			<%@page import="br.fiap.sprint.modelo.Telefone" %>
				<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

					<!DOCTYPE html>
					<html>

					<head>
						<meta charset="UTF-8">
						<meta name="viewport" content="width=device-width, initial-scale=1.0">
						<meta http-equiv="X-UA-Compatible" content="ie=edge">
						<title>Alterar Dado</title>
						<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
						<script src="https://cdn.tailwindcss.com"></script>
					</head>

					<body class="bg-slate-900">
						<div class="max-w-lg my-5 p-7 flex justify-center m-auto rounded-lg bg-neutral-100">
							<!--FORMULÁRIO DE ALTERAÇÃO-->
							<div id="cadastro">
								<form method="post" action="../alterar">
									<div class="flex flex-col">
										<h1 class="text-2xl mb-4">Alteração de Dados</h1>
										<% Integer id=Integer.parseInt(request.getParameter("id")); Cliente cliente=new ClienteDAO().pesquisarId(id); Telefone telefone=new TelefoneDAO().pesquisarTelefone(cliente.getNrTelefone()); %>
											<input class="my-2 p-2 border-b-2 rounded-sm border-slate-900" id="id" name="id" type="hidden" value=<%=cliente.getIdCliente() %>>
											<label for="nome">Nome</label>
											<input id="nome" name="nome" type="text" value="<%= cliente.getNome() %>" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />
											<label for="telefone" class="mt-3">Telefone</label>
											<input id="telefone" name="telefone" type="text" value="<%= cliente.getNrTelefone() %>" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />

											<div class="mt-3">
												<button type="submit" value="Alterar" class="transition ease-in-out delay-150 bg-slate-900 text-white hover:-translate-y-1 hover:scale-110 hover:bg-gray-700 duration-300 p-3 rounded-md">
													Alterar
												</button>
											</div>
									</div>
								</form>
							</div>
						</div>
					</body>

					</html>