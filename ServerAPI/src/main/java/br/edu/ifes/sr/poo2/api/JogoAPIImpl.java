package br.edu.ifes.sr.poo2.api;

import java.lang.reflect.Type;

import br.edu.ifes.sr.poo2.api.generic.APIGeneric;
import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Nivel;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class JogoAPIImpl extends APIGeneric implements JogoAPI {
	
	public Jogo jogar(String username, String URLServico, Nivel nivel) {

		ClientResponse response = clientAPIUtil.get(URLServico+"/partida/"+username+"/"+nivel);
		
		String jsonResposta = response.getEntity(String.class);
		
		Type jogoType = new TypeToken <Jogo>(){}.getType();
		
		Jogo novoJogo = gson.fromJson(jsonResposta, jogoType);
		
		return novoJogo;
	}

	public boolean salvarJogo(String URLServico, Jogo jogo) {
		
		String JSON = gson.toJson(jogo);
		
		ClientResponse response = clientAPIUtil.post(URLServico+"/responder/", JSON);
		
		String retorno = response.getEntity(String.class);
		
		if (retorno.equals("true")) return true;
		
		return false;
	}

}
