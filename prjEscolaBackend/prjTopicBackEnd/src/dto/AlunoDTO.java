package dto;

public class AlunoDTO {

	String matricula;      //     TENTE COLOCAR TODOS OS PARÂMETROS DO DTO COMO STRING !!
	String nome;



	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setMatricula(String matricula){
//        AlunoDTO.validarMatricula(matricula);
		this.matricula = matricula;
	}

	public void setNome(String nome) {
//		AlunoDTO.validarNome(nome);                  
		this.nome = nome;
	}
	

	/**
	 * 
	 * VALIDAÇÃO DE DADOS NÃO É RESPONSABILIDADE DO DTO !!!!!
	 * 
	 * 
	
	
	public static void validarMatricula(int matricula) {
		if (matricula < 1 || matricula > 99) {
			System.out.println("Valor não aceitável."); 
		}

	}

	public static void validarNome(String nome) {
		if (nome == null || nome.length() < 51) {
			System.out.println("Nome não aceitável");
		}
	}
	
	*/

	
}
