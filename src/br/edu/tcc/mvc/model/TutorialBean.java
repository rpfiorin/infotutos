package br.edu.tcc.mvc.model;

public class TutorialBean {
	private Integer tutorialId;
	private String titulo, tema ,data , conceito, caminho_pdf, usuario_id;
	
	public Integer getTutorialId() {
		return tutorialId;
	}
	public void setTutorialId(Integer tutorialId) {
		this.tutorialId = tutorialId;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getConceito() {
		return conceito;
	}
	public void setConceito(String conceito) {
		this.conceito = conceito;
	}
	public String getCaminho_pdf() {
		return caminho_pdf;
	}
	public void setCaminho_pdf(String caminho_pdf) {
		this.caminho_pdf = caminho_pdf;
	}
	public String getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}
	
	
}
