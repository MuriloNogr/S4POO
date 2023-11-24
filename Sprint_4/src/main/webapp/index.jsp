<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro Cliente</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://cdn.tailwindcss.com"></script>
	</head>

	<body class="bg-slate-900">
		<section class="max-w-lg my-5 p-7 flex justify-center m-auto rounded-lg bg-neutral-100">
			<!--FORMULÁRIO DE LOGIN-->
			<div id="cadastro">
				<div class="border-b-4 p-2 text-4xl font-mono border-slate-900">
					<h1>LOGIN</h1>
				</div>
				<form method="post" action="cadastro">
					<!--Dados cliente-->
					<div class="flex flex-col pt-3 pb-4">
						<h2 class="text-2xl mb-4">Dados do cliente</h2>
						<label for="nome" class="text-xl">Nome</label>
						<input id="nome" name="nome" maxlength="50" required="required" type="text" placeholder="Digite o nome do cliente" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />
						<label for="cpf" class="text-xl">CPF</label>
						<input id="cpf" name="cpf" maxlength="11" required="required" type="text" placeholder="Digite o CPF do cliente" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />
						<label for="dtNascimento" class="text-xl">Data Nascimento</label>
						<input id="dtNascimento" name="dtNascimento" required="required" type="date" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />
					</div>
					<!--Fim dados cliente-->

					<!--Dados endereço-->
					<div class="pb-4 flex flex-col">
						<label for="cep" class="text-xl">CEP</label>
						<input id="cep" name="cep" maxlength="11" required="required" type="text" placeholder="Digite o cep do cliente" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />
						<label for="estado" class="text-xl">Estado</label>
						<input id="estado" name="estado" maxlength="2" required="required" type="text" placeholder="Digite o estado do cliente (Ex: SP)" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />
						<label for="numero" class="text-xl">Numero</label>
						<input id="numero" name="numero" maxlength="6" required="required" type="text" placeholder="Digite o número da residencia do cliente" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />
						<label for="Complemento" class="text-xl">Complemento</label>
						<input id="complemento" name="complemento " maxlength="50" required="required" type="text" placeholder="Digite o complemento da residencia do cliente" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />
					</div>
					<!--Fim dados endereço-->

					<!--Dados Telefone-->
					<div class="pb-4 flex flex-col">
						<label for="nrTelefone" class="text-xl">Número de telefone/celular</label>
						<input id="nrTelefone" name="nrTelefone" maxlength="11" required="required" type="text" placeholder="Número de telefone/celular do cliente" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />
					</div>
					<!-- Fim dados telefone -->

					<!-- Tipo conta -->
					<div class="flex flex-col">
						<label for="agencia" class="text-xl">Digite a agencia da conta</label>
						<input id="agencia" name="agencia" maxlength="4" required="required" type="text" placeholder="Digite a agencia da conta do cliente" class="my-2 p-2 border-b-2 rounded-sm border-slate-900" />
						<div class="pt-3 pb-4 mb-3">
							<div class="mb-3">
								<h2 class="text-xl">Tipo conta</h2>
							</div>
							<input type="radio" id="tpConta-pf" name="tpConta" required="required" value="0">
							<label for="tpConta-pf" class="mr-4">Pessoa física</label>
							<input type="radio" id="tpConta-pj" name="tpConta" required="required" value="1">
							<label for="tpConta-pj">Pessoa jurídica</label>
						</div>
					</div>
					<!-- Fim Tipo conta -->

					<div class="pt-2 pb-4 flex gap-5">
						<button type="submit" class="transition ease-in-out delay-150 bg-slate-900 text-white hover:-translate-y-1 hover:scale-110 hover:bg-gray-700 duration-300 p-3 rounded-md">
							Cadastrar cliente
						</button>
						<button class="transition ease-in-out delay-150 bg-slate-900 text-white hover:-translate-y-1 hover:scale-110 hover:bg-gray-700 duration-300 p-3 rounded-md">
							<a href="form/formListar.jsp"> Listar clientes já cadastrados</a>
						</button>
					</div>

				</form>
			</div>
		</section>
	</body>

	</html>