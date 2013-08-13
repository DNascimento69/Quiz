package br.edu.ifes.sr.poo2.api.model;


public class Gerente extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Servico servico;

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	
	
}
