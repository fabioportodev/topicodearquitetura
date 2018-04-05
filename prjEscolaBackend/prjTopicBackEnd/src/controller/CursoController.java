package controller;

import javax.ws.rs.Path;

import service.CursoService;
import dto.CursoDTO;

@Path("/curso")
public class CursoController {
	
	public void inserirCurso(CursoDTO cursoDTO) throws Exception {
		CursoService Curso = new CursoService();
		Curso.inserir(cursoDTO);
	}
	


}
