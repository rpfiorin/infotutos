package br.edu.tcc.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.TutorialDAO;

public class ValidaCadastroTutoriais implements Logica{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String titulo = req.getParameter("titulo");

		TutorialDAO dao = new TutorialDAO();
		
		int status = dao.pesquisaDados(titulo);
		
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
