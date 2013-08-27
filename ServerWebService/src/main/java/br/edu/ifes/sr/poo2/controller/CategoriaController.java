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

			Categoria categoriaPesquisada = service.findByNome(categoria.getNome());
			
			if (categoriaPesquisada == null) service.save(categoria);
			else 
				return new ResponseEntity<String>("-1",
						HttpStatus.OK);

			return new ResponseEntity<String>(categoria.getId().toString(),
					HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Categoria>> get() {
		try {

			List<Categoria> categorias = service.findAll();

			return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<List<Categoria>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
