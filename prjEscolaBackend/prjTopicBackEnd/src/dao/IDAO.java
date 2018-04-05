package dao;

import java.util.List;

public interface IDAO<T> {

	public void salvar(T novo);
	
	public void alterar(T obj);
	
	public void remover(T obj);
	
	public T recuperarPelaId(Long id);
	
	public List<T> recuperarTodos();
	
}
