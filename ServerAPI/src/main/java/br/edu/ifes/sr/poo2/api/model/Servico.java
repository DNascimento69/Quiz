package br.edu.ifes.sr.poo2.api.model;



public class Servico extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String url;
	
	private long idGerente;

	private long idCategoria;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(long idGerente) {
		this.idGerente = idGerente;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
		
	
}
