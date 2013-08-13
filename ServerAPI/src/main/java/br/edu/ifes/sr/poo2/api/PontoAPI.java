package br.edu.ifes.sr.poo2.api;


public interface PontoAPI {
	
	public Long getPonto (String username, Long idServico);
	
	public void setPonto (String username, Long idServico, Long value) throws Exception;
}
