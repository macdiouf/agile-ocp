package ma.agile.ocp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.agile.ocp.entities.Projet;
import ma.agile.ocp.services.ProjetService;

@RestController
@RequestMapping("/api/projet")
public class ProjetController {

	@Autowired
	private ProjetService projetService;
	
	@PostMapping("")
	public ResponseEntity<Projet> createNewProjet(@RequestBody Projet projet){
		Projet newProjet = projetService.saveOrUpdate(projet);
		return new ResponseEntity<Projet>(projet, HttpStatus.CREATED);
	}
}
