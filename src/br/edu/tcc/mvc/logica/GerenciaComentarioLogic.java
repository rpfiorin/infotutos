package br.edu.tcc.mvc.logica;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.ComentarioBean;
import br.edu.tcc.mvc.model.ComentarioDAO;
import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class GerenciaComentarioLogic implements Logica{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		if(req.getParameter("tipo").equals("exclusao")){
			UsuarioDAO dao = new UsuarioDAO();
			UsuarioBean bean2 = new UsuarioBean();
			bean2 = dao.pesquisaUsuario((String) req.getSession().getAttribute("usuarioLogado"));	
			if (bean2.getCpf() == null){
				res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTutoriaisPopulares.jsp");
				req.getSession().removeAttribute("usuarioLogado");		
				req.getSession().setAttribute("sucesso", "Sua conta foi bloqueada!");
			} else {
			ComentarioBean bean = new ComentarioBean();
			ComentarioDAO dao2 = new ComentarioDAO();
			bean.setComentario_id(Integer.parseInt(req.getParameter("comentario_id")));
			dao2.excluiComentario(bean);		
			req.getSession().setAttribute("sucesso", "Comentário excluído com sucesso!");
			res.sendRedirect("http://localhost:8080/TCC/web/private/mvc?logica=VisualizarTutorialLogic&titulo="+ URLEncoder.encode(req.getParameter("tituloTutorial"), "UTF-8"));
			}
		} else {
			ComentarioBean bean = new ComentarioBean();
			ComentarioDAO dao = new ComentarioDAO();
			bean.setComentario_id(Integer.parseInt(req.getParameter("comentario_id")));
			dao.denunciaComentario(bean);
			req.getSession().setAttribute("sucesso", "Comentário denunciado com sucesso!");
			res.sendRedirect("http://localhost:8080/TCC/web/private/mvc?logica=VisualizarTutorialLogic&titulo="+ URLEncoder.encode(req.getParameter("tituloTutorial"), "UTF-8"));
		}
		
	}
	
}
