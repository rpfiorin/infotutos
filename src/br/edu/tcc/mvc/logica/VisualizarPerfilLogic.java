package br.edu.tcc.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class VisualizarPerfilLogic implements Logica{

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
		if (req.getSession().getAttribute("sucesso") != null){
			req.setAttribute("sucesso", req.getSession().getAttribute("sucesso"));
			req.getSession().removeAttribute("sucesso");
		}
		req.setAttribute("nomeUsuario", bean2.getNome());
		req.setAttribute("cpfUsuario", bean2.getCpf());
		req.setAttribute("emailUsuario", bean2.getEmail());
		req.setAttribute("experienciasUsuario", bean2.getExperiencia());
		req.setAttribute("comentarioExperiencia", bean2.getComentarioExperiencia());
		RequestDispatcher rd = req.getRequestDispatcher("Paginas/PaginaPerfilUsuario.jsp");
		rd.forward(req, res);
		}
	}
}
