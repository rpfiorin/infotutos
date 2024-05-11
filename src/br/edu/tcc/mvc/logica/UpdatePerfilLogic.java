package br.edu.tcc.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class UpdatePerfilLogic implements Logica{

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
		if ("salvar".equals(req.getParameter("tipo"))){
			UsuarioDAO dao2 = new UsuarioDAO();
			UsuarioBean dados = new UsuarioBean();
			
			dados.setEmail(req.getParameter("emailuser"));
			dados.setNome(req.getParameter("nomeuser"));
			dados.setSenha(req.getParameter("senhauser"));
			dados.setUsuario(req.getParameter("usuariouser"));
			dados.setComentarioExperiencia(req.getParameter("experienciasUsuario").toString());
			dados.setExperiencia(req.getParameter("experiencia"));
			dados.setCpf(req.getParameter("cpfuser"));
			
			dao2.alteraUsuario((String) req.getSession().getAttribute("usuarioLogado"), dados);			
			
			req.getSession().setAttribute("usuarioLogado", dados.getUsuario());
			
			res.sendRedirect("http://localhost:8080/TCC/web/private/mvc?logica=VisualizarPerfilLogic");
			req.getSession().setAttribute("sucesso", "Alterado com sucesso!");
			
		} else {
			UsuarioDAO dao3 = new UsuarioDAO();
			dao3.excluiUsuario((String) req.getSession().getAttribute("usuarioLogado"));
			req.getSession().removeAttribute("usuarioLogado");
			res.sendRedirect("http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTutoriaisPopulares.jsp");
			}		
		
		}
	}

}
