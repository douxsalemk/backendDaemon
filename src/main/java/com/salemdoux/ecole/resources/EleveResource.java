package com.salemdoux.ecole.resources;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salemdoux.ecole.domain.Eleve;
import com.salemdoux.ecole.dto.EleveDTO;
import com.salemdoux.ecole.dto.ObjectNewDTO;
import com.salemdoux.ecole.services.EleveService;
import com.salemdoux.ecole.services.JasperService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/eleves")
public class EleveResource {

	@Autowired
	private EleveService service;
	
	@Autowired
	private JasperService Jservice;

	@CrossOrigin 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Eleve> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Eleve obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin 
	@RequestMapping(value = "/certificat/pdf/{code}", method = RequestMethod.GET)
	public void exibirRelatorio1(@PathVariable("code") String code, @RequestParam("acao") String acao,
			HttpServletResponse response) throws IOException {
		byte[] bytes = Jservice.exportarPDF(code);
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		if (acao.equals("v")) {
			response.setHeader("Content-disposition" , "inline; filename=certificat-"+ code + ".pdf");
		}else {
			response.setHeader("Content-disposition" , "attachement; filename=certificat-"+ code + ".pdf");
		}
		response.getOutputStream().write(bytes);	
	}
	
	@CrossOrigin 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ObjectNewDTO objDto) {
		Eleve obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin 
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Eleve obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin 
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin 
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EleveDTO>> findAll() {
		List<Eleve> list = service.findAll();
		List<EleveDTO> listDto = list.stream().map(obj -> new EleveDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@CrossOrigin 
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<EleveDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nom") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Eleve> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EleveDTO> listDto = list.map(obj -> new EleveDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
