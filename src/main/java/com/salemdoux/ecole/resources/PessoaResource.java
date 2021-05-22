package com.salemdoux.ecole.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salemdoux.ecole.domain.Pessoa;
import com.salemdoux.ecole.dto.PessoaDTO;
import com.salemdoux.ecole.services.PessoaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Pessoa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	/* NÃO SE PODE INICIALIZAR UMA PESSOA
	 * 
	 * @RequestMapping(method=RequestMethod.POST) public ResponseEntity<Void>
	 * insert(@RequestBody Pessoa obj){ obj = service.insert(obj); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest()
	 * .path("/{id").buildAndExpand(obj.getId()).toUri(); return
	 * ResponseEntity.created(uri).build(); }
	 */

	/* NÃO SE PODE INICIALIZAR UMA PESSOA
	 * 
	 * @RequestMapping(value="/{id}",method=RequestMethod.PUT) public
	 * ResponseEntity<Void> update(@RequestBody PessoaDTO objDto, @PathVariable
	 * Integer id) throws ObjectNotFoundException{ Pessoa obj =
	 * service.fromDTO(objDto); obj.setId(id); obj = service.update(obj); return
	 * ResponseEntity.noContent().build(); }
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable Integer id) throws ObjectNotFoundException {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<PessoaDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nom") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Pessoa> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<PessoaDTO> listDto = list.map(obj -> new PessoaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
