package dto;

public class AlunoDTO {

	String matricula;      //     TENTE COLOCAR TODOS OS PAR�METROS DO DTO COMO STRING !!
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
	 * VALIDA��O DE DADOS N�O � RESPONSABILIDADE DO DTO !!!!!
	 * 
	 * 
	
	
	public static void validarMatricula(int matricula) {
		if (matricula < 1 || matricula > 99) {
			System.out.println("Valor n�o aceit�vel."); 
		}

	}

	public static void validarNome(String nome) {
		if (nome == null || nome.length() < 51) {
			System.out.println("Nome n�o aceit�vel");
		}
	}
	
	*/

	
}
