package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConexaoJDBC;
import model.Curso;

public class CursoDAO implements IDAO<Curso>{
	
	private static final String TABELA_NOME = "tab_curso";
	private static final String CAMPO_ID = "id";
	private static final String CAMPO_CODIGO = "codigo";
	private static final String CAMPO_NOME = "nome";
	
	
	
	
//	
//	public void save(Curso curso) {
//			
//			String sql = "INSERT INTO curso (nomecurso) VALUES (?)";
//			
//			try(Connection conexao = ConexaoJDBC.getConexao();
//				PreparedStatement preparacao = conexao.prepareStatement(sql)) {
//				preparacao.setString(1, curso.getNome());
//				preparacao.executeUpdate(sql);
//				ConexaoJDBC.close(conexao, preparacao);
//				System.out.println("Registro inserido com sucesso!");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	
//	public void delete(Curso curso) {
//		
//		if(curso == null || curso.getId() == null) {
//			System.out.println("Não foi possível excluir o registro");
//			return;
//		}
//		String sql = "DELETE FROM curso WHERE idcurso = ?";
//		
//		try(Connection conexao = ConexaoJDBC.getConexao();
//			PreparedStatement preparacao = conexao.prepareStatement(sql)) {
//			preparacao.setInt(1, curso.getId());
//			preparacao.executeUpdate(sql);
//			ConexaoJDBC.close(conexao, preparacao);
//			System.out.println("Registro excluído com sucesso!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public static void update(Curso curso) {
//		
//		if(curso == null || curso.getId() == null) {
//			System.out.println("Não foi possível excluir o registro");
//			return;
//		}
//		String sql = "UPDATE curso SET nomecurso = ? WHERE idcurso = ?";
//		try(Connection conexao = ConexaoJDBC.getConexao(); 
//			PreparedStatement preparacao = conexao.prepareStatement(sql)) {
//			preparacao.setString(1, curso.getNome());
//			preparacao.setInt(1, curso.getId());
//			preparacao.executeUpdate(sql);
//			//ConexaoJDBC.close(conexao, preparacao);
//			System.out.println("Registro atualizado com sucesso!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public static List<Curso> selectAll() {
//		
//		String sql = "SELECT idcurso, nomecurso FROM curso";
//		Connection conexao = ConexaoJDBC.getConexao();
//		List<Curso> cursoList = new ArrayList<>();
//		
//		try {
//			Statement declaracao = conexao.createStatement();
//			ResultSet resultado = declaracao.executeQuery(sql);
//			while(resultado.next()) {
//				cursoList.add(new Curso(resultado.getInt("idcurso"), resultado.getString("nomecurso")));
//				System.out.println(resultado.getInt(1));
//				System.out.println(resultado.getString("nomealuno"));				
//			}
//			ConexaoJDBC.close(conexao, declaracao, resultado);
//			System.out.println("Registro inserido com sucesso!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
//	
//	public static List<Curso> searchByName(String nome) {
//		
//		String sql = "SELECT idcurso, nomecurso FROM curso WHERE nomecurso like '%" + nome +"%' ";
//		List<Curso> alunoList = new ArrayList<>();
//		try(Connection conexao = ConexaoJDBC.getConexao(); 
//			PreparedStatement preparacao = conexao.prepareStatement(sql)) {
//			preparacao.setString(1, "%" + nome + "%");
//			ResultSet resultado = preparacao.executeQuery();
//			while(resultado.next()) {
//				alunoList.add(new Curso(resultado.getInt("idcurso"), resultado.getString("nomecurso")));			
//			}
//			ConexaoJDBC.close(conexao, preparacao, resultado);
//			System.out.println("Registro inserido com sucesso!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
	
	
	
	
	
	
	
	
	
