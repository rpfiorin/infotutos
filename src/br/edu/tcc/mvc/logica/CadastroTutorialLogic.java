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

public class CadastroTutorialLogic implements Logica {

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
		UploadTutorialBean upload = new UploadTutorialBean();
		upload.setDiretorio("D:\\uploads");
		upload.setSize(10);
		upload.setExtensoesPermitidas("pdf");
		ServletContext context = req.getSession().getServletContext();
		if (upload.doNewFilePost(req, context)) {
			TutorialBean bean = new TutorialBean();
			TutorialDAO dao2 = new TutorialDAO();
			bean.setCaminho_pdf(upload.getDiretorio() + "\\" + upload.getFilename());
			bean.setConceito("Aguardando");
			SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
			Date data = new Date();
			bean.setData(formatarData.format(data));
			bean.setTema(upload.getCategoria());
			bean.setTitulo(upload.getTituloTutorial());
			bean.setUsuario_id((String) req.getSession().getAttribute("usuarioLogado"));
			dao2.insertTutorial(bean);
		}
		
		req.getSession().setAttribute("sucesso", "Enviado com sucesso!");
		res.sendRedirect("http://localhost:8080/TCC/web/private/mvc?logica=TutoriaisUsuarioLogic");
	}
	}
}
