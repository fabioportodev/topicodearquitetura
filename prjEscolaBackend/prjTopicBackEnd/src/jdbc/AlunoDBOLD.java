//package jdbc;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import model.Aluno;
//
//public class AlunoDBOLD {
//	
//	public void save(Aluno aluno) {
//		
//		String sql = "INSERT INTO aluno (nomealuno, matricula, estcivil) VALUES ('" + aluno.getNome() + "', '" + aluno.getMatricula() + "', '" + aluno.getEstadoCivil() +"')";
//		Connection conexao = ConexaoJDBC.getConexao();
//		try {
//			Statement declaracao = conexao.createStatement();
//			System.out.println(declaracao.executeUpdate(sql));
//			ConexaoJDBC.close(conexao, declaracao);
//			System.out.println("Registro inserido com sucesso!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void delete(Aluno aluno) {
//		
//		if(aluno == null || aluno.getId() == null) {
//			System.out.println("Não foi possível excluir o registro");
//			return;
//		}
//		String sql = "DELETE FROM aluno WHERE idaluno ='" + aluno.getId() + "'";
//		Connection conexao = ConexaoJDBC.getConexao();
//		try {
//			Statement declaracao = conexao.createStatement();
//			System.out.println(declaracao.executeUpdate(sql));
//			ConexaoJDBC.close(conexao, declaracao);
//			System.out.println("Registro excluído com sucesso!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public static void update(Aluno aluno) {
//		
//		if(aluno == null || aluno.getId() == null) {
//			System.out.println("Não foi possível excluir o registro");
//			return;
//		}
//		String sql = "UPDATE aluno SET nomealuno = '" + aluno.getNome() +"', matricula = '" + aluno.getMatricula() + "', estcivil = '" + aluno.getEstadoCivil() + "' WHERE idaluno = '" + aluno.getId() + "'";
//		Connection conexao = ConexaoJDBC.getConexao();
//		try {
//			Statement declaracao = conexao.createStatement();
//			System.out.println(declaracao.executeUpdate(sql));
//			ConexaoJDBC.close(conexao, declaracao);
//			System.out.println("Registro atualizado com sucesso!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public static List<Aluno> selectAll() {
//		
//		String sql = "SELECT idaluno, nomealuno, matricula, estcivil FROM aluno";
//		Connection conexao = ConexaoJDBC.getConexao();
//		List<Aluno> alunoList = new ArrayList<>();
//		
//		try {
//			Statement declaracao = conexao.createStatement();
//			ResultSet resultado = declaracao.executeQuery(sql);
//			while(resultado.next()) {
//				alunoList.add(new Aluno(resultado.getInt("idaluno"), resultado.getString("nomealuno"), resultado.getInt("matricula"), resultado.getString("estcivil")));
//				System.out.println(resultado.getInt(1));
//				System.out.println(resultado.getString("nomealuno"));
//				System.out.println(resultado.getString(3));
//				
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
//	public static List<Aluno> searchByName(String nome) {
//		
//		String sql = "SELECT idaluno, nomealuno, matricula, estcivil FROM aluno WHERE nomealuno like '%" + nome +"%' ";
//		Connection conexao = ConexaoJDBC.getConexao();
//		List<Aluno> alunoList = new ArrayList<>();
//		
//		try {
//			Statement declaracao = conexao.createStatement();
//			ResultSet resultado = declaracao.executeQuery(sql);
//			while(resultado.next()) {
//				alunoList.add(new Aluno(resultado.getInt("idaluno"), resultado.getString("nomealuno"), resultado.getInt("matricula"), resultado.getString("estcivil")));
//				System.out.println(resultado.getInt(1));
//				System.out.println(resultado.getString("nomealuno"));
//				System.out.println(resultado.getString(3));
//				
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
//	public static void selectMetaData() {
//		
//		String sql = "SELECT * FROM aluno";
//		Connection conexao = ConexaoJDBC.getConexao();
//		
//		try {
//			Statement declaracao = conexao.createStatement();
//			ResultSet resultado = declaracao.executeQuery(sql);
//			ResultSetMetaData data = resultado.getMetaData();
//			resultado.next();
//			int qntColunas = data.getColumnCount();
//			System.out.println("A quantidade de colunas é: " + qntColunas);
//			for (int i = 1; i <= qntColunas; i++) {
//				System.out.println("Tabelas: " + data.getTableName(i));
//				System.out.println("Nome coluna: " + data.getColumnName(i));
//				System.out.println("Tamanho coluna: " + data.getColumnDisplaySize(i));
//			}
//			
//			ConexaoJDBC.close(conexao, declaracao, resultado);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//}
