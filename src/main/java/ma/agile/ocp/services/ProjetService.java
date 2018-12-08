package ma.agile.ocp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.agile.ocp.entities.Projet;
import ma.agile.ocp.exceptions.ReferenceProjetException;
import ma.agile.ocp.repositories.ProjetRepository;

@Service
public class ProjetService {

	@Autowired
	private ProjetRepository projetRepository;
	
	public Projet saveOrUpdate(Projet projet){
		try{
			projet.setReference(projet.getReference().toUpperCase());
			return projetRepository.save(projet);
		}
		catch (Exception e) {
			throw new ReferenceProjetException("reference projet : "+projet.getReference().toUpperCase()+" existe déja");
		}
	}
}
