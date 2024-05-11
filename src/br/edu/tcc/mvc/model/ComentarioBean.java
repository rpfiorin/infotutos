package br.edu.tcc.mvc.model;

public class ComentarioBean {

	private String comentario, dataComentario, usuario_id;
	private Integer tutorial_id, comentario_id;

	public Integer getComentario_id() {
		return comentario_id;
	}

	public void setComentario_id(Integer comentario_id) {
		this.comentario_id = comentario_id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(String dataComentario) {
		this.dataComentario = dataComentario;
	}

	public String getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Integer getTutorial_id() {
		return tutorial_id;
	}

	public void setTutorial_id(Integer tutorial_id) {
		this.tutorial_id = tutorial_id;
	}

}
