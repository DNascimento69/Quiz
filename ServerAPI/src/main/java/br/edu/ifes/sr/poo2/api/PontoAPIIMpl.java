package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.generic.APIGeneric;
import br.edu.ifes.sr.poo2.api.model.Jogador;

import com.sun.jersey.api.client.ClientResponse;

public class PontoAPIIMpl extends APIGeneric implements PontoAPI{
	
	public PontoAPIIMpl()
	{
		URL +="/ponto";
	}
	
	public boolean isWorking() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/isWorking");
		
		String resp = response.getEntity(String.class);
		
		if (resp.equals("is Working")) return true;
		
		return false;
	}

	public Jogador get(int i) throws Exception{
		throw new Exception("NotImplemented");
	}

	public Long getPonto(String username, Long idServico) {
		
		ClientResponse response = clientAPIUtil.get(URL+"/get/"+username+"/"+idServico);
		
		Long resp = response.getEntity(Long.class);
		
		return resp;
	}

	public void setPonto(String username, Long idServico, Long value) throws Exception {
		
		String JSON = gson.toJson(value);
		
		ClientResponse response = clientAPIUtil.post(URL+"/add/"+username+"/"+idServico, JSON);
		
		String retorno = response.getEntity(String.class);
		
		if (retorno.equals("NOK")) throw new Exception("Problem");
		
		
	}
	
	
	
	

	

}
