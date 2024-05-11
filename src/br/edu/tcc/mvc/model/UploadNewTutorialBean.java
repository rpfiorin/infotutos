package br.edu.tcc.mvc.model;

import java.io.File;
import java.util.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

public class UploadNewTutorialBean {
	private DiskFileItemFactory fileUpload = new DiskFileItemFactory();
	private ServletFileUpload sfu = new ServletFileUpload(fileUpload);

	private String diretorio;
	private String filename;
	private String name, value;
	private String categoria;
	private String tituloTutorial;
	private static int KB = 1024;
	private static int MB = 1024 * 1024;
	private int size;
	private String extensoesPermitidas;
	private String erro = null;

	public String getCategoria() {
		return categoria;
	}

	public String getTituloTutorial() {
		return tituloTutorial;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public String getDiretorio() {
		return diretorio;

	}

	public String getFilename() {
		return filename;
	}

	@SuppressWarnings("rawtypes")
	public boolean doFilePost(HttpServletRequest request, ServletContext context) {
		if (request.getContentType() == null) {
			return false;
		}

		if (!request.getContentType().startsWith("multipart/form-data")) {
			setErro("Seu formulário não envia arquivos");
			return false;
		}

		fileUpload.setSizeThreshold(4 * KB);

		String path = getDiretorio();
		try {
			sfu.setSizeMax(getSize() * MB);

			List list = sfu.parseRequest(request);

			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				FileItem item = (FileItem) iterator.next();

				if (item.isFormField()) {
					{
						name = item.getFieldName();
						value = item.getString();
						
						if(name.equals("tituloTutorial")){
							tituloTutorial = value;							
						}
						if(name.equals("categoria")){
							categoria = value;							
						}
					}
					
				} else
					{
					filename = item.getName();

					if ((filename != null) && (!filename.equals(""))) {
						
						filename = (new File(filename)).getName();

						if (isPermission(filename)) {
							filename = getTituloTutorial()+".pdf";
							item.write(new File(path + "\\" + filename));
						} else {
							setErro("Arquivo não permitido");
							return false;
						}
					}

				}
			}

		} catch (FileUploadBase.SizeLimitExceededException slee) {
			slee.printStackTrace();
			setErro("Tamanho excedido");
			return false;

		} catch (Exception e) {
			setErro("Uma Exceção ocorreu: " + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/*
	 * public boolean isPermission(String fileName) { String lowerCaseName =
	 * fileName.toLowerCase(); for (int i = 0; i < extensoesPermitidas.length;
	 * i++) { if (lowerCaseName.endsWith(extensoesPermitidas[i])) return true; }
	 * return false; }
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	private void setErro(String erro) {
		this.erro = erro;
	}

	public String getErro() {
		return erro;
	}

	public void setExtensoesPermitidas(String extensoesPermitidas) {
		this.extensoesPermitidas = extensoesPermitidas;
	}

	public String getExtensoesPermitidas() {
		return extensoesPermitidas;
	}

	public boolean isPermission(String fileName) {
		String lowerCaseName = fileName.toLowerCase();
		StringTokenizer st = new StringTokenizer(extensoesPermitidas,
				" ,.?! \'-:;|");
		while (st.hasMoreTokens()) {
			if (lowerCaseName.endsWith("." + st.nextToken()))
				return true;
		}

		return false;
	}
}

