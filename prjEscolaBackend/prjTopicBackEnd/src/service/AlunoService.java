package service;

import java.util.List;

import model.Aluno;
import dao.AlunoDAO;
import dto.AlunoDTO;

public class AlunoService {
   
	
	
	/*
	 * ESTA � A CAMADA DE SERVI�O. ELA � RESPONS�VEL POR FAZER AS VALIDA��ES
	 * DOS DADOS PASSADOS AO DTO NO CONSTRUTOR. � AQUI ONDE
	 * VOC� APLICA AS >> REGRAS DE NEG�CIO <<
	 * 
	 * RESSALTO QUE AS INFORMA��ES DEVEM SER VALIDADAS ANTES DE INICIAR 
	 * QUALQUER PROCESSO DE PERSIST�NCIA. � IMPORTANTE QUE AS INFORMA��ES
	 * QUE SER�O PASSADAS AO SEU BANCO DE DADOS SEJAM �NTEGRAS.
	 * 
	 * TODOS AS INFORMA��ES RECEBIDAS DE ALGUMA VIEW SER�O VALIDADAS E ASSIM
	 * "MOLDADAS" PARA QUE ENT�O POSSAM SE TORNAR UM OBJETO DE DOM�NIO (AQUELES
	 * DOMAIN OBJETCS << CLASSES DE DOM�NIO) E ENFIM SER PERSISTIDO.  
	 * 
	 *  � POR AQUI TAMB�M ONDE TODOS OS SERVI�OS QUE SEU SISTEMA OFERECE S�O
	 *  CONFIGURADAS PARA AS CAMADAS QUE ACESSAM ESTA, COMO OS CONTROLLERS POR
	 *  EXEMPLO.
	 *  
	 *  BOM ESTUDO =)
	 *  
	 */
	
	
		
	
	
	
	public void cadastrar(AlunoDTO alunoDTO) throws Exception {
		if(alunoDTO.getNome() == null || alunoDTO.getNome() == "") {
			throw new Exception();
		}
		if(alunoDTO.getMatricula() == null || alunoDTO.getMatricula() == "") {
			throw new Exception();
		}
		
		
		Aluno aluno = new Aluno();
		aluno.setMatricula(Integer.parseInt(alunoDTO.getMatricula()));
		aluno.setNome(alunoDTO.getNome());
		// O restante dos atributos...
 
		
		AlunoDAO dao = new AlunoDAO();
		dao.salvar(aluno);
		
		
		
				
	
	}
	
	public List<AlunoDTO> getTodosAlunos() {
		return null;
	
	}
	
	
	
}