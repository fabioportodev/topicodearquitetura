package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConexaoJDBC;
import model.Aluno;

public class AlunoDAO implements IDAO<Aluno> {

	
	private static final String TABELA_NOME = "tab_aluno";
	private static final String CAMPO_ID = "id";
	private static final String CAMPO_MATRICULA = "matricula";
	private static final String CAMPO_NOME = "nome";
	private static final String CAMPO_ESTADO_CIVIL = "estado_civil";
	private static final String CAMPO_CODIGO_CURSO = "codigo_curso";
	
	

	@Override
	public void salvar(Aluno novo) {
		String sql = "INSERT INTO " + TABELA_NOME + " (";
		sql += CAMPO_MATRICULA + ", ";
		sql += CAMPO_NOME + ", ";
		sql += CAMPO_ESTADO_CIVIL + ", ";
		sql += CAMPO_CODIGO_CURSO + ") ";
		sql += "VALUES (?, ?, ?, ?)";
		
		Connection connection = ConexaoJDBC.getConexao();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, novo.getMatricula());
			preparedStatement.setString(2, novo.getNome());
			preparedStatement.setString(3, novo.getEstadoCivil());
			preparedStatement.setInt(4, novo.getCurso().getCodigo());
			preparedStatement.execute(sql);
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void alterar(Aluno obj) {
		
//		if(aluno == null || aluno.getId() == null) {
//			System.out.println("Não foi possível excluir o registro");
//			return;
//		}

		Connection connection = ConexaoJDBC.getConexao();
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE " + TABELA_NOME + " SET ";
		sql += CAMPO_MATRICULA + " = ?, ";
		sql += CAMPO_NOME + " = ?, ";
		sql += CAMPO_ESTADO_CIVIL + " = ?, ";
		sql += CAMPO_CODIGO_CURSO + " = ? ";
		sql += "WHERE " + CAMPO_ID + " = ?";
		
		
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, obj.getMatricula());
			preparedStatement.setString(2, obj.getNome());
			preparedStatement.setString(3, obj.getEstadoCivil());
			preparedStatement.setInt(4, obj.getCurso().getCodigo());
			preparedStatement.setLong(5, obj.getId());
			preparedStatement.executeUpdate(sql);
			
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public void remover(Aluno obj) {
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
	public Aluno recuperarPelaId(Long id) {
		Connection connection = ConexaoJDBC.getConexao();
		String sql = "SELECT * FROM " + TABELA_NOME;
		sql += " WHERE " + CAMPO_ID + " = ?";
		
		Aluno aluno = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultado = preparedStatement.executeQuery();
						
			if(resultado.next()) {
				aluno = new Aluno();
				
				aluno.setId(resultado.getLong(CAMPO_ID));
				aluno.setMatricula(resultado.getInt(CAMPO_MATRICULA));
				aluno.setNome(resultado.getString(CAMPO_NOME));
				aluno.setEstadoCivil(resultado.getString(CAMPO_ESTADO_CIVIL));
				aluno.setCurso(CursoDAO.recuperarPeloCodigo(resultado.getInt(CAMPO_CODIGO_CURSO)));

			}
			
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aluno;
	}


	
	
	
	@Override
	public List<Aluno> recuperarTodos() {
		
		Connection connection = ConexaoJDBC.getConexao();
		String sql = "SELECT * FROM " + TABELA_NOME;

		List<Aluno> listaAlunos = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery(sql);
			listaAlunos = new ArrayList<>();
			
			while(resultado.next()) {
				Aluno aluno = new Aluno();
				
				aluno.setId(resultado.getLong(CAMPO_ID));
				aluno.setMatricula(resultado.getInt(CAMPO_MATRICULA));
				aluno.setNome(resultado.getString(CAMPO_NOME));
				aluno.setEstadoCivil(resultado.getString(CAMPO_ESTADO_CIVIL));
				aluno.setCurso(CursoDAO.recuperarPeloCodigo(resultado.getInt(CAMPO_CODIGO_CURSO)));

				listaAlunos.add(aluno);
			}
			
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaAlunos;
	}

	
	
	/**
	 * Recurso de AlunoDAO
	 */
	public Aluno recuperarPelaMatricula(int matricula) {
		Connection connection = ConexaoJDBC.getConexao();
		String sql = "SELECT * FROM " + TABELA_NOME;
		sql += " WHERE " + CAMPO_MATRICULA + " = ?";
		
		Aluno aluno = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, matricula);
			ResultSet resultado = preparedStatement.executeQuery();
						
			if(resultado.next()) {
				aluno = new Aluno();
				
				aluno.setId(resultado.getLong(CAMPO_ID));
				aluno.setMatricula(resultado.getInt(CAMPO_MATRICULA));
				aluno.setNome(resultado.getString(CAMPO_NOME));
				aluno.setEstadoCivil(resultado.getString(CAMPO_ESTADO_CIVIL));
				aluno.setCurso(CursoDAO.recuperarPeloCodigo(resultado.getInt(CAMPO_CODIGO_CURSO)));

				
			}
			
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aluno;
	}
	
	
	/**
	 * Recurso de AlunoDAO
	 */
	public List<Aluno> recuperarPeloNome(String nome) {
		
		Connection connection = ConexaoJDBC.getConexao();
		String sql = "SELECT * FROM " + TABELA_NOME;
		sql += " WHERE " + CAMPO_NOME;
		sql += " LIKE %" + nome + "%";

		List<Aluno> listaAlunos = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nome);
			ResultSet resultado = preparedStatement.executeQuery();

			listaAlunos = new ArrayList<>();
			
			while(resultado.next()) {
				Aluno aluno = new Aluno();
				
				aluno.setId(resultado.getLong(CAMPO_ID));
				aluno.setMatricula(resultado.getInt(CAMPO_MATRICULA));
				aluno.setNome(resultado.getString(CAMPO_NOME));
				aluno.setEstadoCivil(resultado.getString(CAMPO_ESTADO_CIVIL));
				aluno.setCurso(CursoDAO.recuperarPeloCodigo(resultado.getInt(CAMPO_CODIGO_CURSO)));

				listaAlunos.add(aluno);
			}
			
			
			// Encerrando a conexão com o banco
			if(connection != null)
				connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaAlunos;
	}
	
}
