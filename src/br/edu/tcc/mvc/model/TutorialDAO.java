package br.edu.tcc.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorialDAO {
	private Connection c;

	public void insertTutorial(TutorialBean bean) {
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("INSERT INTO tutoriais (titulo, tema, data_postagem, conceito, caminho_pdf, usuario_id, visualizacoes)"
							+ "VALUES (?,?,?,?,?,?,?)");
			sql.setString(1, bean.getTitulo());
			sql.setString(2, bean.getTema());
			sql.setString(3, bean.getData());
			sql.setString(4, bean.getConceito());
			sql.setString(5, bean.getCaminho_pdf());
			sql.setString(6, bean.getUsuario_id());
			sql.setInt(7, 0);
			sql.execute();

			sql.close();
			sql = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}
	}

	public List<TutorialBean> getPopularesHardware() {
		List<TutorialBean> listaPopularesHardware = new ArrayList<TutorialBean>();

		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select titulo from tutoriais where tema like 'hardware' and conceito = 'apto' ORDER BY visualizacoes desc LIMIT 5");
			ResultSet rs = sql.executeQuery();

			while (rs.next()) {
				TutorialBean tutoriais = new TutorialBean();
				tutoriais.setTitulo(rs.getString("titulo"));
				listaPopularesHardware.add(tutoriais);
			}

			rs.close();
			sql.close();
			sql = null;
			rs = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}

		return listaPopularesHardware;
	}

	public List<TutorialBean> getPopularesRedes() {
		List<TutorialBean> listaPopularesRedes = new ArrayList<TutorialBean>();

		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select titulo from tutoriais where tema like 'redes' and conceito = 'apto' ORDER BY visualizacoes desc LIMIT 5");
			ResultSet rs = sql.executeQuery();

			while (rs.next()) {
				TutorialBean tutoriais = new TutorialBean();
				tutoriais.setTitulo(rs.getString("titulo"));
				listaPopularesRedes.add(tutoriais);
			}

			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}

		return listaPopularesRedes;
	}

	public List<TutorialBean> getPopularesSO() {
		List<TutorialBean> listaPopularesSO = new ArrayList<TutorialBean>();

		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select titulo from tutoriais where tema like 'sistemas operacionais' and conceito = 'apto' ORDER BY visualizacoes desc LIMIT 5");
			ResultSet rs = sql.executeQuery();

			while (rs.next()) {
				TutorialBean tutoriais = new TutorialBean();
				tutoriais.setTitulo(rs.getString("titulo"));
				listaPopularesSO.add(tutoriais);
			}

			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}

		return listaPopularesSO;
	}

	public List<TutorialBean> getPopularesProgramacao() {
		List<TutorialBean> listaPopularesProgramacao = new ArrayList<TutorialBean>();

		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select titulo from tutoriais where tema like 'programacao' and conceito = 'apto' ORDER BY visualizacoes desc LIMIT 5");
			ResultSet rs = sql.executeQuery();

			while (rs.next()) {
				TutorialBean tutoriais = new TutorialBean();
				tutoriais.setTitulo(rs.getString("titulo"));
				listaPopularesProgramacao.add(tutoriais);
			}

			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}

		return listaPopularesProgramacao;
	}

	public TutorialBean pesquisaAptos(String titulo) {
		TutorialBean bean = new TutorialBean();
		String caminhoCompleto = "";
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select * from tutoriais where titulo = ? and conceito = 'Apto'");
			sql.setString(1, titulo);
			ResultSet rs = sql.executeQuery();
			while (rs.next()) {
				bean.setTitulo(rs.getString("titulo"));
				bean.setTutorialId(rs.getInt("tutorial_id"));
				bean.setUsuario_id(rs.getString("usuario_id"));
				bean.setTema(rs.getString("tema"));
				bean.setData(rs.getString("data_postagem"));
				caminhoCompleto = (rs.getString("caminho_pdf"));
			}

			PreparedStatement sql2 = c
					.prepareStatement("update tutoriais set visualizacoes = visualizacoes + 1 where tutorial_id = ?");
			sql2.setInt(1, bean.getTutorialId());
			sql2.executeUpdate();

			bean.setCaminho_pdf("http://localhost:8080/uploads/"
					+ (caminhoCompleto.substring(caminhoCompleto
							.indexOf("uploads") + 8)));

			sql2.close();
			sql2 = null;
			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}

		return bean;
	}

	public TutorialBean pesquisaTutorial(String titulo) {
		TutorialBean bean = new TutorialBean();
		String caminhoCompleto = "";
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select * from tutoriais where titulo = ?");
			sql.setString(1, titulo);
			ResultSet rs = sql.executeQuery();

			while (rs.next()) {
				bean.setTitulo(rs.getString("titulo"));
				bean.setTutorialId(rs.getInt("tutorial_id"));
				bean.setUsuario_id(rs.getString("usuario_id"));
				bean.setTema(rs.getString("tema"));
				caminhoCompleto = (rs.getString("caminho_pdf"));
			}

			bean.setCaminho_pdf("http://localhost:8080/uploads/"
					+ (caminhoCompleto.substring(caminhoCompleto
							.indexOf("uploads") + 8)));

			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}

		return bean;
	}

	public List<TutorialBean> pesquisaTutoriais(String titulo) {
		List<TutorialBean> resultados = new ArrayList<>();
		int contador = 0;
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select * from tutoriais where titulo like ? and conceito = 'apto'");
			sql.setString(1, "%" + titulo + "%");
			ResultSet rs = sql.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					TutorialBean bean = new TutorialBean();
					bean.setTitulo(rs.getString("titulo"));
					bean.setTutorialId(contador);
					resultados.add(bean);
					contador++;
				}
			} else {
				TutorialBean bean = new TutorialBean();
				bean.setTitulo("0");
				resultados.add(bean);
			}

			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}

		return resultados;
	}

	public List<TutorialBean> pesquisaTutorialTema(String tema) {
		List<TutorialBean> tutoriaisTema = new ArrayList<>();
		int contador = 0;
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select titulo from tutoriais where tema = ? and conceito = 'Apto'"
							+ "and conceito <> 'Inapto'	order by visualizacoes desc");
			sql.setString(1, tema);
			ResultSet rs = sql.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					TutorialBean tutorial = new TutorialBean();
					tutorial.setTitulo(rs.getString("titulo"));
					tutorial.setTutorialId(contador);
					tutoriaisTema.add(tutorial);
					contador++;
				}
			} else {
				TutorialBean tutorial = new TutorialBean();
				tutorial.setTitulo("Ainda não existem tutoriais aptos para esta categoria!");
				tutoriaisTema.add(tutorial);
			}

			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}

		return tutoriaisTema;
	}

	public List<TutorialBean> pesquisaTutorialUsuario(String usuario_id) {
		List<TutorialBean> tutoriaisUsuario = new ArrayList<>();
		int apto = 0, inapto = 0, avaliacao = 0;
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select titulo, tema, conceito from tutoriais where usuario_id = ?"
							+ "order by visualizacoes desc");
			sql.setString(1, usuario_id);
			ResultSet rs = sql.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					TutorialBean tutorial = new TutorialBean();
					tutorial.setTitulo(rs.getString("titulo"));
					tutorial.setTema(rs.getString("tema"));
					tutorial.setConceito(rs.getString("conceito"));

					if (rs.getString("conceito").equals("Apto")) {
						tutorial.setTutorialId(apto);
						tutoriaisUsuario.add(tutorial);
						apto++;
					} else if (rs.getString("conceito").equals("Inapto")) {
						tutorial.setTutorialId(inapto);
						tutoriaisUsuario.add(tutorial);
						inapto++;
					} else if (rs.getString("conceito").equals("Aguardando")){
						tutorial.setTutorialId(avaliacao);
						tutoriaisUsuario.add(tutorial);
						avaliacao++;
					}
				}
			}

			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}

		return tutoriaisUsuario;
	}

	public void editarTutorial(TutorialBean bean) {
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("UPDATE tutoriais SET data_edicao = ?, conceito = ? where titulo = ?");
			sql.setString(1, bean.getData());
			sql.setString(2, "Aguardando");
			sql.setString(3, bean.getTitulo());

			sql.execute();

			sql.close();
			sql = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}
	}

	public int pesquisaDados(String titulo) {
		int status = 0;
		try {
			this.c = ConnectionFactory.getConnection();
			PreparedStatement sql = c
					.prepareStatement("select * from tutoriais where titulo = ?");
			sql.setString(1, titulo);
			ResultSet rs = sql.executeQuery();

			if (rs.next()) {
				status = 1;
			}

			sql.close();
			sql = null;
			rs.close();
			rs = null;
			c.close();
			c = null;

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco de dados: "
					+ e);
		}
		return status;
	}
}
