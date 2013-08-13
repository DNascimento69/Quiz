package br.edu.ifes.sr.poo2.teste;

import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.sr.poo2.api.CategoriaAPI;
import br.edu.ifes.sr.poo2.api.CategoriaAPIIMpl;
import br.edu.ifes.sr.poo2.api.GerenteAPI;
import br.edu.ifes.sr.poo2.api.GerenteAPIIMpl;
import br.edu.ifes.sr.poo2.api.ServicoAPI;
import br.edu.ifes.sr.poo2.api.ServicoAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Categoria;
import br.edu.ifes.sr.poo2.api.model.Gerente;
import br.edu.ifes.sr.poo2.api.model.Servico;

public class ServicoTest {
	
	private GerenteAPI gerenteAPI;
	
	private ServicoAPI servicoAPI;
	
	private CategoriaAPI categoriaAPI;
	
	@Before
	public void before(){
		
		gerenteAPI = new GerenteAPIIMpl();
		servicoAPI = new ServicoAPIIMpl();
		categoriaAPI = new CategoriaAPIIMpl();
	}
	
	
	@Test
	public void isWorking()
	{
		boolean resposta = servicoAPI.isWorking();
		
		Assert.assertTrue(resposta);
		
		resposta = gerenteAPI.isWorking();
		
		Assert.assertTrue(resposta);
		
	}
	
	@Test
	public void adicionarServico() throws Exception
	{
		Gerente gerente = new Gerente();
		gerente.setEmail(UUID.randomUUID().toString());
		gerente.setSenha(UUID.randomUUID().toString());
		
		long idGerente = gerenteAPI.adicionar(gerente);
		
		Categoria categoria = new Categoria();
		categoria.setNome("Categoria X");
		long idCategoria = categoriaAPI.adicionar(categoria);
		
		Servico servicoX = new Servico();
		servicoX.setIdGerente(idGerente);
		servicoX.setIdCategoria(idCategoria);
		servicoX.setUrl("XXXXX");
		//servicoAPI.adicionar(servicoX);
		
	}
	
	//@Test
	public void getListServico() throws Exception
	{
		List<Servico> servicos = servicoAPI.getAll();
		
		
	}

}
