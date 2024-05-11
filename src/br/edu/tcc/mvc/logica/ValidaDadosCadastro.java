package br.edu.tcc.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class ValidaDadosCadastro implements Logica {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		if (req.getParameter("acao").equals("cpf")) {
			String cpf = req.getParameter("cpf");

			UsuarioDAO dao = new UsuarioDAO();
			
			int status = dao.pesquisaDados("cpf", cpf);
			
			if (status == 1) {
				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/html");
				res.getWriter().write("verdadeiro");
			} else {
				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/html");
				res.getWriter().write("falso");
			}
		} else if (req.getParameter("acao").equals("usuario")){
			String usuario_id = req.getParameter("usuario_id");

			UsuarioDAO dao = new UsuarioDAO();
			
			int status = dao.pesquisaDados("usuario_id", usuario_id);
			
			if (status == 1) {
				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/html");
				res.getWriter().write("verdadeiro");
			} else {
				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/html");
				res.getWriter().write("falso");
			}
		} else if (req.getParameter("acao").equals("senha")) {
			UsuarioDAO dao = new UsuarioDAO();
			UsuarioBean bean = new UsuarioBean();
			bean.setUsuario(req.getParameter("usuario_id"));
			bean.setSenha(req.getParameter("senha"));
						
			int status = dao.loginUsuario(bean);
			
			if (status == 1) {
				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/html");
				res.getWriter().write("verdadeiro");
			} else {
				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/html");
				res.getWriter().write("falso");
			}
		}

	} 

}
