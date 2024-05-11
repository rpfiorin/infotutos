package br.edu.tcc.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.EnviaEmailBean;
import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class ReativaUsuarioLogic implements Logica{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		UsuarioBean bean = new UsuarioBean();
		UsuarioDAO dao = new UsuarioDAO();
		bean = dao.pesquisaUsuarioExcluido(req.getParameter("usuarioReativa"));
		
		if (bean.getNome() == null) {
			req.getSession().setAttribute("erro", 1);
			res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaReativaUsuario.jsp");
		} else {		
		if (bean.getEmail().equals(req.getParameter("emailReativa")) && bean.getCpf().equals(req.getParameter("cpfReativa"))){
			String token = dao.recuperaSenha(req.getParameter("usuarioReativa"));
			bean.setSenha(token);
			bean.setUsuario(req.getParameter("usuarioReativa"));
			dao.recuperaUsuario(bean.getUsuario());
			EnviaEmailBean emailBean = new EnviaEmailBean();
			emailBean.enviaEmailReativaUsuario(bean);
			req.getSession().setAttribute("sucesso", "E-mail enviado!");
			res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTutoriaisPopulares.jsp");
		} else {
			req.getSession().setAttribute("erro", 1);
			res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaReativaUsuario.jsp");
			}
		}
		
	}

}
