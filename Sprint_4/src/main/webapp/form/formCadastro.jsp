<%@page import="java.util.List" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<meta http-equiv="X-UA-Compatible" content="ie=edge">
			<title>Sucesso!</title>
			<script src="https://cdn.tailwindcss.com"></script>

		</head>

		<body class="bg-slate-900">
			<div id="cadastro" class="max-w-lg my-5 p-7 flex justify-center m-auto rounded-lg bg-neutral-100">
				<form method="post" action="/listagem">
					<h1 class="border-b-2 p-2 text-4xl border-slate-900 text-center">Cadastro</h1>
					<h2 class="text-2xl mt-2">Cliente cadastrado com sucesso!</h2>
					<div class="mt-8 flex justify-center">
						<button class="transition ease-in-out delay-150 bg-slate-900 text-white hover:-translate-y-1 hover:scale-110 hover:bg-gray-700 duration-300 p-3 rounded-md">
							<a href="index.jsp">Voltar</a>
						</button>
					</div>
				</form>
			</div>
		</body>

		</html>