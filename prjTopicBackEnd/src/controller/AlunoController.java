package controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import service.AlunoService;
import dto.AlunoDTO;


@Path("/aluno")
public class AlunoController {
	 
	@GET
	@Produces("text/plain")
	public String getAlunos() {
		
		
	AlunoService sAlunos = new AlunoService();
	List<AlunoDTO> alunos = sAlunos.getTodosAlunos();
		return "ALUNOOOOOOOOOOOOOOOOO";
	}
	
}
