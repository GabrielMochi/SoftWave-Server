package br.net.softwave.server.service;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataParam;

import br.net.softwave.server.http.DataMessage;

@Path("data")
public class DataService {

	public static final String PATH_DATA = System.getenv("SystemDrive").concat("/upload/");
	public static final HashMap<String, String> ARQUIVOS = new HashMap<>();

	static {
		File diretorio = new File(PATH_DATA);
		File[] arquivos = diretorio.listFiles(new FileFilter() {

			@Override
			public boolean accept(File arquivo) {
				for (String extensao : new String[] { ".html", ".jpeg", ".png", ".mp4" }) {
					if (arquivo.getName().toLowerCase().endsWith(extensao) && !arquivo.isDirectory()) {
						return true;
					}
				}
				return false;
			}
		});

		String[] detalhesArquivo; // primeiro index representa o nome, equanto o segundo a extensão
		for (File arquivo : arquivos) {
			detalhesArquivo = arquivo.getName().split("\\.");
			ARQUIVOS.put(detalhesArquivo[0], detalhesArquivo[1]);
		}
	}

	/**
	 * HTTP POST -> Upload de um novo dado.
	 */
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("upload")
	public DataMessage upload(final @FormDataParam("id") String id,
			@FormDataParam("arquivo") InputStream arquivoUploaded,
			@FormDataParam("arquivo") FormDataBodyPart detalhesArquivo) {

		if (id.matches("(\\d+[_]\\B)+\\d")) {
			String[] classificacoes = id.split("[_]");
			String extensao = detalhesArquivo.getMediaType().getSubtype().toLowerCase();

			if (classificacoes[0].equals("1")) {
				if (classificacoes[1] != null && extensao.equals("jpeg")) {
					return new DataMessage("Arquivo salvo com succeso!",
							salvarArquivoNoDisco(id, extensao, arquivoUploaded));
				}
			} else if (classificacoes[0].equals("2")) {
				try {
					if (classificacoes[2].equals("1") && extensao.equals("jpeg")) { // imagem do blog
						return new DataMessage("Arquivo salvo com succeso!",
								salvarArquivoNoDisco(id, extensao, arquivoUploaded));
					} else if (classificacoes[2].equals("2") // imagens dentro do blog
							&& (extensao.equals("jpeg") || extensao.equals("png")) && classificacoes[3] != null) {
						return new DataMessage("Arquivo salvo com succeso!",
								salvarArquivoNoDisco(id, extensao, arquivoUploaded));
					} else if (classificacoes[2].equals("3") // videos dentro do blog
							&& extensao.equals("mp4") && classificacoes[3] != null) {
						return new DataMessage("Arquivo salvo com succeso!",
								salvarArquivoNoDisco(id, extensao, arquivoUploaded));
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					if (classificacoes[1] != null && extensao.equals("html")) { // conteudo blog
						return new DataMessage("Arquivo salvo com succeso!",
								salvarArquivoNoDisco(id, extensao, arquivoUploaded));
					}
				}
			}

			return new DataMessage("Desculpe, estamos com problemas ao salvar o arquivo.", false);
		}
		
		return new DataMessage("id incorreto!", false);
	}

	@GET
	@Produces(MediaType.MULTIPART_FORM_DATA)
	@Path("download/{id}")
	public StreamingOutput download(@Context HttpHeaders header, @Context HttpServletResponse response,
			@PathParam("id") String id) {
		String extensao = ARQUIVOS.get(id);

		try {
			response.setHeader("content-disposition", "attachment; filename = " + id + "." + extensao);
			return pegarArquivoNoDisco(id, extensao);
		} catch (IOException e) {
			throw new WebApplicationException("não foi possível fazer o download desse ");
		}
	}

	private static boolean salvarArquivoNoDisco(String id, String extensao, InputStream arquivoUploaded) {
		String localizacaoArquivo = PATH_DATA.concat(id).concat(".").concat(extensao);

		OutputStream out = null;

		try {
			out = new FileOutputStream(new File(localizacaoArquivo));
			int read = 0;
			byte[] bytes = new byte[4096];

			while ((read = arquivoUploaded.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			out.flush();
			ARQUIVOS.put(id, extensao);

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

	private static StreamingOutput pegarArquivoNoDisco(String id, String extensao) throws IOException {
		return new StreamingOutput() {
			@Override
			public void write(OutputStream output) throws IOException {
				java.nio.file.Path path = Paths.get(PATH_DATA.concat(id).concat(".").concat(extensao));
				byte[] data = Files.readAllBytes(path);
				output.write(data);
				output.flush();
				output.close();
			}
		};
	}

}
