package br.edu.tcc.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.TutorialBean;
import br.edu.tcc.mvc.model.TutorialDAO;
import br.edu.tcc.mvc.model.UploadTutorialBean;
import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class EditarTutorialLogic implements Logica {

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
		TutorialDAO daoPesquisa = new TutorialDAO();
		TutorialBean beanPesquisa = new TutorialBean();
		beanPesquisa = daoPesquisa.pesquisaTutorial(req.getParameter("titulo"));
		UploadTutorialBean upload = new UploadTutorialBean();
		upload.setDiretorio("D:\\uploads");
		upload.setSize(10);
		upload.setExtensoesPermitidas("pdf");
		upload.setFilename(beanPesquisa.getCaminho_pdf().substring(beanPesquisa.getCaminho_pdf().indexOf("uploads")+8));
		ServletContext context = req.getSession().getServletContext();
		if (upload.doReplaceFilePost(req, context)) {
			TutorialBean bean = new TutorialBean();
			TutorialDAO dao2 = new TutorialDAO();
			SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
			Date data = new Date();
			bean.setTitulo(beanPesquisa.getTitulo());
			bean.setData(formatarData.format(data));
			bean.setCaminho_pdf(upload.getDiretorio() + "\\" + upload.getFilename());
			dao2.editarTutorial(bean);			
		}
		
		req.getSession().setAttribute("sucesso", "Enviado com sucesso!");
		req.getSession().removeAttribute("titulo");
		res.sendRedirect("http://localhost:8080/TCC/web/private/mvc?logica=TutoriaisUsuarioLogic");
		}
	}
}
