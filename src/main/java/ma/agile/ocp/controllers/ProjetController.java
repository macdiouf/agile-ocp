package ma.agile.ocp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.agile.ocp.entities.Projet;
import ma.agile.ocp.services.MapValidationErrorService;
import ma.agile.ocp.services.ProjetService;

@RestController
@RequestMapping("/api/projet")
public class ProjetController {

	@Autowired
	private ProjetService projetService;
	
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProjet(@Valid @RequestBody Projet projet, BindingResult result){
		
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if(errorMap != null)
			return errorMap;
		Projet newProjet = projetService.saveOrUpdate(projet);
		return new ResponseEntity<Projet>(newProjet, HttpStatus.CREATED);
	}
}
