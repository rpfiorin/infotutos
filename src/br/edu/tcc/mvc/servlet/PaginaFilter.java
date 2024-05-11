package br.edu.tcc.mvc.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaginaFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		if (session != null) {
			if (session.getAttribute("usuarioLogado") != null) {
				res.sendRedirect(req.getContextPath()
						+ "/web/private/mvc?logica=VisualizarPerfilLogic");
				System.out.println("Usuário encontrado na sessão, redirecionando para página de perfil.");
				// Logged user found, so redirect to profile page.
			} else {
				req.setCharacterEncoding("UTF-8");
				chain.doFilter(req, res); // Logged-in user not found, so just continue request.
			} 
		} else {
			req.setCharacterEncoding("UTF-8");
			chain.doFilter(req, res); // Logged-in user not found, so just continue request.
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
