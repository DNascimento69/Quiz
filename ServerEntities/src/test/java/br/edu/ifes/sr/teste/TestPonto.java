package br.edu.ifes.sr.teste;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.model.Ponto;
import br.edu.ifes.sr.poo2.model.Servico;
import br.edu.ifes.sr.poo2.service.JogadorService;
import br.edu.ifes.sr.poo2.service.PontoService;
import br.edu.ifes.sr.poo2.service.ServicoService;

public class TestPonto extends AbstractTest {

	@Autowired
	JogadorService service;

	@Autowired
	PontoService pontoService;

	@Autowired
	ServicoService servicoService;

	@Test
	public void salvar() {
		// Salvando o jogador
		Jogador jogador = new Jogador();
		jogador.setEmail(UUID.randomUUID().toString());
		jogador.setSenha(UUID.randomUUID().toString());
		jogador.setUsername(UUID.randomUUID().toString());

		Assert.assertNotSame(jogador.getId(), 0);
		service.save(jogador);

		// Salvando o servico
		Servico servico = new Servico();
		servico.setUrl("Http://serve1.com.br/nomeservico");
		servicoService.save(servico);
		Assert.assertNotSame(servico.getId(), 0);

		// Salvando o ponto
		Ponto ponto = new Ponto();
		ponto.setJogador(jogador);
		ponto.setServico(servico);
		ponto.setValor(10);
		pontoService.save(ponto);
		Assert.assertNotSame(ponto.getId(), 0);
	}

	@Test
	public void findByUsuario() {

		// Salvando o jogador
		Jogador jogador = new Jogador();
		jogador.setEmail(UUID.randomUUID().toString());
		jogador.setSenha(UUID.randomUUID().toString());
		jogador.setUsername(UUID.randomUUID().toString());

		Assert.assertNotSame(jogador.getId(), 0);
		service.save(jogador);

		// Salvando o servico
		Servico servico = new Servico();
		servico.setUrl("Http://serve1.com.br/nomeservico");
		servicoService.save(servico);
		Assert.assertNotSame(servico.getId(), 0);

		// Salvando o ponto
		Ponto ponto = new Ponto();
		ponto.setJogador(jogador);
		ponto.setServico(servico);
		ponto.setValor(10);
		pontoService.save(ponto);
		Assert.assertNotSame(ponto.getId(), 0);
		
		Ponto pontoX = pontoService.findByJogadorId(jogador.getId());
		Assert.assertSame(pontoX.getId(), ponto.getId());
		

	}

}
