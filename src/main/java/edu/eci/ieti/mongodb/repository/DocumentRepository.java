package edu.eci.ieti.mongodb.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.eci.ieti.mongodb.model.Documento;

@Repository
public interface DocumentRepository extends MongoRepository<Documento, String>{
    
    public Documento findByName(String name);

    public void deleteByName(String name);

    public void deleteAll();

}
