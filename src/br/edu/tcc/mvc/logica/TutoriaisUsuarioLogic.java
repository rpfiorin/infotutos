package br.edu.tcc.mvc.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.TutorialBean;
import br.edu.tcc.mvc.model.TutorialDAO;
import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class TutoriaisUsuarioLogic implements Logica {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioBean bean2 = new UsuarioBean();
		bean2 = dao.pesquisaUsuario((String) req.getSession().getAttribute("usuarioLogado"));	
		if (bean2.getCpf() == null){
			res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTutoriaisPopulares.jsp");
			req.getSession().removeAttribute("usuarioLogado");
			req.getSession().setAttribute("sucesso", "Sua conta foi bloqueada!");
		} else {
		TutorialDAO dao2 = new TutorialDAO();
		List<TutorialBean> tutoriaisUsuario = new ArrayList<>();
		List<TutorialBean> tutoriaisAptos = new ArrayList<>();
		List<TutorialBean> tutoriaisInaptos = new ArrayList<>();
		List<TutorialBean> tutoriaisAguardando = new ArrayList<>();

		tutoriaisUsuario = dao2.pesquisaTutorialUsuario((String) req.getSession().getAttribute("usuarioLogado"));
		
		for (int i = 0; i < tutoriaisUsuario.size(); i++) {
			if (tutoriaisUsuario.get(i).getConceito().equals("Apto")) {
				tutoriaisAptos.add(tutoriaisUsuario.get(i));				
			} else if (tutoriaisUsuario.get(i).getConceito().equals("Inapto")) {
				tutoriaisInaptos.add(tutoriaisUsuario.get(i));
			} else {
				tutoriaisAguardando.add(tutoriaisUsuario.get(i));
			}
		}

		if (tutoriaisAptos.size() == 0) {
			TutorialBean tutorial = new TutorialBean();
			tutorial.setTitulo("Você ainda não possui nenhum tutorial apto!");
			tutoriaisAptos.add(tutorial);

		}

		if (tutoriaisInaptos.size() == 0) {
			TutorialBean tutorial = new TutorialBean();
			tutorial.setTitulo("Você ainda não possui nenhum tutorial inapto!");
			tutoriaisInaptos.add(tutorial);
		}

		if (tutoriaisAguardando.size() == 0) {
			TutorialBean tutorial = new TutorialBean();
			tutorial.setTitulo("Você ainda não possui nenhum tutorial em avaliação!");
			tutoriaisAguardando.add(tutorial);
		}
		
		if (req.getSession().getAttribute("sucesso") != null){
			req.setAttribute("sucesso", req.getSession().getAttribute("sucesso"));
			req.getSession().removeAttribute("sucesso");
		}		
		req.setAttribute("tutoriaisAptos", tutoriaisAptos);
		req.setAttribute("tutoriaisInaptos", tutoriaisInaptos);
		req.setAttribute("tutoriaisAvaliacao", tutoriaisAguardando);

		RequestDispatcher rd = req
				.getRequestDispatcher("Paginas/PaginaTutoriaisUsuario.jsp");
		rd.forward(req, res);

		}
	}
}
