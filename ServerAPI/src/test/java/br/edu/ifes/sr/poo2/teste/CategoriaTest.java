package br.edu.ifes.sr.poo2.teste;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.sr.poo2.api.CategoriaAPI;
import br.edu.ifes.sr.poo2.api.CategoriaAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Categoria;

public class CategoriaTest {
	
	private CategoriaAPI categoriaAPI;
	private Categoria categoria;
	
	@Before
	public void before(){
		
		categoriaAPI = new CategoriaAPIIMpl();
		categoria = new Categoria();
		categoria.setNome("XXX");
		categoria.setDescricao("yyy");
	}
	
	
	@Test
	public void isWorking()
	{
		boolean resposta = categoriaAPI.isWorking();
		
		Assert.assertTrue(resposta);
		
	}
	
	@Test
	public void adicionarCategoria() throws Exception
	{
		
		int id = categoriaAPI.adicionar(categoria);
		Assert.assertNotSame(0, id);
		
	}
	
}
