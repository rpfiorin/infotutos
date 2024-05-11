package br.edu.tcc.mvc.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.TutorialBean;
import br.edu.tcc.mvc.model.TutorialDAO;

public class TutoriaisTemaLogic implements Logica{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		TutorialDAO dao = new TutorialDAO();
		List<TutorialBean> tutoriais = new ArrayList<>();
		
		tutoriais = dao.pesquisaTutorialTema(req.getParameter("tema"));
		
		req.setAttribute("tutoriaisTema", tutoriais);
		req.setAttribute("nomeTema", req.getParameter("tema"));
		
		RequestDispatcher rd = req.getRequestDispatcher("PaginasAbertas/PaginaTutoriaisTema.jsp");
		rd.forward(req, res);	
		
	}

}
