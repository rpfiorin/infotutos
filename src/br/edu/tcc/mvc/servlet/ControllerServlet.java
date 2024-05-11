package br.edu.tcc.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.logica.Logica;

@SuppressWarnings("serial")
public class ControllerServlet extends HttpServlet {
	public ControllerServlet() {
		super();

	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String parametro;
		parametro = request.getParameter("logica");
		System.out.println("A lógica é : " + parametro);
		String nomeDaClasse = "br.edu.tcc.mvc.logica." + parametro;
		request.setAttribute("sessao", "on");

		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse);

			Logica logica = (Logica) classe.newInstance();
			logica.execute(request, response);
			
		} catch (Exception e) {			
			throw new ServletException("A lógica causou uma excessão: " + e);			
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
