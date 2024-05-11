package br.edu.tcc.mvc.model;

import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EnviaEmailBean {
	/**
	 * Envia email no formato HTML
	 * @throws EmailException 
	 * @throws MalformedURLException 
	 */
	
		public void enviaEmailRecuperaSenhaModerador(UsuarioBean bean) throws EmailException, MalformedURLException {
		
		HtmlEmail email = new HtmlEmail();
		
		// configura a mensagem para o formato HTML 
		email.setHtmlMsg("<div style='margin: auto; width: 550px; height: 350px;background-color: #F2F2F2;border: solid 2px; border-color: red;'>"
				+ "<table style='margin-left: 20px;text-align:center; width:500px;'>"
				+ "<tr> <td style='border-bottom: 1px solid black;'> <span style='font-size: 25px'><b>InfoTutos</b></span>"
				+ "<span style='font-size: 16px'><b> - Tutoriais de informática </b></span>"
				+ "</td></tr><tr><td><br><span style='font-size: 16px;'><b>Recuperação de senha</b></span></td></tr>"
				+ "<td style='text-align: left;'><br><span style='font-size: 16px;'><b>Olá, " + bean.getNome() + "!</span></td>"
				+ "<tr><td style='text-align: left;'><br><br><span style='font-size: 15px;'>Você solicitou a recuperação de "
				+ "sua senha, segue dados temporários:</span></td></tr>"
				+ "<tr><td><br><span style='font-size: 15px;'><b>Usuário: </b> "+ bean.getUsuario() +"</span></tr>"
				+ "<tr><tr></tr><td><span style='font-size: 15px;'><b>Senha temporária: </b> "+ bean.getSenha() +"</span></tr>"
				+ "<tr><td><br><p style='display: block;margin-left: 90px;height: 25px;width: 320px;line-height: 25px;font-weight: bold;"
				+ "font-size: 15px;text-decoration: none;font-family: Avant Garde, Avantgarde, Century Gothic, CenturyGothic, AppleGothic, sans-serif; "
				+ "color: #000000;margin-top: 0px;'>Acesse o sistema desktop para alterá-la!</p></td></tr><tr><td><br>"
				+ "<span style='font-size: 15px;'>InfoTutos - Tutoriais de informática © 2014 </span></td></tr></table></div>");

		// configure uma mensagem alternativa caso o servidor não suporte HTML
		email.setTextMsg("InfoTutos - Tutoriais de informática <br>"
				+ "Seu servidor de e-mail não suporta a mensagem de recuperação!"
				+ "Sua senha temporária é: "+ bean.getSenha()
				+ "<br> Acesse o sistema desktop e "
				+ "faça login para alterá-la.");
		
		email.setHostName("smtp.ig.com.br"); // o servidor SMTP para envio do e-mail
		email.addTo(bean.getEmail(), bean.getNome()); //destinatário
		email.setFrom("administracao.infotutos@ig.com.br", "InfoTutos - Tutoriais de Informática"); // remetente
		email.setSubject("Recupere sua senha"); // assunto do e-mail
		email.setAuthentication("administracao.infotutos@ig.com.br", "admtccfiec2014");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		// envia email
		email.send();
	}

	public void enviaEmailRecuperaSenha(UsuarioBean bean) throws EmailException, MalformedURLException {
		
		HtmlEmail email = new HtmlEmail();
		
		// configura a mensagem para o formato HTML 
		email.setHtmlMsg("<div style='margin: auto; width: 550px; height: 350px;background-color: #F2F2F2;border: solid 2px; border-color: red;'>"
				+ "<table style='margin-left: 20px;text-align:center; width:500px;'>"
				+ "<tr> <td style='border-bottom: 1px solid black;'> <span style='font-size: 25px'><b>InfoTutos</b></span>"
				+ "<span style='font-size: 16px'><b> - Tutoriais de informática </b></span>"
				+ "</td></tr><tr><td><br><span style='font-size: 16px;'><b>Recuperação de senha</b></span></td></tr>"
				+ "<td style='text-align: left;'><br><span style='font-size: 16px;'><b>Olá, " + bean.getNome() + "!</span></td>"
				+ "<tr><td style='text-align: left;'><br><br><span style='font-size: 15px;'>Você solicitou a recuperação de "
				+ "sua senha, segue dados temporários:</span></td></tr>"
				+ "<tr><td><br><span style='font-size: 15px;'><b>Usuário: </b> "+ bean.getUsuario() +"</span></tr>"
				+ "<tr><tr></tr><td><span style='font-size: 15px;'><b>Senha temporária: </b> "+ bean.getSenha() +"</span></tr>"
				+ "<tr><td><br><a href='http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaLoginCadastro.jsp'"
				+ " style='display: block;margin-left: 170px;height: 25px;width: 150px;line-height: 25px;font-weight: bold;"
				+ "font-size: 15px;text-decoration: none;border-radius: 3px;border-style: solid;border-color: rgba(188, 28, 0, 1);"
				+ "	border-width: 1px;background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(188, 28, 0, 1)), "
				+ "color-stop(100%, rgba(186, 6, 0, 1))); font-family: 'Avant Garde', Avantgarde, 'Century Gothic', CenturyGothic, 'AppleGothic', "
				+ "sans-serif; color: #FFFFFF;'> Acessar o site</a></td></tr><tr><td><br>"
				+ "<span style='font-size: 15px;'>InfoTutos - Tutoriais de informática © 2014 </span></td></tr></table></div>");

		// configure uma mensagem alternativa caso o servidor não suporte HTML
		email.setTextMsg("InfoTutos - Tutoriais de informática <br>"
				+ "Seu servidor de e-mail não suporta a mensagem de recuperação!"
				+ "Sua senha temporária é: "+ bean.getSenha()
				+ "<br> Acesse: http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaLoginCadastro.jsp e "
				+ "faça login para alterá-la.");
		
		email.setHostName("smtp.ig.com.br"); // o servidor SMTP para envio do e-mail
		email.addTo(bean.getEmail(), bean.getNome()); //destinatário
		email.setFrom("administracao.infotutos@ig.com.br", "InfoTutos - Tutoriais de Informática"); // remetente
		email.setSubject("Recupere sua senha"); // assunto do e-mail
		email.setAuthentication("administracao.infotutos@ig.com.br", "admtccfiec2014");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		// envia email
		email.send();
	}	
	
	public void enviaEmailReativaUsuario(UsuarioBean bean) throws EmailException, MalformedURLException {
		
		HtmlEmail email = new HtmlEmail();
		
		// configura a mensagem para o formato HTML 
		email.setHtmlMsg("<div style='margin: auto; width: 550px; height: 350px;background-color: #F2F2F2;border: solid 2px; border-color: red;'>"
				+ "<table style='margin-left: 20px;text-align:center; width:500px;'>"
				+ "<tr> <td style='border-bottom: 1px solid black;'> <span style='font-size: 25px'><b>InfoTutos</b></span>"
				+ "<span style='font-size: 16px'><b> - Tutoriais de informática </b></span>"
				+ "</td></tr><tr><td><br><span style='font-size: 16px;'><b>Reativação de usuário</b></span></td></tr>"
				+ "<td style='text-align: left;'><br><span style='font-size: 16px;'><b>Olá, " + bean.getNome() + "!</span></td>"
				+ "<tr><td style='text-align: left;'><br><br><span style='font-size: 15px;'>Você solicitou a reativação de "
				+ "sua conta, segue dados temporários:</span></td></tr>"
				+ "<tr><td><br><span style='font-size: 15px;'><b>Usuário: </b> "+ bean.getUsuario() +"</span></tr>"
				+ "<tr><tr></tr><td><span style='font-size: 15px;'><b>Senha temporária: </b> "+ bean.getSenha() +"</span></tr>"
				+ "<tr><td><br><a href='http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaLoginCadastro.jsp"
				+ " style='display: block;margin-left: 170px;height: 25px;width: 150px;line-height: 25px;font-weight: bold;"
				+ "font-size: 15px;text-decoration: none;border-radius: 3px;border-style: solid;border-color: rgba(188, 28, 0, 1);"
				+ "	border-width: 1px;background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(188, 28, 0, 1)), "
				+ "color-stop(100%, rgba(186, 6, 0, 1))); font-family: 'Avant Garde', Avantgarde, 'Century Gothic', CenturyGothic, 'AppleGothic', "
				+ "sans-serif; color: #FFFFFF;'> Acessar o site</a></td></tr><tr><td><br>"
				+ "<span style='font-size: 15px;'>InfoTutos - Tutoriais de informática © 2014 </span></td></tr></table></div>");

		// configure uma mensagem alternativa caso o servidor não suporte HTML
		email.setTextMsg("InfoTutos - Tutoriais de informática <br>"
				+ "Seu servidor de e-mail não suporta a mensagem de reativação!"
				+ "Sua senha temporária é: "+ bean.getSenha()
				+ "<br> Acesse: http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaLoginCadastro.jsp e "
				+ "faça login para alterá-la.");
		
		email.setHostName("smtp.ig.com.br"); // o servidor SMTP para envio do e-mail
		email.addTo(bean.getEmail(), bean.getNome()); //destinatário
		email.setFrom("administracao.infotutos@ig.com.br", "InfoTutos - Tutoriais de Informática"); // remetente
		email.setSubject("Reative sua conta"); // assunto do e-mail
		email.setAuthentication("administracao.infotutos@ig.com.br", "admtccfiec2014");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		// envia email
		email.send();
	}	

}
