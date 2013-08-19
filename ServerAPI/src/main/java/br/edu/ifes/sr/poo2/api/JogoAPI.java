package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Jogo;

public interface JogoAPI {

	public Jogo jogar (String username, String URLServico);
	
	public boolean salvarJogo (String URLServico, Jogo jogo);
	
}
