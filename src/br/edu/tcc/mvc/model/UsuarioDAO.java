package br.edu.tcc.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	private Connection c;
	
	
	public String recuperaSenha(String usuario){
		String senhaTemporaria = "";
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql1 = c.prepareStatement("select REPLACE(concat(MONTH(NOW()),SUBSTRING(cpf,1,9), DAY(NOW())), '.', '')"
					+ " as token from login where usuario_id = ?");
			sql1.setString(1, usuario);
			
			ResultSet rs = sql1.executeQuery();
			while(rs.next()){
				 senhaTemporaria = rs.getString("token");
			}
						
			PreparedStatement sql2 = c.prepareStatement("update login set senha = ? where usuario_id = ?");
			sql2.setString(1, senhaTemporaria);
			sql2.setString(2, usuario);
			
			sql2.executeUpdate();
			
			sql1.close();
			sql1 = null;
			rs.close();
			rs = null;
			sql2.close();
			sql2 = null;
			c.close();
			c = null;
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e);
		}
		return senhaTemporaria;
	}
	
	public void excluiUsuario(String usuario) {
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("update login set tipo = ? where usuario_id = ?");
			sql.setString(1, "UD");
			sql.setString(2, usuario);

			sql.executeUpdate();
			
			sql.close();
			sql = null;
			c.close();
			c = null;
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e);
		}
	}
	
	public void recuperaUsuario(String usuario) {
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("update login set tipo = ? where usuario_id = ?");
			sql.setString(1, "U");
			sql.setString(2, usuario);

			sql.executeUpdate();
			
			sql.close();
			sql = null;
			c.close();
			c = null;
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e);
		}
	}

	public void alteraUsuario(String oldUser, UsuarioBean dados) {
		if (dados.getSenha().equals("")) {
			try {
				this.c = ConnectionFactory.getConnection();
				PreparedStatement sql = c.prepareStatement("select senha from login where usuario_id = ?");
				sql.setString(1, oldUser);
				ResultSet rs = sql.executeQuery();

				while (rs.next()) {
					dados.setSenha(rs.getString("senha"));
				}
				
				sql.close();
				sql = null;
				rs.close();
				rs = null;
				
				PreparedStatement sql2 = c.prepareStatement("update login set nome = ?, "
								+ "email = ?, senha = ?, experiencia = ?, comentario_experiencia = ?, usuario_id = ? where usuario_id = ?");
				sql2.setString(1, dados.getNome());
				sql2.setString(2, dados.getEmail());
				sql2.setString(3, dados.getSenha());
				sql2.setString(4, dados.getExperiencia());
				sql2.setString(5, dados.getComentarioExperiencia());
				sql2.setString(6, dados.getUsuario());				
				sql2.setString(7, oldUser);
				
				sql2.executeUpdate();
				
				sql2.close();
				sql2 = null;
				c.close();
				c = null;
				
			} catch (SQLException e) {
				System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e);
			}
		} else {
			try {
				this.c = ConnectionFactory.getConnection();
				PreparedStatement sql2 = c
						.prepareStatement("update login set nome = ?, "
								+ "email = ?, senha = ?, experiencia = ?, comentario_experiencia = ?, usuario_id = ? where usuario_id = ?");
				sql2.setString(1, dados.getNome());
				sql2.setString(2, dados.getEmail());
				sql2.setString(3, dados.getSenha());
				sql2.setString(4, dados.getExperiencia());
				sql2.setString(5, dados.getComentarioExperiencia());
				sql2.setString(6, dados.getUsuario());				
				sql2.setString(7, oldUser);
				
				sql2.executeUpdate();
				
				sql2.close();
				sql2 = null;
				c.close();
				c = null;
				
			} catch (SQLException e) {
				System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e);
			}
		}
	}
	
	public UsuarioBean pesquisaUsuarioExcluido(String usuario) {
		UsuarioBean bean = new UsuarioBean();
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select cpf, nome, email, experiencia, comentario_experiencia from login where usuario_id = ? and tipo = 'UD'");
			sql.setString(1, usuario);

			ResultSet rs = sql.executeQuery();

			while (rs.next()) {
				bean.setCpf(rs.getString("cpf"));
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setExperiencia(rs.getString("experiencia"));
				bean.setComentarioExperiencia(rs.getString("comentario_experiencia"));
			}
			
			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;;
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}
		return bean;

	}
	
	public UsuarioBean pesquisaUsuario(String usuario) {
		UsuarioBean bean = new UsuarioBean();
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select cpf, nome, email, experiencia, tipo, comentario_experiencia from login where usuario_id = ? and tipo = 'U' or usuario_id = ? and tipo='M'");
			sql.setString(1, usuario);
			sql.setString(2, usuario);

			ResultSet rs = sql.executeQuery();
			
			while (rs.next()) {
				bean.setCpf(rs.getString("cpf"));
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setExperiencia(rs.getString("experiencia"));
				bean.setComentarioExperiencia(rs.getString("comentario_experiencia"));
				bean.setTipo(rs.getString("tipo"));
			}
			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;;
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}
		return bean;

	}

	public int loginUsuario(UsuarioBean bean) {
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select usuario_id, senha from login where usuario_id = ? and senha = ? and tipo = 'u'");
			sql.setString(1, bean.getUsuario());
			sql.setString(2, bean.getSenha());

			ResultSet rs = sql.executeQuery();

			if (rs.next()) {
				sql.close();
				sql = null;
				rs.close();
				rs = null;
				c.close();
				c = null;
				return 1;
			} else {
				sql.close();
				sql = null;
				rs.close();
				rs = null;
				c.close();
				c = null;
				return 0;
			}
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
			return 0;
		}
	}

	public void cadastroUsuario(UsuarioBean bean) {
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("INSERT INTO login (usuario_id, cpf, nome, senha, email, tipo, data_cadastro, comentario_experiencia, experiencia) "
							+ "VALUES (?,?,?,?,?,?,?,?,?)");
			sql.setString(1, bean.getUsuario());
			sql.setString(2, bean.getCpf());
			sql.setString(3, bean.getNome());
			sql.setString(4, bean.getSenha());
			sql.setString(5, bean.getEmail());
			sql.setString(6, "U");
			sql.setString(7, bean.getData());
			sql.setString(8, bean.getComentarioExperiencia());
			sql.setString(9, bean.getExperiencia());
			sql.execute();
			
			sql.close();
			sql = null;
			c.close();
			c = null;
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "+ e);				
		}
	}

	public int pesquisaDados(String dado, String valor) {
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select " + dado + " from login where " + dado + "= " + "'"+valor+"'");
			
			ResultSet rs = sql.executeQuery();

			if (rs.next()) {
				sql.close();
				sql = null;
				rs.close();
				rs = null;
				c.close();
				c = null;
				return 1;
			} else {
				sql.close();
				sql = null;
				rs.close();
				rs = null;
				c.close();
				c = null;
				return 0;
			}
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
			return 0;
		}
		
	}

}
