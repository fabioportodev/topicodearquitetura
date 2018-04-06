package model;

public class Curso {
	
	private Long id;
	/**
	 * O atributo 'codigo' pode ser utilizado como
	 * chave primária da entidade Curso. (campo UNIQUE)
	 */
	private int codigo;
	private String nome;

	public Curso() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	
	
}
