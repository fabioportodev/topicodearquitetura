var botaoAdicionar = document.querySelector("#adicionar-aluno");
	botaoAdicionar.addEventListener("click", function(event){
		event.preventDefault();

		var xmlhttp;
		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=funcaoTrataRespostaServidor;
		xmlhttp.open("GET", "https://escola-nerd.herokuapp.com/", true);
		xmlhttp.send();


		var form = document.querySelector("#form-adiciona");

		var aluno = obtemAlunoDoFormulario(form);

		var alunoTr = montaTr(aluno);
		

		var tabela = document.querySelector("#tabela-alunos");

		tabela.appendChild(alunoTr);


		form.reset();



});

function obtemAlunoDoFormulario(form){

	var aluno = {
		nome: form.nome.value,
		matricula: form.matricula.value,
		curso: form.curso.value,
		estadocivil: form.estadocivil.value,
	}

	return aluno;
}

function montaTr(aluno) {
	var alunoTr = document.createElement("tr");
	alunoTr.classList.add("aluno");

	alunoTr.appendChild(montaTd(aluno.nome, "info-nome"));
	alunoTr.appendChild(montaTd(aluno.matricula, "info-matricula"));
	alunoTr.appendChild(montaTd(aluno.curso, "info-curso"));
	alunoTr.appendChild(montaTd(aluno.estadocivil, "info-estudocivil"));

	return alunoTr;
}

function montaTd(dado, classe) {
	var td = document.createElement("td");
	td.textContent = dado;
	td.classList.add(classe);

	return td;
}