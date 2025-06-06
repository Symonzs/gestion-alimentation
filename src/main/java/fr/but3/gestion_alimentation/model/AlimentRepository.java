package fr.but3.gestion_alimentation.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentRepository extends CrudRepository<Aliment, Integer>{
    
}
