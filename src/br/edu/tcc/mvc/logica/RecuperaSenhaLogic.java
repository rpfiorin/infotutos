package br.edu.tcc.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.EnviaEmailBean;
import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class RecuperaSenhaLogic implements Logica{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		UsuarioBean bean = new UsuarioBean();
		UsuarioDAO dao = new UsuarioDAO();		
		bean = dao.pesquisaUsuario(req.getParameter("usuarioRecupera"));
		
		if (bean.getNome() == null) {
			req.getSession().setAttribute("erro", 1);
			res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaRecuperaSenha.jsp");			
		} else {		
		if (bean.getEmail().equals(req.getParameter("emailRecupera")) && bean.getCpf().equals(req.getParameter("cpfRecupera"))){
			String token = dao.recuperaSenha(req.getParameter("usuarioRecupera"));
			bean.setSenha(token);
			bean.setUsuario(req.getParameter("usuarioRecupera"));
			EnviaEmailBean emailBean = new EnviaEmailBean();
			if (bean.getTipo().equals("M")){
				emailBean.enviaEmailRecuperaSenhaModerador(bean);
			} else {
				emailBean.enviaEmailRecuperaSenha(bean);
			}			
			req.getSession().setAttribute("sucesso", "E-mail enviado!");
			res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTutoriaisPopulares.jsp");
		} else {
			req.getSession().setAttribute("erro", 1);
			res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaRecuperaSenha.jsp");
			}
		}		
	}

}
