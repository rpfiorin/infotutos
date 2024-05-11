package br.edu.tcc.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.ComentarioBean;
import br.edu.tcc.mvc.model.ComentarioDAO;
import br.edu.tcc.mvc.model.TutorialBean;
import br.edu.tcc.mvc.model.TutorialDAO;
import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class VisualizarTutorialLogic implements Logica {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioBean bean2 = new UsuarioBean();
		bean2 = dao.pesquisaUsuario((String) req.getSession().getAttribute("usuarioLogado"));	
		if (bean2.getCpf() == null){			
			req.getSession().removeAttribute("usuarioLogado");
		}
		TutorialDAO dao2 = new TutorialDAO();
		TutorialBean bean = new TutorialBean();
		ComentarioDAO comentarioDAO = new ComentarioDAO();
		List<ComentarioBean> comentarios = new ArrayList<>();
		
		req.setCharacterEncoding("UTF-8");  
		res.setCharacterEncoding("UTF-8");
		bean = dao2.pesquisaAptos(req.getParameter("titulo"));
		comentarios = comentarioDAO.getComentariosTutorial(bean.getTutorialId());		
		req.setAttribute("comentarios", comentarios);
		req.setAttribute("tituloTutorial", bean.getTitulo());
		req.setAttribute("caminhoPdf", bean.getCaminho_pdf());
		req.setAttribute("usuario_id", bean.getUsuario_id());
		req.setAttribute("categoria", bean.getTema());
		//o primeiro tem o padrao que será informado:  
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );     
		java.util.Date data = sdf.parse(bean.getData());
		SimpleDateFormat sdfs = new SimpleDateFormat( "dd/MM/yyyy" );     
		String dataFinal = sdfs.format(data);  
		bean.setData(dataFinal);
		req.setAttribute("dataPostagem", bean.getData());
		if (req.getSession().getAttribute("sucesso") != null){
			req.setAttribute("sucesso", req.getSession().getAttribute("sucesso"));
			req.getSession().removeAttribute("sucesso");
		}
		RequestDispatcher rd = req.getRequestDispatcher("PaginasAbertas/PaginaVisualizarTutorial.jsp");
		rd.forward(req, res);
		}
	}
