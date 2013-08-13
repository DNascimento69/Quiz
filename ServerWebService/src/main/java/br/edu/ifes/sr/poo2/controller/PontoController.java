package br.edu.ifes.sr.poo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.model.Ponto;
import br.edu.ifes.sr.poo2.model.Servico;
import br.edu.ifes.sr.poo2.service.JogadorService;
import br.edu.ifes.sr.poo2.service.PontoService;
import br.edu.ifes.sr.poo2.service.ServicoService;

@Controller
@RequestMapping("/ponto")
public class PontoController extends AbstractController {

	@Autowired
	private PontoService pontoservice;
	
	@Autowired
	private JogadorService jogadorService;
	
	@Autowired
	private ServicoService servicoService;
	
	@RequestMapping(value = "/get/{username}/{service}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> get(@PathVariable String username, @PathVariable long service) {
		
		Long valor =  new Long ("-1");
		
		try {
			
			Ponto ponto = pontoservice.findByJogadorUsernameAndServicoId(username, service);
			if (ponto != null)
				valor = ponto.getValor();
			
			return new ResponseEntity<String>(valor.toString(),HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(valor.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@RequestMapping(value = "/add/{username}/{service}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> add(@PathVariable String username, @PathVariable long service, @RequestBody long valor) {
		try {
			//Verificando se existe
			Ponto ponto = pontoservice.findByJogadorUsername(username);
			if (ponto == null)
			{
				Jogador jogador = jogadorService.findByUsername(username);
				Servico servico = servicoService.find(service);
				
				Ponto novoPonto = new Ponto();
				novoPonto.setJogador(jogador);
				novoPonto.setServico(servico);
				novoPonto.setValor(valor);
				pontoservice.save(ponto);
				
			}
			else{
				
				ponto.setValor(valor);
				pontoservice.save(ponto);
			}
			
			return new ResponseEntity<String>("OK",HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("NOK",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
			
	
}
