package service;

import model.Curso;
import dto.CursoDTO;

public class CursoService {

	
	
	
	public void inserir(CursoDTO cursoDTO)throws Exception {
		if(cursoDTO.getNomeCurso()== null || cursoDTO.getNomeCurso()==""){
		throw new Exception();
		}
		
		if(cursoDTO.getIdCurso()== null || cursoDTO.getIdCurso()== ""){
			throw new Exception();
			
		}
		
		try {
			Long.parseLong(cursoDTO.getIdCurso());
		}
		catch (NumberFormatException e) {
			throw new Exception("Este valor não é um Long");
		}
		
		
//		for(int i = 0; i < cursoDTO.getIdCurso().length(); i++) {
//			String numero = "0123456789";
//			if(!numero.contains(cursoDTO.getIdCurso().substring(i, 1)))
//				throw new Exception("Este valor não é um Long");
//	Forma de validar string para numeros.							
//		}
				
				
				
		Curso curso = new Curso();
		curso.setNome(cursoDTO.getNomeCurso());
		curso.setId(Long.parseLong(cursoDTO.getIdCurso()));
	}
	
		
}

