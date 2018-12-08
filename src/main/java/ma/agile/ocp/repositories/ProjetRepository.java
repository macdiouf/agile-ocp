package ma.agile.ocp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.agile.ocp.entities.Projet;

@Repository
public interface ProjetRepository extends CrudRepository<Projet, Long> {

}
