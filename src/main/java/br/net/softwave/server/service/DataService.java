package br.net.softwave.server.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("data")
public class DataService {
	
	/**
	 * HTTP POST -> Upload de um novo dado.
	 * */
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("{id}")
	public boolean upload(@PathParam("id") String id,
			@FormDataParam("arquivo") InputStream arquivoUploaded,
			@FormDataParam("arquivo") FormDataContentDisposition detalhesArquivo) {
		String[] classificacoes = id.split("[_]");
		
		if (classificacoes[0].equals("1")) {
			if (!classificacoes[1].isEmpty()) {
				if (detalhesArquivo.getType().equals("jpg")) {
					return salvarArquivoNoDisco(id, arquivoUploaded, detalhesArquivo);
				}
			}
		} else if (classificacoes[0].equals("2")) {
			if (!classificacoes[1].isEmpty()) {
				try {
					if (!classificacoes[2].isEmpty()) {
						if (classificacoes[2].equals("1")) {
							if (detalhesArquivo.getType().equals("jpg")) {
								return salvarArquivoNoDisco(id, arquivoUploaded, detalhesArquivo);
							}
						} else if (classificacoes[2].equals("2")) {
							if (detalhesArquivo.getType().equals("jpg")
									|| detalhesArquivo.getType().equals("png")) {
								return salvarArquivoNoDisco(id, arquivoUploaded, detalhesArquivo);
							}
						} else if (classificacoes[2].equals("3")) {
							if (detalhesArquivo.getType().equals("mp4")) {
								return salvarArquivoNoDisco(id, arquivoUploaded, detalhesArquivo);
							}
						}
					}
				} catch (Exception e) {
					if (detalhesArquivo.getType().equals("html")) {
						return salvarArquivoNoDisco(id, arquivoUploaded, detalhesArquivo);
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean salvarArquivoNoDisco(String id, InputStream arquivoUploaded, 
			FormDataContentDisposition detalhesArquivo) {
		String localizacaoArquivo = System.getenv("SystemDrive")
				.concat("upload/")
				.concat(id)
				.concat(".")
				.concat(detalhesArquivo.getType());
		
		OutputStream out = null;
		
		try {
			out = new FileOutputStream(new File(localizacaoArquivo));
			int read = 0;
			byte[] bytes = new byte[1024];
			
			while ((read = arquivoUploaded.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
			out.flush();
			out.close();
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();	
			return false;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
