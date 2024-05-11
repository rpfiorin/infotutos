package br.edu.tcc.mvc.logica;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.ComentarioBean;
import br.edu.tcc.mvc.model.ComentarioDAO;
import br.edu.tcc.mvc.model.TutorialBean;
import br.edu.tcc.mvc.model.TutorialDAO;
import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class EnviarComentarioLogic implements Logica{

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
		ComentarioBean comentarioBean = new ComentarioBean();
		ComentarioDAO comentarioDao = new ComentarioDAO();
		TutorialBean tutorialBean = new TutorialBean();
		TutorialDAO tutorialDao = new TutorialDAO();
		String comentario = "";
		
		req.setCharacterEncoding("UTF-8");
		comentario = req.getParameter("txtComentario").toString();
		comentarioBean.setComentario(comentario.replaceAll("\n","<br>"));
		SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
		Date data = new Date();
		comentarioBean.setDataComentario(formatarData.format(data));
		tutorialBean.setTitulo((String) req.getParameter("tutorialid"));
		tutorialBean = tutorialDao.pesquisaTutorial(tutorialBean.getTitulo());		
		comentarioBean.setTutorial_id(tutorialBean.getTutorialId());
		comentarioBean.setUsuario_id((String) req.getSession().getAttribute("usuarioLogado")); 
		comentarioDao.inserirComentario(comentarioBean);  
		
		req.removeAttribute("txtComentario");
		req.removeAttribute("tutorialid");
		req.getSession().setAttribute("sucesso", "Comentário enviado com sucesso!");
		
		res.sendRedirect("http://localhost:8080/TCC/web/private/mvc?logica=VisualizarTutorialLogic&titulo="+ URLEncoder.encode(tutorialBean.getTitulo(), "UTF-8"));
		
	}
	}
}
