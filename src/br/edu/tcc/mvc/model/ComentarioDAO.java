package br.edu.tcc.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO {
	private Connection c;
	
	public void inserirComentario(ComentarioBean dados){
		try{
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c.prepareStatement("INSERT INTO comentarios (usuario_id, tutorial_id, comentario, data_comentario, conceito)"
			+ "VALUES (?,?,?,?,?)");
			sql.setString(1, dados.getUsuario_id());
			sql.setInt(2, dados.getTutorial_id());
			sql.setString(3, dados.getComentario());
			sql.setString(4, dados.getDataComentario());
			sql.setString(5, "Apto");
			sql.executeUpdate();
			
			sql.close();
			sql = null;
			c.close();
			c = null;
			
		} catch (SQLException e){
			System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e);
		}
	}
	
	public void excluiComentario(ComentarioBean dados){
		try{
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c.prepareStatement("UPDATE comentarios SET conceito = 'Excluido' WHERE comentario_id = ?");
			sql.setInt(1, dados.getComentario_id());
			
			sql.executeUpdate();
			
			sql.close();
			sql = null;
			c.close();
			c = null;
			
		} catch (SQLException e){
			System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e);
		} 
	}
	
	public void denunciaComentario(ComentarioBean dados){
		try{
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c.prepareStatement("UPDATE comentarios SET conceito = 'Aguardando' WHERE comentario_id = ?");
			sql.setInt(1, dados.getComentario_id());
			
			sql.executeUpdate();
			
			sql.close();
			sql = null;
			c.close();
			c = null;
			
		} catch (SQLException e){
			System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e);
		} 
	}
	public List<ComentarioBean> getComentariosTutorial(int tutorialId){
		List<ComentarioBean> comentarios = new ArrayList<>();
		
		try{
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c.prepareStatement("SELECT comentario, "
					+ "CONCAT(DAYOFMONTH(data_comentario),'/',MONTH(data_comentario),'/',YEAR(data_comentario)) as data_comentario, "
					+ "comentario_id, comentarios.usuario_id FROM comentarios"
					+ " LEFT JOIN login on comentarios.usuario_id = login.usuario_id"
					+ " LEFT JOIN tutoriais on comentarios.tutorial_id = tutoriais.tutorial_id"
					+ " WHERE comentarios.tutorial_id = ? AND comentarios.conceito = 'Apto' OR"
					+ " comentarios.tutorial_id = ? AND comentarios.conceito = 'Aguardando' ORDER BY comentario_id DESC;");
			sql.setInt(1, tutorialId);
			sql.setInt(2, tutorialId);
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()){
				ComentarioBean comentario = new ComentarioBean();
				comentario.setComentario(rs.getString("comentario"));
				comentario.setDataComentario(rs.getString("data_comentario"));
				comentario.setComentario_id(rs.getInt("comentario_id"));
				comentario.setUsuario_id(rs.getString("usuario_id"));
				comentarios.add(comentario);
			}
			
			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;
			
		} catch (SQLException e){
			System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e);
		}
		
		return comentarios;
		
	}
	
	
}
