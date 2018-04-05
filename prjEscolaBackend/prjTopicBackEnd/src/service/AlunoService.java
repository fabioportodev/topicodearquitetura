package service;

import java.util.List;

import model.Aluno;
import dao.AlunoDAO;
import dto.AlunoDTO;

public class AlunoService {
   
	
	
	/*
	 * ESTA É A CAMADA DE SERVIÇO. ELA É RESPONSÁVEL POR FAZER AS VALIDAÇÕES
	 * DOS DADOS PASSADOS AO DTO NO CONSTRUTOR. É AQUI ONDE
	 * VOCÊ APLICA AS >> REGRAS DE NEGÓCIO <<
	 * 
	 * RESSALTO QUE AS INFORMAÇÕES DEVEM SER VALIDADAS ANTES DE INICIAR 
	 * QUALQUER PROCESSO DE PERSISTÊNCIA. É IMPORTANTE QUE AS INFORMAÇÕES
	 * QUE SERÃO PASSADAS AO SEU BANCO DE DADOS SEJAM ÍNTEGRAS.
	 * 
	 * TODOS AS INFORMAÇÕES RECEBIDAS DE ALGUMA VIEW SERÃO VALIDADAS E ASSIM
	 * "MOLDADAS" PARA QUE ENTÃO POSSAM SE TORNAR UM OBJETO DE DOMÍNIO (AQUELES
	 * DOMAIN OBJETCS << CLASSES DE DOMÍNIO) E ENFIM SER PERSISTIDO.  
	 * 
	 *  É POR AQUI TAMBÉM ONDE TODOS OS SERVIÇOS QUE SEU SISTEMA OFERECE SÃO
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
