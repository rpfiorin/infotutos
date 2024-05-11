package br.edu.tcc.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.tcc.mvc.model.UsuarioBean;
import br.edu.tcc.mvc.model.UsuarioDAO;

public class CadastroLogic implements Logica{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		UsuarioBean bean = new UsuarioBean();
		UsuarioDAO dao = new UsuarioDAO();
		String comentarioExperiencias = "";
		
		req.setCharacterEncoding("UTF-8");
		comentarioExperiencias = req.getParameter("comentarioExperiencias").toString();
		SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
		Date data = new Date();
		bean.setExperiencia(req.getParameter("experiencia"));
		bean.setComentarioExperiencia(comentarioExperiencias);
		bean.setData(formatarData.format(data));
		bean.setNome(req.getParameter("nomeCadastro"));
		bean.setCpf(req.getParameter("cpfCadastro"));
		bean.setEmail(req.getParameter("emailCadastro"));
		bean.setUsuario(req.getParameter("usuarioCadastro"));
		bean.setSenha(req.getParameter("senhaCadastro"));
		
		dao.cadastroUsuario(bean);		
		
		req.getSession().setAttribute("usuarioLogado", bean.getUsuario());
		req.getSession().setAttribute("sucesso", "Cadastrado com sucesso!");
		res.sendRedirect("http://localhost:8080/TCC/web/private/mvc?logica=VisualizarPerfilLogic");  
        		
	}

}
