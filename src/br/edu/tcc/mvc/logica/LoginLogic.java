package br.edu.tcc.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.*;

public class LoginLogic implements Logica{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		UsuarioBean bean = new UsuarioBean();
		UsuarioDAO dao = new UsuarioDAO();
		
		bean.setUsuario(req.getParameter("usuarioLogin"));
		bean.setSenha(req.getParameter("senhaLogin"));
		
		System.out.println(bean.getUsuario() + " "+bean.getSenha());
		Integer status = dao.loginUsuario(bean);		
		req.setAttribute("status", status);
		
		if (status == 1){
			req.getSession().setAttribute("usuarioLogado", bean.getUsuario());
			req.getSession().setAttribute("sucesso", "Login efetuado com sucesso!");			
			res.sendRedirect("http://localhost:8080/TCC/web/private/mvc?logica=VisualizarPerfilLogic");
			} else {
			res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaLoginCadastro.jsp?erro=404");
			}		
	}
	
}
