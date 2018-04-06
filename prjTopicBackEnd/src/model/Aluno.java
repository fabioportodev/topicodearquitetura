package model;

public class Aluno {
	private Long id;
	/**
	 * O atributo 'matricula' pode ser utilizado como
	 * chave primária da entidade Aluno. (campo UNIQUE)
	 */
	private int matricula;
	private String nome;
	private String estadoCivil;

	private Curso curso;
	
		
	public Aluno() {}
	
	
	public Aluno(Long id, String nome, int matricula, String estadoCivil) {
//		super(); ???? Esta classe Aluno é subclasse de alguma outra classe ???
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.estadoCivil = estadoCivil;
	}
	

	public Aluno(String nome, int matricula, String estadoCivil) {
		this.nome = nome;
		this.matricula = matricula;
		this.estadoCivil = estadoCivil;
	}

	public Aluno(String nome, int matricula, Curso curso, String estadoCivil) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.estadoCivil = estadoCivil;
	}
	
	public Aluno(Long id, String nome, int matricula, Curso curso, String estadoCivil) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.estadoCivil = estadoCivil;
	}



	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	
	

}
