package br.edu.ifes.sr.poo2.api;

import java.lang.reflect.Type;
import java.util.List;

import br.edu.ifes.sr.poo2.api.generic.APIGeneric;
import br.edu.ifes.sr.poo2.api.model.Categoria;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class CategoriaAPIIMpl extends APIGeneric implements CategoriaAPI{
	
	public CategoriaAPIIMpl()
	{
		URL +="/categoria";
	}
	
	public boolean isWorking() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/isWorking");
		
		String resp = response.getEntity(String.class);
		
		if (resp.equals("is Working")) return true;
		
		return false;
	}


	public List<Categoria> getAll() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/getall");
		
		String jsonResposta = response.getEntity(String.class);
		
		Type arrayListCategoria = new TypeToken <List<Categoria>>(){}.getType();
		
		List<Categoria> categorias = gson.fromJson(jsonResposta, arrayListCategoria);
		
		return categorias;
		
	}

	public int adicionar(Categoria t) throws Exception {
		
		String categoriaJson = gson.toJson(t);
		
		ClientResponse response = clientAPIUtil.post(URL+"/add/",categoriaJson);
		
		String retorno = response.getEntity(String.class);
		
		Integer id = new Integer(retorno.trim());
		
		if (id == -1) throw new Exception("ValueExist");
		
		return id;
	}

	public Categoria get(int i) throws Exception {
		throw new Exception("NotImplemented");
		
	}

		
	

	

}
