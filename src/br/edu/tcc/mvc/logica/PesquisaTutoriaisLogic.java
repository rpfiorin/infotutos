package br.edu.tcc.mvc.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.TutorialBean;
import br.edu.tcc.mvc.model.TutorialDAO;

public class PesquisaTutoriaisLogic implements Logica{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		TutorialDAO dao = new TutorialDAO();
		List<TutorialBean> resultados = new ArrayList<>();
		resultados = dao.pesquisaTutoriais(req.getParameter("pesquisa"));
		req.setAttribute("resultadosPesquisa", resultados);
		RequestDispatcher rd = req.getRequestDispatcher("PaginasAbertas/PaginaPesquisaTutoriais.jsp");
		rd.forward(req, res);	
	}
		
}