	/** 
	 * 
	 * 
	 * O CÓDIGO ACIMA É PARA COMPARAÇÃO E ESTUDO COM O CÓDIGO ABAIXO
	 * 
	 * (MANTENHA COMENTADO OU APAGUE, HÁ ERROS)
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	
	
	
	

	@Override
	public void salvar(Curso novo) {
		String sql = "INSERT INTO " + TABELA_NOME + " (";
		sql += CAMPO_CODIGO + ", ";
		sql += CAMPO_NOME + ") ";
		sql += "VALUES (?, ?)";
		
		Connection connection = ConexaoJDBC.getConexao();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, novo.getCodigo());
			preparedStatement.setString(2, novo.getNome());
			preparedStatement.execute(sql);
			
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Curso obj) {
		Connection connection = ConexaoJDBC.getConexao();
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE " + TABELA_NOME + " SET ";
		sql += CAMPO_CODIGO + " = ?, ";
		sql += CAMPO_NOME + " = ? ";
		sql += "WHERE " + CAMPO_ID + " = ?";
		
		
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, obj.getCodigo());
			preparedStatement.setString(2, obj.getNome());
			preparedStatement.setLong(3, obj.getId());
			preparedStatement.executeUpdate(sql);
			
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void remover(Curso obj) {
		Connection connection = ConexaoJDBC.getConexao();
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM " + TABELA_NOME;
		sql += " WHERE " + CAMPO_ID  + " = ?";

		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, obj.getId());
			preparedStatement.executeUpdate(sql);
			
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Curso recuperarPelaId(Long id) {
		Connection connection = ConexaoJDBC.getConexao();
		String sql = "SELECT * FROM " + TABELA_NOME;
		sql += " WHERE " + CAMPO_ID + " = ?";
		
		Curso curso = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultado = preparedStatement.executeQuery();
						
			if(resultado.next()) {
				curso = new Curso();
				
				curso.setId(resultado.getLong(CAMPO_ID));
				curso.setCodigo(resultado.getInt(CAMPO_CODIGO));
				curso.setNome(resultado.getString(CAMPO_NOME));

			}
			
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return curso;
	}

	@Override
	public List<Curso> recuperarTodos() {
		Connection connection = ConexaoJDBC.getConexao();
		String sql = "SELECT * FROM " + TABELA_NOME;
		
		List<Curso> listaCursos = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery(sql);
			listaCursos = new ArrayList<>();
			
			while(resultado.next()) {
				Curso curso = new Curso();
				
				curso.setId(resultado.getLong(CAMPO_ID));
				curso.setCodigo(resultado.getInt(CAMPO_CODIGO));
				curso.setNome(resultado.getString(CAMPO_NOME));

				listaCursos.add(curso);
			}
			
			
//			System.out.println("Registro inserido com sucesso!");
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCursos;
	}

	
	
	/**
	 * Recurso de CursoDAO
	 */
	public static Curso recuperarPeloCodigo(int id) {
		
		Connection connection = ConexaoJDBC.getConexao();
		String sql = "SELECT * FROM " + TABELA_NOME;
		sql += " WHERE " + CAMPO_CODIGO + " = ?";
		
		Curso curso = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultado = preparedStatement.executeQuery();
						
			if(resultado.next()) {
				curso = new Curso();
				
				curso.setId(resultado.getLong(CAMPO_ID));
				curso.setCodigo(resultado.getInt(CAMPO_CODIGO));
				curso.setNome(resultado.getString(CAMPO_NOME));

			}
			
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return curso;
		
	}
	
	
	
	/**
	 * Recurso de CursoDAO
	 */
	public List<Curso> recuperarPeloNome(String nome) {
		
		Connection connection = ConexaoJDBC.getConexao();
		String sql = "SELECT * FROM " + TABELA_NOME;
		sql += " WHERE " + CAMPO_NOME;
		sql += " LIKE %" + nome + "%";

		List<Curso> listaCursos = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nome);
			ResultSet resultado = preparedStatement.executeQuery();

			listaCursos = new ArrayList<>();
			
			while(resultado.next()) {
				Curso curso = new Curso();
				
				curso.setId(resultado.getLong(CAMPO_ID));
				curso.setCodigo(resultado.getInt(CAMPO_CODIGO));
				curso.setNome(resultado.getString(CAMPO_NOME));

				listaCursos.add(curso);
			}
			
			
//			System.out.println("Registro inserido com sucesso!");
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCursos;
	}
	
	
}
