package br.edu.tcc.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutLogic implements Logica{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		req.getSession().removeAttribute("usuarioLogado");
		req.getSession().setAttribute("sucesso", "Logout efetuado com sucesso!");
		res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTutoriaisPopulares.jsp");		
	}

}
