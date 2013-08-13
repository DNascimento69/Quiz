package br.edu.ifes.sr.poo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifes.sr.poo2.model.Categoria;
import br.edu.ifes.sr.poo2.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController extends AbstractController {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/add/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> add(@RequestBody Categoria categoria) {
		try {

			service.save(categoria);

			return new ResponseEntity<String>(categoria.getId().toString(),
					HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Retornando um lista de gerentes
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Categoria>> get() {
		try {

			List<Categoria> servicos = service.findAll();

			return new ResponseEntity<List<Categoria>>(servicos, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<List<Categoria>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
